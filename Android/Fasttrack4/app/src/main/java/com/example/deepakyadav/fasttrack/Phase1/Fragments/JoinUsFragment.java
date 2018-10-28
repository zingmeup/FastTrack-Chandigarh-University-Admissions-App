package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.NetworkOperations;
import com.example.deepakyadav.fasttrack.R;

public class JoinUsFragment extends Fragment {
    LoginFragment loginFragment;
    RegisterFragment registerFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    public static Button firstBtn,secondBtn;
    public static Dialog responceDialog;
    boolean isLogin=false;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_joinus, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginFragment=new LoginFragment();
        registerFragment=new RegisterFragment();
        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.joinus_fragment_container, loginFragment).commit();
        firstBtn=view.findViewById(R.id.joinus_first);
        secondBtn=view.findViewById(R.id.joinus_second);
        firstBtn.setText("Register Instead");
        secondBtn.setText("Login");
        firstBtn.setOnClickListener(flipClickListener);
        secondBtn.setOnClickListener(loginClickListener);

        responceDialog=new Dialog(getContext(), R.style.Dialog);
        responceDialog.setCanceledOnTouchOutside(true);
        responceDialog.setContentView(R.layout.dialog_responce);


    }


    private View.OnClickListener loginClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(loginFragment.loginVerifier()){
                Toast.makeText(getActivity(), "All okay!", Toast.LENGTH_SHORT).show();
            }


        }
    };
    private View.OnClickListener flipClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            fragmentTransaction=fragmentManager.beginTransaction();
            if(isLogin){
                fragmentTransaction.setCustomAnimations(R.anim.card_flip_right_in,R.anim.card_flip_right_out,R.anim.card_flip_left_in,R.anim.card_flip_left_out)
                        .replace(R.id.joinus_fragment_container, loginFragment)
                        .commit();
                secondBtn.setOnClickListener(loginClickListener);
                firstBtn.setText("Register Instead");
                secondBtn.setText("Login");
                isLogin=false;
            }else{
                fragmentTransaction.setCustomAnimations(R.anim.card_flip_left_in,R.anim.card_flip_left_out,R.anim.card_flip_right_in,R.anim.card_flip_right_out)
                        .replace(R.id.joinus_fragment_container, registerFragment)
                        .commit();
                secondBtn.setOnClickListener(registerClickListener);
                firstBtn.setText("Login Instead");
                secondBtn.setText("Register");
                isLogin=true;
            }
        }
    };
    private View.OnClickListener registerClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), "Register", Toast.LENGTH_SHORT).show();
            if (registerFragment.registerVerifier()){
                Toast.makeText(getActivity(), "All Ok", Toast.LENGTH_SHORT).show();

            }

        }
    };

}
