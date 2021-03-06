package com.manooz.myjobs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.manooz.jobs_search_engine_material.R;


public class StartActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button loginBtn, createBtn, skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        loginBtn = (Button) findViewById(R.id.loginA);
        createBtn = (Button) findViewById(R.id.createA);
//        skip = (Button) findViewById(R.id.skip);

//        SignInButton signInButton = findViewById(R.id.sign_in_button);
//        signInButton.setSize(SignInButton.SIZE_STANDARD);
//        signInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(StartActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });


//        skip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                skip();
//            }
//        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
            }
        });
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }



//        // Firebase Database ======================================================
//        //for auth
//        mAuth = FirebaseAuth.getInstance();
//        // for storage files
//        mStorageRef = FirebaseStorage.getInstance().getReference();
//        //for RealTime Database
//        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference("message");
//        myRef.setValue("Hello, World!");

    // Read from the database

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });


    //For Store Data in Fire Base

    //  Upload Files =========================================================================

//    Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));
//    StorageReference riversRef = storageRef.child("images/rivers.jpg");
//
//        riversRef.putFile(file).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//        @Override
//        public void onSuccess (UploadTask.TaskSnapshot taskSnapshot){
//            // Get a URL to the uploaded content
//            Uri downloadUrl = taskSnapshot.getDownloadUrl();
//        }
//    }).addOnFailureListener(new OnFailureListener() {
//        @Override
//        public void onFailure (@NonNull Exception exception){
//            // Handle unsuccessful uploads
//            // ...
//        }
//    });

    // Download Files =========================================================================

//
//        File localFile = File.createTempFile("images", "jpg");
//        riversRef.getFile(localFile)
//                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                        // Successfully downloaded data to local file
//                        // ...
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle failed download
//                // ...
//            }
//        });

//        updateUI();
//      } //On Create End

//    private void updateUI() {
//        if (mAuth.getCurrentUser() !=null){
//            Log.d("StartActivity","mAuth != null");
//
//        }else {
//            Log.d("StartActivity","mAuth == null");
//            Intent intent = new Intent();
//        }
//    }


    private void skip() {

    }

    private void login() {
        Intent intent2 = new Intent(StartActivity.this, loginActivity.class);
        startActivity(intent2);
        finish();

    }

    private void register() {
        Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

}



