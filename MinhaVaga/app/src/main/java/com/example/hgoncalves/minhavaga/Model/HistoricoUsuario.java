package com.example.hgoncalves.minhavaga.Model;

import android.content.Entity;

import com.orm.SugarRecord;

/**
 * Created by hgoncalves on 22/10/15.
 */
public class HistoricoUsuario extends SugarRecord<HistoricoUsuario> {
    public Vaga v;
    public String Data;
    public String Hora;
}
