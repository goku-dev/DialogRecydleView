package com.poo.dialogrecycleview;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

public class ExitApp extends Dialog implements View.OnClickListener {
    private onExitListenner listenner;

    public void setOnExitListenner(onExitListenner event){
        listenner =event;
    }

    public ExitApp(@NonNull Context context) {
        super(context);
        setContentView(R.layout.view_exit_app);
        initView();
    }

    private void initView() {
        findViewById(R.id.tv_ok).setOnClickListener(this);
        findViewById(R.id.tv_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tv_cancel){
            dismiss();
        }else if(v.getId()==R.id.tv_ok){
            listenner.exitApp();
        }
    }

    public interface onExitListenner{
        void exitApp();
    }


}
