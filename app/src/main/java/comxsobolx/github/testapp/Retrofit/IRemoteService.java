package comxsobolx.github.testapp.Retrofit;

import android.graphics.Bitmap;

import java.util.List;

import comxsobolx.github.testapp.model.LoginResponse;
import comxsobolx.github.testapp.model.MessageResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by aleksandr on 05.08.16.
 */
public interface IRemoteService {
    @FormUrlEncoded
    @Headers("Authentication:guest")
    @POST("json/sign_in")
    Call<LoginResponse> basicLogin(@Field("login") String login,
                                   @Field("password") String password,
                                   @Field("is_mobile") boolean isMobile);
    @FormUrlEncoded
    @Headers("Authentication:user")
    @POST("json/sign_in")
    Call<LoginResponse> tokenLogin(@Header("Authorization") String token,
                                   @Field("is_mobile") boolean isMobile);

    @FormUrlEncoded
    @Headers("Authentication:user")
    @POST("json/messages/{uid}")
    Call<MessageResponse> postMessage(@Header("Authorization") String token,
                                      @Field("is_mobile") boolean isMobile,
                                      @Path("uid") String uid,
                                      @Field("content") String content);


}
