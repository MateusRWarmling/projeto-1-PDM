package com.example.avaliacao_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editUser;
    private EditText editPassword;
    private Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUser = findViewById(R.id.editUser);
        editPassword = findViewById(R.id.editPassword);
        signInButton = findViewById(R.id.signInButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String usernameString = editUser.getText().toString();
                final String passwordString = editPassword.getText().toString();

                if (usernameString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nome de usuário não pode ser vazio", Toast.LENGTH_LONG).show();
                    return;
                }

                if (passwordString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Senha não pode ser vazia", Toast.LENGTH_LONG).show();
                    return;                }

                if (
                        (usernameString.equals("Administrador") && passwordString.equals("Administrador")) ||
                        (usernameString.equals("Adm") && passwordString.equals("Adm123")) ||
                        (usernameString.equals("Administrator") && passwordString.equals("Que3B1eng4ElT0r0")) ||
                        (usernameString.equals("Root") && passwordString.equals("pr0m1uscu0"))
                ) {
                    startActivity(new Intent(MainActivity.this, MesaActivity.class));
                    return;
                }

                Toast.makeText(MainActivity.this, "Combinação de usuário e senha incorreta", Toast.LENGTH_LONG).show();
            }
        });
    }
}