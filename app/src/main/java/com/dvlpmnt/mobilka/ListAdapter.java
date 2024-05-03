//package com.dvlpmnt.mobilka;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import java.util.ArrayList;
//
//public class ListAdapter extends ArrayAdapter<ListData> {
//    public ListAdapter(@NonNull Context context, ArrayList<ListData> dataArrayList) {
//        super(context, R.layout.list_item, dataArrayList);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
//        ListData listData = getItem(position);
//
//        if (view == null){
//            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
//        }
//
//        TextView textList = view.findViewById(R.id.textList);
//
//        textList.setText(listData.name);
//
//        return view;
//    }
//}
