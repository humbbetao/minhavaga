package com.utfpr.hgoncalves.minhavaga.Activity;

import com.google.android.gms.maps.model.LatLng;

import java.util.Collection;

/**
 * A collection of ClusterItems that are nearby each other.
 */
public interface Cluster<T extends ClusterItem> {
    public LatLng getPosition();

    Collection<T> getItems();

    int getSize();
}