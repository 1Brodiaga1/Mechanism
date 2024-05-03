package com.dvlpmnt.mobilka;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class DetailFragmentPagerAdapter extends FragmentPagerAdapter {

    String[] headers = {"Описание", "Вид", "Код"};

    public DetailFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentDescription();
            case 1:
                return new FragmentInspection();
            case 2:
                return new FragmentCode();
            default:
                return new FragmentDescription();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return headers[position];
    }
}
