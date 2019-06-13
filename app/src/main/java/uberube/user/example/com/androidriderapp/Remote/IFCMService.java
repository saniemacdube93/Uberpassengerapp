package uberube.user.example.com.androidriderapp.Remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import uberube.user.example.com.androidriderapp.Model.FCMResponse;
import uberube.user.example.com.androidriderapp.Model.Sender;

/**
 * Created by User on 3/3/2018.
 */

public interface IFCMService {
    //IFCM stands for Internet Firebase Cloud Messaging

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAFdAjWAA:APA91bFMl9Yp7R1KxeINme-o4iCREbUlNhU2HkdhfAcXynwMdQB_LBcTFyjSlAZ0lyWZpZg4CCG3lU31iLLjcU4ztFXKvCnS_7uqP14HLQMIZxrPceWhAz356NFtlWxDgzSwxa4ClM3q"

    })

    @POST("fcm/send")
    Call<FCMResponse> sendMessage(@Body Sender body);
}