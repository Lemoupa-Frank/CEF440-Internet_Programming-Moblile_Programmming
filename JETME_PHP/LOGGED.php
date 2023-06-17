<!DOCTYPE html>
<html>

<head>
	<title>Insert Page page</title>
</head>

<body>

	<center>
	      <style>
            body{
                background-image: url(18.img.jpg);
                background-repeat: no-repeat;
              background-size: cover;
            }
          </style>
		<?php
		
		require_once "config.php";
		
		// Taking all  values from the form data(input)
		//using name attribute to store request(using DB column name as arguement)
		$PID = $_REQUEST['PID'];
		
		// validating 
		$sql = "SELECT PID FROM `Patient` WHERE PID = '$PID' ";
		$result = mysqli_query($conn, $sql);
		if( mysqli_num_rows($result) > 0){ 
				echo "ID FOUND";
				session_start();  
                           $_SESSION['PID']=$PID;  
  
                             /* Redirect browser */ 
                              echo '<script>
			             alert("LOGGED"); 
			             window.location.href = "../HTML/patients page.html";
			      </script>';
                        
		} else{
			echo "ERROR: ID not FOUND $sql. "
				. mysqli_error($conn);
		}
		
		// Close connection
		mysqli_close($conn);
		?>
	</center>
</body>

</html>

