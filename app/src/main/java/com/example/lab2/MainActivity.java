package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpHandler handler = new HttpHandler();
        handler.execute("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/data/techs.ruleset.json");
    }
    public class HttpHandler extends AsyncTask<String , Void, Void > {

        @Override
        protected Void doInBackground(String[] objects) {
            String url = objects[0];
            final OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String res = response.body().string();
                ObjectMapper mapper = new ObjectMapper();
                mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                List<Item> items = mapper.readValue(res, new TypeReference<List<Item>>(){});
                ItemHandler.createInstance(items);
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e ) {e.printStackTrace();}
            return  null;
        }
    }
}
