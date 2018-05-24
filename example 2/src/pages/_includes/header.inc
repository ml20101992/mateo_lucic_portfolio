<?php

    /*
     * DECLARING SOME USEFUL FUNCTIONS
     */
            /*
             * FUNCTION USED TO RETURN THE PAGE NAME
             */
            function getPageName($url,$nameHoldingArray){
                foreach ($nameHoldingArray as $value){
                    if(strpos($url,$value) != false) return $value;
                }
            }

            /*
             * FUNCTION USED TO GET CSS PATH
             */
            function getCSSPath($filename){
                if($filename == "index.php") return 'css/';
                else return '../css/';
            }

            /*
             * FUNCTION USED TO GET FONTS PATH
             */
            function getFontsPath($filename){
                if($filename == "index.php") return 'fonts/';
                else return '../fonts/';
            }

            /*
             * FUNCTION USED FOR GENERATING LINKS FOR NAVIGATION
             */
            function getLinkPath($filename,$to){
                if($filename == "index.php"){
                    if ($to != "index.php"){
                        return 'pages/';
                    }
                    else return '';

                }
                else{
                    if($to == "index.php") return "../";
                    else return "";
                }
            }

    /*
     * dynamically configuring the path for includes
     */
    $page_url =$_SERVER['PHP_SELF'];    //getting the url

    $page_names = array("index.php","page.php","comments.php");

    $pageName = getPageName($page_url,$page_names);

    $path = "_includes/";

    if($pageName == "index.php"){
        $path = "pages/".$path;
    }

    include_once $path."db_conn_info.inc";
    include_once $path."db_functions.inc";


    $scriptPath = "scripts/script.js";
    if($pageName != "index.php"){
        $scriptPath = "../".$scriptPath;
    }

    $imagePath = "media";
    if($pageName != "index.php"){
        $imagePath = "../".$imagePath;
    }

    $conn = connect($username,$password,$database);

    $id = 0;
    if(!($pageName == "index.php" || $pageName == "comments.php")) $id = $_GET['id'];
    //echo getTitle($conn,$pageName);

?>

<!-- configuring <head> -->

<!DOCTYPE html>
<html lang="en">

<head>
    <title><?php echo getTitle($conn,$pageName,$id)?></title>

    <!-- METADATA -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <!-- CSS -->
    <link rel="stylesheet" href="<?php echo getCSSPath($pageName).'normalize.css'; ?>">
    <link rel="stylesheet" href="<?php echo getCSSPath($pageName).'style.css'; ?>">
    <link rel="stylesheet" href="<?php echo getCSSPath($pageName).'queries.css'; ?>">


    <!-- FONTS -->
    <link rel="stylesheet" href="<?php echo getFontsPath($pageName).'font-awesome-4.7.0/css/font-awesome.min.css'?>" type="text/css">

</head>

<body>
<?php include_once $path."image_full.inc"; ?>
    <nav>
        <div class="page_title">
            <h2><?php echo getTitle($conn,$pageName,$id)?></h2>
        </div>

        <div class="navigation_links_container">

            <a class="nav_link" id="nav4" href="<?php echo getLinkPath($pageName,"comments.php").'comments.php';?>">Comments</a>


            <a class="nav_link" id="nav3" href="<?php echo getLinkPath($pageName,"page.php").'page.php?id=2';  ?>">Visiting</a>


            <a class="nav_link" id="nav2" href="<?php echo getLinkPath($pageName,"page.php").'page.php?id=1';  ?>">Hotels</a>


            <a class="nav_link" id="nav1" href="<?php echo getLinkPath($pageName,"index.php").'index.php';  ?>">Home</a>

            <div class="nav_link" id="expand_button" onclick="expandNav()">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </nav>
    <div id="spacing_div"></div>
    <div id="content">

