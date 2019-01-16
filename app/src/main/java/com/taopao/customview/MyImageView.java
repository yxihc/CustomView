package com.taopao.customview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author：淘跑
 * @Date: 2019/1/14 09:02
 * @Use：
 */
public class MyImageView extends View {
    private int mWidth;
    private int mHeight;
    private Context mContext;
    private Bitmap mFengBitmap;
    private Paint mPaint;
    private int mFengBitmapWidth;
    private int mFengBitmapHeight;

    public MyImageView(Context context) {
        super(context);
        init(context);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    private void init(Context context) {
        mContext = context;
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);


        initBitmap();
    }

    private void initBitmap() {
        mFengBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.fengshan);
        mFengBitmapWidth = mFengBitmap.getWidth();
        mFengBitmapHeight = mFengBitmap.getHeight();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mWidth / 2, mWidth / 2, mFengBitmapWidth / 2 + 5, mPaint);
//        canvas.drawBitmap(mFengBitmap, mWidth / 2 - mFengBitmapWidth / 2, mWidth / 2 - mFengBitmapWidth / 2, mPaint);


        Matrix matrix = new Matrix();

        matrix.postRotate(360, 10, 20);

        canvas.drawBitmap(mFengBitmap, matrix, mPaint);
//        canvas.restore();


        ObjectAnimator alpha = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0f);

        alpha.setDuration(3000);
        alpha.start();


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

}
