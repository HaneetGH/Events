package technorapper.com.event.utils;

import retrofit2.Response;
import technorapper.com.event.networking.model.UnisysModel;

public class ApiGS {
    public static boolean isCacheOn = false;
    public static Response<UnisysModel> mUnisysModelResponse;

    public Response<UnisysModel> getUnisysModelResponse() {
        return mUnisysModelResponse;
    }

    public static void setUnisysModelResponse(Response<UnisysModel> unisysModelResponse) {
        mUnisysModelResponse = unisysModelResponse;
    }


}
