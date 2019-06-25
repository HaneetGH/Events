package technorapper.com.event.menu.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import technorapper.com.event.R;
import technorapper.com.event.RecyclerViewClickListener;
import technorapper.com.event.databinding.HeadItemBinding;
import technorapper.com.event.menu.MainActivity;
import technorapper.com.event.networking.model.Result;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {


    List<Result> mContent;
    RecyclerViewClickListener recyclerViewClickListener;

    public ListAdapter(List<Result> content, MainActivity mainActivity) {
        this.mContent = content;
        recyclerViewClickListener = mainActivity;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private HeadItemBinding binding;

        public MyViewHolder(HeadItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HeadItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.head_item, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.binding.setModel(mContent.get(position));
        holder.binding.groupBkColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerViewClickListener.onClick(view,position);
            }
        });


    }


    @Override
    public int getItemCount() {
        return mContent.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
