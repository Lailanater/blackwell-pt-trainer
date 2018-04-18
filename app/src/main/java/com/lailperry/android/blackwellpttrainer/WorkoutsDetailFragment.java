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

    @SuppressLint("ValidFragment")
    public WorkoutsDetailFragment(Workout workout) {
        mWorkout = workout;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_workouts_detail, container, false);

        mLinearLayout = v.findViewById(R.id.workoutDetailContentLinearLayout);
        mWorkoutName = v.findViewById(R.id.workoutNameTextView);
        mWorkoutName.setText(mWorkout.getName());
        mWorkoutDescription = v.findViewById(R.id.workout_detail_description);
        mWorkoutDescription.setText(mWorkout.getDescription());
        int size = mWorkout.getContent().size();
        final ArrayList<CheckBox> allCheckboxes = new ArrayList<>();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        mWorkout.setComplete(preferences.getBoolean(mWorkout.getName(), false));
        for (int i = 0; i < size; i++) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(mWorkout.getContent().get(i));
            checkBox.setPadding(0, 75, 0, 75);
            boolean checked = preferences.getBoolean(mWorkout.getName() + i, false);
            checkBox.setChecked(checked);
            allCheckboxes.add(checkBox);
            mLinearLayout.addView(checkBox);
            LinearLayout line = new LinearLayout(getContext());
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                line.setBackgroundColor(getResources().getColor(R.color.cardview_dark_background));
            } else {
                line.setBackgroundColor(getResources().getColor(R.color.cardview_light_background));
            }
            line.setMinimumHeight(2);
            line.setOrientation(LinearLayout.VERTICAL);
            if (i != size - 1)
                mLinearLayout.addView(line);
        }
        for (int i = 0; i < allCheckboxes.size(); i++) {
            final CheckBox checkBox = allCheckboxes.get(i);
            final int finalI = i;
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean tasksCompleted = allTasksCompleted(allCheckboxes);
                    mWorkout.setComplete(tasksCompleted);
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    SharedPreferences.Editor edit = preferences.edit();
                    edit.putBoolean(mWorkout.getName() + finalI, checkBox.isChecked());
                    edit.putBoolean(mWorkout.getName(), tasksCompleted);
                    edit.apply();
                }
            });
        }
        mBeginRunButton = v.findViewById(R.id.beginRunButton);
        mBeginRunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fitness.ACTION_TRACK);
                intent.setType("vnd.google.fitness.activity/running");
                intent.putExtra("actionStatus", "ActiveActionStatus");
                startActivity(intent);
            }
        });
        mStartTimerButton = v.findViewById(R.id.startTimerButton);
        mStartTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
                startActivity(intent);
            }
        });

        return v;
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

}
