package com.taopao.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @Author：淘跑
 * @Date: 2018/12/7 15:01
 * @Use：
 */
public class MyCustomView1 extends View {
    private final String TAG = getClass().getName().toString();

    public MyCustomView1(Context context) {
        super(context);
    }

    public MyCustomView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure: ");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout: ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: ");
    }


}
