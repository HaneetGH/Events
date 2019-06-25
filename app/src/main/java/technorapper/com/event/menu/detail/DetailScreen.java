package technorapper.com.event.menu.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import technorapper.com.event.R;
import technorapper.com.event.databinding.ActivityDetailBinding;

import technorapper.com.event.menu.base.SystemBase;

public class DetailScreen extends SystemBase {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void attachViewModel() {
        binding.setHandler(new ClickHandler());
    }

    @Override
    public void bindView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        fillData();
    }


    private void fillData() {
        binding.setModel(mUnisysModelResponse.getResults().get(getIntent().getExtras().getInt("pos")));
    }

    public class ClickHandler {

        public void Action(int x) {
            if (x == 0)
                Toast.makeText(getApplicationContext(), "Attending", Toast.LENGTH_LONG).show();
            if (x == 1)
                Toast.makeText(getApplicationContext(), "Not Attending", Toast.LENGTH_LONG).show();
            if (x == 2)
                Toast.makeText(getApplicationContext(), "May be", Toast.LENGTH_LONG).show();


        }
    }

}
