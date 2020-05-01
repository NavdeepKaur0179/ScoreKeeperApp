package com.app.scorekeeperapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String STATE_SCORE_A = "Team A Score";
    static final String STATE_SCORE_B = "Team B Score";

    // Member variables for holding the score
    private int mScoreA;
    private int mScoreB;
    private TextView mScoreTextA;
    private TextView mScoreTextB;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        // Save the scores.
        outState.putInt(STATE_SCORE_A, mScoreA);
        outState.putInt(STATE_SCORE_B, mScoreB);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScoreTextA = (TextView) findViewById(R.id.scoreTeamA);
        mScoreTextB = (TextView) findViewById(R.id.scoreTeamB);
        if (savedInstanceState != null) {
            mScoreA = savedInstanceState.getInt(STATE_SCORE_A);
            mScoreB = savedInstanceState.getInt(STATE_SCORE_B);

            //Set the score text views
            mScoreTextA.setText(String.valueOf(mScoreA));
            mScoreTextB.setText(String.valueOf(mScoreB));
        }
    }

    public void decreaseScore(View view) {
        switch (view.getId()) {
            case R.id.decreaseTeamA:
                if(mScoreA==0)
                {
                    Toast.makeText(this,"Cannot be reduced less than zero",Toast.LENGTH_SHORT).show();
                }
                else {
                    mScoreA--;
                    mScoreTextA.setText(String.valueOf(mScoreA));
                }
                break;
            case R.id.decreaseTeamB:
                if(mScoreB==0)
                {
                    Toast.makeText(this,"Cannot be reduced less than Zero",Toast.LENGTH_SHORT).show();
                }
                else {
                    mScoreB--;
                    mScoreTextB.setText(String.valueOf(mScoreB));
                }
        }
    }

    public void increaseScore(View view) {
        switch (view.getId()) {
            case R.id.increaseTeamA:
                mScoreA++;
                mScoreTextA.setText(String.valueOf(mScoreA));
                break;
            case R.id.increaseTeamB:
                mScoreB++;
                mScoreTextB.setText(String.valueOf(mScoreB));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if (item.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
// Recreate the activity for the theme change to take effect.
            recreate();
        }
        return true;
    }
}
