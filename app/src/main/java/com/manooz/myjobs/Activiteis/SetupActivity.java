package com.manooz.myjobs.Activiteis;


import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.manooz.jobs_search_engine_material.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class SetupActivity extends AppCompatActivity {

    private CircleImageView setupImage;
    private ImageButton changeImage;
    private Uri mainImageURI = null;
    private boolean isChanged = false;
    private EditText setupName;
    private Button save_user_setting;
    private ProgressBar setupProgress;
//    private StorageReference storageReference;
//    private FirebaseFirestore firebaseFirestore;
    private Bitmap compressedImageFile;
    private TextView usernameDispaly;
    private RecyclerView allPhotos;
    private String uid;

//    private FirebaseUser currentUser;
    private String current_user_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);


//        current_user_id = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();

        setupImage = findViewById(R.id.setup_image);


    }



//
//        Toolbar setupToolbar = findViewById(R.id.setupToolbar);
//        setSupportActionBar(setupToolbar);
//        getSupportActionBar().setTitle("Account Setup");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
//            //Go to login
//            Toast.makeText(this, " Please Sign In", Toast.LENGTH_SHORT).show();
//        }
//
//        else{
//
//            uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        }
//
//        firebaseFirestore = FirebaseFirestore.getInstance();
//        storageReference = FirebaseStorage.getInstance().getReference();
//
//        // views ===================================================
//        usernameDispaly = findViewById(R.id.userNameDisplay);
//        allPhotos = findViewById(R.id.mRv_all);
//        setupImage = findViewById(R.id.setup_image);
//        changeImage = findViewById(R.id.changeimage);
//        setupName = findViewById(R.id.setup_name);
//        save_user_setting = findViewById(R.id.save_setting_btn);
//        setupProgress = findViewById(R.id.setup_progress);
//        //  ===================================================
//
//
//        setupProgress.setVisibility(View.VISIBLE);
//        save_user_setting.setEnabled(false);
//
//        // Get User Info From Firestore
//        firebaseFirestore.collection("User").document(uid).get().addOnCompleteListener(task -> {
//            if(task.isSuccessful()){
//                if(Objects.requireNonNull(task.getResult()).exists()){
//                    String name = task.getResult().getString("name");
//                    String image = task.getResult().getString("image");
//
//                    mainImageURI = Uri.parse(image);
//                    setupName.setText(name);
//                    usernameDispaly.setText(name);
//                    Picasso.with(this).load(image).into(setupImage);
//
////                    GlideApp
////                                .with(SetupActivity.this)
////                                .load(image)
////                                .centerCrop()
////                                .placeholder(R.drawable.ghost)
////                                .into(setupImage);
//
//                }
//
//            } else {
//
//                String error = Objects.requireNonNull(task.getException()).getMessage();
//                Toast.makeText(SetupActivity.this, "(FIRESTORE Retrieve Error) : " + error, Toast.LENGTH_LONG).show();
//
//            }
//
//            setupProgress.setVisibility(View.INVISIBLE);
//            save_user_setting.setEnabled(true);
//
//        });
//
//
//
//        save_user_setting.setOnClickListener(v -> {
//            final String user_name = setupName.getText().toString();
//            if (!TextUtils.isEmpty(user_name) && mainImageURI != null) {
//                setupProgress.setVisibility(View.VISIBLE);
//                if (isChanged) {
//
//                    FirebaseAuth.getInstance().getCurrentUser().getUid();
//
//                    File newImageFile = new File(mainImageURI.getPath());
//
//                    try {
//                        compressedImageFile = new Compressor(SetupActivity.this)
//                                .setMaxHeight(125)
//                                .setMaxWidth(125)
//                                .setQuality(50)
//                                .compressToBitmap(newImageFile);
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                    compressedImageFile.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//                    byte[] thumbData = baos.toByteArray();
//
//                    UploadTask image_path = storageReference.child("profile_images").child(uid + ".jpg").putBytes(thumbData);
//
//                    image_path.addOnCompleteListener(task -> {
//
//                        if (task.isSuccessful()) {
//                            storeFirestore(task, user_name);
//
//                        } else {
//
//                            String error = Objects.requireNonNull(task.getException()).getMessage();
//                            Toast.makeText(SetupActivity.this, "(IMAGE Error) : " + error, Toast.LENGTH_LONG).show();
//
//                            setupProgress.setVisibility(View.INVISIBLE);
//
//                        }
//                    });
//
//                } else {
//
//                    storeFirestore(null, user_name);
//
//                }
//
//            }
//
//        });
//
//        changeImage.setOnClickListener(v -> {
//
//            if(ContextCompat.checkSelfPermission(SetupActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
//
//                Toast.makeText(SetupActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
//                ActivityCompat.requestPermissions(SetupActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
//
//            } else {
//
//                BringImagePicker();
//
//            }
//
//        });
//
//
//    }
//
//
//    // Download Images
//    private void storeFirestore(Task<UploadTask.TaskSnapshot> task, String user_name) {
//
//        Uri download_uri;
//
//        download_uri = (task.getResult()).getUploadSessionUri();
//        Map<String, String> userMap = new HashMap<>();
//        userMap.put("name", user_name);
//        userMap.put("image", Objects.requireNonNull(download_uri != null ? download_uri.toString() : null));
//
//        firebaseFirestore.collection("User").document(uid).set(userMap).addOnCompleteListener(task1 -> {
//
//            if(task1.isSuccessful()){
//
//
//                Toast.makeText(SetupActivity.this, "The user Settings are updated.", Toast.LENGTH_LONG).show();
//                Intent mainIntent = new Intent(SetupActivity.this, MainActivity.class);
//                startActivity(mainIntent);
//                finish();
//
//            } else {
//
//                String error = task1.getException().getMessage();
//                Toast.makeText(SetupActivity.this, "(FIRESTORE Error) : " + error, Toast.LENGTH_LONG).show();
//
//            }
//
//            setupProgress.setVisibility(View.INVISIBLE);
//
//        });
//
//
//    }
//
//
//    // Picker 3pl
//    private void BringImagePicker() {
//
//        CropImage.activity()
//                .setGuidelines(CropImageView.Guidelines.ON)
//                .setAspectRatio(1, 1)
//                .start(SetupActivity.this);
//
//    }
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
//            CropImage.ActivityResult result = CropImage.getActivityResult(data);
//            if (resultCode == RESULT_OK) {
//
//                mainImageURI = result.getUri();
//                setupImage.setImageURI(mainImageURI);
//
//                isChanged = true;
//
//            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
//
//                Exception error = result.getError();
//
//            }
//        }
//
//    }
//}
}
