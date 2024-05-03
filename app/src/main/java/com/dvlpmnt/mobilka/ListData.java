package com.dvlpmnt.mobilka;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

public class ListData {
    private int id;
    private String name;
    private String type;
    private Context context;
    private int choice;
    private Data data;
    private ImageButton buttonDescription;
    private ImageButton buttonInspection;
    private ImageButton buttonCode;

    public static final int PATTERN_CHOICE = 1;
    public static final int ALGORITM_CHOICE = 2;
    public static String TYPE_BEHAVIORAL = "Поведенческий";
    public static String TYPE_STRUCTURAL = "Структурный";
    public static String TYPE_CREATIONAL = "Порождающий";
    public ListData(Context context, Data data, int choice){
        this.data = data;
        this.context = context;
        this.choice = choice;
        this.id = data.getId();
        this.name = data.getName();
        this.type = data.getType();
    }

    public View getView(){
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, null);

        TextView textName = view.findViewById(R.id.textList);
        TextView textType = view.findViewById(R.id.textType);
        buttonDescription = view.findViewById(R.id.buttonDescription);
        buttonInspection = view.findViewById(R.id.buttonInspection);
        buttonCode = view.findViewById(R.id.buttonCode);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                int buttonChoice;

                if (v.getId() == buttonDescription.getId()){
                    buttonChoice = 1;
                } else if (v.getId() == buttonInspection.getId()) {
                    buttonChoice = 2;
                }
                else {
                    buttonChoice = 3;
                }
                intent.putExtra("buttonChoice", buttonChoice);
                intent.putExtra("id", id);
                intent.putExtra("patAlgChoice", choice);
                context.startActivity(intent);
            }
        };

        buttonDescription.setOnClickListener(clickListener);
        buttonInspection.setOnClickListener(clickListener);
        buttonCode.setOnClickListener(clickListener);

        textName.setText(name);
        textType.setText(type);

        return view;
    }
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
    public ImageButton getButtonDescription() {
        return buttonDescription;
    }
    public ImageButton getButtonInspection() {
        return buttonInspection;
    }
    public ImageButton getButtonCode() {
        return buttonCode;
    }
}
