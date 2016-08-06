package comxsobolx.github.testapp.Retrofit;

import android.graphics.Bitmap;

import comxsobolx.github.testapp.model.LoginResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aleksandr on 05.08.16.
 */

public class ServiceHelper {

    private static final String ENDPOINT = "http://api.aolrussia.ru/api/v1/";

    private static OkHttpClient.Builder client = new OkHttpClient.Builder();
    private static ServiceHelper instance = new ServiceHelper();
    private IRemoteService service;


    private ServiceHelper() {

        Retrofit retrofit = createAdapter().build();
        service = retrofit.create(IRemoteService.class);
    }

    public static ServiceHelper getInstance() {
        return instance;
    }

    private Retrofit.Builder createAdapter() {

        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(logger);
        OkHttpClient httpClient = client.build();

        return new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create());
    }

    public Call<LoginResponse> basicLogin(String login, String password, boolean isMobile) {
        return service.basicLogin(login, password, isMobile);
    }

    public Call<LoginResponse> tokenLogin(String token, boolean isMobile){
        return service.tokenLogin(token, isMobile);
    }

    public Call<LoginResponse> postMessage(String token, boolean isMobile,
                                           String uid, String content) {
        return service.postMessage(token, isMobile, uid, content);
    }


}
