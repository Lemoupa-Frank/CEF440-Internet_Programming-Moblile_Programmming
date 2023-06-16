<?php
    require_once "config.php";
    $Name = $_POST['Name'];
    $Admin_password = $_POST['Admin_password'];
    $Admin_id = $_POST['Admin_id'];
  
    $sql = "INSERT INTO `admin` (`Name`,`Admin_password`,`Admin_id`) VALUES ('$Name','$Admin_password','$Admin_id')";
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