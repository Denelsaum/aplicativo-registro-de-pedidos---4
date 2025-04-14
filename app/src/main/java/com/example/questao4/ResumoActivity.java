package com.example.questao4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResumoActivity extends AppCompatActivity {

    TextView txtResumoPedido;
    Button btnNovoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        txtResumoPedido = findViewById(R.id.txtResumoPedido);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);

        // Pegando os dados vindos da tela anterior
        String nome = getIntent().getStringExtra("nomeCliente");
        String lanche = getIntent().getStringExtra("lancheEscolhido");

        txtResumoPedido.setText("Pedido concluído!\nCliente: " + nome + "\nLanche: " + lanche);

        btnNovoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResumoActivity.this, MainActivity.class);
                // limpa a pilha de activities anteriores
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
