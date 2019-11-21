package com.ryutta.monkingmobile.ui.sign_up;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.ryutta.monkingmobile.base.BaseActivity;
import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.ui.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity implements ISignUp{

    @BindView(R.id.et_email_sign_up)
    EditText email;

    @BindView(R.id.et_password_sign_up)
    EditText password;

    @BindView(R.id.et_re_password_sign_up)
    EditText rePassword;

    private SignUpPresenter presenter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        presenter = new SignUpPresenter(this);
    }

    @Override
    public void moveToLogin() {
        intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_sign_up)
    public void signUp(){
        String emailSignUp = email.getText().toString();
        String passwordSignUp = password.getText().toString();
        String retypePassword = rePassword.getText().toString();

        presenter.doSignUp(emailSignUp, passwordSignUp, retypePassword);
    }
}
