<div id="myModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <?php
        if($filename == "forum_index.php"){
            $loginAction = "forum_pages/".$loginAction;
        }
        ?>
        <div class="login_form">
            <form action="<?php echo $loginAction ?>" method="post">
                <input name="username" placeholder="Username"><br>
                <input name="password" placeholder="Password" type="password"><br>
                <input onsubmit="validate()" type="submit">
            </form>
        </div>
    </div>

</div>