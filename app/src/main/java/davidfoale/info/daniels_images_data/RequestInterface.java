package davidfoale.info.daniels_images_data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("mysql/jobz1.php")
    Call<JSONResponse> getJSON();
}