package br.ufla.lemaf.ti.treinamento;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentoCurso extends Fragment {

    OnListCourseSelectedListener callback;

    public interface OnListCourseSelectedListener {
        public void onCourseSelected(long id);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_exemplo, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        List<String> cursos = new ArrayList<>();
        cursos.add("Android Básico");
        cursos.add("Android Intermediário");
        cursos.add("Android Avançado");

        ArrayAdapter<String> adapterCursos = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_gallery_item, cursos);
        ListView list = (ListView) getView().findViewById(R.id.listViewCursos);
        list.setAdapter(adapterCursos);
        list.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callback = (OnListCourseSelectedListener) context;
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            callback.onCourseSelected(id);
        }
    };
}
