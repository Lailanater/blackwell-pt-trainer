package com.lailperry.android.blackwellpttrainer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private WorkoutsAdapter mAdapter;
    private static ArrayList<Workout> mWorkouts;

    public WorkoutsFragment() {
        populateData();
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

    public static ArrayList<Workout> getWorkouts() {
        return mWorkouts;
    }

    private void updateUI() {
        mAdapter = new WorkoutsAdapter(mWorkouts);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void populateData() {
        mWorkouts = new ArrayList<>();
        String name = "Monday Workout - Week 1";
        String description = "Sprint workout # 1 Ladder and Push-ups Ladder\n";
        String content = "Run 400m then Walk 400m\n\n" +
                "Run 300m then Walk 300m\n\n" +
                "Run 200m then Walk 200m\n\n" +
                "Run 100m then walk 100m  Then back up the Ladder  (I.E. 100m again then 200, 300, 400, end)\n\n" +
                "\n" +
                "Push-ups: ladder by time\n\n" +
                "Max Push-ups for two minutes, rest two minutes\n\n" +
                "Max Push-ups for One minute and 30 seconds, rest 1.5 minutes\n\n" +
                "Max Push-ups for one minute, rest one minute\n\n" +
                "Max Push-ups for 30 seconds, rest 30 seconds then back up the ladder same as the run.\n";
        Workout workout = new Workout(name, description, content);
        mWorkouts.add(workout);

        name = "Tuesday Workout - Week 1";
        description = "Core work and squats\n";
        content = "5 rounds of the following, rest two minutes in between rounds.\n\n" +
                "15 squats\n\n" +
                "10 sit ups\n\n" +
                "20 crunches\n\n" +
                "20 leg lifts \n\n" +
                "20 Russian twist\n\n" +
                "30 Bicycles\n";
        workout = new Workout(name, description, content);
        mWorkouts.add(workout);

        name = "Thursday Workout - Week 1";
        description = "Sprint workout #2 Sprint/ Jog for distance and Push-ups for reps\n";
        content = "Sprint 100m, Jog 100m until you complete a mile\n\n" +
                "The distance increase by half a mile each week until you reach 3 miles." +
                " Keep the miles down until you can keep the Sprint’s and Jog Segments consistent.\n\n";
        workout = new Workout(name, description, content);
        mWorkouts.add(workout);

        name = "Friday Workout - Week 1";
        description = "EARN THE WEEKEND Sprint workout # 3/ Core/ Push-ups\n";
        content = "Sprints: 100’s for time, 15 min cap\n\n" +
                "Set a 15 min running clock and sprint for 100m then walk back  to the start," +
                " immediately sprint again. Repeat this until the clock runs down." +
                " Your score is total sprints, try and beat this number next time. \n\n" +
                "Core and Pushups\n\n" +
                "As many rounds as possible in 10 minutes\n\n" +
                "\t10 sit ups\n\n" +
                "\t10 push-ups\n\n";
        workout = new Workout(name, description, content);
        mWorkouts.add(workout);

        name = "Monday Workout - Week 2";
        description ="Sprints/ Push ups\n";
        content = "Sprints: “Thirty Sixty’s”\n\n" +
                "6 rounds\n\n" +
                "Sprint 30 seconds\n\n" +
                "Walk 60 seconds\n\n" +
                "Push-ups:  Ladder by reps \n\n" +
                "For the first set do your max number of push-ups from Monday of last week, rest two minutes\n\n" +
                "The second set will be 75% of this number, rest 1.5 minutes\n\n" +
                "50% for the 3rd set, rest 1 minute\n\n" +
                "25% for the 4th set , rest 30 seconds, then back up the ladder starting with the 25% set.\n\n" +
                "Example:  if I did 40 push-ups in two  minutes last week, then my next set will be 30, then 20, then 10 and so on. ";
        workout = new Workout(name, description, content);
        mWorkouts.add(workout);

        name = "Tuesday Workout - Week 2";
        description = "Core/ legs\n";
        content = "-As many rounds as possible in 5 min                                                       \n\n" +
                "\t10 sit ups\n\n" +
                "\t10 frog Jumps\n\n" +
                "\t10 ankle touch with a twist\n\n" +
                "Once five minutes is up, rest 3 minutes\n\n\n" +
                "-As many rounds as possible in 5 minutes\n\n" +
                "\t10 crunches\n\n" +
                "\t20m duck walks\n\n" +
                "\t10 Russian twists\n\n" +
                "Once five minutes is up, rest 3 minutes\n\n\n" +
                "-As many rounds as possible in 5 minutes \n\n" +
                "\t10 sit ups\n\n" +
                "\t10 walking lunges with a twist\n\n" +
                "\t10 toe touches\n\n" +
                "Once five minutes is up, rest 3 minutes\n\n\n" +
                "-As many rounds as possible in 5 minutes\n\n" +
                "\t20 flutter kicks\n\n" +
                "\t20m bear crawl\n\n" +
                "\t20 leg raises\n\n";
        workout = new Workout(name, description, content);
        mWorkouts.add(workout);

        name = "Thursday Workout - Week 2";
        description = " Sprints/ Push ups\n";
        content = "Sprints: “Sixty One Twenty's” \n\n" +
                "6 rounds\n\n" +
                "All out Sprint for sixty seconds walk for two minutes.\n\n" +
                "Push-ups: \n\n" +
                "Push-ups to failure, jog 200m every time your knees touch the ground. Do this until you have completed 80 push ups\n";
        workout = new Workout(name, description, content);
        mWorkouts.add(workout);

        name = "Friday Workout - Week 2";
        description = "EARN THE WEEKEND. Run recovery and bodyweight challenge\n";
        content = "Run 2 miles, you choose the pace but try out those new legs and put some speed on it from time to time." +
                " You’re working on running fast for a relatively short time, not slow and long, the difference is mechanics," +
                " so you need to pretend you’re sprinting conservatively this will cause you to lead with your body and propel" +
                " you forward unless you aim on leaving some teeth on the greenway.";
        workout = new Workout(name, description, content);
        mWorkouts.add(workout);

        for (Workout w : mWorkouts) {
            MainActivity.mDB.insertData(w.getName(), w.getDescription(), w.getContent(), w.isComplete());
        }
    }

    private class WorkoutsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mWorkoutName;
        private TextView mWorkoutDescription;
        private Workout mWorkout;

        public WorkoutsHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.workouts_list, parent, false));
            itemView.setOnClickListener(this);

            mWorkoutName = itemView.findViewById(R.id.workout_name);
            mWorkoutDescription = itemView.findViewById(R.id.workout_description);
        }

        @Override
        public void onClick(View view) {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, new WorkoutsDetailFragment(mWorkout))
                    .addToBackStack("WorkoutsDetailFragment")
                    .commit();
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
