package com.utfpr.hgoncalves.minhavaga.Model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

/**
 * Created by hgoncalves on 22/10/15.
 */
public class Usuario extends SugarRecord<Usuario> {
    @SerializedName("nome")
    public String nome;
    @SerializedName("email")
    public String email;
    @SerializedName("senha")
    public String senha;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
