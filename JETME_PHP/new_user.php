<?php
    require_once "config.php";
    $Username = $_POST['Username'];
    $Password = $_POST['Password'];
    $contact = $_POST['contact'];
    $longitude= $_POST['longitude'];
    $latitude= $_POST['latitude'];

    
    $sql = "INSERT INTO Passenger (`names`, `ppassword`, `tel`,`passenger_id`,`location`,`freelance_id`,`destination`,`platitudelocation`,`plongitudeLocation`) VALUES ('$Username','$Password','$contact', null, null,null,null,'$latitude','$longitude')";
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