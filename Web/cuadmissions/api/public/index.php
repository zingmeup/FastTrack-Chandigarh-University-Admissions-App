<?php
use \Psr\Http\Message\ServerRequestInterface as Request;
use \Psr\Http\Message\ResponseInterface as Response;

require '../vendor/autoload.php';
function dataCleaner($dirty){
	$clean=htmlspecialchars(strip_tags(addslashes(trim($dirty))));
	return $clean;
}
function dataDecoder($dirty){
	$clean=htmlspecialchars_decode(strip_tags(stripcslashes(trim($dirty))));
	return $clean;
}

$app = new \Slim\App;
$app->get('/category/{category}', function (Request $request, Response $response, array $args) {
	$response=array();
	$response['error']=null;
    $categories=['all','cufest','techfest','freshers','students','visitors','official','all','sports', 'clubactivity','achimile','life'];
    $category = dataCleaner($args['category']);
    if (in_array($category, $categories)) {
    	require_once '../src/connection.php';
    	if ($category!='all') {
    		$selectBrowserCategory->execute();
			$selectBrowserCategory->setFetchMode(PDO::FETCH_ASSOC);
			$response['result']=$selectBrowserCategory->fetchAll();
    	}else{
    		$selectBrowserAll->execute();
			$selectBrowserAll->setFetchMode(PDO::FETCH_ASSOC);
			$response['result']=$selectBrowserAll->fetchAll();

    	
    	}
	
    	
    }else{
    	$response['error']="no such category";
    }
    




    echo json_encode($response);

});
$app->get('/categories', function (Request $request, Response $response, array $args) {
        require_once '../src/connection.php';
            $response=array();
            $response['error']=null;
            if($con){

            $selectCategoryAll->execute();
            $selectCategoryAll->setFetchMode(PDO::FETCH_ASSOC);
            $response['result']=$selectCategoryAll->fetchAll();
   
        }else{
            $response['error']="Connectoion failed";
        
        }
        
    




    echo json_encode($response);

});
$app->get('/photo/{category}', function (Request $request, Response $response, array $args) {
	$dir=$_SERVER['DOCUMENT_ROOT'].'/uploads/photogallery/';
	$response=array();
    $categories=['cufest','techfest','freshers','students','visitors','official','sports', 'clubactivity','achimile','life'];
	if( in_array($args['category'], $categories)){
            $response['error']=null;
            $result=scandir($dir.$args['category'].'/thumb');
            shuffle($result);
            $temp_result=array();
            $junk=0;
            for ($i=0; $i < count($result); $i++) {
            	if ($result[$i]!='.' AND $result[$i]!='..') {
            	$temp_result[$i]['thumb_loc']='uploads/photogallery/'.$args['category'].'/thumb/'.$result[$i];
            	$temp_result[$i]['full_loc']='uploads/photogallery/'.$args['category'].'/'.$result[$i];
            	$extension=strtolower(pathinfo(basename($result[$i]),PATHINFO_EXTENSION ));
            	$title=str_replace('.'.$extension, '', $result[$i]);
            	$temp_result[$i]['title']=$title;
            	$response['result'][$junk++]=$temp_result[$i];
            	}

            }
            $result=$temp_result;
            //var_dump($result);


	}else{
		$response['error']="no such category";

	}  
    




    echo json_encode($response);

});



$app->run();
$con=null;