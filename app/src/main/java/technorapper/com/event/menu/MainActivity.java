package technorapper.com.event.menu;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import technorapper.com.event.R;

import technorapper.com.event.RecyclerViewClickListener;
import technorapper.com.event.databinding.ActivityMainBinding;
import technorapper.com.event.menu.adapter.ListAdapter;
import technorapper.com.event.menu.base.SystemBase;
import technorapper.com.event.menu.detail.DetailScreen;
import technorapper.com.event.menu.viewmodel.ViewModel;
import technorapper.com.event.networking.model.Result;
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
                //   activateFilter();
                fillData(unisysModel);
            }
        });

        viewModel.nextForgot(this);

    }

    Date date = null;
    Date date2 = null;

    private void activateFilter() {

        binding.filter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Date")) {
                    // do your stuff
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");


                    Observable.just(mUnisysModelResponse.getResults()).flatMap(Observable::fromIterable)
                            .toSortedList((complaintRowModel, complaintRowModel2) -> {
                                try {
                                    date = format.parse(complaintRowModel.getStart());
                                    date2 = format.parse(complaintRowModel2.getStart());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                // comparing dates is very much dependent on your implementation
                                if (date.before(date2)) {
                                    return -1;
                                } else if (date.equals(date2)) {
                                    return 0;
                                } else {
                                    return 1;
                                }
                            })

                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(this::handleResult, this::handleError);
                }
            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {

            }

            private void handleError(Throwable throwable) {
                Log.d("Issue", throwable.toString());
            }

            private void handleResult(List<Result> results) {
                ListAdapter mAdapter = new ListAdapter(results, MainActivity.this);
                binding.setAdapter(mAdapter);
            }
        });
    }

    @Override
    public void bindView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        /*binding.filter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Observable.just(mUnisysModelResponse.getResults())
                        .flatMap(Observable::fromIterable)
                        .toSortedList()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::handleSensors, this::handleError);
            }

            private void handleError(Throwable throwable) {
            }

            private void handleSensors(List<Result> results) {
                ListAdapter mAdapter = new ListAdapter(results, MainActivity.this);
                binding.setAdapter(mAdapter);
            }

        });*/


    }


    private void fillData(UnisysModel response) {

        ListAdapter mAdapter = new ListAdapter(response.getResults(), MainActivity.this);
        binding.setAdapter(mAdapter);
        activateFilter();
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(this, DetailScreen.class);
        intent.putExtra("pos", position);
        startActivity(intent);
    }
}
