<?php

$activeContentUpload='none';
$activeContentBrowse='block';
$activeContentDelete='none';
$categories=""; fetchCategories();


function dataCleaner($dirty){
	$clean=htmlspecialchars(strip_tags(addslashes(trim($dirty))));
	return $clean;
}
function imageValidator($Image){
	$return=true;
		$imageMeta=getimagesize($Image['tmp_name']);
		$extension=strtolower(pathinfo(basename($Image['name']),PATHINFO_EXTENSION ));
		if (!($imageMeta['mime']=='image/jpeg' OR $imageMeta['mime']=='image/jpg' OR $imageMeta['mime']=='image/png' OR $imageMeta['mime']=='image/gif' )
			AND !($extension=='jpg' OR $extension=='jepg' OR $extension=='png' OR $extension=='gif')) {
			$return=false;
		}

	return $return;
}
function uploadVideoToDatabase($title, $description, $url, $Image, $category,$date){
	require $_SERVER['DOCUMENT_ROOT'].'/connection.php';

	if ($con) {
		try{

		$con->beginTransaction();
		$insertVideoStmt->execute();
		$lastId=$con->lastInsertId();
		$updateImageRef->bindParam(':lastId', $lastId);
		$extension=strtolower(pathinfo(basename($Image['name']),PATHINFO_EXTENSION ));
		$imageref=$lastId.'.'.$extension;
		$Image['name']=$lastId.'.'.$extension;
		if(move_uploaded_file($Image['tmp_name'], 'uploads/'.$Image['name'])){
			$updateImageRef->execute();
			$con->commit();
			echo "COMMITED";
			return true;
		}else{
			echo "ROLLBACK";
			$con->rollback();
			return false;
		}
		}catch(PDOException $e){
			echo $e;
		}

	}
	$con=NULL;

}
function deleteVideo($id){
	require $_SERVER['DOCUMENT_ROOT'].'/connection.php';

	if ($con) {
		try{
		$con->beginTransaction();
		$deleteDeleteSearch->execute();
			$con->commit();
		}catch(PDOException $e){
			echo $e;
			$con->rollback();
		}

	}
	$con=NULL;

}
function newVideohandler(){
			echo "Video submitted";
		$resultNewVideo="<span class=\"col-md-12\" style=\"background-color: {color}; color: white; opacity: 0.8;\">";
		$error=false;

		if(isset($_POST['newVideo_title']) and !empty(trim($_POST['newVideo_title']))){
			$title=dataCleaner($_POST['newVideo_title']);	
		}else{
			$error=true;
			$resultNewVideo.="<h3>Please enter a valid Title | </h3>";
		}
		if(isset($_POST['newVideo_description']) and !empty(trim($_POST['newVideo_description']))){
			$description=dataCleaner($_POST['newVideo_description']);	
		}else{
			$error=true;
			$resultNewVideo.="<h3>Please enter a valid Description | </h3>";
		}
		if(isset($_POST['newVideo_url']) and !empty(trim($_POST['newVideo_url']))){
			$url=dataCleaner($_POST['newVideo_url']);	
		}else{
			$error=true;
			$resultNewVideo.="<h3>Please enter a valid URL | </h3>";
		}
		if(isset($_POST['newVideo_category']) and !empty(trim($_POST['newVideo_category']))){
			$category=dataCleaner($_POST['newVideo_category']);	
		}else{
			$error=true;
			$resultNewVideo.="<h3>Please enter a valid Category | </h3>";
		}
		$date=explode("-", $_POST['newVideo_date'], 3);
		if(isset($_POST['newVideo_date']) and !empty(trim($_POST['newVideo_date'])) and checkdate($date[1],$date[2],$date[0])){
			$date=$_POST['newVideo_date'];	
		}else{
			$error=true;
			$resultNewVideo.="<h3>Please enter a valid Date | </h3>";
		}
		if(imageValidator($_FILES['newVideo_thumbnail'])){
			$Image=$_FILES['newVideo_thumbnail'];
		}else{
			$error=true;
			$resultNewVideo.="<h3>Please enter a valid Image | </h3>";
		}

		if ($error) {
			$resultNewVideo=str_replace("{color}", "red", $resultNewVideo);
		}else{
			if (uploadVideoToDatabase($title, $description, $url, $Image, $category,$date)) {
				
			$resultNewVideo=str_replace("{color}", "green", $resultNewVideo);
			$resultNewVideo.="<h3>Video uploaded</h3>";
			}else{
			$resultNewVideo=str_replace("{color}", "red", $resultNewVideo);
			$resultNewVideo.="<h3>Something went wrong</h3>";

			}
		}
		$resultNewVideo.="</span>";
		# code...
}
function fetchVideoByCategory($category){
	require $_SERVER['DOCUMENT_ROOT'].'/connection.php';
	$videoList="<h1 style=\"color: white;\">Sorry no Videos to show in $category.</h1>";
	if($con){
		try{
		if($category=='all'){
		$selectBrowserAll->execute();
		$selectBrowserAll->setFetchMode(PDO::FETCH_ASSOC);
		$result=$selectBrowserAll->fetchAll();

		}else{
		$selectBrowserCategory->execute();
		$selectBrowserCategory->setFetchMode(PDO::FETCH_ASSOC);
		$result=$selectBrowserCategory->fetchAll();

		}
		if(count($result)>0){
			$videoList="";
			for ($i=0; $i <count($result) ; $i++) {
			$url=$result[$i]['video_url'];
			$title=$result[$i]['title'];
			$model="<div class=\"w3-card col-md-3\" style=\"opacity: 0.9; background-color: #212121; color: white;\">
						<iframe src=\"https://www.youtube.com/embed/{videoCode}?rel=0&amp;showinfo=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>
						<h5>$title</h5>
						</div>";
			$videoCode=explode("watch?v=", $url,2);
			$videoCode=$videoCode[1];
			$model=str_replace("{videoCode}", $videoCode, $model);			
			$videoList.= $model;
				
			}
		}
		}catch(PDOException $e){
			echo $e;
		}
	}
	$con=NULL;
return $videoList;
}

