package com.lailperry.android.blackwellpttrainer;


import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void fragmentTest() {

        // Check that the FAB is visible and then click it
        onView(withId(R.id.fab))
                .check(matches(isDisplayed()))
                .perform(click());

        // Check that the WorkoutsDetailLinearLayout is visible.
        onView(withId(R.id.workoutsDetailLinearLayout))
                .check(matches(isDisplayed()));

        // Check that the begin workout button is displayed and click it
        onView(withId(R.id.beginWorkoutButton))
                .check(matches(isDisplayed()))
                .perform(click());

        // Make sure the FAB is not visible since we're in the current workout layout
        onView(withId(R.id.fab))
                .check(matches(not(isDisplayed())));

        pressBack();

        // Make sure that it brings us back to the main workouts page
        onView(withId(R.id.workouts_recycler_view))
                .check(matches(isDisplayed()));

        // Click on the second tab in the nav drawer (Stats)
        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.AppBarLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuItemView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        2),
                        isDisplayed()));
        navigationMenuItemView.perform(click());

        // Check that the stats page is displayed
        onView(withId(R.id.statsFrameLayout))
                .check(matches(isDisplayed()));

        // Make sure the FAB is displayed
        onView(withId(R.id.fab))
                .check(matches(isDisplayed()));

        // Click on the third nav drawer tab (Groups)
        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.AppBarLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction navigationMenuItemView2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        3),
                        isDisplayed()));
        navigationMenuItemView2.perform(click());

        // Make sure the groups page is displayed
        onView(withId(R.id.groupsLayout))
                .check(matches(isDisplayed()));

        // Make sure the FAB is displayed
        onView(withId(R.id.fab))
                .check(matches(isDisplayed()));

        // Click on the fourth tab (Tips)
        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.AppBarLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction navigationMenuItemView3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        4),
                        isDisplayed()));
        navigationMenuItemView3.perform(click());

        // Make sure that the tips page is displayed
        onView(withId(R.id.tipsFrameLayout))
                .check(matches(isDisplayed()));

        // Make sure that the FAB is displayed
        onView(withId(R.id.fab))
                .check(matches(isDisplayed()));


        // Click on the fifth tab in the nav drawer (Settings)
        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.AppBarLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction navigationMenuItemView4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        5),
                        isDisplayed()));
        navigationMenuItemView4.perform(click());

        // Make sure that the settings page is displayed
        onView(withId(R.id.settingsLayout))
                .check(matches(isDisplayed()));

        // Make sure that the FAB is displayed
        onView(withId(R.id.fab))
                .check(matches(isDisplayed()));

        pressBack();

        // After pressing the back button make sure that it takes us back to the Workouts page
        onView(withId(R.id.workouts_recycler_view))
                .check(matches(isDisplayed()));

        // Make sure that the FAB is displayed
        onView(withId(R.id.fab))
                .check(matches(isDisplayed()));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
