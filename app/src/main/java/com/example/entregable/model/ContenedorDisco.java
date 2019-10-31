package com.example.entregable.model;

import java.util.List;

public class ContenedorDisco {

    private List<Disco> discos;

    public ContenedorDisco(List<Disco> discos) {
        this.discos = discos;
    }

    public ContenedorDisco() {
    }

    public List<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }
}
