package com.taopao.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.NonNull;
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
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private Bitmap mBitmap;

    public MyCustomView1(Context context) {
        super(context);
        initPaint(context);
    }

    public MyCustomView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint(context);
    }

    private Context mContext;

    private void initPaint(Context context) {
        mContext = context;
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);  //设置画笔模式为填充
        mPaint.setStrokeWidth(10f);         //设置画笔宽度为10px

        mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.x);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure: ");

        int widthsize = MeasureSpec.getSize(widthMeasureSpec);      //取出宽度的确切数值
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);      //取出宽度的测量模式

        int heightsize = MeasureSpec.getSize(heightMeasureSpec);    //取出高度的确切数值
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);    //取出高度的测量模式


        Log.d(TAG, "widthsize:" + widthsize);
        Log.d(TAG, "widthmode:" + widthmode);
        Log.d(TAG, "heightsize:" + heightsize);
        Log.d(TAG, "heightmode:" + heightmode);

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
//        //绘制点
//        canvas.drawPoint(10, 20, mPaint);
//        canvas.drawPoints(new float[]{          //绘制一组点，坐标位置由float数组指定
//                500, 500,
//                500, 600,
//                500, 700
//        }, mPaint);
//
//        //绘制线
//        canvas.drawLine(300, 300, 500, 600, mPaint);    // 在坐标(300,300)(500,600)之间绘制一条直线
//        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
//                100, 200, 200, 200,
//                100, 300, 200, 300
//        }, mPaint);
//
//
//        //矩形
//        // 第一种
//        canvas.drawRect(100, 100, 800, 400, mPaint);
//        // 第二种 Rect是int(整形)的，
//        Rect rect = new Rect(100, 100, 800, 400);
//        canvas.drawRect(rect, mPaint);
//        // 第三种 而RectF是float(单精度浮点型)的
//        RectF rectF = new RectF(100, 100, 800, 400);
//        canvas.drawRect(rectF, mPaint);


        //圆角矩形
        // 第一种
//        RectF rectF1 = new RectF(100, 700, 800, 600);
////        canvas.drawRoundRect(rectF1, 30, 30, mPaint);
//        // 第二种
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            canvas.drawRoundRect(100, 100, 800, 400, 250, 250, mPaint);
//        }

//        canvas.drawCircle(500, 500, 500, mPaint);


        // 在坐标原点绘制一个黑色圆形


        // 在坐标原点绘制一个蓝色圆形
//        mPaint.setColor(Color.BLUE);
//        canvas.translate(200, 200);
//        canvas.drawCircle(0, 0, 100, mPaint);

//        mPaint.setColor(Color.BLACK);
//        canvas.translate(200, 200);
//        canvas.drawCircle(0, 0, 100, mPaint);

        // 将坐标系原点移动到画布正中心

//        mPaint.setColor(Color.BLACK);
//        mPaint.setStyle(Paint.Style.STROKE);  //设置画笔模式为填充
//
//        canvas.translate(mWidth / 2, mHeight / 2);
//
//        RectF rect = new RectF(-400, -400, 400, 400);   // 矩形区域
//
//        for (int i = 0; i <= 20; i++) {
//            canvas.scale(0.9f, 0.9f);
//            canvas.rotate(20);
//            canvas.drawRect(rect, mPaint);
//        }


//        canvas.drawBitmap(mBitmap, 200, 500, new Paint());


        canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心

        Path path = new Path();

        path.addRect(-200, -200, 200, 200, Path.Direction.CW);

        path.setLastPoint(-300, 300);                // <-- 重置最后一个点的位置

        canvas.drawPath(path, mPaint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }
}
