<?php
/**
 * Created by PhpStorm.
 * User: Mateo
 * Date: 30-Nov-17
 * Time: 23:40
 */
session_start();

include_once "../../includes/connect.inc";
include_once "../forum_includes/conn_functions.inc";

function checkLogin($username,$password,$database)
{
    //echo 'starting<br>';
    if (isset($_POST)) {
        //echo 'post exists<br>';
        $conn = connect_forum($username, $password, $database);
        if(!$conn) echo 'error connecting<br>';
        else{
            //echo 'conn ok <br>';
        }
        $q = 'SELECT user_id FROM users WHERE user_name ="'.$_POST['username'].'" AND user_pass = "'.$_POST['password'].'"';
        $result = $conn->query($q);

        if($result == "FALSE"){
            echo ' entry 404 <br>';
            return false;
        }
        else {
            $parsedResult = $result->fetch_assoc();
            $_SESSION['uid'] = $parsedResult['user_id'];
            return true;
        }


    }


    echo 'lolwut';
    return false;
}

?>
<head>
    <link rel="stylesheet" type="text/css" href="../../../css/style.css">
</head>
<body>
    <div id="login_fail">
        <p>! Invalid username and/or password</p>
    </div>
    <div id="login_ok">
        <p>You are logged in.</p>
    </div>
    <?php
        if(checkLogin($username,$password,$database) ){
            echo '<script>document.getElementById("login_ok").style.display = "block"; </script>';
            echo '<script>window.location = "http://serenity.ist.rit.edu/~group1700/240/pages/forum/forum_index.php"</script>';
        }
        else{
            echo '<script>document.getElementById("login_fail").style.display = "block"; </script>';
        }
    ?>
</body>
