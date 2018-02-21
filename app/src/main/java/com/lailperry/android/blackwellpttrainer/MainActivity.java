package com.lailperry.android.blackwellpttrainer;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private static final int WORKOUTS_FRAGMENT = 0;
    private static final int STATS_FRAGMENT = 1;
    private static final int GROUPS_FRAGMENT = 2;
    private static final int TIPS_FRAGMENT = 3;
    private static final int SETTINGS_FRAGMENT = 4;

    android.support.v4.app.FragmentManager mFragmentManager;
    Fragment mFragment;
    FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mFloatingActionButton = findViewById(R.id.fab);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO change this code instead of hard coding
                Workout workout = new Workout("Week 1 - Monday Workout",
                        "Monday Workout Description");
                mFragment = new WorkoutsDetailFragment(workout);
                mFragmentManager.beginTransaction()
                        .addToBackStack("test")
                        .replace(R.id.fragment_container, mFragment)
                        .commit();
                mFloatingActionButton.setVisibility(View.INVISIBLE);
            }
        });

        updateFragment(WORKOUTS_FRAGMENT);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        if (mFloatingActionButton.getVisibility() == View.INVISIBLE)
            mFloatingActionButton.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_workouts) {
            updateFragment(WORKOUTS_FRAGMENT);
        } else if (id == R.id.nav_stats) {
            updateFragment(STATS_FRAGMENT);
        } else if (id == R.id.nav_groups) {
            updateFragment(GROUPS_FRAGMENT);
        } else if (id == R.id.nav_tips) {
            updateFragment(TIPS_FRAGMENT);
        } else if (id == R.id.nav_settings) {
            updateFragment(SETTINGS_FRAGMENT);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void updateFragment(int fragmentView) {
        if (fragmentView == WORKOUTS_FRAGMENT) {
            mFragment = new WorkoutsFragment();
        } else if (fragmentView == STATS_FRAGMENT) {
            mFragment = new StatsFragment();
        } else if (fragmentView == GROUPS_FRAGMENT) {
            mFragment = new GroupsFragment();
        } else if (fragmentView == TIPS_FRAGMENT) {
            mFragment = new TipsFragment();
        } else if (fragmentView == SETTINGS_FRAGMENT) {
            mFragment = new SettingsFragment();
        }
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .addToBackStack(Integer.toString(fragmentView))
                .replace(R.id.fragment_container, mFragment)
                .commit();

        if (mFloatingActionButton.getVisibility() == View.INVISIBLE)
            mFloatingActionButton.setVisibility(View.VISIBLE);
    }

}
