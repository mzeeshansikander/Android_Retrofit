package com.example.zeeshan.myapplication;

import com.example.zeeshan.myapplication.ResObj;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class LoginActivity extends Activity {

    String name, password;
    ResObj resObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText et_name = findViewById(R.id.et_username);
        final EditText et_pass = findViewById(R.id.et_password);
        et_name.setText("zeeshan");
        et_pass.setText("123");
        Button btn_login = findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et_name.getText().toString();
                password = et_pass.getText().toString();

                loginUser();

            }
        });


    }

    private void loginUser() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Log.e("TAG", name + " " + password);
        try {
            Call<String> call = api.login(name,password);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    String res = response.body();


                    startActivity(new android.content.Intent(LoginActivity.this,MainActivity.class));


                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                    Log.e("TAG", t.getMessage());

                }
            });
        }catch(Exception e){
            Log.e("TAG",e.toString());
        }


    }
}