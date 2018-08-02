package com.lailperry.android.blackwellpttrainer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int WORKOUTS_FRAGMENT = 0;
    private static final int STATS_FRAGMENT = 1;
    private static final int GROUPS_FRAGMENT = 2;
    private static final int TIPS_FRAGMENT = 3;
    private static final int SETTINGS_FRAGMENT = 4;
    public static WorkoutDatabase mDB;
    private android.support.v4.app.FragmentManager mFragmentManager = getSupportFragmentManager();
    private SharedPreferences mSharedPreferences;
    private Fragment mFragment;
    private FloatingActionButton mFloatingActionButton;
    private ArrayList<Workout> mWorkouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int mode = mSharedPreferences.getInt("NIGHT_MODE", AppCompatDelegate.MODE_NIGHT_YES);
        AppCompatDelegate.setDefaultNightMode(mode);

        if (savedInstanceState == null) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

            recreate();
        }

        mDB = new WorkoutDatabase(this);

        mWorkouts = WorkoutsList.getInstance().getWorkouts();

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
                mFragment = new WorkoutsDetailFragment(mWorkouts.get(0));
                for (int i = 0; i < mWorkouts.size(); i++) {
                    Workout workout = mWorkouts.get(i);
                    workout.setComplete(mSharedPreferences.getBoolean(workout.getName(), false));
                    if (!workout.isComplete()) {
                        mFragment = new WorkoutsDetailFragment(workout);
                        break;
                    }
                }
                mFragmentManager.beginTransaction()
                        .addToBackStack("test")
                        .replace(R.id.fragment_container, mFragment)
                        .commit();
                mFloatingActionButton.setVisibility(View.INVISIBLE);
            }
        });

        try {
            updateFragment(WORKOUTS_FRAGMENT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        try {
            if (!mFragment.equals(new WorkoutsFragment())) {
                for (int i = 0; i < mFragmentManager.getBackStackEntryCount(); i++) {
                    mFragmentManager.popBackStack();
                }
                updateFragment(WORKOUTS_FRAGMENT);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        setFloatingActionButtonVisibility();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_workouts:
                try {
                    updateFragment(WORKOUTS_FRAGMENT);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.nav_tips:
                try {
                    updateFragment(TIPS_FRAGMENT);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.nav_settings:
                try {
                    updateFragment(SETTINGS_FRAGMENT);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void updateFragment(int fragmentView) throws JSONException {
        setFragmentFromFragmentView(fragmentView);

        if (fragmentView != WORKOUTS_FRAGMENT) {
            mFragmentManager.beginTransaction()
                    .addToBackStack(Integer.toString(fragmentView))
                    .replace(R.id.fragment_container, mFragment)
                    .commit();
        } else {
            mFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, mFragment)
                    .commit();
        }

        setFloatingActionButtonVisibility();
    }

    private void setFloatingActionButtonVisibility() {
        if (mFloatingActionButton.getVisibility() == View.INVISIBLE)
            mFloatingActionButton.setVisibility(View.VISIBLE);
    }

    private void setFragmentFromFragmentView(int fragmentView) throws JSONException {
        switch (fragmentView) {
            case WORKOUTS_FRAGMENT:
                mFragment = new WorkoutsFragment();
                break;
            case STATS_FRAGMENT:
                mFragment = new StatsFragment();
                break;
            case GROUPS_FRAGMENT:
                mFragment = new GroupsFragment();
                break;
            case TIPS_FRAGMENT:
                mFragment = new TipsFragment();
                break;
            case SETTINGS_FRAGMENT:
                mFragment = new SettingsFragment();
                break;
        }
    }

}
