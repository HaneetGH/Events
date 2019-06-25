package technorapper.com.event.networking.repo;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import technorapper.com.event.database.Functions;
import technorapper.com.event.networking.ApiClient;
import technorapper.com.event.networking.ApiInterface;
import technorapper.com.event.networking.model.UnisysModel;

import static android.content.ContentValues.TAG;

public class ApiHit {

    public static void callApi(final Context context, final MutableLiveData<UnisysModel> data) {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<UnisysModel> call = apiService.getTopRatedMovies("Bearer feak936JDyLqIOyAETXEGuwh2x0p2f");

        call.enqueue(new Callback<UnisysModel>() {
            @Override
            public void onResponse(Call<UnisysModel> call, Response<UnisysModel> response) {

                if (response != null) {
                    data.setValue(response.body());
                    Functions.insertInDb(context, response);
                }

                // Log.d(TAG, "Content : " + response.body().getContent().get(0).getSectionName());
            }

            @Override
            public void onFailure(Call<UnisysModel> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }
}
