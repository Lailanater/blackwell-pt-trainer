package com.lailperry.android.blackwellpttrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import android.widget.CalendarView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private static final int WORKOUTS_FRAGMENT = 0;
    private static final int STATS_FRAGMENT = 1;
    private static final int GROUPS_FRAGMENT = 2;
    private static final int TIPS_FRAGMENT = 3;

    android.support.v4.app.FragmentManager mFragmentManager = getSupportFragmentManager();
    Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You clicked on Today's Workout!", Toast.LENGTH_SHORT).show();
            }
        });

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                Toast.makeText(MainActivity.this, "You touched the workout for " + (++month) + "-" + day + "-" + year, Toast.LENGTH_SHORT).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_workouts) {
            Toast.makeText(this.getApplicationContext(), "You clicked on Workouts!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_stats) {
            Toast.makeText(this.getApplicationContext(), "You clicked on Stats!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_groups) {
            Toast.makeText(this.getApplicationContext(), "You clicked on Groups!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_tips) {
            Toast.makeText(this.getApplicationContext(), "You clicked on Tips!", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    /*
     *  This method is not used yet. Must change the structure around a bit.
     */
    private void updateFragment(int fragmentView) {
        if (fragmentView == WORKOUTS_FRAGMENT) {
            mFragment = new WorkoutsFragment();
        } else if (fragmentView == STATS_FRAGMENT) {
            mFragment = new StatsFragment();
        } else if (fragmentView == GROUPS_FRAGMENT){
            mFragment = new GroupsFragment();
        } else if (fragmentView == TIPS_FRAGMENT) {
            mFragment = new TipsFragment();
        }
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .replace(R.id.main_view, mFragment)
                .commit();
    }

}