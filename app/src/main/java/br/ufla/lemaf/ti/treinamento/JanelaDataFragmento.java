package br.ufla.lemaf.ti.treinamento;

import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class JanelaDataFragmento extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public Dialog onCreateDialog(Bundle saveInstanceState){
        Calendar c = Calendar.getInstance();
        int ano = c.get(c.YEAR);
        int dia = c.get(c.DAY_OF_MONTH);
        int mes = c.get(c.MONTH);

        return new DatePickerDialog(getActivity(), this, ano, mes, dia);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Toast toast = Toast.makeText(getActivity(), "Data: " + dayOfMonth + "/" + (month+1) + "/" + year, Toast.LENGTH_LONG);
        toast.show();
    }
}
