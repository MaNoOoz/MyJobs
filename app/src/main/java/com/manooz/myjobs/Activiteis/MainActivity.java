package com.manooz.myjobs.Activiteis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.FirebaseFirestore;
import com.manooz.jobs_search_engine_material.R;
import com.manooz.myjobs.Fragments.HomeFragment;
import com.manooz.myjobs.Fragments.ProfileFragment;
import com.manooz.myjobs.Fragments.Main_Fragment;
import com.mikhaellopez.circularimageview.CircularImageView;

//  http://www.devexchanges.info/2016/05/android-basic-training-course-combining.html

public class MainActivity extends AppCompatActivity {

//    || ======================================== Val ============================================= ||


    private Toolbar mToolbar;
    private ActionBar actionBar;
    private Menu menu_navigation;
    private DrawerLayout drawer;
    private View navigation_header;
    private boolean is_account_mode = false;

//    ===========================================================================================

//    private FirebaseAuth mAuth;
    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private Main_Fragment mWebViewFragment;

    private BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    private RecyclerView recyclerView;
    private String current_user_id;
//    private FirebaseFirestore firebaseFirestore;
//    private FirebaseUser currentUser;
//    private WebsiteAdapter websiteAdapter;
    private NavigationView nav_view;

    // ======================================== Activity LifeCycle ============================================= \\

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        mAuth = FirebaseAuth.getInstance();
//        firebaseFirestore = FirebaseFirestore.getInstance();
//        currentUser = FirebaseAuth.getInstance().getCurrentUser();


        initToolbar();
        initNavigationMenu();
        initBottomNavigationMenu();


    }



//    @Override
//    protected void onStart() {
//        super.onStart();
//
////        CheckUsers();
//
//    }


    // ========================================    My Methods ============================================= \\
//    public void CheckUsers() {
//        currentUser = FirebaseAuth.getInstance().getCurrentUser();
//        if (currentUser == null) {
//
////            sendToLogin();
//            Toast.makeText(this, "You Are Not SignIn ", Toast.LENGTH_SHORT).show();
//
//        } else {
//            current_user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
//            firebaseFirestore.collection("User").document(current_user_id).get().addOnCompleteListener(task -> {
//
//                if (task.isSuccessful()) {
//
//                    if (!task.getResult().exists()) {
//
//                        menu_navigation.findItem(R.id.so).setVisible(true);
//                        menu_navigation.findItem(R.id.si).setVisible(false);
//                        // TODO: 12/8/2018 Fix
////                        Intent setupIntent = new Intent(MainActivity.this, SetupActivity.class);
////                        startActivity(setupIntent);
////                        finish();
//                        Toast.makeText(this, "You Are SignIn As " + currentUser.getDisplayName(), Toast.LENGTH_SHORT).show();
//
//
//                    }
//
//                } else {
//
//                    String errorMessage = task.getException().getMessage();
//                    Toast.makeText(MainActivity.this, "Error : " + errorMessage, Toast.LENGTH_LONG).show();
//
//
//                }
//
//            });
//
//        }
//    }
//
//    private void sendToLogin() {
//
//        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
//        startActivity(loginIntent);
//        finish();
//
//    }

    private void initBottomNavigationMenu() {
        bottomNavigationView = findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


//        //I added this if statement to keep the selected fragment when rotating the device

            getSupportFragmentManager().beginTransaction().replace(R.id.main_container,
                    new Main_Fragment()).commit();


//        if (mAuth.getCurrentUser() != null) {
//            bottomNavigationView = findViewById(R.id.bnv);
//            bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//
//
//            bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
//                Fragment selectedFragment = null;
//                switch (item.getItemId()) {
//
//                    case R.id.bottom_action_home:
//                        selectedFragment = new HomeFragment();
//                        Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
//                        break;
//
//                    case R.id.profile:
//                        selectedFragment = new ProfileFragment();
//                        break;
//
//                    case R.id.search:
//                        selectedFragment = new Main_Fragment();
//                        break;
//
//
//                }
//                if (selectedFragment != null) {
//                    getSupportFragmentManager().beginTransaction().replace(R.id.main_container,
//                            selectedFragment).commit();
//                } else {
//                    Toast.makeText(MainActivity.this, "selectedFragment is Null", Toast.LENGTH_SHORT).show();
//                }
//                return true;
//
//
//            });
//
//
//        }
    }

    // ========================================    Navigation      ============================================= \\


    private void initNavigationMenu() {

        nav_view = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawer, mToolbar,
                        R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
                    public void onDrawerOpened(View drawerView) {
//                updateCounter(nav_view);
                        super.onDrawerOpened(drawerView);
                    }
                };

        drawer.setDrawerListener(toggle);

        toggle.syncState();

        nav_view.setNavigationItemSelectedListener(item -> {
            onItemNavigationClicked(item);
            return true;
        });


        // open drawer at start
        drawer.openDrawer(GravityCompat.START);
//        updateCounter(nav_view);
        menu_navigation = nav_view.getMenu();

        // navigation header
        navigation_header = nav_view.getHeaderView(0);

        TextView name = (TextView) navigation_header.findViewById(R.id.name);
        TextView email = (TextView) navigation_header.findViewById(R.id.email);
        CircularImageView avatar = (CircularImageView) navigation_header.findViewById(R.id.avatar);


