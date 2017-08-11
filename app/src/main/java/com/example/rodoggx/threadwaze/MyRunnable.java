package com.example.rodoggx.threadwaze;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

/**
 * Created by RodoggX on 8/11/2017.
 */

public class MyRunnable implements Runnable {
    int i;
    TextView tvRunnable;
    String result = "My Thread";
    Handler handler = new Handler(Looper.getMainLooper());

    public MyRunnable(TextView tvRunnable) {
        this.tvRunnable = tvRunnable;
    }

    @Override
    public void run() {
        for (i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    tvRunnable.setText(String.valueOf(i));
                }
            });
        }
    }
}
