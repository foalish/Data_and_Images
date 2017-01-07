package davidfoale.info.daniels_images_data;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class RecyclerViewDefaultViewHolder extends RecyclerView.ViewHolder {

    public TextView job_tips;


    public RecyclerViewDefaultViewHolder(View v) {
        super(v);
        job_tips       = (TextView) v.findViewById(R.id.job_tips);
    }
    public TextView getJob_tips()                { return job_tips;  }
    public void setJob_tips(TextView job_tips)   { this.job_tips = job_tips;}
}
