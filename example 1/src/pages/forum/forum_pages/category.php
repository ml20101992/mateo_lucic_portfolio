<?php
/**
 * Created by PhpStorm.
 * User: Mateo
 * Date: 29-Nov-17
 * Time: 10:44
 */

include_once "../forum_includes/forum_header.inc";


$id = $_GET['id'];

$conn = connect_forum($username,$password,$database);

?>
<button id="thread_button_text" style="display: none">New Thread</button>
<div class="button_holder">
    <button id="thread_button" class="forum-buttons-other" onclick="displayOptions(<?php echo isset($_SESSION['uid'])?>)">New Thread</button>
</div>
<div class="new_thread_form_holder">
    <p id="login_fail">Please log in to post</p>
    <form id="login_ok" method="post" action="<?php if($filename == "forum_index.php") echo 'forum_pages/post.php'; else echo 'post.php'?>">
        <input name="topic_subject" placeholder="Topic name here" style="width: 100%"><br><br>
        <textarea name="first_post" placeholder="Text of first post here!" style="width: 100%" rows="10"></textarea>
        <input name="cat_id" value="<?php echo $_GET['id']?>" style="display:none;">
        <input name="post_type" value="topic" style="display:none;">
        <input name="Submit" type="submit" value="Post">
    </form>
</div>
<div class="content_container">
    <div class="category_name">
        <h2>
            <?php echo getCategoryName($conn,$id);?>
        </h2>


    </div>

    <?php
        populateTopicsFromCategory($conn,$id);
    ?>

</div>


    </div>
<?php
mysqli_close($conn);

include_once "../../includes/footer.inc";