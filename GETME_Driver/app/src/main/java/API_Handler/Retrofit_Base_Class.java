package API_Handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//http://192.168.43.81/ Rosine
//http://192.168.43.107/ Frank
public class Retrofit_Base_Class {
    public static String BASE_URL ="http://192.168.43.33/";
    public static Retrofit retrofit;
    private static final Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
