package com.example.jr.projetofinal_stage01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Selecionar Tipo");
        }

        final Button button = (Button) findViewById(R.id.ok);
        button.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v) {
                RadioButton top_rated = (RadioButton)findViewById(R.id.top_rated);
                RadioButton popular = (RadioButton)findViewById(R.id.popular);

                boolean check = false;
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                Bundle b = new Bundle();

                if (top_rated.isChecked() == true) {
                    b.putString("tipo", "top_rated");
                    check = true;
                }
                else if (popular.isChecked() == true){
                    b.putString("tipo", "popular");
                    check = true;
                }

                if (check == true) {
                    i.putExtras(b);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(getBaseContext(), "Selecione uma opção", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
