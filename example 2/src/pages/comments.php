<?php
/**
 * Created by PhpStorm.
 * User: Mateo
 * Date: 02-Dec-17
 * Time: 14:21
 */

include_once "_includes/header.inc";

function validateCaptcha($c_response){
    $url = 'https://www.google.com/recaptcha/api/siteverify';
    $data = array(
        'secret' => '6LfpeDoUAAAAAFwTuYEuYCueEMVBYJVN2iqeIfE6',
        'response' => $c_response
    );
    $options = array(
        'http' => array (
            'method' => 'POST',
            'content' => http_build_query($data)
        )
    );
    $context  = stream_context_create($options);
    $verify = file_get_contents($url, false, $context);
    return json_decode($verify);
}

$filtered = array();
$errors = array();
if($_SERVER["REQUEST_METHOD"] == "POST"){


    if(filter_has_var(INPUT_POST,'poster')) {
        if (strlen($_POST['poster']) == 0) {
            $errors[] = "Error in Poster Name entry. Poster name must not be empty!";
        } else if (strlen($_POST['poster']) < 3) {
            $errors[] = "Error in Poster Name entry. Poster name must not be shorter than three letters!";
        }
        else {
            $filtered['poster'] = filter_input(INPUT_POST, 'poster', FILTER_SANITIZE_STRING);
        }
    }

    if(filter_has_var(INPUT_POST,'comment')){
        if (strlen($_POST['comment']) == 0) {
            $errors[] = "Error in Comment entry. Comment must not be empty!";
        } else if (strlen($_POST['comment']) < 3) {
            $errors[] = "Error in Comment entry. Comment must not be shorter than three letters!";
        }
        else {
            $filtered['comment'] = filter_input(INPUT_POST, 'comment', FILTER_SANITIZE_STRING);
        }
    }

    if(validateCaptcha($_POST['g-recaptcha-response'])->success == false)
    {
        $errors[] = "Invalid captcha";
//        echo '<script>alert("Invalid captcha")</script>';
    }

    if (sizeof($errors) == 0){
        postComment($conn,$filtered);
    }
}
?>

    <section>
        <button id="expand_post" class="buttons" onclick="showPost()">Leave a comment!</button>
        <div id="error_log">
            <?php
                foreach ($errors as $value) { ?>
                    <div style="color:lightcoral"><?php echo $value?></div>
            <?php }
            if(sizeof($errors)==0 && count($filtered)>0) echo '<div style="color:lightgreen">Post successful!</div>'?>
        </div>
        <div id="form_div">
            <form name="comment_form" action="<?php echo $_SERVER['PHP_SELF'];?>" method="post" onsubmit="return validate()">
                <input id="poster_name" name="poster" placeholder="Your name here"><br>

                <textarea name="comment" placeholder="Your comment here" rows="10"></textarea><br>

                <div class="captcha">
                    <div class="g-recaptcha" data-sitekey="6LfpeDoUAAAAABVE19z0xXYx-4jaNr5nn961ZF0h"></div><br/>
                </div>

                <input class="buttons" name="submit" value="Submit post!" type="submit"><br>
            </form>
        </div>

    </section>

<?php
    $comments = getCommentData($conn);

    foreach ($comments as $value){ ?>
        <section>
            <div class="comment_box">
                <h4><?php echo $value['poster_name'];?></h4>
                <p><?php echo $value['post'];?></p>
            </div>
        </section>

    <?php }
?>



<?php
include_once "_includes/footer.inc";
?>