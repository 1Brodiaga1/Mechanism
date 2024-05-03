package com.dvlpmnt.mobilka;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;
public class CheckPatternsView extends LinearLayout {

    public CheckBox checkBoxPatternsBehavioral, checkBoxPatternsStructural, checkBoxPatternsCreational;
    public CheckPatternsView(Context context) {
        super(context);
        init(context, null);
    }

    public CheckPatternsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CheckPatternsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        // Инициализация и настройка вашего пользовательского представления
        setOrientation(VERTICAL);

        checkBoxPatternsBehavioral = new CheckBox(getContext());
        checkBoxPatternsStructural = new CheckBox(getContext());
        checkBoxPatternsCreational = new CheckBox(getContext());

//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(checkboxWidth, checkboxHeight);
//
//        checkBoxPatternsBehavioral.setLayoutParams(params);
//        checkBoxPatternsStructural.setLayoutParams(params);
//        checkBoxPatternsCreational.setLayoutParams(params);
//

        checkBoxPatternsBehavioral.setText("Поведенческие");
        checkBoxPatternsStructural.setText("Структурные");
        checkBoxPatternsCreational.setText("Порождающие");

        checkBoxPatternsBehavioral.setTextSize(26);
        checkBoxPatternsStructural.setTextSize(26);
        checkBoxPatternsCreational.setTextSize(26);

        checkBoxPatternsBehavioral.setChecked(true);
        checkBoxPatternsStructural.setChecked(true);
        checkBoxPatternsCreational.setChecked(true);

        addView(checkBoxPatternsBehavioral);
        addView(checkBoxPatternsStructural);
        addView(checkBoxPatternsCreational);
    }
//
//    public boolean isCheckedBehavioral(){
//        if (checkBoxPatternsBehavioral.isChecked() == true){
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//
//    public boolean isCheckedStructural() {
//        if (checkBoxPatternsStructural.isChecked() == true){
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//
//    public boolean isCheckedCreational() {
//        if (checkBoxPatternsCreational.isChecked() == true){
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
}
