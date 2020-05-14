package com.lyf.scrollflagsdemo.android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.lyf.scrollflagsdemo.R;

import java.util.List;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.ViewHolder> {
    private List<String> mNames;

    public AndroidAdapter(List<String> mNames) {
        this.mNames = mNames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.textView = view.findViewById(R.id.tvName);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(mNames.get(position));
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
