package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.deepakyadav.fasttrack.Phase1.Adapters.StudentSpeakAdapter;
import com.example.deepakyadav.fasttrack.Phase1.EventListeners.OnCLickListeners;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.NetworkOperations;
import com.example.deepakyadav.fasttrack.R;

public class StudentSpeaksFragment extends Fragment{
    public View inflatedView;
    public static ListView listView;
    public static StudentSpeakAdapter studentSpeakAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView=inflater.inflate(R.layout.fragment_studentspeaks, container, false);
        return inflatedView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.studentspeak_listview);
        studentSpeakAdapter=new StudentSpeakAdapter(getActivity());
        listView.setAdapter(studentSpeakAdapter);
        int[] contents={R.id.ss_2017,R.id.ss_2016,R.id.ss_2015,R.id.ss_iitnit,R.id.ss_visitors};
        TextView textView;
        for (int i = 0; i <contents.length ; i++){
            textView=view.findViewById(contents[i]);
            textView.setOnClickListener(OnCLickListeners.getInstance(getActivity()).getStudentSpeaksFloats());

        }

    }

    @Override
    public void onResume() {
        super.onResume();
        studentSpeakAdapter.notifyDataSetChanged();
        TextView textView=inflatedView.findViewById(R.id.ss_2017);
        textView.callOnClick();
    }

}
