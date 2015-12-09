package com.utfpr.hgoncalves.minhavaga.Model;

import com.google.api.client.util.Key;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by hgoncalves on 22/10/15.
 */
public class Vaga extends SugarRecord<Vaga> {
//    public boolean OCUPADA;
//    public long latitude;
//    public long longitude;
    @Key("predictions")
    public List<Prediction> predictions;

}

class Prediction {
    @Key("description")
    public String description;

    @Key("id")
    public String id;


}


