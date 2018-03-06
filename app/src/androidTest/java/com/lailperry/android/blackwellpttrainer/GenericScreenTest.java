package com.lailperry.android.blackwellpttrainer;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Owner on 3/6/2018.
 */

@RunWith(AndroidJUnit4.class)
public class GenericScreenTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void clickFAB_opensWorkoutsDetailFragment() {
        // Click the FloatingActionButton
        onView(withId(R.id.fab))
                .perform(click());

        // Make sure the WorkoutsDetailFragment is visible
        onView(withId(R.id.workoutsDetailLinearLayout))
                .check(matches(isDisplayed()));
    }

    @Test
    public void exitTodayWorkout_showsWorkoutsFragment() {
        // Open WorkoutsDetailFragment through FAB
        clickFAB_opensWorkoutsDetailFragment();

        // Press the back button on WorkoutsDetailFragment view
        onView(withId(R.id.workoutsDetailLinearLayout))
                .perform(pressBack());

        // Make sure WorkoutsFragment is displayed
        onView(withId(R.id.workouts_recycler_view))
                .check(matches(isDisplayed()));
    }
}
