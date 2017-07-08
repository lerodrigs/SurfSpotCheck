package com.surfspotcheck.surfspotcheck.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.surfspotcheck.surfspotcheck.R;

public class Register extends AppCompatActivity {

    EditText nome;
    EditText email;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nome = (EditText)  findViewById(R.id.txt_nome);
        email = (EditText) findViewById(R.id.txt_email);
        pass = (EditText) findViewById(R.id.txt_pass);

        Button btnRegister = (Button) findViewById(R.id.btnCadastrar);
        TextView entrar = (TextView) findViewById(R.id.ja_logado_entrar);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
