<?php
    require_once "config.php";
    $names = $_POST['names'];
    $ppassword = $_POST['ppassword'];
    $tel = $_POST['tel'];
    $passenger_id = $_POST['passenger_id'];
    $location= $_POST['location'];
    $freelance_id= $_POST['freelance_id'];
    $destination= $_POST['destination'];
    $sql = "INSERT INTO `Passenger` (`names`, `ppassword`, `tel`,`passenger_id`,`location`,`freelance_id`,`destination`) VALUES ('$names','$ppassword','$tel','$passenger_id','$location','$freelance_id','$destination')";
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