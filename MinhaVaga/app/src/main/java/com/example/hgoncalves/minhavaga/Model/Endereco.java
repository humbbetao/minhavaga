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

    public Endereco() {
    }

    public Endereco(String pais, String estado, String cidade, String endereco, int numeroDeVagas) {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.numeroDeVagas = numeroDeVagas;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumeroDeVagas() {
        return numeroDeVagas;
    }

    public void setNumeroDeVagas(int numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
    }
}
