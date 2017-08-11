package com.example.rodoggx.threadwaze;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

/**
 * Created by RodoggX on 8/11/2017.
 */

public class MyThread extends Thread {
    int i;
    TextView tvThread;
    String result = "My Thread";
    Handler handler = new Handler(Looper.getMainLooper());

    public MyThread(TextView tvThread) {
        this.tvThread = tvThread;
    }

    @Override
    public void run() {
        super.run();
        for (i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    tvThread.setText(String.valueOf(i));
                }
            });
        }
    }
}
