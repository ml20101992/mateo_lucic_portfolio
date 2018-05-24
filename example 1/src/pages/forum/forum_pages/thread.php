<?php
/**
 * Created by PhpStorm.
 * User: Mateo
 * Date: 29-Nov-17
 * Time: 18:47
 */

include_once "../forum_includes/forum_header.inc";



if(!array_key_exists('page',$_GET)){
        $_GET['page'] = 1;
}

//echo $_GET['page'];

$dbConnection = connect_forum($username,$password,$database);

?>
    <button id="thread_button_text" style="display: none">Reply</button>
    <div class="button_holder">
        <button id="thread_button" class="forum-buttons-other" onclick="displayOptions(<?php echo isset($_SESSION['uid'])?>)">Reply</button>
    </div>
    <div class="new_thread_form_holder">
        <p id="login_fail">Please log in to post</p>
        <form id="login_ok" method="post" action="<?php if($filename == "forum_index.php") echo 'forum_pages/post.php'; else echo 'post.php'?>">
            <textarea name="post_content" placeholder="Your post here!" style="width: 100%" rows="10" ></textarea>
            <input name="thread_id" value="<?php echo $_GET['id']?>" style="display:none;">
            <input name="post_type" value="reply" style="display:none;">
            <input name="Submit" type="submit" value="Post">
        </form>
    </div>
<div class="thread">
    <div class="thread_header">
        <div class="thread_name">
            <h4><?php echo getThreadName($dbConnection,$_GET['id']); ?></h4>
        </div>
        <div class="thread_page">
            <?php createThreadNav($dbConnection,$_GET['id']) ?>
        </div>
    </div>
    <div class="posts">
        <?php populatePosts($dbConnection,$_GET['id'],$_GET['page']); ?>
    </div>

</div>

    </div>
<?php
mysqli_close($conn);

include_once "../../includes/footer.inc";
