package br.ulbra.applogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity {
    EditText edNome, edUser, edPass1, edPass2;
    Button btnSalvar;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        db = new DBHelper(this);
        edNome = (EditText)findViewById(R.id.edNome);
        edUser = (EditText)findViewById(R.id.edUser);
        edPass1 = (EditText)findViewById(R.id.edPass1);
        edPass2 = (EditText)findViewById(R.id.edPass2);
        btnSalvar = (Button)findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edUser.getText().toString();
                String pas1 = edPass1.getText().toString();
                String pas2 = edPass2.getText().toString();
                if (userName.equals("")) {
                    Toast.makeText(RegistrarActivity.this, "Insira o LOGIN DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (pas1.equals("") || pas2.equals("")){
                    Toast.makeText(RegistrarActivity.this, "Insira a SENHA DO USUÁRIO", Toast.LENGTH_SHORT).show();
                }else if(!pas1.equals(pas2)){
                    Toast.makeText(RegistrarActivity.this,"As senhas não correspondem ao login do usuário", Toast.LENGTH_SHORT).show();
                }else{
                    long res = db.criarUtilizador(userName,pas1);
                    if(res>0){
//nesta parte você poderá chamar a tela principal do sistema autenticado
                        Toast.makeText(RegistrarActivity.this, "Resgistro OK", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegistrarActivity.this, "Senha inválida!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
