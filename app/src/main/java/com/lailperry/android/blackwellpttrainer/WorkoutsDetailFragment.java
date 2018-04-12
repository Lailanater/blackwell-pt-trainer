package com.lailperry.android.blackwellpttrainer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.fitness.Fitness;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class WorkoutsDetailFragment extends Fragment {

    private TextView mWorkoutName;
    private TextView mWorkoutDescription;
    private TextView mWorkoutContent;
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

        mWorkoutName = v.findViewById(R.id.workoutNameTextView);
        mWorkoutName.setText(mWorkout.getName());
        mWorkoutDescription = v.findViewById(R.id.workout_detail_description);
        mWorkoutDescription.setText(mWorkout.getDescription());
        mWorkoutContent = v.findViewById(R.id.workout_detail_content);
        mWorkoutContent.setText(mWorkout.getContent());
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

}
