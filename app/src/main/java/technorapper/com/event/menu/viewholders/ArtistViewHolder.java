package technorapper.com.event.menu.viewholders;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import technorapper.com.event.menu.detail.DetailScreen;
import technorapper.com.event.R;


public class ArtistViewHolder extends ChildViewHolder {
    private String COMBINER = "###combine###";
    private TextView title, titleDec;
    private ImageView imgThumb;
    private Switch mSwitch;
    private LinearLayout linearLayoutTitleGroup;

    public ArtistViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.lblListItem);
        titleDec = (TextView) itemView.findViewById(R.id.lblListItemDetail);
        imgThumb = (ImageView) itemView.findViewById(R.id.imageviewchildexpandable);
        mSwitch = (Switch) itemView.findViewById(R.id.idSwich);
        linearLayoutTitleGroup = (LinearLayout) itemView.findViewById(R.id.id_for_ll_title_group);
    }

    public void setArtistName(String name) {
        final String[] parts = name.split(COMBINER);
        if (parts != null && parts[0] != null)
            title.setText(parts[0]);
        if (parts != null && parts[1] != null)
            titleDec.setText(parts[1]);
        if (parts != null && parts[2] != null) {
            try {
                Picasso.with(itemView.getContext()).load(parts[2])
                        .into(imgThumb);
            } catch (Exception
                    e) {
                Log.e("Error", e.toString());
            }
        }
        linearLayoutTitleGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DetailScreen.class);//haven't use Fragment For this Cauase of less complexity of project
                if (parts != null && parts[3] != null)
                    intent.putExtra("head", parts[3]);
                if (parts != null && parts[4] != null)
                    intent.putExtra("child", parts[4]);
                itemView.getContext().startActivity(intent);
            }
        });
        mSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(itemView.getContext(), parts[3] + parts[4], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
