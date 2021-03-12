package com.anta40.app.covidapitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String STATS_URL = "https://api.covid19api.com/summary";
    RecyclerView rcdata;
    ArrayList<ModelData> dataArrayList;
    AdapterData adapterData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataArrayList = new ArrayList<>();

        rcdata = findViewById(R.id.recystat);
        rcdata.setLayoutManager(new LinearLayoutManager(this));

       // adapterData = new AdapterData(this, dataArrayList);
        //rcdata.setAdapter(adapterData);
        rcdata.setHasFixedSize(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        prosesdata();
    }

    private void prosesdata(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, STATS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                handlerespon(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void handlerespon(String response) {

        dataArrayList = new ArrayList<>();
        dataArrayList.clear();

        try{

            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("Countries");

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setDateFormat("dd/MM/yyyy hh:mm a");
            Gson gson = gsonBuilder.create();

            for (int i=0; i<jsonArray.length(); i++){
                //ModelData modelData = gson.fromJson(jsonArray.getJSONObject(i).toString(), ModelData.class);

                JSONObject obj = jsonArray.getJSONObject(i);

                ModelData modelData = new ModelData(obj.getString("Country"),
                        obj.getString("TotalConfirmed"),
                        obj.getString("NewConfirmed"),
                        obj.getString("TotalDeaths"),
                        obj.getString("NewDeaths"),
                        obj.getString("TotalRecovered"),
                        obj.getString("NewRecovered"));

                dataArrayList.add(modelData);
            }

            adapterData = new AdapterData(MainActivity.this, dataArrayList);
            rcdata.setAdapter(adapterData);
            //rcdata.setHasFixedSize(true);
            adapterData.notifyDataSetChanged();

        }
        catch (Exception e){
            Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}