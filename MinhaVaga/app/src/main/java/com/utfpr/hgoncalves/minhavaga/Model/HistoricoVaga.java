package com.utfpr.hgoncalves.minhavaga.Model;

import com.orm.SugarRecord;

/**
 * Created by hgoncalves on 22/10/15.
 */
public class HistoricoVaga extends SugarRecord<HistoricoVaga> {
    public Usuario u;
    public String Data;
    public String Hora;
}
