<?php
/**
 * Created by PhpStorm.
 * User: Mateo
 * Date: 01-Dec-17
 * Time: 09:56
 */

session_start();
include_once "../../includes/connect.inc";
include_once "../forum_includes/conn_functions.inc";
$dbConn = connect_forum($username,$password,$database);

//INSERT INTO `topics` (`topic_id`, `topic_subject`, `topic_date`, `topic_cat`, `topic_by`) VALUES (NULL, 'testing topic insert', '2017-12-31 00:00:00', '1', '1');
function newTopic($conn,$uid,$topic_cat,$topic_subject,$first_post){
    $currDate = date("Y-m-d H:i:s");
    $q = "INSERT INTO topics (topic_subject, topic_date, topic_cat, topic_by) VALUES ('".$topic_subject."','".$currDate."','".$topic_cat."','".$uid."')";
    $result = $conn->query($q);

    if(!$result) echo mysqli_error($conn);

    $topicID = $conn->query('SELECT topic_id FROM topics WHERE topic_by='.$uid.' AND topic_date="'.$currDate.'"');
    if(!$topicID) echo mysqli_error($conn);

    $topicID = $topicID->fetch_assoc();
    $topicID = $topicID['topic_id'];


    postReply($conn,$first_post,$currDate,$topicID,$_SESSION['uid']);
}
function postReply($conn,$post_content,$post_date,$post_topic,$post_by){
    $q = "INSERT INTO posts (post_content,post_date,post_topic,post_by) VALUES ('".$post_content."','".$post_date."','".$post_topic."','".$post_by."')";
    $result = $conn->query($q);

    if(!$result) echo mysqli_error($conn);

}
if($_POST['post_type'] == "topic"){
    newTopic($dbConn,$_SESSION['uid'],$_POST['cat_id'],$_POST['topic_subject'],$_POST['first_post']);
    //echo $_POST['cat_id'];

    $newURL = "http://serenity.ist.rit.edu/~group1700/240/pages/forum/forum_pages/category.php?id=".$_POST['cat_id'];
    header('Location: '.$newURL);
}
else if($_POST['post_type'] == "reply"){
    postReply($dbConn,$_POST['post_content'],date("Y-m-d H:i:s"),$_POST['thread_id'],$_SESSION['uid']);

    $newURL = "http://serenity.ist.rit.edu/~group1700/240/pages/forum/forum_pages/thread.php?id=".$_POST['thread_id'];
    header('Location: '.$newURL);
}