function fetchCategories(){
	require $_SERVER['DOCUMENT_ROOT'].'/connection.php';
	$videoList="<h1 style=\"color: white;\">Sorry no Videos to show in $category.</h1>";
	if($con){
		try{
		$selectCategoryAll->execute();
		$selectCategoryAll->setFetchMode(PDO::FETCH_ASSOC);
		$result=$selectCategoryAll->fetchAll();


			for ($i=0; $i <count($result) ; $i++) {
				$GLOBALS['categories'].="<option value=\"".$result[$i]['category_tag']."\">".$result[$i]['category_name']."</option>";

				
			}
		}catch(PDOException $e){
			echo $e;
		}
	}
	$con=NULL;
return $videoList;
}


function fetchVideoByDeleteSearch($search){
	require $_SERVER['DOCUMENT_ROOT'].'/connection.php';
	$videoList="<h1 style=\"color: white;\">Sorry no Videos to show in $search.</h1>";
	if($con){
		try{
			echo $search;
			$search='%'.$search.'%';
		$selectDeleteSearch->execute();
		$selectDeleteSearch->setFetchMode(PDO::FETCH_ASSOC);
		$result=$selectDeleteSearch->fetchAll();

		if(count($result)>0){
			$videoList="";
			for ($i=0; $i <count($result) ; $i++) {
			$id=$result[$i]['id'];
			$url=$result[$i]['video_url'];
			$title=$result[$i]['title'];
			$description=$result[$i]['video_description'];
			$category=$result[$i]['video_category'];
			$model="	<div class=\"w3-card col-md-6\" style=\"opacity: 0.9; background-color: #212121; color: white;\">
		<div class=\"col-md-6\">
			<iframe src=\"https://www.youtube.com/embed/2ZrWHtvSog4?rel=0&amp;showinfo=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>	
		</div>
		<div class=\"col-md-6\">
		<h5>This is the title of the video</h5>
			<h5>$category</h5>
		<h6>$description</h6>
		<form class=\"col-md-12\" style=\"text-align: center;\" method=\"POST\"".htmlspecialchars($_SERVER['PHP_SELF']).">
			<button class=\"btn\" name=\"delete_video_edit\" style=\"background-color: green;\">Edit</button>
			<button class=\"btn\" type=\"submit\" name=\"delete_video_delete\" style=\"background-color: red;\" value=\"$id\">Remove</button>
		</form>
		</div>
	</div>";
			$videoCode=explode("watch?v=", $url,2);
			$videoCode=$videoCode[1];
			$model=str_replace("{videoCode}", $videoCode, $model);			
			$videoList.= $model;
				
			}
		}
		}catch(PDOException $e){
			echo $e;
		}
	}
	$con=NULL;
return $videoList;
}

