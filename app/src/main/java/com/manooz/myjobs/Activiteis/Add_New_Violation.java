package com.manooz.myjobs.Activiteis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.manooz.jobs_search_engine_material.R;
import com.manooz.myjobs.POJO.New_Violation_Object;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.util.ArrayList;

public class Add_New_Violation extends AppCompatActivity {

        private static final String TAG = "Add_New_Violation";
        // ======================================== Val ============================================= \\
        boolean mLinksIsGood = false;

        // Storage Firebase
        private Uri postImageUri;
//        private StorageReference mStorageRef    = FirebaseStorage.getInstance().getReference("uploads");
//        private DatabaseReference mDatabaseRef  = FirebaseDatabase.getInstance().getReference("uploads");
//        private StorageTask storageTask;
        //
        public String item,item2;
        int mNumOfRatings,mNumOfLikes,mNumOfComments,mNumOfViews;

        private Spinner spinner,spinner2;
        public ArrayAdapter<CharSequence> mSpinneradapter;
        public ArrayAdapter<CharSequence> mSpinneradapter2;

        private EditText mGroupName, mGroupDesc, mGroupLink, mUserName;
        private Button mAddToMyDataBase;
        private ImageView addImage;
        private ProgressBar progressBar;
        // --------
//        private FirebaseFirestore db = FirebaseFirestore.getInstance();
//        private CollectionReference mCollectionReference = db.collection(MAIN_COLLECTION);

        private ConstraintLayout constraintLayout;
        private ArrayList<New_Violation_Object> groupModels;


        // ======================================== Spinner ============================================= \\

        private void mySpineers() {

            spinner = (Spinner) findViewById(R.id.spinner);
            spinner2 = (Spinner) findViewById(R.id.spinnerCity);

            // Spinner click listener
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    // An item was selected. You can retrieve the selected item using
                    // parent.getItemAtPosition(pos)
                    item = parent.getItemAtPosition(position).toString();
                    // Showing selected spinner item
                    switch (position) {
                        case 0:
                            // Whatever you want to happen when the first item gets selected

//                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                            break;
                        case 1:
                            // Whatever you want to happen when the second item gets selected
                            break;
                        case 2:
                            // Whatever you want to happen when the thrid item gets selected
                            break;

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    // An item was selected. You can retrieve the selected item using
                    // parent.getItemAtPosition(pos)
                    item2 = parent.getItemAtPosition(position).toString();
                    // Showing selected spinner item
                    switch (position) {
                        case 0:
                            // Whatever you want to happen when the first item gets selected

//                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                            break;
                        case 1:
                            // Whatever you want to happen when the second item gets selected
                            break;
                        case 2:
                            // Whatever you want to happen when the thrid item gets selected
                            break;

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            mSpinneradapter = ArrayAdapter.createFromResource(this, R.array.mListOfCatagories2, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            mSpinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the mSpinneradapter to the spinner
            spinner.setAdapter(mSpinneradapter);

            mSpinneradapter2 = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            mSpinneradapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the mSpinneradapter to the spinner
            spinner2.setAdapter(mSpinneradapter2);

        }


        // ======================================== Activity LifeCycle ============================================= \\

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add__new__violation);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(getColor(R.color.white));
//            toolbar.setBackgroundColor(getResources().getColor(R.color.green_800));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

            ActionBar ab = getSupportActionBar();
//         Enable the Up button
            if (ab != null) {
                ab.setDisplayHomeAsUpEnabled(true);
                ab.setTitle(R.string.app_name);
            }


            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.save:
//                            if (storageTask !=null && storageTask.isInProgress()){
//                                Toast.makeText(Add_New_Violation.this, " Saved", Toast.LENGTH_SHORT).show();
//                                Log.d(" TAG ", " Clicked");
//
//                            }else {
//
////                                uploadFile();
//                                Toast.makeText(Add_New_Violation.this, "TODO ... ", Toast.LENGTH_SHORT).show();
//
//
//                            }
                    }
                    return false;
                }
            });

            mWidgets();
            mySpineers();
            clicks();


        }



//        private void uploadFile() {
//            if (postImageUri!=null){
//
//                StorageReference fileRef = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtinction(postImageUri));
//                storageTask = fileRef.putFile(postImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                progressBar.setProgress(0);
//                            }
//                        },5000);
//                        Toast.makeText(Add_New_Violation.this, "Upload successful", Toast.LENGTH_SHORT).show();
//                        Upload upload = new Upload(mGroupName.getText().toString().trim(),taskSnapshot.getUploadSessionUri().toString());
//                        String uploadId = mDatabaseRef.push().getKey();
//                        mDatabaseRef.child(uploadId).setValue(upload);
//
//
//
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//
//                        Toast.makeText(Add_New_Violation.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                        double progress = (100.0 * taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
//                        progressBar.setProgress((int) progress);
//                        progressBar.setVisibility(View.INVISIBLE);
//
//                    }
//                });
//
//            }else {
//                Toast.makeText(this, "No File Selected", Toast.LENGTH_SHORT).show();
//
//
//            }
//
//        }
//
//        public String getFileExtinction(Uri uri){
//            ContentResolver contentResolver = getContentResolver();
//            MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
//            return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
//
//        }
        // ======================================== ToolBar ============================================= \\

