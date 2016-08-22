package com.aohuan.test.dodoevent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.aohuan.test.dodoevent.tools.TouchEventUtil;


public class TouchEventChilds extends LinearLayout {

	private final Context mContext;

	public TouchEventChilds(Context context) {
		super(context);
		this.mContext = context;
	}

	public TouchEventChilds(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
//		this.setClickable(false);
//		this.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				TouchEventUtil.doClick(TouchEventChilds.class);
//			}
//		});
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		TouchEventUtil.logActionMsg(getClass(),"onInterceptTouchEvent",ev);
		return super.onInterceptTouchEvent(ev);
//		return true;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		TouchEventUtil.logActionMsg(getClass(),"dispatchTouchEvent",ev);
		return super.dispatchTouchEvent(ev);
//		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		TouchEventUtil.logActionMsg(getClass(),"onTouchEvent",ev);
		return super.onTouchEvent(ev);
	}

}
