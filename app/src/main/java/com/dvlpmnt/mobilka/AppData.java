package com.dvlpmnt.mobilka;

import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AppData {

    private static AppData dataInstance = new AppData();

    private List<Data> listAlgoritms = new ArrayList<>();
    private List<Data> listPatterns = new ArrayList<>();
    private DatabaseReference mDataBase = FirebaseDatabase.getInstance("https://mechanism-20ffe-default-rtdb.europe-west1.firebasedatabase.app/").getReference();

    public static synchronized AppData getAppDataInstance(){
        return dataInstance;
    }

    public void initListPatterns(LoadDataFromDBCallback callback){

        mDataBase.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (!task.isSuccessful()){
                    Log.d("APPDATA_DATABASE", task.getException().getMessage());
                }
                else {
                    if (listPatterns.isEmpty()){
                    for (DataSnapshot ds : task.getResult().child("Patterns").getChildren()){
                        Data data = ds.getValue(Data.class);
                        Log.d("APPDATA_LIST", data.getName());
                        listPatterns.add(data);
                        }
                    }

                    callback.onCallback(listPatterns);

                }
            }
        });
    }

    public void initListAlgoritms(LoadDataFromDBCallback callback){

        mDataBase.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (!task.isSuccessful()){
                    Log.d("APPDATA_DATABASE", task.getException().getMessage());
                }
                else {
                    if (listAlgoritms.isEmpty()){
                        for (DataSnapshot ds : task.getResult().child("Algoritms").getChildren()){
                            Data data = ds.getValue(Data.class);
                            Log.d("APPDATA_LIST", data.getName());
                            listAlgoritms.add(data);
                        }
                    }
                    Log.d("APPDATA_FL", String.valueOf(listAlgoritms.size()));
                    callback.onCallback(listAlgoritms);

                }
            }
        });
    }
    public interface LoadDataFromDBCallback {
        void onCallback(List<Data> dataList);
    }
    public List<Data> getListPatterns() {
        return listPatterns;
    }

    public List<Data> getListAlgoritms() {
        return listAlgoritms;
    }
}
