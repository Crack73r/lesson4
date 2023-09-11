package ru.mirea.filin.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import ru.mirea.filin.thread.databinding.ActivityMainBinding;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        infoTextView.setText("Имя текущего потока: " + mainThread.getName());
        // Меняем имя и выводим в текстовом поле
        mainThread.setName("МОЙ НОМЕР ГРУППЫ: 05, НОМЕР ПО СПИСКУ: 29, МОЙ ЛЮБИИМЫЙ ФИЛЬМ: Драйв");
        infoTextView.append("\n Новое имя потока: " + mainThread.getName());
        Log.d(MainActivity.class.getSimpleName(), "Stack: " + Arrays.toString(mainThread.getStackTrace()));
    }
    public void onClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                int numberThread = counter++;
                Log.d("ThreadProject", String.format("Запущен поток No %d студентом группы %s номер по списку 29 %d ", numberThread, "БСБО-05-21", -1));
                long endTime = System.currentTimeMillis() + 20 * 1000;
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            wait(endTime - System.currentTimeMillis());
                            Log.d(MainActivity.class.getSimpleName(), "Endtime: " + endTime);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    Log.d("ThreadProject", "Выполнен поток No " + numberThread);
                }
            }
        }).start();
    }
}