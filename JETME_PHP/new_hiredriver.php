<?php
    require_once "config.php";
    $HF_name = $_POST['HF_name'];
    $Hpassword = $_POST['Hpassword'];
    $Admin_id = $_POST['Admin_id'];
    $driver_licence = $_POST['driver_licence'];
    $HL_name = $_POST['HL_name'];
    $plate_no = $_POST['plate_no'];
    $employer = $_POST['employer'];
   
    $sql = "INSERT INTO `hiredtaxi` (`HF_name`, `Hpassword`, `Admin_id`,`driver_licence`,`HL_name`,`hiredtaxi_id`,`plate_no`,`employer`,`Hlongitudelocation`,`HLatitudelocation`) VALUES ('$HF_name','$Hpassword',1,'Not Found','$HL_name',null,'$plate_no','$employer',null,null)";
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