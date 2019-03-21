package com.manooz.myjobs.Activiteis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;
import com.manooz.jobs_search_engine_material.R;

public class LoginActivity extends AppCompatActivity {

//    public UserProfileChangeRequest userProfileChangeRequest;
    private Button btnLogIn;
    private TextInputLayout inputEmail, inputPass;
//    private FirebaseAuth mAuth;
    private Toolbar toolbar;
    private LinearLayout toRigsterText;
    private TextView forgetPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        inputEmail = (TextInputLayout) findViewById(R.id.input_log_email);
        inputPass = (TextInputLayout) findViewById(R.id.input_log_pass);
        btnLogIn = (Button) findViewById(R.id.btn_log);
        toRigsterText = findViewById(R.id.toRigsterText);
        forgetPass = findViewById(R.id.forgot_password);

        setSupportActionBar(toolbar);


//        mAuth = FirebaseAuth.getInstance();


        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String lEmail = inputEmail.getEditText().getText().toString().trim();
                String lPass = inputPass.getEditText().getText().toString().trim();
                if (lEmail.isEmpty()) {
                    inputEmail.getEditText().setError("Email Is Required");
                    inputEmail.getEditText().requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(lEmail).matches()) {
                    inputEmail.getEditText().setError("Please Enter a valid Email");
                    inputEmail.getEditText().requestFocus();

                }
                if (lPass.isEmpty()) {
                    inputPass.getEditText().setError("Password  Is Required");
                    inputPass.getEditText().requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(lEmail).matches()) {
                    inputPass.getEditText().setError("Please Enter at least 6 char");
                    inputPass.getEditText().requestFocus();

                }
                if (!TextUtils.isEmpty(lEmail) && !TextUtils.isEmpty(lPass)) {
                    logIn(lEmail, lPass);
                }

            }
        });
        toRigsterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 12/7/2018
//                AlertDialog alertDialog =

            }
        });

    }

    private void logIn(String email, String password) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging in, please wait...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        Toast.makeText(this, "Email : " + email + "Pass : " +password, Toast.LENGTH_SHORT).show();


// TODO: 3/20/2019 Check moraqeb auth

//        FirebaseAuth auth = FirebaseAuth.getInstance();
//        if (Task.isSuccessful()) {
//            FirebaseUser user = task.getResult().getUser();
//            userProfileChangeRequest = new UserProfileChangeRequest.Builder()
//                    .setDisplayName(user.getUid())
//                    .setPhotoUri(Uri.parse("https://pixabay.com/static/uploads/photo/2016/06/20/16/37/rope-1469244__340.jpg"))
//                    .build();
//            Toast.makeText(LoginActivity.this, "Task is Successful You Are Login As  " +
//                    " " + "  " + user.getEmail(), Toast.LENGTH_LONG).show();
//
//
//        }
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
        finish();

//        Intent s = new Intent(this, StartActivity.class);
//        startActivity(s);

    }


}
