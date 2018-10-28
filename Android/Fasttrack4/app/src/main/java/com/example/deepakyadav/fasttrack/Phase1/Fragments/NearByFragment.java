package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.deepakyadav.fasttrack.Phase1.Adapters.AdmissionOfficesAdapter;
import com.example.deepakyadav.fasttrack.Phase1.Data.AdmissionOfficesData;
import com.example.deepakyadav.fasttrack.R;

public class NearByFragment extends Fragment {
    private AdapterView.OnItemSelectedListener spinnerListener=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d("admissionoffice", "item clicked");
            admissionOfficesAdapter=new AdmissionOfficesAdapter(getActivity(), stateList.getSelectedItem().toString());
            listView.setAdapter(admissionOfficesAdapter);
            admissionOfficesAdapter.notifyDataSetChanged();
            listView.setVisibility(View.VISIBLE);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    View inflatedView;
    ListView listView;
    public static AdmissionOfficesAdapter admissionOfficesAdapter;
    Spinner stateList;
    public static ArrayAdapter<String> arrayAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView=inflater.inflate(R.layout.fragment_nearby, container, false);
        return inflatedView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.nearby_listview);
        admissionOfficesAdapter=new AdmissionOfficesAdapter(getActivity(),"ALL");
        stateList=view.findViewById(R.id.nearby_states);

        Log.d("admissionoffice", "spinner adapter created");
        arrayAdapter=new ArrayAdapter<>(getActivity(), R.layout.row_custom_spinner_item, AdmissionOfficesData.getInstance().getStates());

        listView.setAdapter(admissionOfficesAdapter);

        Log.d("admissionoffice", "spinner Adapter set");
        stateList.setAdapter(arrayAdapter);

        Log.d("admissionoffice", "Spinner onItemSelected");
        stateList.setOnItemSelectedListener(spinnerListener);
        Log.d("admissionoffice", "Notify dataset Changed List");
        admissionOfficesAdapter.notifyDataSetChanged();
        Log.d("admissionoffice", "Notify dataset Changed Spinner");
        arrayAdapter.notifyDataSetChanged();



    }

    public AdmissionOfficesAdapter getAdmissionOfficesAdapter() {
        return admissionOfficesAdapter;
    }

    public ArrayAdapter<String> getArrayAdapter() {
        return arrayAdapter;
    }
}
