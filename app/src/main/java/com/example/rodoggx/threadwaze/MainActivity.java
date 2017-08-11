package com.example.rodoggx.threadwaze;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    TextView tvThread, tvRunnable, tvAsynctask, tvIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvThread = (TextView) findViewById(R.id.tv_thread);
        tvRunnable = (TextView) findViewById(R.id.tv_runnable);
        tvAsynctask = (TextView) findViewById(R.id.tv_asynctask);
        tvIntentService = (TextView) findViewById(R.id.tv_intent_service);
    }

    public void startThread(View view) {
        MyThread myThread = new MyThread(tvThread);
        myThread.start();
    }

    public void startRunnable(View view) {
        MyRunnable myRunnable = new MyRunnable(tvRunnable);
        Thread myThread = new Thread(myRunnable);
        myThread.start();
    }

    public void startAsynctask(View view) {
        MyAsyncTask myAsyncTask = new MyAsyncTask(tvAsynctask);
        myAsyncTask.execute("Start AsyncTask");
    }

    public void startIntentService(View view) {
        Intent intent = new Intent(MainActivity.this, MyIntentService.class);
        startService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode =  ThreadMode.MAIN)
    public void onMyEvent(MyEvent event){

    }
}
