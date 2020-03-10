package com.example.pertemuan5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pertemuan5.Database.DataDiri;

import java.util.ArrayList;

public class DataDiriAdapter extends RecyclerView.Adapter<DataDiriAdapter.ViewHolder> {
    private ArrayList<DataDiri> dataDiris;
    public Context context;

    public DataDiriAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<DataDiri> getDataDiris() {
        return dataDiris;
    }

    public void setDataDiris(ArrayList<DataDiri> dataDiris) {
        this.dataDiris = dataDiris;
    }

    @NonNull
    @Override
    public DataDiriAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data,parent,false);

        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull DataDiriAdapter.ViewHolder holder, int position) {
        holder.tvNama.setText(getDataDiris().get(position).getName());
        holder.tvGender.setText(getDataDiris().get(position).getGender());
        holder.tvAddress.setText(getDataDiris().get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return getDataDiris().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama,tvGender,tvAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvAddress = itemView.findViewById(R.id.tvAddress);
        }
    }

}
