package com.lailperry.android.blackwellpttrainer;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Owner on 2/13/2018.
 */

class Workout {

    private String mName;
    private String mDescription;
    private ArrayList<String> mContent;
    private boolean mComplete;
    private UUID id;

    public Workout(String workoutName, String workoutDescription, ArrayList<String> workoutContent) {
        mName = workoutName;
        mDescription = workoutDescription;
        mContent = workoutContent;
        mComplete = false;
        id = UUID.randomUUID();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public ArrayList<String> getContent() {
        return mContent;
    }

    public void setContent(ArrayList<String> content) {
        mContent = content;
    }

    public boolean isComplete() {
        return mComplete;
    }

    public void setComplete(boolean complete) {
        mComplete = complete;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
