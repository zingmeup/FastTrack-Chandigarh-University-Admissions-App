<?php
$servername="localhost";
$username="root";
$password="";
$dbname="fasttrack";

$con=NULL;
try{
	$con=new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
	$con->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
	$selectBrowserAll=$con->prepare("SELECT * FROM video_gallery ORDER BY date");
	$selectBrowserCategory=$con->prepare("SELECT * FROM video_gallery WHERE video_category=:category ORDER BY date");
	$selectBrowserCategory->bindParam(':category', $category);
	$selectCategoryAll=$con->prepare("SELECT * FROM categories");
	

}catch(PDOException $e){
	echo "Connection Failed".$e;
}



?>