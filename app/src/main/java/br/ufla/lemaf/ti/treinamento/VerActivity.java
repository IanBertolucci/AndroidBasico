package br.ufla.lemaf.ti.treinamento;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VerActivity extends AppCompatActivity {

    TextView textViewNome, textViewCurso;
    Button btnVoltar, btnAvaliar;

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

        btnAvaliar = (Button) findViewById(R.id.btnAvaliar);
        btnAvaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerActivity.this, AvaliacaoActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                if (data.hasExtra("nota")) {
                    TextView txtNota = (TextView) findViewById(R.id.txtViewNota);
                    String nota = data.getExtras().getString("nota");

                    txtNota.setText(nota);
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
