package com.example.lv1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    public Student student = new Student();

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;

        switch (position)
        {
            case 1 :
                fragment = new StudentInfoFragment();
                ((StudentInfoFragment)fragment).fragmentListener = student;
                break;
            case 2:
                fragment = new SummaryFragment();
                ((SummaryFragment)fragment).fragmentListener = student;
                break;
            default:
                fragment = new PersonalInfoFragment();
                ((PersonalInfoFragment)fragment).fragmentListener = student;
                break;
        }

        return fragment;
    }

    @Override
    public int getItemCount() {

        return 3;
    }
}