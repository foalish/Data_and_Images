package davidfoale.info.daniels_images_data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<AndroidVersion> data;
    private DataAdapter adapter;

    private final String android_image_urls[] = {
            "http://davidfoale.info/images/app_images/vetsurgeon.jpg",
            "http://davidfoale.info/images/app_images/hairdresser.jpg",
            "http://davidfoale.info/images/app_images/vetsurgeon.jpg",
            "http://davidfoale.info/images/app_images/hairdresser.jpg",
            "http://davidfoale.info/images/app_images/vetsurgeon.jpg",
            "http://davidfoale.info/images/app_images/hairdresser.jpg",
            "http://davidfoale.info/images/app_images/vetsurgeon.jpg",
            "http://davidfoale.info/images/app_images/hairdresser.jpg",
            "http://davidfoale.info/images/app_images/vetsurgeon.jpg",
            "http://davidfoale.info/images/app_images/hairdresser.jpg",
    };



    // inflates activity_main at the start
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    // inflates Menu at the start
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    // initialises card view st start
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        loadJSON();
    }

    // calls retrofit JSON data
    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://davidfoale.info/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {

            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }


    // this all relates to image retrieval
    private ArrayList prepareData() {

        ArrayList android_version = new ArrayList<>();
        for (int i = 0; i < android_image_urls.length; i++) {
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }


  }
