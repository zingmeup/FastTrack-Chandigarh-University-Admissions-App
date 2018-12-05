<?php
error_reporting(0);
function getByCategory($category){
  $data="";
  require $_SERVER['DOCUMENT_ROOT']."/res/conxtion.php";
  if($category==NULL){
    $query=mysqli_query($conx, "SELECT video_code FROM video_gallery ORDER BY date_on DESC");
  }
  else{
    $query=mysqli_query($conx, "SELECT video_code,category FROM video_gallery WHERE category='$category'"); 
  }
      if($query){
      if(mysqli_num_rows($query)>0){
                  while($row=mysqli_fetch_array($query)){ 
                    $data.='<iframe class="video" src="https://www.youtube.com/embed/'.$row['video_code'].'?rel=0" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>';
                  }

      }else{
        $data="<br><h1>No more videos to show, Stay tuned</h1><br>";

      } 
    }else{
      echo "query failed".mysqli_error($conx);
    }
    mysqli_close($conx);
  return $data;
}
function addByCategory($video_code,$category,$time){
  require $_SERVER['DOCUMENT_ROOT']."/res/conxtion.php";
    $query=mysqli_query($conx, "INSERT INTO video_gallery VALUES('$video_code', '$category', '$time')");
      if($query){
          echo "<h1>Added</h1>";
      }else{
          echo "query failed".mysqli_error($conx);
      } 
    mysqli_close($conx);
  
}

if (isset($_GET['video_code'])&&isset($_GET['category'])&&isset($_GET['date_on'])){
 addByCategory($_GET['video_code'],$_GET['category'],$_GET['date_on']);
}else{
$_GLOBALS['data']=getByCategory($_GET['category']);
}

?>
<!DOCTYPE html>
<html>
<head>
	<title></title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">
  	.full{
  		height: 100vh;
  	}
  	.half{
  		height: 50vh;

  	}
  	.quat{
  		height: 25vh;

  	}
  	.quatmargin{
  		border-radius: 10px;
  		padding: 10px;
  		height: 25vh;
  		border: 1px;
  		border-style: solid;
  		border-color: white;

  	}
  	img{
  		width: 100px;
  		height: 100px;
  		margin: auto;
  	}
  	.video{
      padding: 5px;
      border-radius: 15px;
  		width: 100vw;
  		height: 25ch;
  	}
  </style>
</head>
<body style="background-color: #212121">
	<div>

    <?php echo $_GLOBALS['data'];  ?>
	</div>
</body>
</html>