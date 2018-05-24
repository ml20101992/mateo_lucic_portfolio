<?php
/**
 * Created by PhpStorm.
 * User: Mateo
 * Date: 01-Dec-17
 * Time: 09:09
 */

session_start();
session_unset();
session_destroy();

echo '<script>window.location = "http://serenity.ist.rit.edu/~group1700/240/pages/forum/forum_index.php"</script>';
?>




