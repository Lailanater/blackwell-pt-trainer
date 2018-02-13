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
        for (int i = 0; i < 100; i++){
            workouts.add(new Workout());
        }
        mAdapter = new WorkoutsAdapter(workouts);
        mRecyclerView.setAdapter(mAdapter);
    }

    private class WorkoutsHolder extends RecyclerView.ViewHolder {
        public WorkoutsHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.workouts_list, parent, false));
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

        }

        @Override
        public int getItemCount() {
            return mWorkoutList.size();
        }

    }

}
