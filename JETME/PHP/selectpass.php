<?php
require_once "config.php";
$sql = "SELECT * FROM passenger WHERE passenger_id=55868614";
$result = mysqli_query($conn, $sql);
if(mysqli_num_rows($result)  > 0)
{
    echo "User Found";
}
else          
{
        echo "ERROR: Sorry $sql". mysqli_error($conn);
}
    mysqli_close($conn);

?>