if($_SERVER['REQUEST_METHOD']=='POST'){
	echo "request recieved";

	if (isset($_POST['newVideo_submit'])){
		$activeContentUpload='block';
		$activeContentBrowse='none';
		$activeContentDelete='none';
		newVideohandler();
	}
	if (isset($_POST['browse_submit'])){
		$activeContentUpload='none';
		$activeContentBrowse='block';
		$activeContentDelete='none';

		if(isset($_POST['browse_category']) and !empty(trim($_POST['browse_category']))){
			$category=dataCleaner($_POST['browse_category']);
			$videoList=fetchVideoByCategory($category);	
		}
		# code...
	}
	if (isset($_POST['delete_search'])){
		echo "Video delete search";
		$activeContentUpload='none';
		$activeContentBrowse='none';
		$activeContentDelete='block';
		if(isset($_POST['delete_search']) and !empty(trim($_POST['delete_search']))){
			$deleteSearch=dataCleaner($_POST['delete_search']);
			$deleteSearchResult=fetchVideoByDeleteSearch($deleteSearch);

		}

		# code...
	}
	if (isset($_POST['delete_video_delete'])){
		echo "Video delete called";
		$activeContentUpload='none';
		$activeContentBrowse='none';
		$activeContentDelete='block';		
		if(isset($_POST['delete_video_delete']) and !empty(trim($_POST['delete_video_delete']))){
			$id=dataCleaner($_POST['delete_video_delete']);
		deleteVideo($id);
		}


		# code...
	}

}
/*
ITray162@307*/


?>


<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/css/bootstrap.css">
  <link rel="stylesheet" href="/css/styles.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
  <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
