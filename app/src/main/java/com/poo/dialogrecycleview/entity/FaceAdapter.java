package com.poo.dialogrecycleview.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poo.dialogrecycleview.R;

import java.util.List;

public class FaceAdapter extends RecyclerView.Adapter<FaceAdapter.FaceHolder> {
    private List<FaceEntity> listData;
    private Context context;

    public FaceAdapter(List<FaceEntity> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public FaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_face, null);
        return new FaceHolder(view);
        //nhúng
    }

    @Override
    public void onBindViewHolder(@NonNull FaceHolder holder, int position) {
    FaceEntity item = listData.get(position);
    holder.ivImage.setImageResource(item.getIdImage());
    holder.tvName.setText(item.getName());
    holder.tvName.setTag(item);
    //đưa cái data vào tvName , sau khi click sẽ lấy được data

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class FaceHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName;

        public FaceHolder(@NonNull View itemView) {
            super(itemView);

            ivImage= itemView.findViewById(R.id.iv_face);
            tvName = itemView.findViewById(R.id.tv_face);
            itemView.findViewById(R.id.ln_face).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                listenner.itemClick((FaceEntity) tvName.getTag());
                }
            });
        }
    }
    private onItemListenner listenner;

    public void setOnItemListenner(onItemListenner event){
        listenner =event;
    }

    public interface onItemListenner{
        void itemClick(FaceEntity data);
    }

    //Bước 3: tạo faceAdapter extends RecycleView.Adapter<FaceAdapter.FaceHolder>
    //FaceHolder extends ViewHolder
    // khai báo list data , Context
    //khai báo số lượng thực thể của listView (getItemCount)
    //Bước 4: Nhúng Item vào holder trong method ""onCreateViewHolder
    //Bước 5:khai báo và ánh xạ các đối tượng của faceEntity vào FaceHolder
    //nhân bản các view trong onBindViewHolder
}
