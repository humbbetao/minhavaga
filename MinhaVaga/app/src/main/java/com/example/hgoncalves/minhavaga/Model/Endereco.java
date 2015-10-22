package com.example.hgoncalves.minhavaga.Model;

import com.orm.SugarRecord;

/**
 * Created by hgoncalves on 22/10/15.
 */
public class Endereco extends SugarRecord<Endereco> {
    public String pais;
    public String estado;
    public String cidade;
    public String endereco;
    public int numeroDeVagas;

}
