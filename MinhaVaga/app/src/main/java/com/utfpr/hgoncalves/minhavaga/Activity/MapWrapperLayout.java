package com.utfpr.hgoncalves.minhavaga.Activity;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by clodoaldo on 19-11-2015.
 */
public class MapWrapperLayout extends FrameLayout{
    public interface OnDragListener{
        public void onDrag(MotionEvent motionEvent);
    }

    private OnDragListener mOnDragListener;

    public MapWrapperLayout(Context context) {
        super(context);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent){
        if (mOnDragListener != null) {
            mOnDragListener.onDrag(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setmOnDragListener(OnDragListener mOnDragListener){
        this.mOnDragListener=mOnDragListener;
    }

}
