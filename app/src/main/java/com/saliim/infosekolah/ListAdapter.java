package com.saliim.infosekolah;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by saliim on 10/9/18.
 */

class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    Context context;
    List<DataLokasiItem>dataLokasi;

    public ListAdapter(Context context, List<DataLokasiItem> dataLokasiItem){
        this.context = context;
        this.dataLokasi = dataLokasiItem;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.nama.setText(""+ dataLokasi.get(position).getNamelocation());
        holder.latitude1.setText("Latitude    : " + dataLokasi.get(position).getLatitude());
        holder.longitude1.setText("Longitude : " + dataLokasi.get(position).getLongitude());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirim = new Intent(context, DetailActivity.class);
                kirim.putExtra("nama", dataLokasi.get(position).getNamelocation());
                kirim.putExtra("lat", dataLokasi.get(position).getLatitude());
                kirim.putExtra("lon", dataLokasi.get(position).getLongitude());
                context.startActivity(kirim);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataLokasi.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama, latitude1, longitude1;
        public MyViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama_lokasi);
            latitude1 = itemView.findViewById(R.id.letak_latitude);
            longitude1 = itemView.findViewById(R.id.letak_longitude);
        }
    }
}
