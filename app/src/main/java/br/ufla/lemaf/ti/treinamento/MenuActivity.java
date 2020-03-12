package br.ufla.lemaf.ti.treinamento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView txtResultado = (TextView) findViewById(R.id.textView);
        String texto = "";

        switch (item.getItemId()){
            case R.id.menuAdd:
                texto = "add";
                break;
            case R.id.menuAjuda:
                texto = "ajyda";
                break;
            case R.id.menuSalvar:
                texto = "salvar";
                break;
            case R.id.menuEditar:
                texto = "editar";
                break;
            case R.id.menuDeletar:
                texto = "deletar";
                break;
        }

        txtResultado.setText(texto);

        return super.onOptionsItemSelected(item);
    }
}
