package com.aohuan.test.disallowintercept.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;


/**
 * Created by Administrator on 2016/8/28.
 */
public class MyWebView extends WebView{
    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        doSth3(ev);
//        return super.onInterceptTouchEvent(ev);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        doSth3(ev);
        return super.onTouchEvent(ev);
    }

    void doSth0(MotionEvent ev){}

    void doSth1(MotionEvent ev){
        this.requestDisallowInterceptTouchEvent(true);
    }

    void doSth2(MotionEvent ev){
        boolean isEnd = (getContentHeight()*getScale() - getHeight()-getScrollY() == 0);
        this.requestDisallowInterceptTouchEvent(!isEnd);
    }

    int moveOldY;
    int moveOldX;

    MovingBean oldBean;

    MovingBean getMovingBean(MotionEvent ev){
        if(oldBean == null){
            oldBean = new MovingBean(ev.getX(), ev.getY(), false, false, false);
            return oldBean;
        }

        MovingBean returnBean = oldBean;

        if(returnBean.getPositionY() - ev.getY() == 0){
            returnBean.setMoving(false);
        }else if(ev.getY() - returnBean.getPositionY() > 0){
            returnBean.setMoving(true);
            returnBean.setToUp(false);
        }else{
            returnBean.setMoving(true);
            returnBean.setToUp(true);
        }

        if(returnBean.getPositionX() - ev.getX() == 0){
            //这里，前面判断过是否Moving， 如果为false， 还是false， 前面如果true， 还是true， 所以不用判断
            returnBean.setToRight(false);      //
        }else if(returnBean.getPositionY() - ev.getY() > 0){
            if(!returnBean.isMoving){
                returnBean.setMoving(true);
            }
            returnBean.setToRight(false);
        }else{
            if(!returnBean.isMoving){
                returnBean.setMoving(true);
            }
            returnBean.setToRight(true);
        }
        oldBean = returnBean;
        oldBean.setPositionX(ev.getX());
        oldBean.setPositionY(ev.getY());
        return returnBean;
    }

    void doSth3(MotionEvent ev){
        MovingBean movingBean = getMovingBean(ev);
        doSth31(movingBean, ev);
    }

    void doSth31(MovingBean movingBean, MotionEvent ev){
        if(movingBean == null || ev == null){
            return;
        }
//        if(!movingBean.isMoving){
//            return;
//        }
        if(!movingBean.isToUp()){
            boolean isStart = (getScrollY() == 0);
            this.requestDisallowInterceptTouchEvent(!isStart);
        }else{
            boolean isEnd = (getContentHeight()*getScale() - getHeight() - getScrollY() == 0);
            this.requestDisallowInterceptTouchEvent(!isEnd);
        }

    }





    class MovingBean {
        float positionX;
        float positionY;
        boolean isToUp;
        boolean isToRight;
        boolean isMoving;

        public MovingBean() {
        }

        public MovingBean(float positionX, float positionY, boolean isToUp, boolean isToRight, boolean isMoving) {
            this.positionX = positionX;
            this.positionY = positionY;
            this.isToUp = isToUp;
            this.isToRight = isToRight;
            this.isMoving = isMoving;
        }

        public float getPositionX() {
            return positionX;
        }

        public void setPositionX(float positionX) {
            this.positionX = positionX;
        }

        public float getPositionY() {
            return positionY;
        }

        public void setPositionY(float positionY) {
            this.positionY = positionY;
        }

        public boolean isToUp() {
            return isToUp;
        }

        public void setToUp(boolean toUp) {
            isToUp = toUp;
        }

        public boolean isMoving() {
            return isMoving;
        }

        public void setMoving(boolean moving) {
            isMoving = moving;
        }

        public boolean isToRight() {
            return isToRight;
        }

        public void setToRight(boolean toRight) {
            isToRight = toRight;
        }
    }

}
