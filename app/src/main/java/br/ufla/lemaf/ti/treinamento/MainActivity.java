package br.ufla.lemaf.ti.treinamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtResultado;
    CheckBox checkBoxAndroid1;
    CheckBox checkBoxAndroid2;
    CheckBox checkBoxAndroid3;
    RadioGroup radioGroupInfo;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String resultado = "Curso de interesse: ";

        txtResultado = (TextView) findViewById(R.id.txtResultado);
        checkBoxAndroid1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBoxAndroid2 = (CheckBox) findViewById(R.id.checkbox2);
        checkBoxAndroid3 = (CheckBox) findViewById(R.id.checkbox3);
        radioGroupInfo = (RadioGroup) findViewById(R.id.radioGroup);

        if (checkBoxAndroid1.isChecked()) resultado += checkBoxAndroid1.getText().toString() + ", ";
        if (checkBoxAndroid2.isChecked()) resultado += checkBoxAndroid2.getText().toString() + ", ";
        if (checkBoxAndroid3.isChecked()) resultado += checkBoxAndroid3.getText().toString() + ", ";

        if (radioGroupInfo.getCheckedRadioButtonId() != -1){
            RadioButton radioButtonSelecionado = (RadioButton) findViewById(radioGroupInfo.getCheckedRadioButtonId());
            resultado += "Receber mais informações? "+radioButtonSelecionado.getText().toString();
        }

        txtResultado.setText(resultado);


    }
}
