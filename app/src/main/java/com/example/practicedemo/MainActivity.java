package com.example.practicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private static  String TAG = "debug:";
    private Button button;
    int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
         AsyncTask<Integer, String, Boolean> result=new TestAsync().execute(120,100);
        try {
            boolean a= result.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     class TestAsync extends AsyncTask<Integer,String,Boolean>{
        @Override
        protected Boolean doInBackground(Integer... integers) {
            Log.d(TAG, "doInBackground: "+Thread.currentThread().getName());
            publishProgress("Hey...");
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            Log.d(TAG, "onPostExecute: "+Thread.currentThread().getName());
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: "+Thread.currentThread().getName());
        }

        @Override
        protected void onProgressUpdate(String... values) {
            Log.d(TAG, "onProgressUpdate:  "+values[0]+Thread.currentThread().getName());
//            super.onProgressUpdate(values);

        }
    }
}