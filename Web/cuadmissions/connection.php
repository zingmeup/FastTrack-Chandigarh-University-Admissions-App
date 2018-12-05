<?php
$servername="mysql.hostinger.in";
$username="u332240463_cuadm";
$password="amazing";
$dbname="u332240463_ft";

$con=NULL;
try{
	$con=new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
	$con->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
	$insertVideoStmt=$con->prepare("INSERT INTO video_gallery VALUES('', :title,'',:category,:video_url,:date,:description)");
	$insertVideoStmt->bindParam(':title', $title);
	$insertVideoStmt->bindParam(':category', $category);
	$insertVideoStmt->bindParam(':video_url', $url);
	$insertVideoStmt->bindParam(':date', $date);
	$insertVideoStmt->bindParam(':description', $description);

	$updateImageRef=$con->prepare("UPDATE video_gallery SET thumbnail_image=:imageref WHERE id=:lastId");
	$updateImageRef->bindParam(':imageref', $imageref);

	$selectBrowserAll=$con->prepare("SELECT * FROM video_gallery ORDER BY date");
	$selectBrowserCategory=$con->prepare("SELECT * FROM video_gallery WHERE video_category=:category ORDER BY date");
	$selectBrowserCategory->bindParam(':category', $category);

	$selectDeleteSearch=$con->prepare("SELECT * FROM video_gallery WHERE title LIKE :search");
	$selectDeleteSearch->bindParam(':search', $search,PDO::PARAM_STR);

	$deleteDeleteSearch=$con->prepare("DELETE FROM video_gallery WHERE id=:id");
	$deleteDeleteSearch->bindParam(':id', $id,PDO::PARAM_STR);


	$selectCategoryAll=$con->prepare("SELECT * FROM categories");
	

}catch(PDOException $e){
	echo "Connection Failed".$e;
}



?>