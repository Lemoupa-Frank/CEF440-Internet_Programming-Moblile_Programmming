<?php
error_reporting(0);
$Flatitudelocation= $_POST['longitude'];
$Flongitudelocation= $_POST['latitude'];
//names
//platitudeLocation
//plongitudeLocation
require_once "config.php";
// SQL query to retrieve the data
$query = "SELECT `names`,`platitudelocation`,`plongitudeLocation` FROM `passenger` WHERE    (6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(platitudelocation) - RADIANS(platitudelocation)) / 2), 2) + COS(RADIANS(platitudelocation)) * COS(RADIANS(platitudelocation)) * POWER(SIN((RADIANS(plongitudeLocation) - RADIANS($Flongitudelocation)) / 2), 2)))) <= 200";


$result = $conn->query($query);
// Create an array to store the data
$data = array();
$fdata = array();
$ddata = array();
$total = array();
// Fetch the rows and store them in the data array
while ($row = $result->fetch_assoc()) {
    $totat[] = $row;
    $data[] = $row["names"];
    $fdata[] = $row["plongitudeLocation"];
    $ddata[] = $row["platitudelocation"];
}
// Convert the data to JSON

    $response = array(
       'D1name' => $data[1],
       'D1long' => $fdata[1],
       'D1lat' => $ddata[1],
       'D2name' => $data[2],
       'D2long' => $fdata[2],
       'D2lat' => $ddata[2],
       'D3name' => $data[3],
       'D3long' => $fdata[3],
       'D3lat' => $ddata[3]
   );
//$jsonData = json_encode($data[]);

// Set the appropriate headers for JSON response
header('Content-Type: application/json');
echo json_encode($response);
// Send the JSON data as the response
//echo $jsonData;

// Close the database connection
$conn->close();
$conn->close();

?>