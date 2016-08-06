package comxsobolx.github.testapp.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aleksandr on 05.08.16.
 */
abstract public class RetrofiCallBack<T> implements Callback<T>{

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }
}
