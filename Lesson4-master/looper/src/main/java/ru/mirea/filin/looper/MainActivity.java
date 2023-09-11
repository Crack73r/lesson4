package ru.mirea.filin.looper;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.filin.looper.databinding.ActivityMainBinding;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler mainThreadHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {

                Log.d(MainActivity.class.getSimpleName(), "Task execute. This is result: " + msg.getData().getString("result"));

            }
        };
        MyLooper myLooper = new MyLooper(mainThreadHandler);
        myLooper.start();
        binding.textMirea.setText("Мой номер по списку No 29");
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString("KEY", "mirea");
                msg.setData(bundle);
                myLooper.mHandler.sendMessage(msg);
            }
        });
    }
}