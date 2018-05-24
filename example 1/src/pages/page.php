<?php

include_once "includes/connect.inc";
include_once "includes/db_functions.inc";
include_once "includes/header.inc";


?>
<div id="breadcrumb-nav" class="container breadcrumb-nav">
    <br>
    <div class="row d-flex flex-row align-content-center">
        <div class="col-12 d-flex align-content-center">
            <nav id="page_title"><h1><?php echo getPageTitle($dbConnection,$_GET['id'])?></h1></nav>
        </div>
    </div>
    <br>
    <hr class="hr-line">
    <div class="row">
        &nbsp;
    </div>


    <?php populate_page($dbConnection,$_GET['id']); ?>
</div>


<?php
include_once "includes/footer.inc";
?>





