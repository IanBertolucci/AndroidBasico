package br.ufla.lemaf.ti.treinamento;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentoCursoDetalhe extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_curso_detalhe, container, false);
    }

    public void load(int id) {
        TextView textViewCurso = (TextView) getView().findViewById(R.id.textViewCurso);

        List<String> cursos = new ArrayList<>();
        cursos.add("Android Básico");
        cursos.add("Android Intermediário");
        cursos.add("Android Avançado");

        String curso = cursos.get(id);

        textViewCurso.setText(curso);
    }

}
