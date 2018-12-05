<?php


if ($_SERVER['REQUEST_METHOD']=='POST'){
	if (isset($_POST['submit'])) {
/*		echo " SUBMITED"."<br>";
		$a=explode("-",$_POST['date'],3);
		echo $a[0];
		echo $a[1];
		echo $a[2];*/


		$check= getimagesize($_FILES['filetoupload']['tmp_name']);
		$targetfile=basename($_FILES['filetoupload']['name']);
		$imageFileType = strtolower(pathinfo($targetfile,PATHINFO_EXTENSION));
		echo $targetfile.'<br>';
		echo $imageFileType.'<br>';
		echo $check['mime'].'<br>';

		if(move_uploaded_file($_FILES['filetoupload']['tmp_name'], 'uploads/'.$targetfile)){
			echo "done";
		}else{
			echo "not done";
		}





	}
	# code...
}
/*	function dataCleaner($dirty){
	$clean=htmlspecialchars(strip_tags(addslashes(trim($dirty))));
	return $clean;
	}*/

?>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
<!-- 	<form method="POST" enctype="multipart/form-data" action=<?php echo $_SERVER['PHP_SELF'];?>>
		<input type="file" name="filetoupload"><br>
		<input type="submit" name="submit">
	</form> -->
	<form method="POST" enctype="multipart/form-data" action=<?php echo htmlspecialchars($_SERVER['PHP_SELF']);?>>
		<input type="file" name="filetoupload">
		<input type="submit" name="submit">
	</form>




</body>
</html>