<?php

if(isset($_GET['code'])){
	$url=$_GET['code'];
	$model="
	<iframe class=\"videoFrame\" style=\"float: left;\" align=\"middle\" src=\"https://www.youtube.com/embed/".$url."?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
}

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
  <style type="text/css">
  	.videoFrame{
  		margin-top: 30vh;
  		width: 100vw;
  		height: 35vh;
  	}
  </style>
</head>
<body style="background-color: #000;">
	<content>
		<?php
		if (isset($model)) {
		echo $model;
		 	# code...
		 } ?>
		
	</content>
</body>
</html>