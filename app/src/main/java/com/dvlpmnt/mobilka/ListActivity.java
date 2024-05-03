package com.dvlpmnt.mobilka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Context;

import com.dvlpmnt.mobilka.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ActivityListBinding binding;
    List<ListData> listDataArray = new ArrayList<>();
    List<View> listDataViewArray = new ArrayList<>();
    int PatAlgChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonExitList.setOnClickListener(new View.OnClickListener() { // Кнопка возвращения на главный экран
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intentBack);
            }
        });

        Intent intent = getIntent();
        PatAlgChoice = intent.getIntExtra("choice", 1);
        AppData appdata = AppData.getAppDataInstance();

        if (PatAlgChoice == 1){
            binding.textViewHeader.setText("Паттерны");

            appdata.initListPatterns(new AppData.LoadDataFromDBCallback() {
                @Override
                public void onCallback(List<Data> dataList) {
                    new ComplexAsyncTask().execute(dataList);
                }
            });
    }
        else{
            binding.textViewHeader.setText("Алгоритмы");
            binding.linearLayout.removeView(binding.checkBoxPatterns);

            appdata.initListAlgoritms(new AppData.LoadDataFromDBCallback() {
                @Override
                public void onCallback(List<Data> dataList) {
                    new ComplexAsyncTask().onPostExecute(dataList);
                }
            });

        }
    }

    class ComplexAsyncTask extends AsyncTask<List<Data>, Void, List<Data>>{

        @Override
        protected List<Data> doInBackground(List<Data>... lists) {

            List<Data> dataList = lists[0];
            Log.d("APPDATA_BACK", String.valueOf(dataList.size()));
            return dataList;
        }

        @Override
        protected void onPostExecute(List<Data> data) {
            super.onPostExecute(data);

            if (PatAlgChoice == 1) {
                Log.d("APPDATA_POST", String.valueOf(data.size()));
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getType().equals("Поведенческий")) {
                        Log.d("APPDATA", data.get(i).getName());
                        ListData listData = new ListData(ListActivity.this, data.get(i), ListData.PATTERN_CHOICE);
                        View view = listData.getView();
                        listDataArray.add(listData);
                        listDataViewArray.add(view);
                        binding.linearlist.addView(view);
                    }
                }

                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getType().equals("Структурный")) {
                        Log.d("APPDATA", data.get(i).getName());
                        ListData listData = new ListData(ListActivity.this, data.get(i), ListData.PATTERN_CHOICE);
                        View view = listData.getView();
                        listDataArray.add(listData);
                        listDataViewArray.add(view);
                        binding.linearlist.addView(view);
                    }
                }

                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getType().equals("Порождающий")) {
                        Log.d("APPDATA", data.get(i).getName());
                        ListData listData = new ListData(ListActivity.this, data.get(i), ListData.PATTERN_CHOICE);
                        View view = listData.getView();
                        listDataArray.add(listData);
                        listDataViewArray.add(view);
                        binding.linearlist.addView(view);
                    }
                }
                CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            binding.linearlist.removeAllViews();

                            if (binding.checkBoxPatterns.checkBoxPatternsBehavioral.isChecked()) {
                                for (int i = 0; i < listDataViewArray.size(); i++) {

                                    Log.d("APPDATA_CB", listDataArray.get(i).getType());
                                    if (listDataArray.get(i).getType().equals(ListData.TYPE_BEHAVIORAL)) {
                                        binding.linearlist.addView(listDataViewArray.get(i));
                                    }
                                }
                            }

                            if (binding.checkBoxPatterns.checkBoxPatternsStructural.isChecked()) {
                                for (int i = 0; i < listDataViewArray.size(); i++) {

                                    Log.d("APPDATA_CB", listDataArray.get(i).getType());
                                    if (listDataArray.get(i).getType().equals(ListData.TYPE_STRUCTURAL)) {
                                        binding.linearlist.addView(listDataViewArray.get(i));
                                    }
                                }
                            }

                            if (binding.checkBoxPatterns.checkBoxPatternsCreational.isChecked()) {
                                for (int i = 0; i < listDataViewArray.size(); i++) {

                                    Log.d("APPDATA_CB", listDataArray.get(i).getType());
                                    if (listDataArray.get(i).getType().equals(ListData.TYPE_CREATIONAL)) {
                                        binding.linearlist.addView(listDataViewArray.get(i));
                                    }
                                }
                            }
                        } else {

                            if (!binding.checkBoxPatterns.checkBoxPatternsBehavioral.isChecked()) {
                                for (int i = 0; i < listDataViewArray.size(); i++) {

                                    Log.d("APPDATA_CB", listDataArray.get(i).getType());
                                    if (listDataArray.get(i).getType().equals(ListData.TYPE_BEHAVIORAL)) {
                                        binding.linearlist.removeView(listDataViewArray.get(i));
                                    }
                                }
                            }

                            if (!binding.checkBoxPatterns.checkBoxPatternsStructural.isChecked()) {
                                for (int i = 0; i < listDataViewArray.size(); i++) {

                                    Log.d("APPDATA_CB", listDataArray.get(i).getType());
                                    if (listDataArray.get(i).getType().equals(ListData.TYPE_STRUCTURAL)) {
                                        binding.linearlist.removeView(listDataViewArray.get(i));
                                    }
                                }
                            }

                            if (!binding.checkBoxPatterns.checkBoxPatternsCreational.isChecked()) {
                                for (int i = 0; i < listDataViewArray.size(); i++) {

                                    Log.d("APPDATA_CB", listDataArray.get(i).getType());
                                    if (listDataArray.get(i).getType().equals(ListData.TYPE_CREATIONAL)) {
                                        binding.linearlist.removeView(listDataViewArray.get(i));
                                    }
                                }
                            }
                        }
                    }
                };

                binding.checkBoxPatterns.checkBoxPatternsBehavioral.setOnCheckedChangeListener(checkedChangeListener);
                binding.checkBoxPatterns.checkBoxPatternsStructural.setOnCheckedChangeListener(checkedChangeListener);
                binding.checkBoxPatterns.checkBoxPatternsCreational.setOnCheckedChangeListener(checkedChangeListener);
            }
            else {

                for (int i = 0; i < data.size(); i++){
                    Log.d("APPDATA_CYCLE", data.get(i).getName());
                    ListData listData = new ListData(ListActivity.this, data.get(i), ListData.ALGORITM_CHOICE);
                    View view = listData.getView();
                    listDataArray.add(listData);
                    listDataViewArray.add(view);
                    binding.linearlist.addView(view);
                }
            }
        }
    }
}


