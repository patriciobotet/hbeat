package com.example.entregable.controller;

import com.example.entregable.dao.ProvedorDeDisco;
import com.example.entregable.dao.ProvedorDeDiscosDeInternet;
import com.example.entregable.model.Disco;

import java.util.List;

public class DiscoController {

    private ProvedorDeDisco provedorDeDisco;
    private ProvedorDeDiscosDeInternet provedorDeDiscosDeInternet;

    public DiscoController() {
        this.provedorDeDisco = new ProvedorDeDisco();
        this.provedorDeDiscosDeInternet = new ProvedorDeDiscosDeInternet();
    }

    public List<Disco> getCeldas(){
        if (hayInternet()){
            return provedorDeDiscosDeInternet.getCeldaInternet();
        }else{
            return provedorDeDisco.getCeldas();
        }
    }

    public Boolean hayInternet(){
        return false;
    }
}
