package davidfoale.info.daniels_images_data;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;




public class ViewHolder2 extends RecyclerView.ViewHolder {

    public ImageView img_android;

    public ViewHolder2(View v) {
        super(v);
        img_android = (ImageView) v.findViewById(R.id.img_android);
    }

    public ImageView getAndroid_image_url() {
        return img_android;
    }

    public void setAndroid_image_url(ImageView img_android) { this.img_android = img_android;
    }
}


