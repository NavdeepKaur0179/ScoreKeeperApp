# ScoreKeeperApp

This app displays score of two teams.Team A and Team B. The Plus Image Button increase the score and minus image button decrease the score. 
This app also has a Night Mode Option. It has been implemented using the user preffered mode on the mobile device

This project illustrates the use of
vector assets
ShapeDrawables
Styles-extracting,defining,adding parent style.
Theme for whole app

For night mode in MainActivity 
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

//Drawable Selectors
To change button background and img src on pressed, sample code

<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:state_focused="true"
        android:state_pressed="true"
        android:drawable="@drawable/button_selected" />

    <item
        android:state_focused="false"
        android:state_pressed="false"
        android:drawable="@drawable/button_unselected"
        android:color="@android:color/white"/>

    <item android:drawable="@drawable/button_selected" />
</selector>

<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:state_focused="true"
        android:state_pressed="true"
        android:drawable="@drawable/ic_remove_white" />

    <item
        android:state_focused="false"
        android:state_pressed="false"
        android:drawable="@drawable/ic_remove" />

    <item android:drawable="@drawable/ic_remove_white" />
</selector>
