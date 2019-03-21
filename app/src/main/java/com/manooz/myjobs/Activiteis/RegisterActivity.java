package com.manooz.myjobs.Activiteis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;
import com.manooz.jobs_search_engine_material.R;

public class RegisterActivity extends AppCompatActivity {

    private Button btnReg;
    private TextInputLayout inName, inEmail, inPass;
    TextView  toLoginText ;
    private Toolbar toolbar;
//    private FirebaseAuth mAuth;
//    private DatabaseReference fUsersDatabase;
    private ProgressDialog progressDialog;
//    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        mAuth = FirebaseAuth.getInstance();
//        fUsersDatabase = FirebaseDatabase.getInstance().getReference("uploads");
//        db = FirebaseFirestore.getInstance();

        btnReg  =  findViewById(R.id.btn_reg);
        inName  =  findViewById(R.id.input_reg_name);
        inEmail =  findViewById(R.id.input_reg_email);
        inPass  =  findViewById(R.id.input_reg_pass);
        toLoginText = findViewById(R.id.toLogin);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = inName.getEditText().getText().toString().trim();
                String uemail = inEmail.getEditText().getText().toString().trim();
                String upass = inPass.getEditText().getText().toString().trim();
//                registerUser(uname, uemail, upass);
            }
        });
        toLoginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

    }

//    private void registerUser(final String name, String email, String password) {
//
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Processing your request, please wait...");
//        progressDialog.show();
//
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful() && mAuth.getCurrentUser() != null) {
//                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
//
////                        FirebaseUser user = mAuth.getInstance().getCurrentUser();
//                        Toast.makeText(getApplicationContext(), "Hi User Is Not null", Toast.LENGTH_SHORT).show();
//
//                        if (currentUser != null) {
//                            String uid = currentUser.getUid();
//                            fUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
//                            HashMap<String, String> usermap = new HashMap<>();
//                            usermap.put("name", name);
//                            usermap.put("status", name + " Hi There I Am Using This App");
//                            usermap.put("image", "default");
//                            usermap.put("image thumb", "default");
//                            fUsersDatabase.setValue(usermap);
//                            progressDialog.dismiss();
//                            Toast.makeText(RegisterActivity.this, "User Created ", Toast.LENGTH_SHORT).show();
//
//                            Intent toLogin = new Intent(getApplicationContext(), LoginActivity.class);
//                            startActivity(toLogin);
//                        }
//
////              fUsersDatabase.child(mAuth.getCurrentUser().getUid()).child("name").setValue(name)
//
////                      .addOnCompleteListener(new OnCompleteListener<Void>() {
////                          @Override
////                          public void onComplete(@NonNull Task<Void> task) {
////                              if (task.isSuccessful()){
////                                  progressDialog.dismiss();
////                                  Toast.makeText(RegisterActivity.this, "فشل التسجيل", Toast.LENGTH_SHORT).show();
////                                  Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
////                                  startActivity(mainIntent);
////                                  finish();
////                                  Toast.makeText(RegisterActivity.this, "User created!", Toast.LENGTH_SHORT).show();
////                              } else {
////                                  progressDialog.dismiss();
////                                  Toast.makeText(RegisterActivity.this, "ERROR : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
////                              }
////                          }
////                      });
//
//                    } else {
//                        progressDialog.dismiss();
//                        Toast.makeText(RegisterActivity.this, "ERROR: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }


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


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent s = new Intent(this, StartActivity.class);
        startActivity(s);

    }
}









