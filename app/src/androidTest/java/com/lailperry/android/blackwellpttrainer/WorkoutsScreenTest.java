package com.lailperry.android.blackwellpttrainer;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Owner on 3/6/2018.
 */

@RunWith(AndroidJUnit4.class)
public class WorkoutsScreenTest {

    @Rule
    public ActivityTestRule<MainActivity> mWorkoutsTestRule =
        new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void isWorkoutsFragmentVisible() {
        // Make sure the Workouts list is shown
        onView(withId(R.id.workouts_recycler_view))
                .check(matches(isDisplayed()));

        // Make sure the FloatingActionButton is displayed
        onView(withId(R.id.fab))
                .check(matches(isDisplayed()));

        // Make sure the DrawerLayout is visible
        onView(withId(R.id.drawer_layout))
                .check(matches(isDisplayed()));
    }
}
