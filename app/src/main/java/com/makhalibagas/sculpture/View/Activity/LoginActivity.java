package com.makhalibagas.sculpture.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.makhalibagas.sculpture.Model.Login.Login;
import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.Retrofit.ApiService;
import com.makhalibagas.sculpture.Retrofit.RetroConfig;

import org.json.JSONObject;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_email,et_password;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        preferences = getApplicationContext().getSharedPreferences("myPREF", Context.MODE_PRIVATE);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        String code = preferences.getString("TOKEN","abc");
        if (!code.equals("abc")){
            startActivity(new Intent(this, MainActivity.class));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_daftar:
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                break;
            case R.id.bt_login:
                requestLogin();
                break;
        }
    }

    private void requestLogin() {
        RetroConfig.getRetrofit().create(ApiService.class).getLogin(et_email.getText().toString(), et_password.getText().toString(), 200).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.isSuccessful()){
                    if (Objects.requireNonNull(response.body()).getCode() == 200){
                        String fullName = response.body().getData().getFullname();
                        String token = response.body().getToken();
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("TOKEN",token);
                        editor.putString("NAME", fullName);
                        editor.apply();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }else {

                        Toast.makeText(getApplicationContext(), "Email Atau Password Anda Salah", Toast.LENGTH_LONG).show();
                    }
                }else {

                    Toast.makeText(getApplicationContext(), "Email Atau Password Anda Salah", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Email Atau Password Anda Salah", Toast.LENGTH_LONG).show();
            }
        });
    }
}