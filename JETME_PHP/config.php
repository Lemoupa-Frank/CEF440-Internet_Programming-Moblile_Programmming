<?php
		$conn = mysqli_connect("localhost", "root", "", "jetme pd");
		
		// Check connection
		if($conn){
			echo "connected";
		}
		else
		{
			die("ERROR: Could not connect. "
				. mysqli_connect_error());
		}
?>
