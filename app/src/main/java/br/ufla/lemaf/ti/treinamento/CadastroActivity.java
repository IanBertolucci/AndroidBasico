package br.ufla.lemaf.ti.treinamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    EditText edtNome, edtCurso;
    Button btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = (EditText) findViewById(R.id.editTextNome);
        edtCurso = (EditText) findViewById(R.id.editTextCurso);

        btnProximo = (Button) findViewById(R.id.txtButtonProximo);
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtNome = edtNome.getText().toString();
                String txtCurso = edtCurso.getText().toString();

                Intent intent = new Intent(CadastroActivity.this, VerActivity.class);
                intent.putExtra("nome", txtNome);
                intent.putExtra("curso", txtCurso);
                startActivity(intent);
            }
        });
    }
}
