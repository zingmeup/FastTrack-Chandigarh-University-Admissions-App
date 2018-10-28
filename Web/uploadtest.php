<?php
$list=array();
$list=scandir("uploads/photogallery/cufest");

print_r(shuffle($list));


for ($i=0; $i < count($list); $i++) { 
	echo $list[$i].'<br>';
	# code...
}