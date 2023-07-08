<?php
error_reporting(0);
require_once "config.php";

$FL_name = $_POST['FL_name'];
$FFpassword = $_POST['FFpassword'];
$FF_name = $_POST['FF_name'];

$sql = "SELECT  `HF_name`, `HL_name`, `Hpassword` FROM `hiredtaxi` WHERE `HF_name` = '$HF_name' AND `HL_name` = '$FL_name' AND `Hpassword` = '$Hpassword'";
$resultHired = mysqli_query($conn, $sql);


$sql2 = "SELECT  `FF_name`, `FL_name`, `FFpassword` FROM `freelancetaxi` WHERE `FF_name` = '$HF_name' AND `FL_name` = '$FL_name' AND `FFpassword` = '$Hpassword'";
$resultFreelance = mysqli_query($conn, $sql2);

if (mysqli_num_rows($resultHired) > 0) {
    $response = array(
        'status' => 'success',
        'message' => 'HIRED DRIVER'
    );
   // http_response_code(400);
    echo json_encode($response);
} elseif (mysqli_num_rows($resultFreelance) > 0) {
    $response = array(
        'status' => 'success',
        'message' => 'FREE LANCE DRIVER'
    );
   // http_response_code(400);
    echo json_encode($response);
} else {
    $response = array(
        'status' => 'success',
        'message' => 'NOT A USER'
    );

    //http_response_code(400);
    echo json_encode($response);
}

mysqli_error($conn);

// Set the response headers
//$dd = array('CustomResponse'=>$response);
// Send the JSON response
?>