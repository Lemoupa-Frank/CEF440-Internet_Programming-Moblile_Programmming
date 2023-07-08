<?php

require_once "config.php";
// SQL query to retrieve the data
$query = "SELECT `HF_name`, `HL_name`,`HLatitudelocation`, `Hlongitudelocation`, `time` FROM `hiredtaxi` WHERE 1";

$result = $conn->query($query);

// Create an array to store the data
$data = array();

// Fetch the rows and store them in the data array
while ($row = $result->fetch_assoc()) {
    $data[] = $row;
}

// Convert the data to JSON
$jsonData = json_encode($data);

// Set the appropriate headers for JSON response
header('Content-Type: application/json');

// Send the JSON data as the response
echo $jsonData;

// Close the database connection
$conn->close();
?>