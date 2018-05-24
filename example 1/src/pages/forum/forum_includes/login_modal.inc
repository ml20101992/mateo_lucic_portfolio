<div id="login-modal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close" id="close_signup">&times;</span>
        <?php
        if($filename == "forum_index.php"){
            $signupAction = "forum_pages/".$signupAction;
        }
        ?>
        <div class="login_form">
            <h3 style="color:black;">Sign up</h3>
            <form action="<?php echo $signupAction ?>" method="post">
                <input name="username" placeholder="Username"><br>
                <input name="password" placeholder="Password" type="password"><br>
                <input name="email"  placeholder="eMail" type="email">
                <input onsubmit="validate()" type="submit">
            </form>
        </div>
    </div>

</div>