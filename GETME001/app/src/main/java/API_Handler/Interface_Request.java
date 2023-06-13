package API_Handler;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Interface_Request {
    @GET("JETME_PHP/deletable.php")
    Call<PassengerModel> getPassenger();
    @Headers("Content-Type: application/json")
    @POST("JETME_PHP/newUser.php")
    Call<PassengerModel> Send_Logs(@Body PassengerModel passenger);
}
