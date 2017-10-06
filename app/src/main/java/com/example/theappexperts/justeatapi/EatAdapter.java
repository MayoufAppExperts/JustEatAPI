package com.example.theappexperts.justeatapi;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.theappexperts.justeatapi.model.EatModel;

import java.util.List;

/**
 * Created by TheAppExperts on 04/10/2017.
 */

class EatAdapter extends RecyclerView.Adapter <EatAdapter.EatViewHolder> {

    EatModel eatModels;
    int row;
    Context context;

    public EatAdapter(EatModel eatModels, int row, Context context) {
        this.eatModels = eatModels;
        this.row=row;
        this.context=context;
    }

    @Override
    public EatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(row, parent, false);
        return new EatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EatViewHolder holder, int position) {
        holder.tvName.setText(eatModels.getRestaurants().get(position).getName());

    }

    @Override
    public int getItemCount() {
        return eatModels.getRestaurants().size();
    }

    public class EatViewHolder  extends RecyclerView.ViewHolder{

        TextView tvName;

        public EatViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView)itemView.findViewById(R.id.eatName);
        }
    }
}
