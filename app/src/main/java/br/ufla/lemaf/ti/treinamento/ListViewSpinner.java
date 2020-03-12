package br.ufla.lemaf.ti.treinamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewSpinner extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ArrayAdapter<String> adapterHabilidades;
    ArrayAdapter<String> adapterAreas;
    ArrayList<String> habilidades;
    Spinner spnArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_spinner);

        habilidades = new ArrayList<String>();
        adapterHabilidades = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, habilidades);

        String[] areaAtuacao = {"Desenvolvimento", "Segurança da Informação", "Infraestrutura"};
        adapterAreas = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, areaAtuacao);

        spnArea = (Spinner) findViewById(R.id.mSpinner);
        spnArea.setAdapter(adapterAreas);

        ListView listaHabilidades = (ListView) findViewById(R.id.listView);
        listaHabilidades.setAdapter(adapterHabilidades);

        Button btnSelecionar = (Button) findViewById(R.id.btnSelecionar);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        btnSelecionar.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

        listaHabilidades.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSelecionar:
                TextView txtResultado = (TextView) findViewById(R.id.txtSelecionado);
                String txtSpinner = spnArea.getSelectedItem().toString();
                txtResultado.setText("Área selecionada: " + txtSpinner + " com as habilidades abaixo:");
                break;
            case R.id.btnAdd:
                EditText edtHabilidades = (EditText) findViewById(R.id.editText);
                String txtHabilidades = edtHabilidades.getText().toString();

                if (!txtHabilidades.isEmpty()){
                    habilidades.add(txtHabilidades);
                    adapterHabilidades.notifyDataSetChanged();
                }

                edtHabilidades.setText("");
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        habilidades.remove(position);
        adapterHabilidades.notifyDataSetChanged();
    }
}
