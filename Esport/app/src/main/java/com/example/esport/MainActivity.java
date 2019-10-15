package com.example.esport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.esport.ui.CatalogFragment;
import com.example.esport.ui.CommentsFragment;
import com.example.esport.ui.GuideFragment;
import com.example.esport.ui.NewsFragment;
import com.example.esport.ui.PostFragment;
import com.example.esport.ui.SupportFragment;
import com.example.esport.ui.TourFragment;
import com.example.esport.ui.UpdateFragment;
import com.example.esport.ui.UsersFragment;
import com.example.esport.ui.HomeFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;
    NavigationView navigationView;
    private static int login = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.mn_home, R.id.mn_guide, R.id.mn_news,
//                R.id.mn_update, R.id.mn_tour, R.id.mn_sp,
//                R.id.mn_login, R.id.mn_logout)
//                .setDrawerLayout(drawer)
//                .build();

        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.mn_home);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.fragment_container);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mn_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.mn_guide:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new GuideFragment()).commit();
                break;
            case R.id.mn_news:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NewsFragment()).commit();
                break;
            case R.id.mn_update:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UpdateFragment()).commit();
                break;
            case R.id.mn_tour:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TourFragment()).commit();
                break;
            case R.id.mn_sp:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SupportFragment()).commit();
                break;
            case R.id.mn_posts:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PostFragment()).commit();
                break;
            case R.id.mn_catalog:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CatalogFragment()).commit();
                break;
            case R.id.mn_users:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UsersFragment()).commit();
                break;
            case R.id.mn_comments:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CommentsFragment()).commit();
                break;
            case R.id.mn_login:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent, login);
                break;
            case R.id.mn_logout:
                navigationView.getMenu().findItem(R.id.mn_logout).setVisible(false);
                navigationView.getMenu().findItem(R.id.mn_login).setVisible(true);
                navigationView.getMenu().findItem(R.id.mn_admin).setVisible(false);
                navigationView.getMenu().setGroupVisible(R.id.mn_main, true);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                navigationView.setCheckedItem(R.id.mn_home);
                ((TextView)findViewById(R.id.username)).setText(R.string.acc_name);
                ((TextView)findViewById(R.id.email)).setText(R.string.acc_email);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    private long backPressedTime;
//    private Toast backToast;
//    @Override
//    public void onBackPressed() {
//        if (backPressedTime + 2000 > System.currentTimeMillis()) {
//            backToast.cancel();
////            super.onBackPressed();
//            NavUtils.navigateUpFromSameTask(this);
//            return;
//        } else {
//            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
//            backToast.show();
//        }
//
//        backPressedTime = System.currentTimeMillis();
//    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public void onActivityResult(int request, int result, Intent intent){
        super.onActivityResult(request, result, intent);
        if(result == Activity.RESULT_OK) {
            if(request == login){
                String name = intent.getStringExtra("Name");
                String email = intent.getStringExtra("Email");
                String role = intent.getStringExtra("Role");
                if(role.equals("admin")){
                    navigationView.getMenu().findItem(R.id.mn_logout).setVisible(true);
                    navigationView.getMenu().findItem(R.id.mn_login).setVisible(false);
                    navigationView.getMenu().setGroupVisible(R.id.mn_main, false);
                    navigationView.getMenu().findItem(R.id.mn_admin).setVisible(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new PostFragment()).commit();
                    navigationView.setCheckedItem(R.id.mn_posts);
                    ((TextView)findViewById(R.id.username)).setText(name);
                    ((TextView)findViewById(R.id.email)).setText(email);
                }
                if(role.equals("user")){
                    navigationView.getMenu().findItem(R.id.mn_logout).setVisible(true);
                    navigationView.getMenu().findItem(R.id.mn_login).setVisible(false);
                    ((TextView)findViewById(R.id.username)).setText(name);
                    ((TextView)findViewById(R.id.email)).setText(email);
                }
            }
        }
    }
}
