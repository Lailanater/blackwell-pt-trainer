package com.lailperry.android.blackwellpttrainer;

import java.util.ArrayList;

class WorkoutsList {
    private static final WorkoutsList ourInstance = new WorkoutsList();
    private ArrayList<Workout> mWorkouts;
    private boolean isPopulated;

    private WorkoutsList() {
        mWorkouts = new ArrayList<>();
        isPopulated = false;
    }

    public static WorkoutsList getInstance() {
        return ourInstance;
    }

    public ArrayList<Workout> getWorkouts() {
        return mWorkouts;
    }

    public void setWorkouts(ArrayList<Workout> workouts) {
        mWorkouts = workouts;
    }

    public boolean isPopulated() {
        return isPopulated;
    }

    public void setPopulated(boolean populated) {
        isPopulated = populated;
    }
}
