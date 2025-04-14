package com.example.questao4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioActivity extends AppCompatActivity {

    TextInputEditText edtNomeCliente;
    RadioGroup grupoLanches;
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        edtNomeCliente = findViewById(R.id.edtNomeCliente);
        grupoLanches = findViewById(R.id.grupoLanches);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edtNomeCliente.getText().toString();
                int idSelecionado = grupoLanches.getCheckedRadioButtonId();

                if (idSelecionado != -1 && !nome.isEmpty()) {
                    RadioButton radioSelecionado = findViewById(idSelecionado);
                    String lanche = radioSelecionado.getText().toString();

                    Intent intent = new Intent(FormularioActivity.this, ResumoActivity.class);
                    intent.putExtra("nomeCliente", nome);
                    intent.putExtra("lancheEscolhido", lanche);
                    startActivity(intent);
                }
            }
        });
    }
}
