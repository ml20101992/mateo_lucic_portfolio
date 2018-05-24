<?php

    $path = "../";
    $string =$_SERVER['PHP_SELF'];
    $filename = explode("/",$_SERVER['PHP_SELF']);

    $loginAction = "login.php";
    $logoutAction = "logout.php";
    $signupAction = "signup.php";

    $filename = $filename[sizeof($filename)-1];
    if($filename == "forum_index.php"){
        include_once "../includes/connect.inc";
        include_once "../includes/db_functions.inc";
        include_once "../includes/header.inc";
        include_once "forum_includes/conn_functions.inc";
        include_once "forum_includes/modal.inc";
        include_once "forum_includes/login_modal.inc";
        $logoutAction= "forum_pages/".$logoutAction;
    }
    else{
        include_once "../../includes/connect.inc";
        include_once "../../includes/db_functions.inc";
        include_once "../../includes/header.inc";
        include_once "../forum_includes/conn_functions.inc";
        include_once "../forum_includes/modal.inc";
        include_once "../forum_includes/login_modal.inc";

    }

    $conn = connect_forum($username,$password,$database);
    session_start();
    //$_SESSION['uid']=1;
    //session_unset();


?>
<div class="forum_holder">
<div class="forum_header">
    <div class="default_holder">
        <div id="page_title"><p style="display:none;">Forum</p></div>
    </div>
    <div class="nav_holder">
        <div class="nav-element">
            <a href="<?php echo getRootPath($pageName).'pages/forum/forum_index.php'?>">Forum Index</a>
        </div>
        <div class="nav-element" >
            <?php
            if(array_key_exists("message",$_GET)){
                echo '<p>Congratulations! You have created your new account!</p>';
            }
            ?>
        </div>
        <div class="nav-element" >
            <?php configureLoginElement($conn,$logoutAction)?>
        </div>

    </div>


</div>















