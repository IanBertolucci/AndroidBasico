package br.ufla.lemaf.ti.treinamento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentsActivity extends AppCompatActivity {

    EditText editText;
    Button btnLigar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);

        editText = (EditText) findViewById(R.id.editTextTelefone);
        btnLigar = (Button) findViewById(R.id.btnLigar);
        btnLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtTelefone = editText.getText().toString();

                if (ActivityCompat.checkSelfPermission(IntentsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(IntentsActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + txtTelefone));
                    startActivity(intent);
                }
            }
        });
    }
}
