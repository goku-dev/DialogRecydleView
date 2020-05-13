package com.poo.dialogrecycleview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.poo.dialogrecycleview.entity.FaceAdapter;
import com.poo.dialogrecycleview.entity.FaceEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ExitApp.onExitAppListener, FaceAdapter.itemClickListener {
    private List<FaceEntity> listData;

    private RecyclerView recyclerView;
    private FaceAdapter faceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.tv_back).setOnClickListener(this);
        recyclerView = findViewById(R.id.rv_face);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initData();

    }

    private void initData() {
        listData = new ArrayList<>();
        listData.add(new FaceEntity(R.drawable.ic_tucgian, "cau vl"));
        listData.add(new FaceEntity(R.drawable.ic_traitim, "cau vl"));
        listData.add(new FaceEntity(R.drawable.ic_redsmile, "cau vl"));
        listData.add(new FaceEntity(R.drawable.ic_khoc, "cau vl"));
        listData.add(new FaceEntity(R.drawable.ic_cuoi, "cau vl"));
        listData.add(new FaceEntity(R.drawable.ic_boss, "cau vl"));
        faceAdapter = new FaceAdapter(listData, this);
        faceAdapter.setItemClickListener(this);
        recyclerView.setAdapter(faceAdapter);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back || v.getId() == R.id.tv_back) {
//            showConfirmDialog();
            showCustomDialog();


        }
    }

    private void showCustomDialog() {
        ExitApp exitApp = new ExitApp(this);
        exitApp.setOnExitAppListenner(this);
        exitApp.show();

    }

    private void showConfirmDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle(R.string.txt_tittle_exit);
        dialog.setMessage(getString(R.string.txt_msg_exit));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.show();
    }

    @Override
    public void exitApp() {
        finish();
    }

    @Override
    public void itemClick(FaceEntity data) {
        Toast.makeText(this, data.getName(), Toast.LENGTH_SHORT).show();
        listData.remove(data);
        faceAdapter.notifyDataSetChanged();

    }

}
