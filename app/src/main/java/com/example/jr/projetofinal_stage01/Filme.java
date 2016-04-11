package com.example.jr.projetofinal_stage01;

/**
 * Created by Jr on 10/04/2016.
 */
public class Filme {
    private String linkImg;
    private String sinopse;
    private String dataRelease;
    private String tituloOriginal;
    private String idioma;
    private String titulo;

    public Filme(String linkImg, String sinopse, String dataRelease, String tituloOriginal, String idioma, String titulo) {
        this.linkImg = linkImg;
        this.sinopse = sinopse;
        this.dataRelease = dataRelease;
        this.tituloOriginal = tituloOriginal;
        this.idioma = idioma;
        this.titulo = titulo;
    }

    public String toString() {
        return "Link: " + linkImg + " - Data: " + dataRelease + " Titulo Original: " + tituloOriginal + " Idioma: " + idioma + " Título: " + titulo + " Sinopse: " + sinopse;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getDataRelease() {
        return dataRelease;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdioma() {
        return idioma;
    }
}
