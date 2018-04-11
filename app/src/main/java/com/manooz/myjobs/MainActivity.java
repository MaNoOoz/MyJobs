package com.manooz.myjobs;

import android.Manifest;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.manooz.jobs_search_engine_material.R;

import java.util.ArrayList;
//  http://www.devexchanges.info/2016/05/android-basic-training-course-combining.html

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Views
    public EditText e;
    public ClipboardManager clipboard;
    private ViewPager viewPager;
    private DrawerLayout drawer;
    private TabLayout tabLayout;
    private int[] pageTitle = {R.string.tap1 ,R.string.tap2 ,R.string.tap3};
    public Toolbar toolbar;
    boolean isUserPressBack = false;

    // For Desplay User Info In Drawer
    TextView nameTextView;
    TextView emailTextView;
    ImageView photoImageView;
//    private static final int RC_SIGN_IN = 1;
//    private GoogleSignInClient mGoogleSignInClient;

      private int STORAGE_PERMISSION_CODE = 1;

     FirebaseUser user;
     FirebaseAuth mAuth;
     FirebaseAuth.AuthStateListener authStateListener;
     OnCompleteListener onCompleteListener;
     DatabaseReference databaseReference;
     ArrayList<Fragment> data;
    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Construct a GeoDataClient.
//        GeoDataClient mGeoDataClient = Places.getGeoDataClient(this, null);
//
//        // Construct a PlaceDetectionClient.
//        PlaceDetectionClient mPlaceDetectionClient = Places.getPlaceDetectionClient(this, null);

//        // Construct a FusedLocationProviderClient.
//        FusedLocationProviderClient mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("User_Links").child(mAuth.getCurrentUser().getUid());
        }

        setupListener();

        // Not Working
//        setDataToView(user);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }

        getpermi();



        clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        e = (EditText) findViewById(R.id.editText);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                int id = item.getItemId();
//                if (id== R.id.showUrl){
//                    item.setIcon(getResources().getDrawable(R.drawable.ic_group_collapse_01));
//                    return true;
//                }
//                return false;
//            }
//        });
        drawer = findViewById(R.id.drawerLayout);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        //create default navigation drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //setting Tab layout (number of Tabs = number of ViewPager pages)
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//        for (int i = 0; i < 4; i++) {
        for (int i = 0; i < pageTitle.length; i++) {

            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
        }
        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        tabLayout.getResources().getColor(R.color.cayan);
        //handling navigation view item event
        NavigationView navigationView = findViewById(R.id.nav_view);
//        View header = navigationView.getHeaderView(0);
        navigationView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        assert navigationView != null;
         nameTextView = (TextView)findViewById(R.id.userName);
          emailTextView = (TextView) findViewById(R.id.userEmail);
//          photoImageViewe = (ImageView) findViewById(R.id.imageView);

        navigationView.setNavigationItemSelectedListener(this);
        //set viewpager adapter
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //change Tab selection when swipe ViewPager
        //change ViewPager page when tab selected
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        viewPager.setCurrentItem(tab.getPosition());
                        break;
                    case 1:
                        viewPager.setCurrentItem(tab.getPosition());
                        break;
                    case 2:
                        viewPager.setCurrentItem(tab.getPosition());
                        break;
//                    case 2:
//                        Toast.makeText(MainActivity.this, "Started!!!!", Toast.LENGTH_SHORT).show();
//                        Intent s = new Intent(getApplicationContext(), Chat_Activity.class);
//                        startActivity(s);
//                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    } // OnCreate End

//    private void getLocationPermission() {
//    /*
//     * Request location permission, so that we can get the location of the
//     * device. The result of the permission request is handled by a callback,
//     * onRequestPermissionsResult.
//     */
//        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
//                android.Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//             mLocationPermissionGranted = true;
//        } else {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
//                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
//        }
//    }

    private void getpermi() {

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Log.e("PERMISSION","You have already granted this permission!");
//            Toast.makeText(MainActivity.this, "You have already granted this permission!",
//                    Toast.LENGTH_SHORT).show();
        } else {
            requestStoragePermission();
        }


    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {

            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed because of this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, STORAGE_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE)  {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }


