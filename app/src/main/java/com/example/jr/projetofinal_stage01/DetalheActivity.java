package com.example.jr.projetofinal_stage01;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalheActivity extends AppCompatActivity {
    private TextView mTituloOriginal;
    private TextView mTitulo;
    private TextView mIdioma;
    private TextView mData;
    private TextView mSinopse;
    private ImageView mImagem;

    private String linkImg;
    private String sinopse;
    private String dataRelease;
    private String tituloOriginal;
    private String idioma;
    private String titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        Bundle b = getIntent().getExtras();

        mTituloOriginal = (TextView) findViewById(R.id.tituloOriginal);
        mTitulo = (TextView) findViewById(R.id.titulo);
        mIdioma = (TextView) findViewById(R.id.idioma);
        mData = (TextView) findViewById(R.id.data);
        mSinopse = (TextView) findViewById(R.id.sinopse);
        mImagem = (ImageView) findViewById(R.id.imageInfo);

        linkImg = b.getString("link");
        sinopse = b.getString("sinopse");
        dataRelease = b.getString("dataRelease");
        tituloOriginal = b.getString("tituloOriginal");
        idioma = b.getString("idioma");
        titulo = b.getString("titulo");

        Picasso.with(getBaseContext()).load(linkImg).into(mImagem);
        mTituloOriginal.setText("Titulo Original: " + tituloOriginal);
        mTitulo.setText("Titulo: " + titulo);
        mIdioma.setText("Idioma: " + idioma);
        mData.setText("Data Release: " + dataRelease);
        mSinopse.setText("Sinopse: " + sinopse);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(titulo);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
