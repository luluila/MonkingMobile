package com.ryutta.monkingmobile.ui.home_transaction_debt;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.model.ResData;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DebtListAdapter extends RecyclerView.Adapter<DebtListAdapter.DebtListViewHolder> {
    private List<ResData> listDebt = new ArrayList<>();

    @NonNull
    @Override
    public DebtListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cardview_transaction, parent, false);

        return new DebtListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DebtListViewHolder holder, int position) {
        ResData recentDebt = listDebt.get(position);

        int amount = recentDebt.getDebit();
        String transTitle = "Cash In";

        if (amount==0){
            amount = recentDebt.getDebit();
            transTitle = "Cash Out";
        }

        Log.e("SETDATA", "onBindViewHolder: "+amount);

        holder.title.setText(transTitle);
        holder.amount.setText(Integer.toString(amount));
        holder.transaction.setText(recentDebt.getTitle());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DebtListViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_business_targetReached)
        TextView transaction;

        @BindView(R.id.tv_cv_typeTransaction)
        TextView title;

        @BindView(R.id.tv_business_reachedValue)
        TextView amount;

        public DebtListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
