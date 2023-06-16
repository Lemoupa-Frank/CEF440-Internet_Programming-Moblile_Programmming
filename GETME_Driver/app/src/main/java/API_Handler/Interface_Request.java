package API_Handler;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Interface_Request {
    @GET("JETME_PHP/deletable.php")
    Call<PassengerModel> getPassenger();
    //@header('Content-Type: application');
    @POST("JETME/PHP/freelancedriver.php")
    @FormUrlEncoded
    Call<Void> createDriver(
            @Field("Admin_id") String adminId,
            @Field("driver_licence") String driverLicense,
            @Field("FFpassword") String ffPassword,
            @Field("FF_nam") String ffName,
            @Field("Flatitudelocation") double latitudeLocation,
            @Field("Flongitudelocation") double longitudeLocation,
            @Field("FL_name") String flName,
            @Field("freelance_id") String freelanceId,
            @Field("plate_no") String plateNo,
            @Field("seats") int seats
    );

}
//"JETMEPHP/PHP/new_user.php"
//Call<Void> Send_Logs(@Body PassengerModel passenger);
//http://192.168.43.81/
//    @POST("JETME/PHP/new_user.php")
//JETME/PHP/new_hiredriver.php
//JETME/PHP/freelancedriver.php