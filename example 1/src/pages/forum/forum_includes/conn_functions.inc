<?php



    function connect_forum($username, $password, $database){
        $conn = mysqli_connect("localhost",$username,$password,$database);

        if(!$conn) echo'error';
        return $conn;
    }

    function populateCategories($conn){
        $get_categories = "SELECT * FROM categories";

        $result = $conn->query($get_categories);


        $parsed_result = resultToArray($result);

        foreach ($parsed_result as $value){

            echo '<div class="category">';
            echo '<div class="cat_header">';
            echo '<h2><a href="forum_pages/category.php?id='.$value['cat_id'].'">'.$value['cat_name'].'</a></h2></div><div class="cat_content">';
            echo '<p>'.$value['cat_description'].'</p></div></div>';

        }
    }

    function resultToArray($result){
        $rows = array();
        while($row = $result->fetch_assoc()){
            $rows[] = $row;

        }

        return $rows;

    }

    function populateTopicsFromCategory($conn,$id){
        $get_threads = "SELECT * FROM topics WHERE topic_cat = ".$id;

        $result = $conn->query($get_threads);

        $parsed_result = resultToArray($result);

        foreach ($parsed_result as $value){

            //echo '<a href="forum_pages/thread.php?id='.$value['cat_id'].'"><h3>'.$value['topic_subject'].'</h3></a><br>';
            echo '<div class="topic_container">';
            echo '<div class="topic_name">';
            echo '<p><a href="thread.php?id='.$value['topic_id'].'">'.$value['topic_subject'].'</a></p>';
            echo '</div>';
            echo '<div class="topic_poster">';
            echo '<p>'.getPosterName($conn,$value['topic_by']).'</p>';
            echo '</div>';
            echo '<div class="topic_post_date">';
            echo '<p>'.$value['topic_date'].'</p>';
            echo '</div></div>';
        }
    }

    function getCategoryName($conn,$catID){
        $result = $conn->query("SELECT cat_name FROM categories WHERE cat_id =".$catID );

        $returnValue = $result->fetch_assoc();

        return $returnValue['cat_name'];
    }

    function getPosterName($conn,$posterID){
        $result = $conn->query("SELECT user_name FROM users WHERE user_id = ".$posterID);

        $returnValue = $result->fetch_assoc();

        return $returnValue['user_name'];
    }

    function getThreadName($conn,$threadID){
        $result = $conn->query("SELECT topic_subject FROM topics WHERE topic_id =".$threadID);

        $returnValue = $result->fetch_assoc();

        return $returnValue['topic_subject'];
    }

    function createThreadNav($conn,$threadID){


        $result = $conn->query("SELECT count(*) FROM posts WHERE post_topic = ".$threadID);

        $returnValue = $result->fetch_assoc();

        $replies = $returnValue['count(*)'];



        if($replies > 10){
            echo '<div class="page_indicator"><a href="thread.php?id='.$threadID.'&page='.(intdiv($replies,10)+1).'">LAST</a></div>';
            if($_GET['page'] < (intdiv($replies,10)+1)) echo '<div class="page_indicator"><a href="thread.php?id='.$threadID.'&page='.($_GET['page']+1).'">NEXT</a></div>';
            echo '<div class="page_indicator"><a href="#">'.$_GET['page'].'</a></div>';
            if($_GET['page'] > 1) echo '<div class="page_indicator"><a href="thread.php?id='.$threadID.'&page='.($_GET['page']-1).'">PREV</a></div>';
            echo '<div class="page_indicator"><a href="thread.php?id='.$threadID.'&page=1">FIRST</a></div>';
        }
    }

    function populatePosts($conn,$threadID,$page){

        $result = $conn->query("SELECT * FROM posts WHERE post_topic = ".$threadID);


        $parsedResult = resultToArray($result);

        $truncated = array();

        if($result->num_rows > 10){
            $startPoint = ($page - 1) * 10;

            $truncated = array_splice($parsedResult,$startPoint,10);

        }
        else{
            $truncated = $parsedResult;
        }

        foreach ($truncated as $value){
            //echo $value['post_content'].'<br>';
            echo '<div class="post">';
                echo '<div class="name_and_date">';
                    echo '<div class="poster_name">';
                        echo '<p>'.getPosterName($conn,$value['post_by']).' says:</p>';
                    echo '</div>';
                    echo '<div class="post_date">';
                        echo '<p>'.$value['post_date'].'</p>';
                    echo '</div>';
                echo '</div>';
                echo '<div class="post_content">';
                    echo '<p>'.$value['post_content'].'</p>';
                echo '</div>';
            echo '</div>';
        }

    }

    function getUserName($conn,$id){
        $result = $conn->query("SELECT user_name FROM users WHERE user_id=".$id);

        $returnValue = $result->fetch_assoc();

        return $returnValue['user_name'];
    }

    function configureLoginElement($conn,$targetLocation){
        if(!isset($_SESSION['uid'])){
            echo '<button id="login">LOGIN</button>';
            echo '<button id="signup">SIGN UP</button>';
        }
        else{
            echo '<p>Welcome, '.getUserName($conn,$_SESSION['uid']).'</p><form action="'.$targetLocation.'" method="post"><input id ="login" type="submit" value="LOGOUT"></form>';
        }
    }

?>