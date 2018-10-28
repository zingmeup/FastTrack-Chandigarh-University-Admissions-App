package com.example.deepakyadav.fasttrack.Phase1.extra;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

@SuppressLint("ValidFragment")
public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    int viewId;
    @SuppressLint("ValidFragment")
    public DatePicker(int viewId) {
        this.viewId=viewId;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int mon=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, mon, day);
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int i, int i1, int i2) {
        TextView dob=getActivity().findViewById(viewId);
        dob.setText((datePicker.getMonth()+1)+"/"+datePicker.getDayOfMonth()+"/"+datePicker.getYear());
    }
}
