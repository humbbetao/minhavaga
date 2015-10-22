package com.example.hgoncalves.minhavaga.Model;

import com.orm.SugarRecord;

/**
 * Created by hgoncalves on 22/10/15.
 */
class Usuario extends SugarRecord<Usuario> {
    public String nome;
    public String email;
    public String senha;

}
