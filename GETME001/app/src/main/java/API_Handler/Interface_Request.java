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
    Call<Void> Send_Logs(@Field("Username") String Username,@Field("contact") String contact,@Field("Password") String Password);
}
//"JETMEPHP/PHP/new_user.php"
//Call<Void> Send_Logs(@Body PassengerModel passenger);
//http://192.168.43.81/
//    @POST("JETME/PHP/new_user.php")