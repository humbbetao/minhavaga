package com.example.hgoncalves.minhavaga.Model;

import android.graphics.Bitmap;

import com.orm.SugarRecord;

/**
 * Created by hgoncalves on 22/10/15.
 */
class Usuario extends SugarRecord<Usuario> {
    public String nome;
    public String email;
//    public String senha;
    public byte[] picture;
    public Bitmap pictureBitmap;
    public String id;
//    public String name;;
//
    public Usuario() {
    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
//        this.senha = senha;
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

//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }
}
