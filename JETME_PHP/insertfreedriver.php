<?php
require_once "config.php";

$sql = "INSERT INTO `freelancetaxi`(Admin_id,driver_license,FFpassword,FF_name,FL_name,freelance_id,plate_no,seats) VALUES (1,'[fake]','[frank]','[Noughue]','[Michele]',9,'[FE23BU]',5)";
if( mysqli_query($conn, $sql)){ 
    echo "ID FOUND";
    session_start();  
                 /* Redirect browser */ 
                  echo "ID FOUND";
            
} else{
    echo "ERROR: Sorry $sql. "
    . mysqli_error($conn);
}
mysqli_close($conn);
?>