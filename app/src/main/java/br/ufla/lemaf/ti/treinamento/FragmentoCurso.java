package br.ufla.lemaf.ti.treinamento;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragmento, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAdicionar2:
                Toast toast = Toast.makeText(getActivity(), "Menu selecionado: adicionar", Toast.LENGTH_LONG);
                toast.show();
                return true;
            case R.id.menuEditar2:
                Toast toast2 = Toast.makeText(getActivity(), "Menu selecionado: editar", Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
