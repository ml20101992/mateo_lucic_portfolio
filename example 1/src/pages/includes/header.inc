<?php

ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

/*
 * DECLARING SOME USEFUL FUNCTIONS
 */
/*
 * FUNCTION USED TO RETURN THE PAGE NAME
 */
function getPageName($url,$nameHoldingArray){
    if(strpos($url,"forum_index.php")) return "forum_index.php";

    foreach ($nameHoldingArray as $value){
        if(strpos($url,$value) != false) return $value;
    }
}

/*
 * FUNCTION USED TO GET CSS PATH
 */
function getRootPath($filename){
    switch ($filename){
        case "index.php": return "";
        case "page.php": return "../";
        case "types.php": return "../";
        case "regions.php": return "../";
        case "gallery.php": return "../";
        case "forum_index.php": return "../../";
        default: return "../../../";
    }
}

if (!key_exists("id",$_GET)){
    $_GET['id'] = 0;
}



/*
 * dynamically configuring the path for includes
 */
$page_url =$_SERVER['PHP_SELF'];    //getting the url

$page_names = array("index.php","page.php","forum_index.php","category.php","thread.php","regions.php","types.php","gallery.php");

$pageName = getPageName($page_url,$page_names);

//echo $pageName;

//echo getRootPath($pageName);

$dbConnection = connect($server,$username,$password,$database);

?>
<!DOCTYPE html>

<html lang="en">

<head>
    <!-- METADATA -->
    <title>KofiTuGo</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="<?php echo getRootPath($pageName).'css/bootstrap.css'?>">
    <link rel="stylesheet" type="text/css" href="<?php echo getRootPath($pageName).'css/style.css'?>">

    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

</head>

<body>

<div class="div-bg container-fluid fixed-top nav-bg">
    <nav class="navbar navbar-expand-md navbar-dark bg-faded">
        <a id="logo" class="navbar-brand" href="<?php echo getRootPath($pageName)."index.php" ?>">
            <span id="logo">KOFI TU GO</span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse flex-row justify-content-end" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" id="home" href="<?php echo getRootPath($pageName)."index.php" ?>">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="about" href="<?php echo getRootPath($pageName)."pages/page.php?id=1" ?>">About Coffee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="types" href="<?php echo getRootPath($pageName)."pages/types.php" ?>">Types of Coffee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="regions" href="<?php echo getRootPath($pageName)."pages/regions.php" ?>">Coffee by Regions</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="harvesting" href="<?php echo getRootPath($pageName)."pages/page.php?id=4"?>">Harvesting</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="trivia" href="<?php echo getRootPath($pageName)."pages/page.php?id=5"?>">Trivia</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="faq" href="<?php echo getRootPath($pageName)."pages/page.php?id=3" ?>">FAQ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="forum" href="<?php echo getRootPath($pageName)."pages/forum/forum_index.php" ?>">Forum</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<br><br><br>



