package com.ryutta.monkingmobile.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.model.Data;
import com.ryutta.monkingmobile.model.ResData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private List<ResData> dataList;

    public HomeAdapter(List<ResData> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cardview_transaction, parent, false);

        return new HomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        ResData data = dataList.get(position);

        int amount = data.getCredit();
        String transTitle = "Cash In";

        if (amount==0){
            amount = data.getDebit();
            transTitle = "Cash Out";
        }

        holder.title.setText(transTitle);
        holder.amount.setText(amount);
        holder.transaction.setText(data.getTitle());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_business_targetReached)
        TextView transaction;

        @BindView(R.id.tv_cv_typeTransaction)
        TextView title;

        @BindView(R.id.tv_business_reachedValue)
        TextView amount;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
