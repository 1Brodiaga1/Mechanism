package com.dvlpmnt.mobilka;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class FragmentDescription extends Fragment {

    public FragmentDescription(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        TextView detailsHeader = view.findViewById(R.id.detailsHeader);
        TextView textDescription = view.findViewById(R.id.textDescription);

        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.getItemData().observe(getViewLifecycleOwner(), data -> {

            String name = data.getName();
            String description = data.getDescription();

            detailsHeader.setText(name);
            textDescription.setText(description);

        });
        return view;
    }
}
