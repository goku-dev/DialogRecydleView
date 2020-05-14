package com.poo.dialogrecycleview.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poo.dialogrecycleview.R;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.TextHolder> {
    private List<String> listText;
    private Context context;

    public TextAdapter(List<String> listText, Context context) {
        this.listText = listText;
        this.context = context;
    }

    @NonNull
    @Override
    public TextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_text, null);
        return new TextHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull TextHolder holder, int position) {
        String textEntity = listText.get(position);
        holder.tvText.setText(textEntity);
        holder.tvText.setTag(textEntity);
    }

    @Override
    public int getItemCount() {
        return listText.size();
    }

    public class TextHolder extends RecyclerView.ViewHolder {
        TextView tvText;

        public TextHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_text);
            itemView.findViewById(R.id.ln_text).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.clickText((String) tvText.getTag());
                }
            });
        }
    }

    private textListener listener;

    public void setTextListener(textListener event) {
        listener = event;
    }

    public interface textListener {
        void clickText(String data);
    }
}
