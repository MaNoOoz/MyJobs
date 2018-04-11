package com.manooz.myjobs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
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
import com.google.firebase.auth.UserProfileChangeRequest;
import com.manooz.jobs_search_engine_material.R;

public class loginActivity extends AppCompatActivity {
    private Button btnLogIn;
    private TextInputLayout inputEmail, inputPass;
    private FirebaseAuth mAuth;
    private Toolbar toolbar;
    public UserProfileChangeRequest userProfileChangeRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        inputEmail = (TextInputLayout) findViewById(R.id.input_log_email);
        inputPass = (TextInputLayout) findViewById(R.id.input_log_pass);
        btnLogIn = (Button) findViewById(R.id.btn_log);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.login);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();



        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String lEmail = inputEmail.getEditText().getText().toString().trim();
                String lPass = inputPass.getEditText().getText().toString().trim();

                if (!TextUtils.isEmpty(lEmail) && !TextUtils.isEmpty(lPass)) {
                    logIn(lEmail, lPass);
                }

            }
        });

    }

    private void logIn(String email, String password) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging in, please wait...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();
                        progressDialog.setCanceledOnTouchOutside(false);

                        if (task.isSuccessful()) {
                            FirebaseUser user = task.getResult().getUser();
                             userProfileChangeRequest = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(user.getUid())
                                    .setPhotoUri(Uri.parse("https://pixabay.com/static/uploads/photo/2016/06/20/16/37/rope-1469244__340.jpg"))
                                    .build();
                            Toast.makeText(loginActivity.this, "Task is Successful You Are Login As  " +
                                    " " + "  " + user.getEmail(), Toast.LENGTH_LONG).show();


                            user.updateProfile(userProfileChangeRequest);

                            Intent mainIntent = new Intent(loginActivity.this, MainActivity.class);
                            startActivity(mainIntent);
                            finish();

                            Toast.makeText(loginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(loginActivity.this, "ERROR: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
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
        
        Intent s = new Intent(this,StartActivity.class);
        startActivity(s);

    }




}