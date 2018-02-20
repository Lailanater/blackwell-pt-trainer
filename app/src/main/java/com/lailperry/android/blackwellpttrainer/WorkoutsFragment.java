package com.lailperry.android.blackwellpttrainer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private WorkoutsAdapter mAdapter;

    public WorkoutsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_workouts, container, false);

        mRecyclerView = v.findViewById(R.id.workouts_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }

    private void updateUI() {
        // Dummy code
        List<Workout> workouts = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            workouts.add(new Workout("Week " + (i+1) + " - Monday Workout",
                    "Monday Workout Description"));
            workouts.add(new Workout("Week " + (i+1) + " - Tuesday Workout",
                    "Tuesday Workout Description"));
            workouts.add(new Workout("Week " + (i+1) + " - Thursday Workout",
                    "Thursday Workout Description"));
            workouts.add(new Workout("Week " + (i+1) + " - Friday Workout",
                    "Friday Workout Description"));
        }
        mAdapter = new WorkoutsAdapter(workouts);
        mRecyclerView.setAdapter(mAdapter);
    }

    private class WorkoutsHolder extends RecyclerView.ViewHolder {

        private TextView mWorkoutName;
        private TextView mWorkoutDescription;
        private Workout mWorkout;

        public WorkoutsHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.workouts_list, parent, false));

            mWorkoutName = itemView.findViewById(R.id.workout_name);
            mWorkoutDescription = itemView.findViewById(R.id.workout_description);
        }

        public void bind(Workout workout) {
            mWorkout = workout;

            mWorkoutName.setText(mWorkout.getName());
            mWorkoutDescription.setText(mWorkout.getDescription());
        }
    }

    private class WorkoutsAdapter extends RecyclerView.Adapter<WorkoutsHolder> {

        private List<Workout> mWorkoutList;

        public WorkoutsAdapter(List<Workout> workoutList) {
            mWorkoutList = workoutList;
        }

        @Override
        public WorkoutsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new WorkoutsHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(WorkoutsHolder holder, int position) {
            Workout item = mWorkoutList.get(position);
            holder.bind(item);
        }

        @Override
        public int getItemCount() {
            return mWorkoutList.size();
        }

        public void setWorkoutList(List<Workout> workoutList) {
            mWorkoutList = workoutList;
        }

    }

}
