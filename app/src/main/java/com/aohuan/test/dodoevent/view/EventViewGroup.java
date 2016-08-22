package com.aohuan.test.dodoevent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aohuan.test.dodoevent.tools.TouchEventUtil;

public class EventViewGroup extends LinearLayout{
    public EventViewGroup(Context context) {
        super(context);
    }

    public EventViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EventViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        TouchEventUtil.logActionMsg(getClass(),"onTouchEvent",ev);
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        TouchEventUtil.logActionMsg(getClass(),"dispatchTouchEvent",ev);
        return super.dispatchTouchEvent(ev);
    }

}
