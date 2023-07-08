<?php
error_reporting(0);
require_once "config.php";
$Flatitudelocation= $_POST['longitude'];
$Flongitudelocation= $_POST['latitude'];


// SQL query to retrieve the data
$query = "SELECT `FF_name`,`FL_name`,`FLongitudelocation`, `Flatitudelocation` FROM `freelancetaxi` WHERE    (6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(Flatitudelocation) - RADIANS(Flatitudelocation)) / 2), 2) + COS(RADIANS(Flatitudelocation)) * COS(RADIANS(Flatitudelocation)) * POWER(SIN((RADIANS(Flongitudelocation) - RADIANS($Flongitudelocation)) / 2), 2)))) <= 200";



$result = $conn->query($query);
// Create an array to store the data
$data = array();
$fdata = array();
$ddata = array();
$total = array();
// Fetch the rows and store them in the data array
while ($row = $result->fetch_assoc()) {
    $totat[] = $row;
    $data[] = $row["FL_name"];
    $fdata[] = $row["FLongitudelocation"];
    $ddata[] = $row["Flatitudelocation"];
}
echo $row['FL_name'];

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
//$query = "SELECT `FF_name`,`FL_name`,`FLongitudelocation`, `Flatitudelocation` FROM `freelancetaxi` WHERE 1";
//$query = "SELECT `FF_name`,`FL_name`,`FLongitudelocation`, `Flatitudelocation` FROM `freelancetaxi` WHERE `FLongitudelocation`='$Flongitudelocation' AND `Flatitudelocation` = '$Flatudelocation' ";
//$query = "SELECT `FF_name`,`FL_name`,`FLongitudelocation`, `Flatitudelocation` FROM `freelancetaxi` WHERE `FLongitudelocation`='4.15032645479301100000' AND `Flatitudelocation` = '9.28618813467422000000' ";

//(6371 * ACOS(COS(RADIANS($Flatitudelocation)) * COS(RADIANS($Flatitudelocation)) * COS(RADIANS($Flongitudelocation) - RADIANS($Flongitudelocation)) + SIN(RADIANS($Flatitudelocation)) * SIN(RADIANS($Flatitudelocation)))) <= $radius
?>
