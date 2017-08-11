package com.example.rodoggx.threadwaze;

import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by RodoggX on 8/11/2017.
 */

public class MyAsyncTask extends AsyncTask<String, Integer, String> {
    TextView tvAsynctask;
    String result;
    int i;

    public MyAsyncTask(TextView tvAsynctask) {
        this.tvAsynctask = tvAsynctask;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        for (i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return String.valueOf(i);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvAsynctask.setText(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        tvAsynctask.setText(String.valueOf(values[0]));
    }
}
