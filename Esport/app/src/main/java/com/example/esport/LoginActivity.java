package com.example.esport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView login_btn, register_btn, lin, sup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.sup).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sup) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.login) {
            String user = ((EditText) findViewById(R.id.usrusr)).getText().toString();
            String pass = ((EditText) findViewById(R.id.pwdpwd)).getText().toString();
            String mail = "abcd@gmail.com";
            String role = "";
            if (user.equals("admin"))
                role = "admin";
            else
                role = "user";
            Intent intent = new Intent();
            intent.putExtra("Name", user);
            intent.putExtra("Email", mail);
            intent.putExtra("Role", role);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
//        if (view.getId() == R.id.lin) {
//            setContentView(R.layout.activity_login);
//        }
//        if (view.getId() == R.id.register) {
//            Toast.makeText(LoginActivity.this, "Register", Toast.LENGTH_SHORT).show();
//            finish();
//        }
    }
}
