package ru.mirea.filin.lesson_4;

import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.filin.lesson_4.databinding.ActivityMainBinding;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}