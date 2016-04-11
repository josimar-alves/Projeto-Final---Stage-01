package com.example.jr.projetofinal_stage01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private String tipo = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Filme> filmes = new ArrayList<Filme>();
        GridView grid = (GridView) findViewById(R.id.gridView);


        Bundle b = getIntent().getExtras();

        if (b == null) {
            tipo = "popular";
        } else {
            tipo = b.getString("tipo");
        }

        try {
            filmes = new JsonManager().execute(tipo).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (filmes != null) {
            String[] links = getLinks(filmes);
            ImagemAdapter imageAdapter = new ImagemAdapter(this, links);
            grid.setAdapter(imageAdapter);
        }

        final List<Filme> finalFilmes = filmes;
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(), DetalheActivity.class);
                Bundle b = new Bundle();

                Filme f = finalFilmes.get(position);
                b.putString("link", f.getLinkImg());
                b.putString("sinopse", f.getSinopse());
                b.putString("dataRelease", f.getDataRelease());
                b.putString("tituloOriginal", f.getTituloOriginal());
                b.putString("idioma", f.getIdioma());
                b.putString("titulo", f.getTitulo());
                i.putExtras(b);
                startActivity(i);
            }
        });

    }

    private String[] getLinks(List<Filme> filmes) {
        String[] links = new String[filmes.size()];
        int x = 0;
        for (Filme f : filmes) {
            links[x] = f.getLinkImg();
            x += 1;
        }
        return links;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent i = new Intent(getBaseContext(), SettingsActivity.class);
            Bundle b = new Bundle();
            b.putString("tipo", tipo);
            i.putExtras(b);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
