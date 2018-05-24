<?php
/*
 * function used to connect to database
 * returns $conn -> initialized database connection
 */
function connect($server,$username,$password,$database){
    $conn = mysqli_connect($server,$username,$password,$database);
    if(!$conn) {
        echo 'error connecting to db';
        return false;
    }

    else return $conn;
}

function populate_page($conn,$id){
    $q = 'SELECT * FROM page_content WHERE parent_page = '.$id.' ORDER BY position ASC';

    $rows = $conn->query($q);

    $result = array();
    if(!$rows){
        echo mysqli_error($conn);
    }
    else{
        while($parsed_row = $rows->fetch_assoc()){
            $result[] = $parsed_row;
        }
    }
    //echo sizeof($result);

//    switch(getDescription($conn,$id)){
//        case "About": populate_about($result);
//            break;
//        case "Types": populate_region($result);
//            break;
//        case "faq": populate_questions($result);
//            break;
//        default: return false;
//    }
    populate($result);

}

/*
 * function which check which page is in question
 * needed because different pages have different styling
 */
function getDescription($conn,$id){
    $q = "SELECT page_desc FROM pages WHERE page_id = ".$id;

    $rows = $conn->query($q);
    if(!$rows){
        echo mysqli_error($conn);
        return false;
    }
    else{
        return ($rows->fetch_assoc())['page_desc'];
    }

}
/*
 * function used to populate  page
 */
function populate($result){

    foreach ($result as $value){
        if($value['image'] != "no"){
            echo '<div class="row">';
            echo '<h2 class="region-names">'.$value['header'].'</h2>';
            echo '</div>';
            echo '<div class="row">&nbsp;</div><div class="row col-12"><div class="col-6"><p class="region-texts">';
            echo $value['content'];
            echo '</p></div><div class="col-2 "></div><div class="col-4 "><a href="../assets/images/fullsize/'.$value['image'].'" target="_blank"><img class="img-fluid show" src="../assets/images/thumbs/'.$value['image'].'" alt="REGION PICTURE"></a></div></div><br>';
        }
        else{
            echo '<div class="row ">';
            echo '<h2 class="region-names">'.$value['header'].'</h2>';
            echo '</div>';
            echo '<div class="row ">&nbsp;</div><div class="row col-12"><div class="col-12 "><p class="region-texts">';
            echo $value['content'];
            echo '</p></div></div><br>';
        }


    }

}

function getPageTitle($conn,$id){
    $result = $conn->query("SELECT full_title FROM pages WHERE page_id = ".$id);
    if(!$result){
        echo mysqli_error($conn);
    }

    $page_title = $result->fetch_assoc();
    return $page_title['full_title'];
}


/*
 *
 */

?>