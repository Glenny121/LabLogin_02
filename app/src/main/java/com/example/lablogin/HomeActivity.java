package com.example.lablogin;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lablogin.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("nombres")) {
            String nombres = intent.getStringExtra("nombres");
            String apellidos = intent.getStringExtra("apellidos");
            binding.textView2.setText("Bienvenido(a) " + nombres + apellidos);
        }
    }
}
