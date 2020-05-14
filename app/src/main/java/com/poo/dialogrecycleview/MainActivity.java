package com.poo.dialogrecycleview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.poo.dialogrecycleview.entity.FaceAdapter;
import com.poo.dialogrecycleview.entity.FaceEntity;
import com.poo.dialogrecycleview.entity.TextAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ExitApp.onExitAppListener, FaceAdapter.itemClickListener, TextAdapter.textListener {
    private List<FaceEntity> listData;
    private List<String> listText;

    private RecyclerView recyclerView, rvText;
    private FaceAdapter faceAdapter;
    private TextAdapter textAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.tv_back).setOnClickListener(this);
        rvText = findViewById(R.id.rv_text);
        rvText.setLayoutManager(new LinearLayoutManager(this));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouch);
        itemTouchHelper.attachToRecyclerView(rvText);
        initData();

    }

    private void initData() {
//        listData = new ArrayList<>();
////        listData.add(new FaceEntity(R.drawable.ic_tucgian, "cau vl"));
////        listData.add(new FaceEntity(R.drawable.ic_traitim, "thả tym"));
////        listData.add(new FaceEntity(R.drawable.ic_redsmile, "cuời đểu"));
////        listData.add(new FaceEntity(R.drawable.ic_khoc, "cry on my shoulder"));
////        listData.add(new FaceEntity(R.drawable.ic_cuoi, "smile"));
////        listData.add(new FaceEntity(R.drawable.ic_boss, "bosss"));
////        faceAdapter = new FaceAdapter(listData, this);
////        faceAdapter.setItemClickListener(this);
////        recyclerView.setAdapter(faceAdapter);

        listText = new ArrayList<>();
//        listText.add(new TextEntity("hey"));
//        listText.add(new TextEntity("byby"));
//        listText.add(new TextEntity("heloo"));
//        listText.add(new TextEntity("mami"));
//        listText.add(new TextEntity("noli"));
//        listText.add(new TextEntity("conwwe"));
//        listText.add(new TextEntity("ace"));
//        listText.add(new TextEntity("gold"));
//        listText.add(new TextEntity("aug"));
//        listText.add(new TextEntity("akm"));
//        listText.add(new TextEntity("swith"));

        listText.add("chào các bạn");
        listText.add("đã đến với app test demo");
        listText.add("Swipe RecycleView");
        listText.add("Của chúng tôi");
        listText.add("Mời bạn thử test tính năng");
        listText.add("xoá và khôi phục dữ liệu");
        listText.add("cảm ơn bạn đã sử dụng");
        listText.add("Tks kiu!!!!!!!!!!");
        textAdapter = new TextAdapter(listText, this);
        textAdapter.setTextListener(this);
        rvText.setAdapter(textAdapter);
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
    public void itemClick(final FaceEntity data) {
        Toast.makeText(this, data.getName(), LENGTH_SHORT).show();


    }


    @Override
    public void clickText(String data) {

    }

    String delete = null;
    ItemTouchHelper.SimpleCallback itemTouch = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            final int posision = viewHolder.getAdapterPosition();
            delete = listText.get(posision);
            listText.remove(posision);
            textAdapter.notifyDataSetChanged();
            Snackbar.make(rvText, delete, Snackbar.LENGTH_LONG).setAction("undo", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listText.add(posision, delete);
                    textAdapter.notifyDataSetChanged();
                }
            }).show();
        }


    };


}