//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            getMenuInflater().inflate(R.menu.menu_web_view, menu);
//            return true;
//        }
//
//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            switch (item.getItemId()) {
//
//                case R.id.settings:
//                    // TODO: 6/10/2018
////                logOut();
//
//                    return true;
//
//                case R.id.action_settings_btn:
////
////                Intent settingsIntent = new Intent(FireBaseTest.this, SetupActivity.class);
////                startActivity(settingsIntent);
//
//                    return true;
//
//
//                default:
//                    return false;
//
//            }
//        }


        // ======================================== My Methods ============================================= \\

        private void mWidgets() {

            progressBar = findViewById(R.id.new_post_progress);
            mGroupName = findViewById(R.id.mName);
            mGroupLink = findViewById(R.id.mGroupLink);
            mGroupDesc = findViewById(R.id.mGroupDesc);
            mUserName = findViewById(R.id.mGroupUserName);
            mAddToMyDataBase = findViewById(R.id.mAddToDatabase);
            addImage = findViewById(R.id.addImg);
        }
        private void clicks() {

            mAddToMyDataBase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    TakeMyData(0);
//                progressBar.setVisibility(View.VISIBLE);
                    Toast.makeText(Add_New_Violation.this, "Uploading ... ", Toast.LENGTH_SHORT).show();


                }
            });


            addImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CropImage.activity()
                            .setGuidelines(CropImageView.Guidelines.ON)
                            .setMinCropResultSize(512, 512)
                            .setAspectRatio(1, 1)
                            .start(Add_New_Violation.this);

                }

            });
        }

        private TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }



            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            https://stackoverflow.com/questions/8543449/how-to-use-the-textwatcher-class-in-android

//        if ( )
                // TODO: 7/23/2018 Check User input


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

//        public void TakeMyData(int postion) {
//            // Take My Text
//            String mLink = mGroupLink.getText().toString().trim();
//            String mName = mGroupName.getText().toString().trim();
//            String mDesc = mGroupDesc.getText().toString().trim();
//            String myUserName = mUserName.getText().toString().trim();
//            String mCatogries = item;
//            String mCity = item2 ;
//
//            // TODO: 8/14/2018
//
//            //dummy Data
////            Random random = new Random();
////            double mRating = GroupsUtil.getRandomRating(random);
////            int mNumOfRatings = GroupsUtil.setRandomInt(random);
////            int mNumOfLikes = GroupsUtil.setRandomInt(random);
////            int mNumOfComments =GroupsUtil.setRandomInt(random);
////            int mNumOfViews=   GroupsUtil.setRandomInt(random);
//
////        if (mLink.startsWith("http://")|| mLink.startsWith("https://")||mLink.startsWith("@")){
//            if (mLink.startsWith("http://")|| mLink.startsWith("https://")){
//
//                mLinksIsGood = false;
//                mLink = mGroupLink.getText().toString().trim();
//                // TODO: 7/22/2018 Make Photo Uri
//                Uri photoUri = postImageUri;
////        Map<String, Object> note = new HashMap<>();
////        note.put(GroupName, mName);
////        note.put(GroupDesc, mDesc);
////        note.put(GroupLink, mLink);
////        note.put(UserName, myUserName);
////        mGroupLink.addTextChangedListener(textWatcher);
//
////                final Group_Object group_object = new Group_Object("",mName, mDesc, mLink, myUserName,mCatogries,mCity,
////                        mRating,mNumOfRatings,mNumOfLikes,mNumOfComments,mNumOfViews);
////
////                final List<Group_Object> group_objects =new ArrayList<>();
//                // WTF
////            mSpinneradapter.getItem(postion);
////            if (postion == 0){
//
//
//
//                mCollectionReference.document().set(group_object)
//                        .addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//
//                                Log.d(TAG, " Clicked");
//                            }
//
//                        }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d(" TAG ", " Clicked");
//
//
//                    }
//
//                }).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        Toast.makeText(Add_New_Violation.this, getString(R.string.groupAdded) , Toast.LENGTH_SHORT).show();
//
////                        finish();
//                    }
//                });
//            }else {
//                mGroupLink.setError(getString(R.string.enter_good_group_link), getResources().getDrawable(R.drawable.ic_error_outline_black_24dp));
//                mAddToMyDataBase.setEnabled(true);
//            }
//
//
//            // TODO: 7/20/2018
////        // Send My Data To Fragment
////        GroupModel groupModel = new GroupModel(mName, mDesc, mLink, myUserName);
////        HomeFragment homeFragment = new HomeFragment();
////        Bundle bundle = new Bundle();
////        bundle.putParcelable("Student", groupModel);
////        homeFragment.setArguments(bundle);
//
//
////        }else {
//
////        }
//
//        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {

                    postImageUri = result.getUri();
                    Picasso.get().load(postImageUri).into(addImage);
//                Intent intent = new Intent();
//                intent.putExtra("image",postImageUri);
//                startActivity(intent);
//                newPostImage.setImageURI(postImageUri);

                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                    Exception error = result.getError();

                }
            }

        }


        // ======================================== Finish ============================================= \\


        // ======================================== Res ============================================= \\
        // https://stackoverflow.com/questions/13377361/how-to-create-a-drop-down-list
        // https://stackoverflow.com/questions/12739909/send-data-from-activity-to-fragment-in-android

    }


