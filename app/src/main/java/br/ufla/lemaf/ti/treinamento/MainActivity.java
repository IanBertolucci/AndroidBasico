package br.ufla.lemaf.ti.treinamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentoCurso.OnListCourseSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onCourseSelected(long id) {
        FragmentoCursoDetalhe fragmentoCursoDetalhe = (FragmentoCursoDetalhe) getSupportFragmentManager().findFragmentById(R.id.fragmento_curso_detalhe);
        if (fragmentoCursoDetalhe != null) {
            fragmentoCursoDetalhe.load((int) id);
        } else {
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }
    }
}
