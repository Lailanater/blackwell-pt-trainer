package com.lailperry.android.blackwellpttrainer;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment {

    private LinearLayout mLinearLayout;
    private TextView mSummary;
    private Button mLink;

    public TipsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tips, container, false);

        final String armyWebsite = "https://www.goarmy.com/content/dam/goarmy/downloaded_assets/pt_guide/pocket-pt-guide.pdf";
        mLinearLayout = v.findViewById(R.id.tipsLinearLayout);
        mSummary = v.findViewById(R.id.tipsSummary);
        mSummary.setText("For warmup routines, tips, workout demonstrations, and proper safety we strongly" +
                "recommend that you download and review the GoArmy Pocket PT Guide. You can download the pdf below.\n\n");
        mLink = v.findViewById(R.id.tipsDownloadButton);
        mLink.setText("Download PT Guide");
        mLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(armyWebsite));
                startActivity(intent);
            }
        });
        return v;
    }

}
