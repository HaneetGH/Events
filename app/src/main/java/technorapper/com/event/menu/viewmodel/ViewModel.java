package technorapper.com.event.menu.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;


import technorapper.com.event.networking.model.UnisysModel;
import technorapper.com.event.networking.repo.ApiHit;

public class ViewModel extends AndroidViewModel {
    public MutableLiveData<UnisysModel> data = new MutableLiveData<>();

    Context context;

    public ViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public void nextForgot(Activity mContext) {

            ApiHit.callApi(mContext, data);
    }


}
