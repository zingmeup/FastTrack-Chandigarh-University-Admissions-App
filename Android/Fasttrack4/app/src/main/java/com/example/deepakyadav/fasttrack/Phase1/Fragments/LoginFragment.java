package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.deepakyadav.fasttrack.Phase1.Data.JoinUsData;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.NetworkOperations;
import com.example.deepakyadav.fasttrack.R;

public class LoginFragment extends Fragment {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPrefrencesEditor;
    View inflatedView;
    EditText username, password;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView= inflater.inflate(R.layout.fragment_login, container, false);
        return inflatedView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        username=view.findViewById(R.id.joinus_login_userid);
        password=view.findViewById(R.id.joinus_login_password);
        sharedPreferences=getActivity().getSharedPreferences("com.example.deepakyadav.fasttrack.Phase1.Activities", Context.MODE_PRIVATE);
        sharedPrefrencesEditor=sharedPreferences.edit();

    }


    @Override
    public void onResume() {
        super.onResume();
        username.setText(JoinUsData.getData().getTempLoginData().get("fasttrackid"));
        password.setText(JoinUsData.getData().getTempLoginData().get("password"));
        if (JoinUsData.getData().getTempLoginData().get("fasttrackid").equals("")){
            username.setText(sharedPreferences.getString("username", ""));
            password.setText(sharedPreferences.getString("password", ""));
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        sharedPrefrencesEditor.putString("username", username.getText().toString());
        sharedPrefrencesEditor.putString("password", password.getText().toString());
        sharedPrefrencesEditor.commit();
    }

    public boolean loginVerifier(){
        boolean returnvalue=true;
        EditText editText;

        editText=inflatedView.findViewById(R.id.joinus_login_userid);
        if(editText.getText().toString().length()>8){
            editText.setBackgroundColor(getActivity().getResources().getColor(R.color.colorWhite));
        }else {
            editText.setBackgroundColor(getActivity().getResources().getColor(R.color.colorerror));
            returnvalue=false;
        }
        editText=inflatedView.findViewById(R.id.joinus_login_password);
        if(editText.getText().toString().length()>8){
            editText.setBackgroundColor(getActivity().getResources().getColor(R.color.colorWhite));
        }else {
            editText.setBackgroundColor(getActivity().getResources().getColor(R.color.colorerror));
            returnvalue=false;
        }
        if (returnvalue){
            NetworkOperations.getInstance().validate(getActivity(), username.getText().toString(), password.getText().toString());
        }

        return returnvalue;
    }

}
