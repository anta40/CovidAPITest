package com.anta40.app.covidapitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter<AdapterData.RecyclerHolder> {

    private Context context;
    public ArrayList<ModelData> dataArrayList;

    public AdapterData(Context context, ArrayList<ModelData> dataArrayList) {
        this.context = context;
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_stat, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {

        ModelData modelData = dataArrayList.get(position);

        String Country = modelData.getCountry();
        String TotalConfirmed = modelData.getTotalConfirmed();
        String NewConfirmed = modelData.getNewConfirmed();
        String TotalDeaths = modelData.getTotalDeaths();
        String NewDeaths = modelData.getNewDeaths();
        String TotalRecovered = modelData.getTotalRecovered();
        String NewRecovered = modelData.getNewRecovered();

        System.out.println("Country: "+Country);
        System.out.println("Total confirmed: "+TotalConfirmed);

        holder.negara.setText(Country);
        holder.totalpositif.setText(TotalConfirmed);
        holder.positifbaru.setText(NewConfirmed);
        holder.totalmati.setText(TotalDeaths);
        holder.matihariini.setText(NewDeaths);
        holder.totalsembuh.setText(TotalRecovered);
        holder.sembuhhariini.setText(NewRecovered);


    }

    @Override
    public int getItemCount() {
        if (dataArrayList == null) return 0;
        else {
            return dataArrayList.size();
        }
    }


    class RecyclerHolder extends RecyclerView.ViewHolder {

        TextView negara, totalpositif, positifbaru, totalmati, matihariini, totalsembuh, sembuhhariini;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            negara = itemView.findViewById(R.id.negara);
            totalpositif = itemView.findViewById(R.id.totalpositif);
            positifbaru = itemView.findViewById(R.id.positifbaru);
            totalmati = itemView.findViewById(R.id.totalmati);
            matihariini = itemView.findViewById(R.id.matihariini);
            totalsembuh = itemView.findViewById(R.id.totalsembuh);
            sembuhhariini = itemView.findViewById(R.id.sembuhhariini);

        }
    }
}
