<?php
/**
 * Created by PhpStorm.
 * User: Mateo
 * Date: 26-Nov-17
 * Time: 21:16
 */

error_reporting(E_ALL);
ini_set('display_errors', 1);

//include_once "../includes/connect.inc";
//include_once "forum_includes/conn_functions.inc";
//include_once "../includes/header.inc";
include_once "forum_includes/forum_header.inc";



$dbConnection = connect_forum($username,$password,$database);

?>

<div class="container-fluid">

    <?php
        populateCategories($dbConnection);
    ?>
</div>

    </div>
<?php
mysqli_close($dbConnection);
include_once "../includes/footer.inc";
?>