package com.makhalibagas.sculpture.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.makhalibagas.sculpture.Model.Login.Data;
import com.makhalibagas.sculpture.Model.Login.Login;
import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.Retrofit.ApiService;
import com.makhalibagas.sculpture.Retrofit.RetroConfig;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_name,et_sekolah,et_email,et_nomor,et_password;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        preferences = getApplicationContext().getSharedPreferences("myPREF", Context.MODE_PRIVATE);
        et_name = findViewById(R.id.et_nama);
        et_sekolah = findViewById(R.id.et_sekolah);
        et_email = findViewById(R.id.et_email);
        et_nomor = findViewById(R.id.et_ponsel);
        et_password = findViewById(R.id.et_password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_daftar:
                requestRegister();
                break;
            case R.id.tv_masuk:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
        }
    }

    private void requestRegister() {
        RetroConfig.getRetrofit().create(ApiService.class).getRegister(et_name.getText().toString(),et_name.getText().toString(), et_email.getText().toString(),et_password.getText().toString(), 201).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.isSuccessful()){
                    if (Objects.requireNonNull(response.body()).getCode() == 201){


                        String sekolah = et_sekolah.getText().toString().trim();
                        int nomor = Integer.parseInt(et_nomor.getText().toString().trim());
                        Data data = new Data();
                        data.setSekolah(sekolah);

                        String fullName = response.body().getData().getFullname();
                        String email = response.body().getData().getEmail();
                        String password = response.body().getData().getPassword();
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("NAME", fullName);
                        editor.putString("EMAIL", email);
                        editor.putString("PASSWORD", password);
                        editor.putString("SEKOLAH", sekolah);
                        editor.putInt("NOMOR", nomor);
                        editor.apply();
                        Toast.makeText(SignUpActivity.this, "Register Berhasil", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }else {

                        Toast.makeText(getApplicationContext(), "Register Gagal", Toast.LENGTH_LONG).show();
                    }
                }else {

                    Toast.makeText(getApplicationContext(), "Register Gagal", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Register Gagal", Toast.LENGTH_LONG).show();
            }
        });
    }
}
