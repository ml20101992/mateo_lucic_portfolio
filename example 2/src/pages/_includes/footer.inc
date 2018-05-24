    </div>
    <footer>
        <p>Mateo Lucic, 2017, Web and Mobile 2, RIT Croatia <a href="<?php echo getLinkPath($pageName,"references.html").'references.html'?>">References</a> <a href="<?php echo getLinkPath($pageName,"rubrics.html").'rubrics.html'?>">Rubrics</a></p>
    </footer>
    <?php
    ?>
    <!--google maps api-->
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA_EFEyfmXtDHiL2FiG0t88vvQeSHonjoQ&callback=initMap"
            type="text/javascript"></script>
    <script src="<?php echo $scriptPath ?>"></script>
    <?php
    if( basename($_SERVER['PHP_SELF']) == "comments.php")
    {
        echo '<script src="https://www.google.com/recaptcha/api.js" async defer></script>';
    }

    ?>
    </body>
    </html>