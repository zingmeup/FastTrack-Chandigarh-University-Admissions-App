package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deepakyadav.fasttrack.Phase1.Data.JoinUsData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.CityModel;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.NetworkOperations;
import com.example.deepakyadav.fasttrack.Phase1.extra.DatePicker;
import com.example.deepakyadav.fasttrack.R;

public class RegisterFragment extends Fragment {
    View inflatedView,dobView;
    EditText name,email,mobile;
    Spinner discipline, program;
    TextView dob;
    AutoCompleteTextView city;
    String autoCompleteSelectedItem, programSelectedCode;
    public static ArrayAdapter disciplineAdapter,programAdapter,cityAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView= inflater.inflate(R.layout.fragment_register, container, false);
        return inflatedView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dobView=view.findViewById(R.id.joinus_register_dobView);
        name=view.findViewById(R.id.joinus_register_name);
        email=view.findViewById(R.id.joinus_register_email);
        mobile=view.findViewById(R.id.joinus_register_mobile);
        discipline=view.findViewById(R.id.joinus_register_discipline);
        program=view.findViewById(R.id.joinus_register_program);
        dob=view.findViewById(R.id.joinus_register_dob);
        city=view.findViewById(R.id.joinus_register_city);
        NetworkOperations.getInstance().fetchCity(getActivity());
        dobView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchDatePicker();

            }
        });
        cityAdapter=new ArrayAdapter(getContext(), R.layout.row_custom_spinner_item, JoinUsData.getData().getCityList());
        city.setAdapter(cityAdapter);
        city.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                autoCompleteSelectedItem=city.getText().toString();
                Log.e("onItemClick", autoCompleteSelectedItem);

            }
        });
        city.setThreshold(1);
        disciplineAdapter=new ArrayAdapter(getContext(), R.layout.row_custom_spinner_item, JoinUsData.getData().getDisciplineList());
        discipline.setAdapter(disciplineAdapter);
        Log.e("Discipline Adapter","Adapter set");
        NetworkOperations.getInstance().fetchDiscipline(getActivity());
        Log.e("Discipline Adapter","Network operation requested");
        discipline.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                NetworkOperations.getInstance().fetchProgram(getActivity(), discipline.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        programAdapter=new ArrayAdapter(getContext(), R.layout.row_custom_spinner_item, JoinUsData.getData().getProgramList());
        program.setAdapter(programAdapter);
        program.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String programCode=JoinUsData.getData().getProgramCode(i);
                programSelectedCode=String.valueOf(programCode);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void launchDatePicker() {
        DatePicker datePicker=new DatePicker(R.id.joinus_register_dob);
        datePicker.show(getActivity().getFragmentManager(), "saddasa");

    }
    public boolean registerVerifier(){
        boolean returnvalue=true;

        if(name.getText().toString().trim().length()>0){
            name.setBackgroundColor(getActivity().getResources().getColor(R.color.colorWhite));
        }else {
            name.setBackgroundColor(getActivity().getResources().getColor(R.color.colorerror));
            returnvalue=false;
        }
        if(email.getText().toString().trim().length()>8){
            email.setBackgroundColor(getActivity().getResources().getColor(R.color.colorWhite));
        }else {
            email.setBackgroundColor(getActivity().getResources().getColor(R.color.colorerror));
            returnvalue=false;
        }
        if(mobile.getText().toString().trim().length()==10){
            mobile.setBackgroundColor(getActivity().getResources().getColor(R.color.colorWhite));
        }else {
            mobile.setBackgroundColor(getActivity().getResources().getColor(R.color.colorerror));
            returnvalue=false;
        }
        try {

            if (!(discipline.getSelectedItem().toString().equals("SELECT DISCIPLINE"))) {
                discipline.setBackgroundColor(getActivity().getResources().getColor(R.color.colorWhite));
            } else {
                discipline.setBackgroundColor(getActivity().getResources().getColor(R.color.colorerror));
                returnvalue = false;
            }

            if (!(program.getSelectedItem().toString().equals("SELECT PROGRAM"))) {
                program.setBackgroundColor(getActivity().getResources().getColor(R.color.colorWhite));
            } else {
                program.setBackgroundColor(getActivity().getResources().getColor(R.color.colorerror));
                returnvalue = false;
            }
        }catch (NullPointerException e){
            Toast.makeText(getActivity(), "Connection Lost", Toast.LENGTH_SHORT).show();
        }

/*        if((city.getText().toString().equals(autoCompleteSelectedItem))){
            city.setBackgroundColor(getActivity().getResources().getColor(R.color.colorWhite));
        }else {
            city.setBackgroundColor(getActivity().getResources().getColor(R.color.colorerror));
            returnvalue=false;
        }*/

        if(!(dob.getText().toString().equals("mm/dd/yyyy"))){
            dob.setBackgroundColor(getActivity().getResources().getColor(R.color.colorWhite));
        }else {
            dob.setBackgroundColor(getActivity().getResources().getColor(R.color.colorerror));
            returnvalue=false;
        }
        if(returnvalue){
            NetworkOperations.getInstance().SubmitData(getActivity(), name.getText().toString(),
                    email.getText().toString(), mobile.getText().toString(), programSelectedCode, "0", dob.getText().toString());
        }

        return returnvalue;
    }
}
