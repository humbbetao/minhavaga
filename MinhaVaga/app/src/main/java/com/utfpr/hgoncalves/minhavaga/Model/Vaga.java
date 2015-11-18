package com.utfpr.hgoncalves.minhavaga.Model;

import com.orm.SugarRecord;

/**
 * Created by hgoncalves on 22/10/15.
 */
public class Vaga extends SugarRecord<Vaga> {
    public boolean OCUPADA;
    public long latitude;
    public long longitude;

    public Vaga() {
    }

    public Vaga(boolean OCUPADA, long latitude, long longitude) {
        this.OCUPADA = OCUPADA;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public boolean isOCUPADA() {
        return OCUPADA;
    }

    public void setOCUPADA(boolean OCUPADA) {
        this.OCUPADA = OCUPADA;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }
}
