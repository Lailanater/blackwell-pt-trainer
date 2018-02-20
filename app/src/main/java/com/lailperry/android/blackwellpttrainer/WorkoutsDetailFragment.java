package com.lailperry.android.blackwellpttrainer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutsDetailFragment extends Fragment {

    private TextView mWorkoutName;
    private Button mReadyButton;
    private Workout mWorkout;

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
        mReadyButton = v.findViewById(R.id.readyButton);
        mReadyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Today's Workout is now starting!", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}
