<?php
error_reporting(0);
    require_once "config.php";
    
    $Admin_id = $_POST['Admin_id'];
    $driver_license = $_POST['driver_licence'];
    $HHpassword = $_POST['FFpassword'];
    $HF_name = $_POST['FF_nam'];
    $Flatitudelocation= $_POST['Flatitudelocation'];
    $Flongitudelocation= $_POST['Flongitudelocation'];
    $HL_name = $_POST['FL_name'];
    $employer = $_POST['employer'];
    $plate_no = $_POST['plate_no'];
    $seats = $_POST['seats'];
    $sql = "INSERT INTO `hiredtaxi`(`HF_name`, `HL_name`, `driver_licence`, `Hpassword`, `plate_no`, `employer`, `Admin_id`, `HLatitudelocation`, `Hlongitudelocation`) VALUES ('$HF_name','$HL_name','$driver_license','$HHpassword','$plate_no','$employer',1,'$Flatitudelocation','$Flongitudelocation')";
     if(mysqli_query($conn,$sql))
                                {
                                 $response = array(
                                    'status' => 'success',
                                    'message' => 'FREE LANCE DRIVER'
                                );
                               // http_response_code(400);
                                echo json_encode($response);
              }
                 else          
                    {
          $response = array(
            'status' => mysqli_error($conn),
            'message' => 'mysqli_error($conn)'
        );
       // http_response_code(400);
        echo json_encode($response);
                    }

           
?>