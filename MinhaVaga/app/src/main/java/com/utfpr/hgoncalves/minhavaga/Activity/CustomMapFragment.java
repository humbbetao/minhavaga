package com.utfpr.hgoncalves.minhavaga.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by clodoaldo on 19-11-2015.
 */
public class CustomMapFragment extends SupportMapFragment{
    private View mOriginalView;
    private MapWrapperLayout mapWrapperLayout;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mOriginalView = super.onCreateView(inflater, container, savedInstanceState);

        mapWrapperLayout = new MapWrapperLayout(getActivity());
        mapWrapperLayout.addView(mOriginalView);

        return mapWrapperLayout;
    }
    public View getView() {
        return mOriginalView;
    }

    public void setOnDragListener(MapWrapperLayout.OnDragListener onDragListener) {
        mapWrapperLayout.setOnDragListener((View.OnDragListener) onDragListener);
    }
}
