package technorapper.com.event.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import technorapper.com.event.networking.model.UnisysModel;

public interface  ApiInterface {
    @GET("v1/events/")
   Call<UnisysModel> getTopRatedMovies(@Header("Authorization")String token);
}
