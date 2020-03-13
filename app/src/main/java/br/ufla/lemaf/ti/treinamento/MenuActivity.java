package br.ufla.lemaf.ti.treinamento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MenuActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.inflateMenu(R.menu.activity_menu);
        toolbar.setTitle("toolbar");
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setOnMenuItemClickListener(this);
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
            case android.R.id.home:
                texto = "icone app";
        }

        Toast toast = Toast.makeText(this, texto, Toast.LENGTH_LONG);
        toast.setGravity(0, 0, 50);
        toast.show();

        txtResultado.setText(texto);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        TextView txtResultado = (TextView) findViewById(R.id.textView2);
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
            case android.R.id.home:
                texto = "icone app";
        }

        txtResultado.setText(texto);
        return false;

    }
}
