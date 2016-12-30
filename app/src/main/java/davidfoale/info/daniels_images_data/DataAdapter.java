package davidfoale.info.daniels_images_data;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;




    public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        // items to display in the RecyclerView
    private ArrayList<AndroidVersion> android, android_versions;
    private Context context;
    private final int USER = 0, IMAGE = 1;

        // Provide two suitable constructors
    public DataAdapter(ArrayList<AndroidVersion> android) {
        this.android = android;
        }
    public DataAdapter(Context context,ArrayList<AndroidVersion> android_versions) {
        this.android_versions = android_versions;
        this.context = context;
        }




    // this tells recycler view about the type of view to inflate based on the position returning USER or IMAGE
    @Override
    public int getItemViewType(int position) {
        if (android.get(position) instanceof Adapter) {
            return USER;

      //         } else if (android_versions.get(position) instanceof String) {
      //             return IMAGE;
               }
                return -1;
        }





    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        RecyclerView.ViewHolder viewHolder;

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

    //      default:
    //         View v = inflater.inflate(R.layout.activity_main, viewGroup, false);
    //         viewHolder = new RecyclerViewSimpleTextViewHolder(v);
    //          break;
        }

        return new viewHolder;
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
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {

            case USER:
                ViewHolder1 vh1 = (ViewHolder1) viewHolder;
                configureViewHolder1(vh1, position);

                vh1.job_title.setText(android.get(position).getTitle());
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
     //    default:
     //           RecyclerViewSimpleTextViewHolder vh = (RecyclerViewSimpleTextViewHolder) viewHolder;
     //           configureDefaultViewHolder(vh, position);
     //           break;

        }
    }





        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return this.android.size();
        }


    /**
     not sure if the code below belongs in the data adapter or as a seperate class as its the methods used to configure the
     individual RecyclerView.viewholder objects
    */

    //   private void configureDefaultViewHolder(RecyclerViewSimpleTextViewHolder vh, int position) {
    //   vh.getJob().setText((CharSequence) android.get(position));        }

   // configures VH1
       private void configureViewHolder1(ViewHolder1 vh1, int position) {

   // unsure if this is adapter or data or neither?
        Adapter adapter = (Adapter).get(position);
        if (adapter != null) {

            vh1.getJob_tips      ().setText((CharSequence) android_versions);
            vh1.getSalary        ().setText((CharSequence) android_versions);
            vh1.getDegree        ().setText((CharSequence) android_versions);
            vh1.getQualifications().setText((CharSequence) android_versions);
            vh1.getJob_desc      ().setText((CharSequence) android_versions);
            vh1.getJob_title     ().setText((CharSequence) android_versions);
        }

    }

    // configures VH2
    private void configureViewHolder2(ViewHolder2 vh2, int position) {

        vh2.getAndroid_image_url().setImageResource(android);

    }

}







