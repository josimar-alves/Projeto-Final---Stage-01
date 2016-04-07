package com.example.jr.projetofinal_stage01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        mText = (TextView) findViewById(R.id.texto);
        Bundle b = getIntent().getExtras();
        String texto = b.getString("nome");
        mText.setText("Olá, " + texto + ", Seja bem vindo, querido!");
    }
}
