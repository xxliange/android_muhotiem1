package com.example.muhoitem1.ui.activity.publicActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.muhoitem1.R;

import org.w3c.dom.Text;

import butterknife.BindView;

public class DialogActivity extends Dialog{

    @BindView(R.id.dialog_title)
    public TextView titleTv;
    @BindView(R.id.dialog_message)
    public TextView messageTv;
    @BindView(R.id.dialog_cancle)
    public TextView cancleBtn;
    @BindView(R.id.dialog_ok)
    public TextView okBtn;

    private  Context context;

    //内容数据
    private String title;
    private String message;

    public DialogActivity(@NonNull Context context) {
        super(context, R.style.Dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_dialog);
        setCanceledOnTouchOutside(false);
        //初始化界面控件
        initView();
        //初始化界面数据
        refreshView();
        //初始化界面控件的事件
        initEvent();
    }

    private void initEvent() {
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickBottomListener!=null) {
                    onClickBottomListener.onOK();
                }
            }
        });
        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickBottomListener!=null) {
                    onClickBottomListener.onCancle();
                }
            }
        });
    }

    private void refreshView() {
        if (!TextUtils.isEmpty(title)) {
            titleTv.setText(title);
            titleTv.setVisibility(View.VISIBLE);
        }else{
            titleTv.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(message)) {
            messageTv.setText(message);
            messageTv.setVisibility(View.VISIBLE);
        }else{
            messageTv.setVisibility(View.GONE);
        }

    }

    @Override
    public void show() {
        super.show();
        refreshView();
    }

    private void initView() {
    }

    //设置确定取消按钮的回调
    public OnClickBottomListener onClickBottomListener;
    public DialogActivity setOnClickBottomListener(OnClickBottomListener onClickBottomListener){
        this.onClickBottomListener = onClickBottomListener;
        return this;
    }
    public interface OnClickBottomListener{
        public void onOK();
        public void onCancle();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
