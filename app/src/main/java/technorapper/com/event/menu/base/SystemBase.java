package technorapper.com.event.menu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import technorapper.com.event.networking.model.UnisysModel;

public abstract class SystemBase extends AppCompatActivity {
    public static UnisysModel mUnisysModelResponse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        attachViewModel();
    }

    public abstract  void attachViewModel();


    public abstract void bindView();
}
