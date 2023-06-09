package API_Handler;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Interface_Request {
    @GET("JETME_PHP/deletable.php")
    Call<PassengerModel> getPassenger();
    //@header('Content-Type: application');
    @POST("JETME/PHP/new_user.php")
    @FormUrlEncoded
    Call<Void> Send_Logs(@Field("Username") String Username,@Field("contact") String contact,@Field("Password") String Password,@Field("longitude") double longitude,@Field("latitude") double latitude);
    @POST("JETME/PHP/login.php")
    @FormUrlEncoded
    Call<CustomResponse> Send_Logs(@Field("Username") String Username,@Field("Password") String Password);
    @POST("JETME/PHP/Book.php")
    @FormUrlEncoded
    Call<Void> Send_Logs(@Field("Username") String Username,@Field("contact") String contact,@Field("longitude") double longitude,@Field("latitude") double latitude);
    @POST("JETME/PHP/getfreetaxilocation.php")
    @FormUrlEncoded
    Call<responsemodel> Send_Logs(@Field("longitude") double longitude,@Field("latitude") double latitude);
}
//"JETMEPHP/PHP/new_user.php"
//Call<Void> Send_Logs(@Body PassengerModel passenger);
//http://192.168.43.81/
//    @POST("JETME/PHP/new_user.php")