package com.dvlpmnt.mobilka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.dvlpmnt.mobilka.databinding.ActivityDetailBinding;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;

    private int ALGORITMS_CHOICE = 2;
    private int PATTERNS_CHOICE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        int buttonChoice = intent.getIntExtra("buttonChoice", 1);
        int patAlgChoice = intent.getIntExtra("patAlgChoice", 1);
        int id = intent.getIntExtra("id", 1);

        binding.buttonExitDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit = new Intent(DetailActivity.this, ListActivity.class);
                exit.putExtra("choice", patAlgChoice);
                startActivity(exit);
            }
        });

        binding.viewpager.setAdapter(new DetailFragmentPagerAdapter(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewpager);

        switch (buttonChoice){
            case 1:
                binding.viewpager.setCurrentItem(0);
                break;
            case 2:
                binding.viewpager.setCurrentItem(1);
                break;
            case 3:
                binding.viewpager.setCurrentItem(2);
                break;
            default:
                binding.viewpager.setCurrentItem(0);
        }

        Log.d("DETAIL", String.valueOf(id));
        List<Data> list;
        Data data = new Data();
        if (patAlgChoice == PATTERNS_CHOICE) {
            list = AppData.getAppDataInstance().getListPatterns();
            Log.d("DETAIL_LS", String.valueOf(list.size()));
        }
        else {
            list = AppData.getAppDataInstance().getListAlgoritms();
            Log.d("DETAIL_LS", String.valueOf(list.size()));
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                data = list.get(i);
                break;
            } else {
                data = list.get(0);
            }
        }

        SharedViewModel viewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        viewModel.setItemData(data);
    }

}