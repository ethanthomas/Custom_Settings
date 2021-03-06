package com.example.customsettingsexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.ImageButton;

public class Settings extends PreferenceActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.layout.settings);

        setContentView(R.layout.custom_preferences); // uses the listview in custom_preferences as the preferenceresource

        ImageButton share = (ImageButton) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = “This is my app <insert_url_here>”;
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share To:"));

            }
        });

        ImageButton rate = (ImageButton) findViewById(R.id.rate);
        rate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(“<insert_link_to_app_here”)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(“<insert_link_to_app_here”)));
                }

            }
        });

        ImageButton apps = (ImageButton) findViewById(R.id.apps);
        apps.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(“<insert_developer_id_here>”)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(“<insert_developer_id_here>”)));
                }

            }
        });

    }
}
