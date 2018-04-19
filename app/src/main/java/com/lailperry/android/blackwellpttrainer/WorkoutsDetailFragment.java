package com.lailperry.android.blackwellpttrainer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.AlarmClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.fitness.Fitness;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class WorkoutsDetailFragment extends Fragment {

    private LinearLayout mLinearLayout;
    private TextView mWorkoutName;
    private TextView mWorkoutDescription;
    private Button mStartTimerButton;
    private Button mBeginRunButton;
    private Workout mWorkout;
    private SharedPreferences mSharedPreferences;
    private ArrayList<CheckBox> mAllCheckboxes = new ArrayList<>();
    private LinearLayout mDividerLine;

    @SuppressLint("ValidFragment")
    public WorkoutsDetailFragment(Workout workout) {
        mWorkout = workout;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_workouts_detail, container, false);

        initializeViews(v);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        setWorkoutCompleteFromPreferences();
        dynamicallyCreateCheckboxes();
        setOnClickListenersToAllCheckboxes();
        setOnClickListenerForBeginRunButton();
        setOnClickListenerForStartTimerButton();

        return v;
    }

    private void setOnClickListenerForStartTimerButton() {
        mStartTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
                startActivity(intent);
            }
        });
    }

    private void setOnClickListenerForBeginRunButton() {
        mBeginRunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = createFitnessIntent();
                startActivity(intent);
            }
        });
    }

    public Intent createFitnessIntent() {
        Intent intent = new Intent(Fitness.ACTION_TRACK);
        intent.setType("vnd.google.fitness.activity/running");
        intent.putExtra("actionStatus", "ActiveActionStatus");
        return intent;
    }

    private void setOnClickListenersToAllCheckboxes() {
        for (final CheckBox checkBox : mAllCheckboxes) {
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean tasksCompleted = allTasksCompleted(mAllCheckboxes);
                    mWorkout.setComplete(tasksCompleted);
                    saveIsCheckedToPreferences(checkBox);
                    saveIsEntireWorkoutCompleteToPreferences(tasksCompleted);
                }
            });
        }
    }

    private void saveIsEntireWorkoutCompleteToPreferences(boolean tasksCompleted) {
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putBoolean(mWorkout.getName(), tasksCompleted);
        edit.apply();
    }

    private void saveIsCheckedToPreferences(CheckBox checkBox) {
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putBoolean(mWorkout.getName() + mAllCheckboxes.indexOf(checkBox), checkBox.isChecked());
        edit.apply();
    }

    private void dynamicallyCreateCheckboxes() {
        int last = getContentSizeFromWorkout() - 1;
        for (int i = 0; i < getContentSizeFromWorkout(); i++) {
            CheckBox checkBox = createFormattedCheckbox(i);
            checkBox.setChecked(isCheckboxChecked(i));
            addCheckboxToLayout(checkBox);
            createNewDividerLine();
            if (i != last)
                addDividerLineToView();
        }
    }

    private void setWorkoutCompleteFromPreferences() {
        mWorkout.setComplete(mSharedPreferences.getBoolean(mWorkout.getName(), false));
    }

    private boolean allTasksCompleted(ArrayList<CheckBox> allCheckboxes) {
        boolean flag = true;
        for (int i = 0; i < allCheckboxes.size(); i++) {
            CheckBox checkBox = allCheckboxes.get(i);
            if (!checkBox.isChecked()) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void initializeViews(View v) {
        mLinearLayout = v.findViewById(R.id.workoutDetailContentLinearLayout);
        mWorkoutName = v.findViewById(R.id.workoutNameTextView);
        mWorkoutName.setText(mWorkout.getName());
        mWorkoutDescription = v.findViewById(R.id.workout_detail_description);
        mWorkoutDescription.setText(mWorkout.getDescription());
        mBeginRunButton = v.findViewById(R.id.beginRunButton);
        mStartTimerButton = v.findViewById(R.id.startTimerButton);
    }

    private int getContentSizeFromWorkout() {
        return mWorkout.getContent().size();
    }

    private CheckBox createFormattedCheckbox(int location) {
        CheckBox checkBox = new CheckBox(getContext());
        checkBox.setText(mWorkout.getContent().get(location));
        checkBox.setPadding(0, 75, 0, 75);
        return checkBox;
    }

    private boolean isCheckboxChecked(int location) {
        return mSharedPreferences.getBoolean(mWorkout.getName() + location, false);
    }

    private void addCheckboxToLayout(CheckBox checkBox) {
        mAllCheckboxes.add(checkBox);
        mLinearLayout.addView(checkBox);
    }

    private void createNewDividerLine() {
        mDividerLine = new LinearLayout(getContext());
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
            mDividerLine.setBackgroundColor(getResources().getColor(R.color.cardview_dark_background));
        } else {
            mDividerLine.setBackgroundColor(getResources().getColor(R.color.cardview_light_background));
        }
        mDividerLine.setMinimumHeight(2);
        mDividerLine.setOrientation(LinearLayout.VERTICAL);
    }

    private void addDividerLineToView() {
        mLinearLayout.addView(mDividerLine);
    }
}
