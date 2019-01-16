package com.taopao.customview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;

/**
 * @Author：淘跑
 * @Date: 2019/1/15 14:45
 * @Use：
 */
public class ScaleLayoutView extends FrameLayout {
    View mShowView;
    View mHideView;
    Context mContext;

    public ScaleLayoutView(Context context) {
        super(context);
        init(context);
    }

    public ScaleLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        setForegroundGravity(Gravity.CENTER);
    }

    public void setNormalView(View showView, View hideView) {
        mShowView = showView;
        mHideView = hideView;


        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        addView(hideView, 0, layoutParams);

        addView(showView, 1, layoutParams);


        mShowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mShowView.animate().scaleX(0.5f)
                        .scaleY(0.5f)
                        .setDuration(500)
                        .setInterpolator(new AccelerateDecelerateInterpolator())
                        .start();
//                mCv.animate().alpha(0)

//                        .setDuration(800)
//                        .start();
                mHideView.animate().alpha(1)
                        .setDuration(300)
                        .start();
                mHandler.sendEmptyMessageDelayed(1, 500);
            }
        });
        mHideView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setNormalView(@LayoutRes int showViewId, @LayoutRes int hideViewId) {
        setNormalView(View.inflate(mContext, showViewId, null), View.inflate(mContext, hideViewId, null));
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            mView1.setVisibility(View.GONE);
//            mView2.setVisibility(View.VISIBLE);
//            mView1.setBackgroundResource(R.color.dialog_cancel);
//            mCv.setVisibility(View.INVISIBLE);

            mShowView.setAlpha(0);
//            mCv_loading.setVisibility(View.VISIBLE);
//            mCv_loading.setAlpha(1);
        }
    };

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


    }
}
