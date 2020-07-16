package com.example.androidmvcroom.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidmvcroom.R;
import com.example.androidmvcroom.Model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<User> userList;
    public UserAdapter(List<User> userList) {
        this.userList=userList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_adapter_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.itemTextViewName);
            textViewNumber=itemView.findViewById(R.id.itemTextViewNumber);
        }

        public void bind(int position) {
            textViewName.setText("Name: "+userList.get(position).getName());
            textViewNumber.setText("No: "+userList.get(position).getUserNo());
        }
    }
}
