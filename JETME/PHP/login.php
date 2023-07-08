<?php
error_reporting(0);
    require_once "config.php";
    $HF_name = $_POST['Username'];
    $Hpassword = $_POST['Password'];
   
    $sql = "SELECT  `names`, `ppassword` FROM `passenger` WHERE `names` = '$HF_name' AND `ppassword` = '$Hpassword'";
    $result = mysqli_query($conn, $sql);
    if (mysqli_num_rows($result) > 0) {
      $response = array(
          'status' => 'success',
          'message' => 'LOGGED'
      );
     // http_response_code(400);
      echo json_encode($response);
  }
                 else          
                    {
                     $response = array(
                        'status' => 'success',
                        'message' => 'ChecK Details'
                    );
                    //mysqli_error($conn)  
                    echo json_encode($response);
                    }
                    

           
?>