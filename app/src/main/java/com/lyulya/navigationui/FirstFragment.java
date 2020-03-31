package com.lyulya.navigationui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.lyulya.navigationui.Canvas.LineView;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private int randomint = 20;
    private LineView lineView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        getActivity().setTitle(R.string.first_fragment_label);

        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SettingsFragment);
//            }
//        });

        lineView = view.findViewById(R.id.line_view);

        //must*
        ArrayList<String> test = new ArrayList<>();
        for (int i = 0; i < randomint; i++) {
            test.add(String.valueOf(i + 1));
        }
        lineView.setBottomTextList(test);
        lineView.setDrawDotLine(true);
        lineView.setShowPopup(LineView.SHOW_POPUPS_NONE);

        Button lineButton = view.findViewById(R.id.line_button);
        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomSet(lineView);

            }
        });

        randomSet(lineView);
    }

    private void randomSet(LineView lineView) {
        ArrayList<Integer> dataList = new ArrayList<>();
        int random = (int) (Math.random() * 9 + 1);
        for (int i = 0; i < randomint; i++) {
            dataList.add((int) (Math.random() * random));
        }

//        ArrayList<Integer> dataList2 = new ArrayList<>();
//        random = (int) (Math.random() * 9 + 1);
//        for (int i = 0; i < randomint; i++) {
//            dataList2.add((int) (Math.random() * random));
//        }

//        random = (int) (Math.random() * 9 + 1);
//        ArrayList<Integer> dataList3 = new ArrayList<>();
//        for (int i = 0; i < randomint; i++) {
//            dataList3.add((int) (Math.random() * random));
//        }

        ArrayList<ArrayList<Integer>> dataLists = new ArrayList<>();
        dataLists.add(dataList);
//        dataLists.add(dataList2);


        lineView.setDataList(dataLists);
    }
}
