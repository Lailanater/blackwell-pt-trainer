package com.lailperry.android.blackwellpttrainer;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * Created by Owner on 3/6/2018.
 */

@RunWith(AndroidJUnit4.class)
public class WorkoutsScreenTest {

    @Rule
    public ActivityTestRule<MainActivity> mWorkoutsTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);
}
