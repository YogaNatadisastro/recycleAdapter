package com.example.tugas_3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.MyViewHolder> {
    private ArrayList<User> usersList;
    private  RecyclerViewClickListener listener;

    public recycleAdapter(ArrayList<User> usersList, RecyclerViewClickListener listener){
        this.usersList = usersList;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameText;

        public  MyViewHolder(final View view) {
            super(view);
            nameText = view.findViewById(R.id.textView3);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public recycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recycleAdapter.MyViewHolder holder, int position) {
        String name = usersList.get(position).getUsername();
        holder.nameText.setText(name);
    }

    @Override
    public int getItemCount() {return usersList.size();}

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }
}
