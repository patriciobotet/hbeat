package com.example.entregable.model;

import java.io.Serializable;



//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Disco implements Serializable {
    private Integer imagen;
    private String nombreArtista;
    private String nombreDisco;

    public Disco() {
    }

    public Disco(Integer imagen, String nombreArtista, String nombreDisco) {
        this.imagen = imagen;
        this.nombreArtista = nombreArtista;
        this.nombreDisco = nombreDisco;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public void setNombreDisco(String nombreDisco) {
        this.nombreDisco = nombreDisco;
    }
}
