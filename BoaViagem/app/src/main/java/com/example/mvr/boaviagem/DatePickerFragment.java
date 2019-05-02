package com.example.mvr.boaviagem;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private int ano, mes, dia;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Calendar calendar = Calendar.getInstance();
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);


        return new DatePickerDialog(getActivity(), this, ano, mes, dia);

    }

    public void onDateSet(DatePicker view, int year, int month, int day){
        ano = year;
        mes = month;
        dia = day;
        GastoActivity.dataGasto.setText(dia + "/" + (mes+1) + "/" + ano);

    }
}
