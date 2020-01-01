package com.ryutta.monkingmobile.ui.home_transaction_cash_out;

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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CashOutListAdapter extends RecyclerView.Adapter<CashOutListAdapter.CashOutListViewHolder> {
    private List<ResData> cashOutList = new ArrayList<>();

    public CashOutListAdapter(List<ResData> cashOutList) {
        this.cashOutList = cashOutList;
    }

    @NonNull
    @Override
    public CashOutListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cardview_transaction, parent, false);

        return new CashOutListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CashOutListViewHolder holder, int position) {
        ResData currentCashOut = cashOutList.get(position);

        String title = "Cash Out";
        if (currentCashOut.getDebit()==0){
            holder.amount.setText(Integer.toString(currentCashOut.getCredit()));
        }
        else {
            holder.amount.setText(Integer.toString(currentCashOut.getDebit()));
        }

        Log.e("ON CASH OUT LIST", "onBindViewHolder: "+currentCashOut.getTitle() );
        holder.title.setText(title);
        holder.transaction.setText(currentCashOut.getTitle());

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class CashOutListViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_business_targetReached)
        TextView transaction;

        @BindView(R.id.tv_cv_typeTransaction)
        TextView title;

        @BindView(R.id.tv_business_reachedValue)
        TextView amount;
        public CashOutListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
