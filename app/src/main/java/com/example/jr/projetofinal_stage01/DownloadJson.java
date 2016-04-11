package com.example.jr.projetofinal_stage01;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jr on 10/04/2016.
 */
public class DownloadJson extends AsyncTask<String, Void, List<Filme>> {
    private final String LOG_TAG = DownloadJson.class.getSimpleName();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override

    protected List<Filme> doInBackground(String... params) {

        HttpURLConnection urlConnection = null;
        BufferedReader leitor = null;
        String json = null;

        try {
            URL url = new URL("https://api.themoviedb.org/3/movie/popular?api_key=79919b501a3624188f03afd85f62db76");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            if (inputStream == null) {
                return null;
            }

            leitor = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = leitor.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }
            json = buffer.toString();

            return getJson(json);

        } catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (leitor != null) {
                try {
                    leitor.close();
                } catch (final IOException e) {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }
        return null;
    }


    protected void onPostExecute(List<Filme> result) {
        super.onPostExecute(result);
    }


    private List<Filme> getJson(String jsonStr) throws JSONException {
        JSONObject json = new JSONObject(jsonStr);
        JSONArray jsonArray = json.getJSONArray("results");

        List<Filme> listFilmes = new ArrayList<Filme>();
        Filme filme;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject f = jsonArray.getJSONObject(i);
            filme = new Filme("http://image.tmdb.org/t/p/w300" + f.getString("poster_path"), f.getString("overview"), f.getString("release_date"), f.getString("original_title"), f.getString("original_language"), f.getString("title"));
            listFilmes.add(filme);
           // Log.e("lol", filme.toString());
        }
        return listFilmes;
    }
}
