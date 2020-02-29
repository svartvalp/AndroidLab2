package com.example.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class ViewPagerHolderFragment extends Fragment {
    int position;
    public ViewPagerHolderFragment(int position) {
        super();
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_pager_holder, container, false);
        ViewPager2 viewPager2 = v.findViewById(R.id.view_pager);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        ViewPagerAdapter adapter = new ViewPagerAdapter();
        viewPager2.setAdapter(adapter);
        viewPager2.setCurrentItem(position);
        return v;
    }
}
