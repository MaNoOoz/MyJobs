package com.manooz.myjobs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.manooz.jobs_search_engine_material.R;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private Button btnReg;
    private TextInputLayout inName, inEmail, inPass;
    private Toolbar toolbar;
    private FirebaseAuth mAuth;
    private DatabaseReference fUsersDatabase;
    FirebaseUser user;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.createacount);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnReg = (Button) findViewById(R.id.btn_reg);
        inName = (TextInputLayout) findViewById(R.id.input_reg_name);
        inEmail = (TextInputLayout) findViewById(R.id.input_reg_email);
        inPass = (TextInputLayout) findViewById(R.id.input_reg_pass);

        mAuth = FirebaseAuth.getInstance();
            btnReg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String uname = inName.getEditText().getText().toString().trim();
                    String uemail = inEmail.getEditText().getText().toString().trim();
                    String upass = inPass.getEditText().getText().toString().trim();
                    registerUser(uname, uemail, upass);
                }
            });
    } //finish onCreate



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void registerUser(final String name, String email, String password){

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Processing your request, please wait...");

        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)

          .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {

          if (task.isSuccessful()){

//              user = FirebaseAuth.getInstance().getCurrentUser(); Tested
              FirebaseUser user = mAuth.getInstance().getCurrentUser();

              if (user !=null) {
                  String uid = user.getUid();
                  fUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);

                  HashMap<String, String> usermap = new HashMap<>();
                  usermap.put("name", name);
                  usermap.put("status", name + " Hi There I Am Using This App");
                  usermap.put("image", "default");
                  usermap.put("image thumb", "default");
                  fUsersDatabase.setValue(usermap);
                  progressDialog.dismiss();
                  Toast.makeText(RegisterActivity.this, "User Created ", Toast.LENGTH_SHORT).show();

                  Intent toLogin = new Intent(getApplicationContext(), loginActivity.class);
                  startActivity(toLogin);
              }

//              fUsersDatabase.child(mAuth.getCurrentUser().getUid()).child("name").setValue(name)

//                      .addOnCompleteListener(new OnCompleteListener<Void>() {
//                          @Override
//                          public void onComplete(@NonNull Task<Void> task) {
//                              if (task.isSuccessful()){
//                                  progressDialog.dismiss();
//                                  Toast.makeText(RegisterActivity.this, "فشل التسجيل", Toast.LENGTH_SHORT).show();
//                                  Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
//                                  startActivity(mainIntent);
//                                  finish();
//                                  Toast.makeText(RegisterActivity.this, "User created!", Toast.LENGTH_SHORT).show();
//                              } else {
//                                  progressDialog.dismiss();
//                                  Toast.makeText(RegisterActivity.this, "ERROR : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                              }
//                          }
//                      });

                  } else {
                      progressDialog.dismiss();
                      Toast.makeText(RegisterActivity.this, "ERROR: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                  }
              }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent s = new Intent(this,StartActivity.class);
        startActivity(s);

    }
}
