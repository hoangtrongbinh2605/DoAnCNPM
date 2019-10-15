package com.example.esport;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    TextView login_btn, register_btn, lin, sup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        findViewById(R.id.register).setOnClickListener(this);
        findViewById(R.id.lin).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        if (view.getId() == R.id.sup) {
//            setContentView(R.layout.activity_signup);
//        }
//        if (view.getId() == R.id.login) {
//            Toast.makeText(RegisterActivity.this, "Login", Toast.LENGTH_SHORT).show();
//            finish();
//        }
        if (view.getId() == R.id.lin) {
            finish();
        }
        if (view.getId() == R.id.register) {
            String mail = ((EditText) findViewById(R.id.mail)).getText().toString();
            String user = ((EditText) findViewById(R.id.usrusr)).getText().toString();
            String pass = ((EditText) findViewById(R.id.pwdpwd)).getText().toString();
            String confirm = ((EditText) findViewById(R.id.confirm)).getText().toString();
            Toast.makeText(RegisterActivity.this, mail+" "+user+" "+pass+" "+confirm, Toast.LENGTH_SHORT).show();
//            finish();
        }
    }
}
