package com.example.pertemuan5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pertemuan5.Database.DataDiri;

import java.util.ArrayList;
import java.util.List;

public class DataDiriAdapter extends RecyclerView.Adapter<DataDiriAdapter.ViewHolder> {
    private List<DataDiri> dataDiris;
    private DataDiriListener dataDiriListener;
    public Context context;

    public DataDiriAdapter(Context context, DataDiriListener listener) {
        this.context = context;
        this.dataDiriListener = listener;
    }

    public List<DataDiri> getDataDiris() {
        return dataDiris;
    }

    public void setDataDiris(List<DataDiri> dataDiris) {
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
    public void onBindViewHolder(@NonNull DataDiriAdapter.ViewHolder holder, final int position) {
        holder.tvNama.setText(getDataDiris().get(position).getName());
        // karena dari char ke string maka ditambahkan ""
        holder.tvGender.setText("" + getDataDiris().get(position).getGender());
        holder.tvAddress.setText(getDataDiris().get(position).getAddress());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataDiriListener.onButtonDelete(getDataDiris().get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getDataDiris().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama,tvGender,tvAddress;
        Button btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            btnDelete = itemView.findViewById(R.id.btnHapus);
        }
    }

}
