package com.ryutta.monkingmobile.ui.home_transaction_form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.model.Data;
import com.ryutta.monkingmobile.model.request.CashInRequest;

public class HomeTransactionFormActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener
, IHomeTransaction{

    Group cashInLayout;
    Group cashOutLayout;
    Group debtLayout;
    Group loanLayout;
    TextView formTitle;

//    @BindView(R.id.group_form_cash_in)
//    Group cashInLayout;
//
//    @BindView(R.id.group_form_cashOut)
//    Group cashOutLayout;
//
//    @BindView(R.id.group_form_debt)
//    Group debtLayout;
//
//    @BindView(R.id.group_form_loan)
//    Group loanLayout;

    @BindView(R.id.tv_form_formTitle)
    TextView category;

    @BindView(R.id.tv_form_cashIn_title)
    EditText title;

    @BindView(R.id.tv_form_cashIn_account)
    EditText firstAccount;

    @BindView(R.id.tv_form_cashIn_to)
    EditText secondAccount;

    @BindView(R.id.tv_form_cashIn_amount)
    EditText amount;

    @BindView(R.id.tv_form_cashIn_date)
    EditText date;

//    @BindView(R.id.btn_form_next)
    Button save;

    HomeTransactionPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_transaction_form);

        ImageButton menuButton = findViewById(R.id.ib_menu_transactionForm);
        menuButton.setOnClickListener(this);

        ImageView backButton = findViewById(R.id.iv_form_back);
        backButton.setOnClickListener(this);

        cashInLayout = findViewById(R.id.group_form_cash_in);
        cashOutLayout = findViewById(R.id.group_form_cashOut);
        debtLayout = findViewById(R.id.group_form_debt);
        loanLayout = findViewById(R.id.group_form_loan);

        formTitle = findViewById(R.id.tv_form_formTitle);

        ButterKnife.bind(this);
        presenter = new HomeTransactionPresenter(this,
                HomeTransactionFormActivity.this);

        title = (EditText) findViewById(R.id.tv_form_cashIn_title);
        date = (EditText) findViewById(R.id.tv_form_cashIn_date);
        amount = (EditText) findViewById(R.id.tv_form_cashIn_amount);
        category = (TextView) findViewById(R.id.tv_form_formTitle);
        firstAccount = (EditText) findViewById(R.id.tv_form_cashIn_account);
        secondAccount = (EditText)  findViewById(R.id.tv_form_cashIn_to);
        save = (Button) findViewById(R.id.btn_form_next);

        save.setOnClickListener(btnListener);
    }

    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            addCashIn();
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_menu_transactionForm:
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.inflate(R.menu.transaction_form_menu);
                popupMenu.show();
                break;
            case R.id.iv_form_back:
                onBackPressed();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.transaction_form_cash_in:
                formTitle.setText("CASH IN");
                cashInLayout.setVisibility(View.VISIBLE);
                cashOutLayout.setVisibility(View.GONE);
                debtLayout.setVisibility(View.GONE);
                loanLayout.setVisibility(View.GONE);
                addCashIn();

                return true;
            case R.id.transaction_form_cash_out:
                formTitle.setText("CASH OUT");
                cashInLayout.setVisibility(View.GONE);
                cashOutLayout.setVisibility(View.VISIBLE);
                debtLayout.setVisibility(View.GONE);
                loanLayout.setVisibility(View.GONE);

                return true;
            case R.id.transaction_form_debt:
                formTitle.setText("DEBT");
                cashInLayout.setVisibility(View.GONE);
                cashOutLayout.setVisibility(View.GONE);
                debtLayout.setVisibility(View.VISIBLE);
                loanLayout.setVisibility(View.GONE);

                return true;
            case R.id.transaction_form_loan:
                formTitle.setText("LOAN");
                cashInLayout.setVisibility(View.GONE);
                cashOutLayout.setVisibility(View.GONE);
                debtLayout.setVisibility(View.GONE);
                loanLayout.setVisibility(View.VISIBLE);

                return true;
            default:
                return false;
        }
    }

    @OnClick(R.id.btn_form_next)
    void addCashIn(){
        CashInRequest data = new CashInRequest();

        category.setText("Cash In");
        String title = this.title.getText().toString();
        int firstAccount = Integer.parseInt(this.firstAccount.getText().toString());
        int secondAccount = Integer.parseInt(this.secondAccount.getText().toString());
        int amount = Integer.parseInt(this.amount.getText().toString());
        String date = this.date.getText().toString();

        Log.d("ON CASH IN FIELD", "addCashIn: "+date);

//        String title = "CUMAN CASH IN";
//        String firstAccount = "13";
//        String secondAccount = "7";
//        String amount = "200,000";
//        String date = "2019-12-02";

        data.setDate(date);
        data.setAmount(amount);
        data.setFirstAccount(firstAccount);
        data.setSecondAccount(secondAccount);
        data.setTitle(title);

        presenter.addCashIn(data);

    }

}
