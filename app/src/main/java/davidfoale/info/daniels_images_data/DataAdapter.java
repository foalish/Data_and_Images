package davidfoale.info.daniels_images_data;


import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> android;
    private ArrayList<AndroidVersion> android_versions;
    private Context context;

    private final int USER = 0, IMAGE = 1;

    // Provide a suitable constructor
    public DataAdapter(ArrayList<AndroidVersion> android) { this.android = android;
     //  this.context = context;
       this.android = android;
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.android.size();
    }


    // this tells recycler view about the type of view to inflate based on the position returning USER or IMAGE
    @Override
    public int getItemViewType(int position) {
        if (android.get(position) instanceof ???) {
            return USER;

        } else if (android_versions.get(position) instanceof String) {
            return IMAGE;
        }
        return -1;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        ViewHolder1 viewHolder;

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case USER:
                View v1 = inflater.inflate(R.layout.activity_main, viewGroup, false);
                viewHolder = new ViewHolder1(v1);
                break;
            case IMAGE:
                View v2 = inflater.inflate(R.layout.row_layout, viewGroup, false);
                viewHolder = new ViewHolder2(v2);
                break;
        }
        return viewHolder;
    }


    /**
     * This method internally calls onBindViewHolder(ViewHolder, int) to update the
     * RecyclerView.ViewHolder contents with the item at the given position
     * and also sets up some private fields to be used by RecyclerView.
     *
     * @param viewHolder The type of RecyclerView.ViewHolder to populate
     * @param position   Item position in the viewgroup.
     */
    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case USER:
                ViewHolder1 vh1 = (ViewHolder1) viewHolder;
                configureViewHolder1(vh1, position);

                viewHolder.job_title.setText(android.get(position).getTitle());
                viewHolder.job_desc.setText(android.get(position).getDescription());
                viewHolder.qualifications.setText(android.get(position).getQualifications());
                viewHolder.degree.setText(android.get(position).getDegree());
                viewHolder.job_tips.setText(android.get(position).getTips());
                viewHolder.salary.setText(android.get(position).getSalary());
                break;

            case IMAGE:
                ViewHolder2 vh2 = (ViewHolder2) viewHolder;
                configureViewHolder2(vh2, position);

                Picasso.with(context).load(android_versions.get(position).getAndroid_image_url()).resize(61, 65).into
                        (viewHolder.img_android);
                break;

        }}


   // configures VH1

    private void configureViewHolder1(ViewHolder1 vh1, int position) {
        ??? ??? = (???) android.get(position);
    }

    // have to incorporate this into above two lines of code
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView job_title, job_desc, qualifications, degree, job_tips, salary;

        public ViewHolder(View view) {
            super(view);
            job_title = (TextView) view.findViewById(R.id.job_title);
            job_desc = (TextView) view.findViewById(R.id.job_desc);
            qualifications = (TextView) view.findViewById(R.id.qualifications);
            degree = (TextView) view.findViewById(R.id.degree);
            job_tips = (TextView) view.findViewById(R.id.job_tips);
            salary = (TextView) view.findViewById(R.id.salary);
        }
    }


    // configures VH2

    private void configureViewHolder2(ViewHolder2 vh2, int position) {
        vh2.getAndroid_image_url().setImageResource(R.id.img_android);
    }

        ImageView img_android;
        public ViewHolder(View view) {
        super(view);
        img_android = (ImageView)view.findViewById(R.id.img_android);
    }
}







