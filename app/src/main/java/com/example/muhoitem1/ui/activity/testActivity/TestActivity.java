package com.example.muhoitem1.ui.activity.testActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseActivity;
import com.example.muhoitem1.ui.activity.mineActivity.LoginActivity;
import com.example.muhoitem1.utils.Utils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

public class TestActivity extends BaseActivity {
    @BindView(R.id.test_linearLayout)
    public LinearLayout linearLayout;
    @BindView(R.id.test_image)
    public ImageView imageView;
    @BindView(R.id.test_btn)
    public TextView btn;
    @BindView(R.id.test_closeBtn)
    public ImageView test_closeBtn;
    private int isTran = 1;
    Timer timer = new Timer();

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (isTran) {
                case 1:
                    transistionImg();
                    break;
                case 2:
                    transistionImg2();
                    break;
                case 3:
                    transistionImg3();
                    break;
                default:
                    break;

            }
        }
    };

    @Override
    protected void initEvent() {
        super.initEvent();
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
        test_closeBtn.setOnClickListener(v -> finish());
        ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(this,R.anim.login_img_scale);
        imageView.startAnimation(scaleAnimation);
    }

    private void transistionImg() {
        TransitionDrawable td = new TransitionDrawable(new Drawable[]{getResources().getDrawable(R.drawable.bg1), getResources().getDrawable(R.drawable.bg2)});
        imageView.setImageDrawable(td);
        td.startTransition(2000);
        isTran = 2;
    }

    private void transistionImg2() {
        TransitionDrawable td = new TransitionDrawable(new Drawable[]{getResources().getDrawable(R.drawable.bg2), getResources().getDrawable(R.drawable.bg3)});
        imageView.setImageDrawable(td);
        td.startTransition(2000);
        isTran = 3;
    }

    private void transistionImg3() {
        TransitionDrawable td = new TransitionDrawable(new Drawable[]{getResources().getDrawable(R.drawable.bg3), getResources().getDrawable(R.drawable.bg1)});
        imageView.setImageDrawable(td);
        td.startTransition(2000);
        isTran = 1;
    }

    @Override
    protected void initPresent() {

    }

    @Override
    protected void initView() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(test_closeBtn.getLayoutParams());
        layoutParams.setMargins(40,Utils.getStatusBarHeight(this)+20,0,0);
        test_closeBtn.setLayoutParams(layoutParams);

        setTransparentStatusBar();
        imageView.setImageResource(R.drawable.bg1);
        timerRun();
    }

    private void timerRun() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                handler.sendMessage(message);
            }
        }, 3000, 5000);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_test;
    }
}
