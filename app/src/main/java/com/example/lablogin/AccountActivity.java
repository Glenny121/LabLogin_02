package com.example.lablogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lablogin.databinding.ActivityAccountBinding;
import com.example.lablogin.databinding.ActivityMainBinding;
import com.google.gson.Gson;

public class AccountActivity extends AppCompatActivity {
    private ActivityAccountBinding binding;
    private static String TAG = "AccountActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edtFirstName = binding.edtFirstName;
        EditText edtLastName = binding.edtLastName;
        EditText edtEmail = binding.edtEmail;
        EditText edtPhone = binding.edtPhone;
        EditText edtUsername2 = binding.edtUsername2;
        EditText edtPassword2 = binding.edtPassword2;

        Button btnOk = binding.btnOk;

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountEntity accountEntity = new AccountEntity();
                accountEntity.setFirstName(edtFirstName.getText().toString());
                accountEntity.setLastName(edtLastName.getText().toString());
                accountEntity.setEmail(edtEmail.getText().toString());
                accountEntity.setPhone(edtPhone.getText().toString());
                accountEntity.setUsername(edtUsername2.getText().toString());
                accountEntity.setPassword(edtPassword2.getText().toString());
                Gson gson = new Gson();
                String json = gson.toJson(accountEntity);
                Intent data = new Intent();

                data.putExtra("account", json);
                setResult(Activity.RESULT_OK, data);
                finish();
            }

        });
    }
}