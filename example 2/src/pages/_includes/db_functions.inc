<?php
    //FILE CONTAINS FUNCTIONS USED FOR COMMUNICATION WITH DATABASE

    /*
     * Function used to connect to the database
     */
    function connect($username,$password,$database){
        $conn = mysqli_connect("localhost",$username,$password,$database);

        if(!$conn){
            echo mysqli_error($conn);
            return false;
        }
        else{
            return $conn;
        }

    }

    /*
     * Function used to post comments into database
     */
    function postComment($conn,$data){
        $query = 'INSERT INTO comments (poster_name,post) VALUES ("'.$data['poster'].'","'.$data['comment'].'")';


        $answer = $conn->query($query);

        if(!$answer) {
            echo mysqli_error($conn);
            return;
        }
    }

    function getCommentData($conn){
        $result = $conn->query("SELECT * FROM comments ORDER BY id DESC");

        if(!$result){
            echo mysqli_error($conn);
            return false;
        }

        $retVal = array();

        while($row = $result->fetch_assoc()){
            $retVal[] = $row;
        }

        return $retVal;
    }

    function populatePage($conn, $id){
        $query = 'SELECT * FROM page_content WHERE origin_page ='.$id.' ORDER BY position ASC';

        $result = $conn->query($query);

        if(!$result){
            echo mysqli_error($conn);
            return;
        }

        $rows = array();

        while($row = $result->fetch_assoc()){
            $rows[] = $row;
        }



        foreach($rows as $value){
            echo '<section><h2>'.$value['content_header'].'</h2>';
            switch($value['type']){
                case "standard":{
                    echo '<p>'.$value['content'].'</p>';
                }break;
                case "map":{
                    echo '<div id="loc">';
                    echo $value['content'].'</div><div id="map"></div>';
                }break;
                default:{} break;
            }
            echo '</section>';
        }

    }

    function getGalleryFolder($conn,$id){
        $query = "SELECT img_folder FROM pages WHERE page_id = ".$id;

        $result = $conn->query($query);

        if(!$result){
            echo mysqli_error($conn);
            return false;
        }

        $retVal = $result->fetch_assoc();
        return $retVal['img_folder'];
    }

    function getTitle($conn,$pageName,$id){
        switch($pageName){
            case "index.php": return "Dubrovnik - Home";
            case "comments.php": return "Leave a comment!";
            default:{
                $query = "SELECT page_title FROM pages WHERE page_id = ".$id;

                $result = $conn->query($query);

                if(!$result){
                    echo mysqli_error($conn);
                    return false;
                }

                $retVal = $result->fetch_assoc();
                return 'Dubrovnik - '.$retVal['page_title'];
            }
        }
    }

    function getHeroMessages($conn,$id){
        $query = "SELECT hero_message FROM pages WHERE page_id = ".$id;

        $result = $conn->query($query);

        if(!$result){
            echo mysqli_error($conn);
            return false;
        }

        $retVal = $result->fetch_assoc();
        return $retVal['hero_message'];
    }