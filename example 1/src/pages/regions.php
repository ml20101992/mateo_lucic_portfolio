<?php
/**
 * Created by PhpStorm.
 * User: Mateo
 * Date: 05-Dec-17
 * Time: 15:08
 */


include_once "includes/connect.inc";
include_once "includes/db_functions.inc";
include_once "includes/header.inc";


?>
<div id="breadcrumb-nav" class="container breadcrumb-nav">
    <div class="row d-flex flex-row align-content-center">
        <div class="col-12 d-flex align-content-center">
            <nav id="page_title"><h1>Where can you find Coffee?</h1></nav>
        </div>
    </div>
    <hr class="hr-line">
    <br>
    <br>
    <div class="row">
        <div class="col-12">
            <p class="ml-4 region-texts">
                Where can you find coffee? I mean, it does not grow on the trees!
                <br><br>
                ...
                <br><br>
                Actually yes, it does. Why don't we have those trees providing us with the glory that is coffee everywhere?
                <br><br>
                You see, coffee trees are not like potatoes that can grow anywhere! You actually need to have some favourable conditions for coffee to grow!
                <br><br>
                Here are some of the more interesting locations that grow coffee and some interesting facts about coffee culture!
                <br><br>
            </p>
        </div>
    </div>
    <div class="row">
        <div class="col-3 dd">
            <a href="page.php?id=10">
                <img class="img-fluid bottom" src="../assets/images/thumbs/america1.png" height="200" width="200">
                <img class="img-fluid top" src="../assets/images/thumbs/america.png" height="200" width="200">

            </a>
        </div>
        <div class="col-3 dd">
            <a href="page.php?id=9">
                <img class="img-fluid bottom" src="../assets/images/thumbs/europa1.png" height="200" width="200">
                <img class="img-fluid top" src="../assets/images/thumbs/europa.png" height="200" width="200">
            </a>
        </div>
        <div class="col-3 dd">
            <a href="page.php?id=7">
                <img class="img-fluid bottom" src="../assets/images/thumbs/africa1.png" height="200" width="200">
                <img class="img-fluid top" src="../assets/images/thumbs/africa.png" height="200" width="200">
            </a>
        </div>
        <div class="col-3 dd">
            <a href="page.php?id=8">
                <img class="img-fluid bottom" src="../assets/images/thumbs/asia1.png" height="200" width="200">
                <img class="img-fluid top" src="../assets/images/thumbs/asia.png" height="200" width="200">
            </a>
        </div>

    </div>
    <br>
    <div class="row justify-content-center">
        <div class="col-3 text-center">
            <p class="region-names">Americas</p>
        </div>
        <div class="col-3 text-center">
            <p class="region-names">Europe</p>
        </div>
        <div class="col-3 text-center">
            <p class="region-names">Africa</p>
        </div>
        <div class="col-3 text-center">
            <p class="region-names">Asia</p>
        </div>
    </div>
</div>
<br>
<br>
<br>


    <?php
include_once "includes/footer.inc";
?>