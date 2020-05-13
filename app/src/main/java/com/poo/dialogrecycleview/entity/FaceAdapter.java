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

public class FaceAdapter extends RecyclerView.Adapter<FaceAdapter.FaceHolder>  {
    private List<FaceEntity> listData;
    private Context context;


    public FaceAdapter(List<FaceEntity> listData, Context context) {
        this.listData = listData;
        this.context = context;
        initView();
    }

    private void initView() {

    }


    @NonNull
    @Override
    public FaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_face, null);
        return new FaceHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull FaceHolder holder, int position) {
        FaceEntity faceEntity = listData.get(position);
        holder.ivImage.setImageResource(faceEntity.getIdImage());
        holder.tvName.setText(faceEntity.getName());
        holder.tvName.setTag(faceEntity);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }



    public class FaceHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName;

        public FaceHolder(@NonNull final View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_face);
            tvName = itemView.findViewById(R.id.tv_face);
            itemView.findViewById(R.id.ln_face).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                listener.itemClick((FaceEntity) tvName.getTag());
                }
            });

        }
    }




    private itemClickListener listener;
    public void setItemClickListener(itemClickListener event){
        listener =event;
    }

    public  interface itemClickListener{
        void itemClick(FaceEntity data);
    }

}