//        if (currentUser != null) {
//            current_user_id = currentUser.getDisplayName();
//            email.setText(currentUser.getEmail());
//            avatar.setImageResource(R.drawable.album2);
//
//            name.setText(current_user_id);
//            email.setText(currentUser.getEmail());
//            avatar.setImageResource(R.drawable.album2);
//
//        }


//        (navigation_header.findViewById(R.id.bt_account)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                boolean is_hide = Tools.toggleArrow(view);
//                is_account_mode = is_hide;
//                menu_navigation.clear();
//                if (is_hide) {
//                    menu_navigation.add(1, 1000, 100, "evans.collins@mail.com").setIcon(R.drawable.ic_account_circle);
//                    menu_navigation.add(1, 2000, 100, "adams.green@mail.com").setIcon(R.drawable.ic_account_circle);
//                    menu_navigation.add(1, 1, 100, "Add account").setIcon(R.drawable.ic_add);
//                    menu_navigation.add(1, 2, 100, "Manage accounts").setIcon(R.drawable.ic_settings);
//                } else {
//                    nav_view.inflateMenu(R.menu.activity_main_drawer);
//                    updateCounter(nav_view);
//                }
//            }
//        });
    }

    private void onItemNavigationClicked(MenuItem item) {
        if (!is_account_mode) {
            Toast.makeText(getApplicationContext(), item.getTitle() + " Selected", Toast.LENGTH_SHORT).show();
            actionBar.setTitle(item.getTitle());

            switch (item.getItemId()) {
                case R.id.so:
//                    mAuth.getCurrentUser();
//                    if (currentUser != null) {
//                        mAuth.signOut();
//                        Toast.makeText(this, currentUser + " " + "Are Signed Out ", Toast.LENGTH_SHORT).show();
//                        Intent s = new Intent(getApplicationContext(), StartActivity.class);
//                        startActivity(s);
//                        return;
//                    }
                case R.id.si: {
//                    Toast.makeText(this, currentUser + " " + "Are Not Null  ", Toast.LENGTH_SHORT).show();
//                    Intent ss = new Intent(getApplicationContext(), LoginActivity.class);
//                    startActivity(ss);
//                    return;

                }

                case R.id.nav_profile:
                    Intent intent = new Intent(getApplicationContext(), SetupActivity.class);
                    startActivity(intent);
                    break;
                case R.id.nav_apps:
                    String url = "https://play.google.com/store/apps/dev?id=8389389659889758696";
                    Intent ii = new Intent(Intent.ACTION_VIEW);
                    ii.setData(Uri.parse(url));
                    startActivity(ii);
                    break;
                case R.id.nav_about:
                    Intent all = new Intent(getApplicationContext(), About_Activty.class);
                    startActivity(all);
                    break;
                case R.id.share_app:
                    String packageName = "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName();

                    Intent i = new Intent(android.content.Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(
                            android.content.Intent.EXTRA_TEXT, packageName);
                    startActivity(Intent.createChooser(i, "Share via "));

                    break;
            }
            drawer.closeDrawers();

        }

    }


    // ========================================   Sheared  Methods ============================================= \\

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(mToolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("تطبيق المراقبين");
//        Tools.setSystemBarColor(this, R.color.pink_700);

    }


    @Override
    public void onBackPressed() {
//        assert drawer != null;

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
//        } else {
//            AppRater.app_launched(this);
//
//        }
    }


    //    private void updateCounter(NavigationView nav) {
//        if (is_account_mode) return;
//        Menu m = nav.getMenu();
//        ((TextView) m.findItem(R.id.nav_all_inbox).getActionView().findViewById(R.id.text)).setText("75");
//        ((TextView) m.findItem(R.id.nav_inbox).getActionView().findViewById(R.id.text)).setText("68");
//
//        TextView badgePrioInbx = (TextView) m.findItem(R.id.nav_priority_inbox).getActionView().findViewById(R.id.text);
//        badgePrioInbx.setText("3 new");
//        badgePrioInbx.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
//
//        TextView badgeSocial = (TextView) m.findItem(R.id.nav_social).getActionView().findViewById(R.id.text);
//        badgeSocial.setText("51 new");
//        badgeSocial.setBackgroundColor(getResources().getColor(R.color.green_500));
//
//        ((TextView) m.findItem(R.id.nav_spam).getActionView().findViewById(R.id.text)).setText("13");
//    }

//    //    private void getLocationPermission() {
////    /*
////     * Request location permission, so that we can get the location of the
////     * device. The result of the permission request is handled by a callback,
////     * onRequestPermissionsResult.
////     */
////        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
////                android.Manifest.permission.ACCESS_FINE_LOCATION)
////                == PackageManager.PERMISSION_GRANTED) {
////             mLocationPermissionGranted = true;
////        } else {
////            ActivityCompat.requestPermissions(this,
////                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
////                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
////        }
////    }
//
//
//    private void getpermi() {
//
//        if (ContextCompat.checkSelfPermission(MainActivity.this,
//                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            Log.e("PERMISSION", "You have already granted this permission!");
////            Toast.makeText(MainActivity.this, "You have already granted this permission!",
////                    Toast.LENGTH_SHORT).show();
//        } else {
//            requestStoragePermission();
//        }
//
//
//    }
//
//    private void requestStoragePermission() {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                Manifest.permission.ACCESS_FINE_LOCATION)) {
//
//            new AlertDialog.Builder(this)
//                    .setTitle("Permission needed")
//                    .setMessage("This permission is needed because of this and that")
//                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            ActivityCompat.requestPermissions(MainActivity.this,
//                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, STORAGE_PERMISSION_CODE);
//                        }
//                    })
//                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    })
//                    .create().show();
//
//        } else {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, STORAGE_PERMISSION_CODE);
//        }
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == STORAGE_PERMISSION_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }


    //    private void setDataToView(FirebaseUser dataToView) {
