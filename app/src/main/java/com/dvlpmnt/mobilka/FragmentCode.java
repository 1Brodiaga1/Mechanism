package com.dvlpmnt.mobilka;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FragmentCode extends Fragment {

    public FragmentCode(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_code, container, false);

        TextView codeHeader = view.findViewById(R.id.codeHeader);
        TextView textCode = view.findViewById(R.id.textCode);

        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.getItemData().observe(getViewLifecycleOwner(), data -> {

            String name = data.getName();
            String code = data.getCode();

            codeHeader.setText(name);
            textCode.setText(code);

        });

        return view;
    }
}
