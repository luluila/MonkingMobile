package com.ryutta.monkingmobile.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.model.ResData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListTransactionAdapter extends RecyclerView.Adapter<ListTransactionAdapter.ActivityListViewHolder> {
    private List<ResData> dataList;
    private final Context context;

    public ListTransactionAdapter(List<ResData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ActivityListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cardview_transaction, parent, false);

        return new ActivityListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityListViewHolder holder, int position) {
        ResData data = dataList.get(position);

        int amount = data.getDebit();
        String transTitle = "Cash In";

        if (amount==0){
            amount = data.getDebit();
            transTitle = "Cash Out";
        }

        Log.e("SETDATA", "onBindViewHolder: "+amount);

        holder.title.setText(transTitle);
        holder.amount.setText(Integer.toString(amount));
        holder.transaction.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {

        if (dataList == null) {
            return 0;
        }
        return dataList.size();
    }

    public class ActivityListViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_business_targetReached)
        TextView transaction;

        @BindView(R.id.tv_cv_typeTransaction)
        TextView title;

        @BindView(R.id.tv_business_reachedValue)
        TextView amount;

        public ActivityListViewHolder(@NonNull View itemView) {
            super(itemView);

            transaction = itemView.findViewById(R.id.tv_business_targetReached);
            title = itemView.findViewById(R.id.tv_cv_typeTransaction);
            amount = itemView.findViewById(R.id.tv_business_reachedValue);

            ButterKnife.bind(this, itemView);
        }
    }
}