//        dataToView = mAuth.getCurrentUser();
//        if (dataToView != null) {
//            nameTextView.setText("User Email: " + dataToView.getEmail());
//            emailTextView.setText("User name: " + dataToView.getDisplayName());
////        userId.setText("User id: " + user.getUid());
//        }
////    }
//    private void setupListener() {
//        authStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth mAuth) {
//
//                user = mAuth.getCurrentUser();
//                if (user != null) {
//
//                    Toast.makeText(MainActivity.this, "HELLO " + user.getEmail(), Toast.LENGTH_SHORT).show();
////                    switchToPasswordFragment("users/" + user.getUid());
//                } else {
////                    switchToLoginFragment();
//                }
//            }
//        };
//
//        onCompleteListener = new OnCompleteListener() {
//            @Override
//            public void onComplete(@NonNull Task task) {
//                if (!task.isSuccessful()) {
//                    showLoginError("Login Failed");
//
//
//                }
//            }
//        };
//    }
////
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

//    @Override
//    protected void onResume() {
//        super.onResume();
//        mAuth.addAuthStateListener(authStateListener);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (authStateListener != null) {
//            mAuth.removeAuthStateListener(authStateListener);
//
//        }
//    }

//    protected void onStart() {
//        super.onStart();
//        user = mAuth.getCurrentUser();
//        mAuth.addAuthStateListener(authStateListener);
//        if (user == null) {
//            Intent s = new Intent(this, StartActivity.class);
//            startActivity(s);
//            finish();
//        }
//
//    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (authStateListener != null) {
//            mAuth.removeAuthStateListener(authStateListener);
//        }
//
//    }


    //    public void onLogin(String email, String password) {
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(onCompleteListener);
//        //TODO: Log user in with username & password
//    }

//    public void onLogout() {
//        mAuth.signOut();
//    }

//    private void switchToPasswordFragment(String path) {
//        Intent intent2 = new Intent(this, StartActivity.class);
//        startActivity(intent2);
//    }

//    private void showLoginError(String message) {
//
//    }

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//        if (id == R.id.so) {
//
//            mAuth.getCurrentUser();
//            if (user != null) {
//                AuthUI.getInstance().signOut(this);
//                Toast.makeText(this, user + " " + "Are Signed Out ", Toast.LENGTH_SHORT).show();
//                Intent s = new Intent(this, StartActivity.class);
//                startActivity(s);
//
//                return true;
//            }
//        }
//
//        if (id == R.id.nav_apps) {
//            String url = "https://play.google.com/store/apps/developer?id=Yaman+Alkhateeb";
//            Intent ii = new Intent(Intent.ACTION_VIEW);
//            ii.setData(Uri.parse(url));
//            startActivity(ii);
//            return true;
//
//        }
//        if (id == R.id.nav_about) {
//            Intent all = new Intent(getApplicationContext(), About_Activty.class);
//            startActivity(all);
//
//        }
//
//
//        if (id == R.id.share_app) {
//            Intent i = new Intent(android.content.Intent.ACTION_SEND);
//            i.setType("text/plain");
//            i.putExtra(
//                    android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=manooz.com.finalapp");
//            startActivity(Intent.createChooser(i, "Share via "));
//            return true;
//        }
//        return false;
//    }

//    @Override
//    public void onBackPressed() {
//        assert drawer != null;
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else if (!isUserPressBack) {
//            AlertDialog.Builder ad = new AlertDialog.Builder(
//                    this);
//            ad.setTitle("هل تريد الخروج من البرنامج");
//            // set dialog message
//            ad
//                    .setIcon(R.drawable.search)
//                    .setMessage(" ")
//                    .setCancelable(false)
//                    .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            // if this button is clicked, close
//                            // current activity
//                            MainActivity.this.finish();
//                        }
//                    })
//                    .setNegativeButton("لا", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            // if this button is clicked, just close
//                            // the dialog box and do nothing
//                            dialog.cancel();
//                        }
//                    });
//            // create alert dialog
//            AlertDialog alertDialog = ad.create();
//
//            // show it
//            alertDialog.show();
//            isUserPressBack = true;
//
//
//        }
//
//    }


}


