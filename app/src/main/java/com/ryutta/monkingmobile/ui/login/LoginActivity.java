package com.ryutta.monkingmobile.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ryutta.monkingmobile.MainActivity;
import com.ryutta.monkingmobile.R;
import com.ryutta.monkingmobile.base.BaseActivity;
import com.ryutta.monkingmobile.ui.reset_password.ResetPasswordActivity;
import com.ryutta.monkingmobile.ui.sign_up.SignUpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView{
    @BindView(R.id.et_email_login)
    EditText email;

    @BindView(R.id.et_password_sign_up)
    EditText passwordSignIn;

    @BindView(R.id.btn_sign_in)
    Button btnLogin;

    @BindView(R.id.tv_description_sign_in)
    TextView txtResetPassword;

    @BindView(R.id.tv_sign_in)
    TextView txtSignIn;

    private LoginPresenter presenter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);
    }

    @OnClick(R.id.btn_sign_in)
    public void onLoginClicked(){
        String emailLogin = email.getText().toString();
        String password = passwordSignIn.getText().toString();

        presenter.doLogin(emailLogin, password);
    }

    @Override
    public void moveIntoMain() {
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_sign_in)
    public void moveToCreateAccount() {
        intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.tv_description_sign_in})
    public void moveToReset() {
        intent = new Intent(this, ResetPasswordActivity.class);
        startActivity(intent);
    }
}
