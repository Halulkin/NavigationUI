package com.lyulya.navigationui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SettingsFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btSettingsToThird = view.findViewById(R.id.btSettingsToThird);
        Button btSettingsToFirst = view.findViewById(R.id.btSettingsToFirst);

        btSettingsToFirst.setOnClickListener(this);
        btSettingsToThird.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btSettingsToThird:
                NavHostFragment.findNavController(SettingsFragment.this)
                        .navigate(R.id.action_SettingsFragment_to_thirdFragment);
                break;

            case R.id.btSettingsToFirst:
                NavHostFragment.findNavController(SettingsFragment.this)
                        .navigate(R.id.action_SettingsFragment_to_FirstFragment);
                break;

            default:
                break;
        }
    }
}
