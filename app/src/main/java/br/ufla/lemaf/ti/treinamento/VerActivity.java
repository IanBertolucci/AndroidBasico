package br.ufla.lemaf.ti.treinamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VerActivity extends AppCompatActivity {

    TextView textViewNome, textViewCurso;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        Bundle bundle = getIntent().getExtras();
        String txtNome = bundle.getString("nome");
        String txtCurso = bundle.getString("curso");

        textViewNome = (TextView) findViewById(R.id.textViewNomeResposta);
        textViewCurso = (TextView) findViewById(R.id.textViewCursoResposta);

        textViewNome.setText("Nome: " + txtNome);
        textViewCurso.setText("Curso: " + txtCurso);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
