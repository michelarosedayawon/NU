<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "gpa_tracker";


$conn = new mysqli($servername, $username, $password, $database);


if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


$name = $_POST['name'];
$studentID = $_POST['studentID'];


$sql = "INSERT INTO students (name, student_id) VALUES ('$name', '$studentID')";
if ($conn->query($sql) === TRUE) {
    
    header("Location: Trackerpage.html");
    exit();
} else {
    echo "Error: " . $conn->error;
}

$conn->close();
?>
