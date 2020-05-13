package com.poo.dialogrecycleview;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;


public class ExitApp extends Dialog implements View.OnClickListener {
    private onExitAppListener listener;

    public void setOnExitAppListenner(onExitAppListener event) {
        listener = event;
    }

    public ExitApp(@NonNull Context context) {
        super(context);
        setContentView(R.layout.view_exit_app);
        initView();
    }

    private void initView() {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        findViewById(R.id.tv_ok).setOnClickListener(this);
        findViewById(R.id.tv_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      if(v.getId() == R.id.tv_cancel){
          dismiss();
      }else if(v.getId()==R.id.tv_ok){
          listener.exitApp();
      }
    }


    public interface onExitAppListener {
        void exitApp();
    }
}
