package com.lailperry.android.blackwellpttrainer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import java.util.Objects;

/**
 * Created by Owner on 2/20/2018.
 */

public class SettingsFragment extends Fragment {

    private Switch mThemeSwitch;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        mThemeSwitch = v.findViewById(R.id.themeSwitch);
        setThemeSwitchBasedOnPreferences();

        mThemeSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateThemeSwitchWhenClicked();
                saveNightModeToPreferences();
                Objects.requireNonNull(getActivity()).recreate();
            }
        });

        return v;
    }

    private void saveNightModeToPreferences() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt("NIGHT_MODE", AppCompatDelegate.getDefaultNightMode());
        edit.apply();
    }

    private void updateThemeSwitchWhenClicked() {
        boolean checked = mThemeSwitch.isChecked();
        if (checked)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    private void setThemeSwitchBasedOnPreferences() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
            mThemeSwitch.setChecked(true);
        }
    }
}
