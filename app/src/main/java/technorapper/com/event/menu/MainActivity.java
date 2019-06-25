package technorapper.com.event.menu;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import technorapper.com.event.R;

import technorapper.com.event.RecyclerViewClickListener;
import technorapper.com.event.databinding.ActivityMainBinding;
import technorapper.com.event.menu.adapter.ListAdapter;
import technorapper.com.event.menu.base.SystemBase;
import technorapper.com.event.menu.detail.DetailScreen;
import technorapper.com.event.menu.viewmodel.ViewModel;
import technorapper.com.event.networking.model.UnisysModel;


public class MainActivity extends SystemBase implements RecyclerViewClickListener {
    String TAG = "Api";
    private RecyclerView mRecyclerView;
    ActivityMainBinding binding;
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void attachViewModel() {
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.data.observe(this, new Observer<UnisysModel>() {
            @Override
            public void onChanged(@Nullable UnisysModel unisysModel) {
                mUnisysModelResponse = unisysModel;
                fillData(unisysModel);
            }
        });

        viewModel.nextForgot(this);

    }

    @Override
    public void bindView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


    }


    private void fillData(UnisysModel response) {

        ListAdapter mAdapter = new ListAdapter(response.getResults(), MainActivity.this);
        binding.setAdapter(mAdapter);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(this, DetailScreen.class);
        intent.putExtra("pos",position);
        startActivity(intent);
    }
}
