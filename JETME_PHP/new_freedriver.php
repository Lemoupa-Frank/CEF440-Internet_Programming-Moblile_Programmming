<?php
    require_once "config.php";
    
    $FF_name = $_POST['FF_nam'];
    $FFpassword = $_POST['FFpassword'];
    $Admin_id = $_POST['Admin_id'];
    $driver_license = $_POST['driver_licence'];
    $FL_name = $_POST['FL_name'];
    $plate_no = $_POST['plate_no'];
    $seats = $_POST['seats'];
    $Flatitudelocation= $_POST['Flatitudelocation'];
    $Flongitudelocation= $_POST['Flongitudelocation'];
    $TEL = $_POST['telephone'];

    $sql = "INSERT INTO `freelancetaxi` (`FF_name`, `FFpassword`, `Admin_id`,`driver_license`,`FL_name`,`plate_no`,`seats`,`FLongitudelocation`,`Flatitudelocation`,`TEL`) VALUES ('$FF_name','$FFpassword',1,'$driver_license','$FL_name','$plate_no','$seats','$Flongitudelocation','$Flatitudelocation','$TEL')";
     if(mysqli_query($conn,$sql))
                                {
                 echo "query done";
              }
                 else          
                    {
               echo "ERROR: Sorry $sql. "
          . mysqli_error($conn);
                    }

           
?>