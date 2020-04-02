package com.lyulya.navigationui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment implements View.OnClickListener {

    private Long time, time1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnGoToSettingsFragment = view.findViewById(R.id.btnGoToSettingsFragment);
        btnGoToSettingsFragment.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGoToSettingsFragment) {
            NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_FirstFragment_to_SettingsFragment);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        time = System.currentTimeMillis();
    }

    @Override
    public void onStop() {
        super.onStop();
        time1 = System.currentTimeMillis() - time;
        Log.i("FragmentSpeed", String.valueOf(time1));
    }
}



