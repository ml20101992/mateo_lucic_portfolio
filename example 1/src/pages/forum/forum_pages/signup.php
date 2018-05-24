<?php
/**
 * Created by PhpStorm.
 * User: Mateo
 * Date: 05-Dec-17
 * Time: 19:16
 */

include_once "../../includes/connect.inc";
include_once "../forum_includes/conn_functions.inc";

if (isset($_POST)){
    $conn = connect_forum($username, $password, $database);

    if(!$conn) {
        echo mysqli_error($conn);
    }

    $dbunames = $conn->query("SELECT * FROM users WHERE user_name='$username'");
    if(mysqli_num_rows($dbunames) > 0 ) {
        echo "Username Taken!";
        echo '<a href="../forum_index.php">Go Back</a>';

    } else {

        $query = 'INSERT INTO users (user_name, user_pass, user_email, user_date, user_level) VALUES';
        $query .= '("' . $_POST['username'] . '","' . $_POST['password'] . '","' . $_POST['email'] . '","' . date("Y-m-d H:i:s") . '","1")';

        $result = $conn->query($query);

        if (!$result) echo mysqli_error($conn);

        $recieving = $_POST['email'];
        $subject = "Welcome to KofiToGo Forums!";
        $headers = "From: group1700@g.rit.edu\r\n";

        $txt = "YOU ARE NOW REGISTERED! \r\n Username: ".$_POST['username']." \r\n Password: ".$_POST['password'];

        mail($recieving,$subject,$txt,$headers);
        
        header("Location: http://serenity.ist.rit.edu/~group1700/240/pages/forum/forum_index.php?message=1");
    }
}