package com.ryutta.monkingmobile.ui.home_transaction_cash_in;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.model.ResData;
import com.ryutta.monkingmobile.ui.home.ListTransactionAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CashInAdapter extends RecyclerView.Adapter<CashInAdapter.CashInListViewHolder> {

    List<ResData> cashInList = new ArrayList<>();

    public CashInAdapter(List<ResData> cashInList) {
        this.cashInList = cashInList;

        Log.e("ON CASH IN ADAP", "CashInAdapter: fix");
        Log.e("ON cash in list adap", "CashInAdapter: "+cashInList.get(0).getTitle());
    }

    @NonNull
    @Override
    public CashInListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cardview_transaction, parent, false);

        Log.e("CASH IN ADAPTER", "onCreateViewHolder: ");
        return new CashInListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CashInListViewHolder holder, int position) {
        ResData data = cashInList.get(position);

        Log.e("ON CASH IN ADAPTER", "onBindViewHolder: "+data.getTitle());
        int amount = data.getDebit();
        String transTitle = "Cash In";

        holder.amount.setText(Integer.toString(amount));
        holder.title.setText(transTitle);
        holder.transaction.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CashInListViewHolder extends RecyclerView.ViewHolder{
//        @BindView(R.id.tv_business_targetReached)
        TextView transaction;

//        @BindView(R.id.tv_cv_typeTransaction)
        TextView title;

//        @BindView(R.id.tv_business_reachedValue)
        TextView amount;

        public CashInListViewHolder(@NonNull View itemView) {
            super(itemView);

            transaction = itemView.findViewById(R.id.tv_business_targetReached);
            title = itemView.findViewById(R.id.tv_cv_typeTransaction);
            amount = itemView.findViewById(R.id.tv_business_reachedValue);

            ButterKnife.bind(this, itemView);
        }
    }
}
