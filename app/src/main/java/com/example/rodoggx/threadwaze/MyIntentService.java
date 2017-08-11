package com.example.rodoggx.threadwaze;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

/**
 * Created by RodoggX on 8/11/2017.
 */

public class MyIntentService extends IntentService {
    TextView tvIntentService;
    int i;
    Handler handler = new Handler(Looper.getMainLooper());
    String result;

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for (i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
