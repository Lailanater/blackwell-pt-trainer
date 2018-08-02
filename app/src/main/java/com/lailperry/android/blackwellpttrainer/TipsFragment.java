package com.lailperry.android.blackwellpttrainer;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tips, container, false);

        final String armyWebsite = "https://www.goarmy.com/content/dam/goarmy/downloaded_assets/pt_guide/pocket-pt-guide.pdf";
        findAllViewsById(v);
        mSummary.setText("For warmup routines, tips, workout demonstrations, and proper safety we strongly" +
                "recommend that you download and review the GoArmy Pocket PT Guide. You can download the pdf below.\n\n");
        mLink.setText("Download PT Guide");
        mLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadArmyPDFFromWebsite(armyWebsite);
            }
        });
        return v;
    }

    private void downloadArmyPDFFromWebsite(String armyWebsite) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(armyWebsite));
        startActivity(intent);
    }

    private void findAllViewsById(View v) {
        mLinearLayout = v.findViewById(R.id.tipsLinearLayout);
        mSummary = v.findViewById(R.id.tipsSummary);
        mLink = v.findViewById(R.id.tipsDownloadButton);
    }

}