//    private void setDataToView(FirebaseUser dataToView) {
//        dataToView = mAuth.getCurrentUser();
//        if (dataToView != null) {
//            nameTextView.setText("User Email: " + dataToView.getEmail());
//            emailTextView.setText("User name: " + dataToView.getDisplayName());
////        userId.setText("User id: " + user.getUid());
//        }
//    }
    private void setupListener() {
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth mAuth) {

                user = mAuth.getCurrentUser();
                Log.e(Constants.TAG, "User" + user);
                if (user != null) {
                    Log.e(Constants.TAG, "User" +  "HELLO " + user.getEmail());

//                    Toast.makeText(MainActivity.this,
//                            "HELLO " + user.getEmail() , Toast.LENGTH_SHORT).show();
//                    switchToPasswordFragment("users/" + user.getUid());
                } else {
//                    switchToLoginFragment();
                }
            }
        };

        onCompleteListener = new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (!task.isSuccessful()) {
                    showLoginError("Login Failed");


                }
            }
        };
    }
//
//    private void setupGoogle() {
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//
//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        updateUI(account);
//    }
//
//    private void updateUI(GoogleSignInAccount account) {
//
//    }
//

    @Override
    protected void onResume() {
        super.onResume();
        mAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (authStateListener != null) {
            mAuth.removeAuthStateListener(authStateListener);

        }
    }

    protected void onStart() {
        super.onStart();
        user = mAuth.getCurrentUser();
        mAuth.addAuthStateListener(authStateListener);
        if (user == null) {
            Intent s = new Intent(this, StartActivity.class);
            startActivity(s);
            finish();
        }

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                                              @Override
                                              public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//               invalidateOptionsMenu();
                                              }

                                              @Override
                                              public void onPageSelected(int position) {
                                              }

                                              @Override
                                              public void onPageScrollStateChanged(int state) {
                                              }
                                          }
        );
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authStateListener != null) {
            mAuth.removeAuthStateListener(authStateListener);
        }

    }


//    public void onLogin(String email, String password) {
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(onCompleteListener);
//        //TODO: Log user in with username & password
//    }
    public void onLogout() {
        mAuth.signOut();
    }

//    private void switchToPasswordFragment(String path) {
//        Intent intent2 = new Intent(this, StartActivity.class);
//        startActivity(intent2);
//    }

    private void showLoginError(String message) {

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.so) {

            mAuth.getCurrentUser();
            if (user != null) {
                AuthUI.getInstance().signOut(this);
                Toast.makeText(this, user + " " + "Are Signed Out ", Toast.LENGTH_SHORT).show();
                Intent s = new Intent(this,StartActivity.class);
                startActivity(s);

                return true;
            }
        }
//        if (id == R.id.seting) {
//            Intent setting = new Intent(this,SettingActivity.class);
//            startActivity(setting);
//        }
        if (id == R.id.nav_fav) {
            viewPager.setCurrentItem(1);

        }
        if (id == R.id.nav_apps) {
                String url = "https://play.google.com/store/apps/developer?id=Yaman+Alkhateeb";
                Intent ii = new Intent(Intent.ACTION_VIEW);
                ii.setData(Uri.parse(url));
                startActivity(ii);
                return true;

        }
        if (id == R.id.nav_about) {
            Intent all = new Intent(getApplicationContext(),about.class);
            startActivity(all);

        }


        if (id == R.id.share_app) {
            Intent i = new Intent(android.content.Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(
                    android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=manooz.com.finalapp");
            startActivity(Intent.createChooser(i, "Share via "));
            return true;
        }

        DrawerLayout drawer = findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        assert drawer != null;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else  if (!isUserPressBack)
            {
                AlertDialog.Builder ad = new AlertDialog.Builder(
                        this);
                ad.setTitle("هل تريد الخروج من البرنامج");
                // set dialog message
                ad
                        .setIcon(R.drawable.search)
                        .setMessage(" ")
                        .setCancelable(false)
                        .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("لا", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = ad.create();

                // show it
                alertDialog.show();
                isUserPressBack = true;


        }

    }


}