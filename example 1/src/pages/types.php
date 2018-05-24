<?php
/**
 * Created by PhpStorm.
 * User: Mateo
 * Date: 05-Dec-17
 * Time: 16:31
 */

include_once "includes/connect.inc";
include_once "includes/db_functions.inc";
include_once "includes/header.inc";


?>
<!DOCTYPE html>

<html lang="en">
<head>


</head>

<body>

<div class="container div-bg show breadcrumb-nav">
<div id="breadcrumb-nav" class="container show">
    <br>
    <div class="row d-flex flex-row align-content-center">
        <div class="col-12 d-flex align-content-center">
            <nav id="page_title"><h1>Types of Coffee</h1></nav>
        </div>
    </div>
    <br>
    <hr class="hr-line">
    <div class="row">
        &nbsp;
    </div>

</div>
    <br>

    <div class="row">
        <div class="col-12">
            <h2 class="region-names">How to divide the Coffee</h2>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-12">
            <p class="ml-4 region-texts">
                How can you even divide the glory that is coffee in some arbitrary types?
                <br><br>
                Easy, my fellow coffee addict! After all, not all coffee is created equal!
                <br><br>
                We can divide coffee into two divisions. One division is by the bean itself, while the other division is by the end product itself!
                Yes, I did not know there are two types of coffee as well before doing my research.
                <br><br>
                Don't let us stop you there! Dive in and see the differences by yourself!
            </p>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-1">

        </div>
        <div class="col-4">
            <a href="page.php?id=2">
                <img class="img-fluid" alt="PLACEHOLDER" src="../assets/images/thumbs/typesofbeans.jpg">
            </a>
        </div>
        <div class="col-2"></div>
        <div class="col-4">
            <a href="page.php?id=6">
                <img class="img-fluid" alt="PLACEHOLDER" src="../assets/images/thumbs/typesofproduct.jpg">
            </a>
        </div>
        <div class="col-1"></div>
    </div>
    <br><br><br>

</div>

</body>

</html>

<?php
include_once "includes/footer.inc";
?>