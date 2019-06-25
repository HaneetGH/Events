package technorapper.com.event.menu.viewholders;

import android.view.View;
import android.widget.TextView;


import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import technorapper.com.event.R;

/**
 * Created by Brad on 12/18/2016.
 */

public class GenreViewHolder extends GroupViewHolder {

    private TextView genreTitle;

    public GenreViewHolder(View itemView) {
        super(itemView);
        genreTitle = (TextView)itemView.findViewById(R.id.lblListHeader);
    }

    public void setGenreName(String name){
        genreTitle.setText(name);
    }
}