</head>
<body>
	<section style="background-image: url(https://uims.cuchd.in/uims/bg/1.jpg); ">
	<content id="uploadnew" style="display: <?php echo $activeContentUpload;?>;">
	<div class="col-md-12">
		
	<form style="background: #212121; height: 80vh; opacity: 0.8" class="col-md-8 col-md-offset-2" method="POST" enctype="multipart/form-data" action=<?php echo ''.htmlspecialchars($_SERVER['PHP_SELF']).'';?> >
		<div class="col-md-12" style="opacity: 1.0">
			<h1 style="color: white; margin: 5px; padding: 5px; font-style: bold;">Video Gallery</h1>
			

			<div class="form-group col-md-6">
				<input type="text" required class="form-control" name="newVideo_url" placeholder="Youtube link URL">
			</div>
			<div class="form-group col-md-6">
				<input type="text" required class="form-control" name="newVideo_title" placeholder="Title">
			</div>
			<div class="form-group col-md-12">
				<input type="text" required class="form-control" style="height: 100px;" name="newVideo_description" placeholder="Descriptin about the video">
			</div>

			<div class="form-group col-md-4">
				<input type="file" required name="newVideo_thumbnail" class="btn form-control" style="text-align: center;" placeholder="Upload thubnail">
			</div>

			<div class="form-group col-md-4">
				<select class="form-control" required style="margin-top: 5px;" name="newVideo_category">
          			<option value=""><a src="img/logo.png"></a>Select Category</option>
 <?php echo $categories;  ?>
          		</select>
			</div>
			<div class="form-group col-md-4">
				<input type="date" required name="newVideo_date"class="btn form-control" style="text-align: center;" placeholder="Upload thubnail">
			</div>

			<div class="form-group col-md-6 col-md-offset-3">
				<input type="submit" class=" btn form-control" style="background-color: #0dbaf9; color: white;" name="newVideo_submit">
			</div>
		</div>
	<?php 
		if (isset($resultNewVideo)) {
		echo $resultNewVideo;
	}?>
	</form>
	</div>

	</content>
	<content id="browse" style="display: <?php echo $activeContentBrowse;?>; overflow-y: auto;">
	<div class="col-md-12" style="background: #212121; height: 80vh; opacity: 0.8; padding: 10px;">
		<form class="col-md-12" style="text-align: center;" method="POST" action=<?php echo htmlspecialchars($_SERVER['PHP_SELF']);?>>
			<button type="submit" class="btn pull-right form-group" name="browse_submit" style="background-color: #006734; color: white; margin: 5px;">Filter</button>
			<div class="form-group col-md-4 pull-right">
				<select class="form-control" style="margin-top: 5px;" name="browse_category">
          			<option value="0"><a src="img/logo.png"></a>Select Category</option>
          			<option value="all">ALL</option>
 <?php echo $categories;  ?>

          		</select>
			</div>


			</form>
		
<?php
if (isset($videoList)) {
echo $videoList;
	# code...
}else{
	echo "<h1>Select a category</h1>";
}
?>



	</div>

	</content>
	<content id="delete" style="display: <?php echo $activeContentDelete;?>; overflow-y: auto;">
	<div class="col-md-12" style="background: #212121; height: 80vh; opacity: 0.8; padding: 10px;">
		<form class="col-md-12" style="text-align: center;" method="POST" action=<?php echo htmlspecialchars($_SERVER['PHP_SELF']);?>>
			<button type="submit" name="delete_submitSearch" class="btn pull-right form-group" style="background-color: #006734; color: white; margin: 5px;">Search</button>
			<div class="form-group col-md-4 pull-right">
				<input type="text" name="delete_search" class="form-control" placeholder="Search by title">
			</div>


			</form>
		

		<?php 
		if (isset($deleteSearchResult)) {
		echo $deleteSearchResult;
	}?>



	</div>

	</content>
	<footer class="col-md-10 col-md-offset-1" style="text-align: center; color: white;">
		<div class="w3-card w3-red col-md-4" style="padding: 2px; height: 50px;" onclick="openNewVideo();">Upload Video</div>

		<div class="w3-card w3-blue col-md-4" style="padding: 2px;  height: 50px;" onclick="openVideoGallery();">Browse Gallery</div>

		<div class="w3-card w3-yellow col-md-4" style="padding: 2px;  height: 50px;" onclick="openDeleteVideo();">Delete Video</div>
	</footer>
	</section>
</body>
<script type="text/javascript">
	function openVideoGallery(){
		var x=document.getElementById('uploadnew');
		var y=document.getElementById('browse');
		var z=document.getElementById('delete');
		x.style.display="none";
		y.style.display="block";
		z.style.display="none";
	}
	function openNewVideo(){
		var x=document.getElementById('uploadnew');
		var y=document.getElementById('browse');
		var z=document.getElementById('delete');
		x.style.display="block";
		y.style.display="none";
		z.style.display="none";
	}
	function openDeleteVideo(){
		var x=document.getElementById('uploadnew');
		var y=document.getElementById('browse');
		var z=document.getElementById('delete');
		x.style.display="none";
		y.style.display="none";
		z.style.display="block";
	}
</script>
</html>