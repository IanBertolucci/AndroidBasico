package br.ufla.lemaf.ti.treinamento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JanelaDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_janela_data);

        Button botao = (Button) findViewById(R.id.btnData);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JanelaDataFragmento janelaDataFragmento = new JanelaDataFragmento();
                janelaDataFragmento.show(getSupportFragmentManager(), "janelaData");
            }
        });
    }
}
