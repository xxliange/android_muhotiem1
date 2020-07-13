package com.example.muhoitem1.ui.activity.publicActivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.muhoitem1.R;

public class LooperViewPager extends ViewPager {

    private static final long DEFAULT_DURATION = 3000;
    private boolean isLoop = false;
    private long mDuration = DEFAULT_DURATION;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int currentItem = getCurrentItem();
            currentItem++;
            setCurrentItem(currentItem);
            if (isLoop) {
                postDelayed(this, mDuration);
            }

        }
    };

    public LooperViewPager(@NonNull Context context) {
        super(context);
    }

    public LooperViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray t = context.obtainStyledAttributes(attrs, R.styleable.LooperStyle);
        t.getInteger(R.styleable.LooperStyle_duration, (int) DEFAULT_DURATION);
        t.recycle();
    }

    public void startLoop() {
        isLoop = true;
        post(runnable);
    }

    /**
     * 设置切换时间
     * @param duration 时长,单位:毫秒
     */
    public void setDuration(int duration) {
        this.mDuration = duration;
    }

    public void stopLoop() {
        isLoop = false;
        removeCallbacks(runnable);
    }
}
