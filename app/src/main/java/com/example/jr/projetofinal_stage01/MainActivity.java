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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView grid = (GridView) findViewById(R.id.gridView);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(), DetalheActivity.class);
                Bundle b = new Bundle();

                b.putString("nome", "Junior"); //// MUDAR

                i.putExtras(b);
                startActivity(i);
                finish();

            }
        });

        String[] imagens = new String[] {"https://pbs.twimg.com/media/CfEfxKEW8AAj-hj.jpg",
                "http://www.teamplay.com.br/imagens/jogos-descricao/lol/League_of_Legends_logo.jpg",
                "http://www.teamplay.com.br/imagens/jogos-descricao/lol/League_of_Legends_logo.jpg",
                "https://pbs.twimg.com/media/CfEfxKEW8AAj-hj.jpg",
                "https://pbs.twimg.com/media/CfEfxKEW8AAj-hj.jpg",
                "http://www.teamplay.com.br/imagens/jogos-descricao/lol/League_of_Legends_logo.jpg",
                "http://www.teamplay.com.br/imagens/jogos-descricao/lol/League_of_Legends_logo.jpg",
                "https://pbs.twimg.com/media/CfEfxKEW8AAj-hj.jpg",
                "https://pbs.twimg.com/media/CfEfxKEW8AAj-hj.jpg",
                "http://www.teamplay.com.br/imagens/jogos-descricao/lol/League_of_Legends_logo.jpg",
                "http://www.teamplay.com.br/imagens/jogos-descricao/lol/League_of_Legends_logo.jpg",
                "https://pbs.twimg.com/media/CfEfxKEW8AAj-hj.jpg",
                "https://pbs.twimg.com/media/CfEfxKEW8AAj-hj.jpg",
                "http://www.teamplay.com.br/imagens/jogos-descricao/lol/League_of_Legends_logo.jpg",
                "http://www.teamplay.com.br/imagens/jogos-descricao/lol/League_of_Legends_logo.jpg",
                "https://pbs.twimg.com/media/CfEfxKEW8AAj-hj.jpg"};

//        int[] imagens = new int[]{R.drawable.sample_0, R.drawable.sample_1,
//                R.drawable.sample_2, R.drawable.sample_3,
//                R.drawable.sample_3, R.drawable.sample_5,
//                R.drawable.sample_0, R.drawable.sample_1,
//                R.drawable.sample_2, R.drawable.sample_3,
//                R.drawable.sample_3, R.drawable.sample_5};

        ImagemAdapter imageAdapter = new ImagemAdapter(this, imagens);

        grid.setAdapter(imageAdapter);
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



//    private AdapterView.OnItemClickListener onGridViewItemClick() {
//        Log.e("lol","1");
//        return new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent i = new Intent(getBaseContext(), DetalheActivity.class);
//                Bundle b = new Bundle();
//                b.putString("nome", "Junior");
//                i.putExtras(b);
//                startActivity(i);
//                finish();
//            }
//        };
//    }



}
