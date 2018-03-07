package com.lailperry.android.blackwellpttrainer;

import android.support.design.internal.NavigationMenu;
import android.support.design.internal.NavigationMenuItemView;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.view.Gravity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
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

    @Test
    public void isScrollable() {
        onView(withId(R.id.workouts_recycler_view))
                .perform(swipeUp())
                .perform(swipeDown());
    }
}
