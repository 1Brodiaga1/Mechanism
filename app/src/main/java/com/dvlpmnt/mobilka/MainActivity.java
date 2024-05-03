package com.dvlpmnt.mobilka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dvlpmnt.mobilka.databinding.ActivityListBinding;
import com.dvlpmnt.mobilka.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonPatterns.setOnClickListener(clickListener);
        binding.buttonAlgoritms.setOnClickListener(clickListener);
        binding.buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int choice;
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            if (view.getId() == binding.buttonPatterns.getId()){
                intent.putExtra("choice", 1);  //Если нажата кнопка Паттерны, в следующее окно
            }                                             //передается значение 1, в обратном случае 0
            else {
                intent.putExtra("choice", 2);
            }
            startActivity(intent);
            }
        };
    }