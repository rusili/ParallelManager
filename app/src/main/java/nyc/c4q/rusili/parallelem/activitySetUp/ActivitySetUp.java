package nyc.c4q.rusili.parallelem.activitySetUp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import nyc.c4q.rusili.parallelem.R;
import nyc.c4q.rusili.parallelem.activitySetUp.questions.FragmentSetUpQuestions;
import nyc.c4q.rusili.parallelem.activitySetUp.start.FragmentSetUpStart;
import nyc.c4q.rusili.parallelem.utility.CustomAlertDialog;
import nyc.c4q.rusili.parallelem.utility.CustomSoundEffects;

public class ActivitySetUp extends AppCompatActivity {
    private int containerID = R.id.activity_monitor_fragment_container;
    private CustomSoundEffects mCustomSoundEffects;
    private CustomAlertDialog mCustomAlertDialog = new CustomAlertDialog();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        initialize();

        loadFragmentStart();
    }

    private void initialize () {
        mCustomSoundEffects = new CustomSoundEffects(getWindow().getDecorView().getRootView());
    }

    private void loadFragmentStart () {
        FragmentSetUpStart fragmentSetUpStart = new FragmentSetUpStart();
        getSupportFragmentManager().beginTransaction()
                .replace(containerID, fragmentSetUpStart)
                .commit();
    }

    private void loadFragmentSetUpQuestions () {
        FragmentSetUpQuestions fragmentSetUpQuestions = new FragmentSetUpQuestions();
        getSupportFragmentManager().beginTransaction()
                .replace(containerID, fragmentSetUpQuestions)
                .commit();
    }

    @Override
    public void onBackPressed () {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(containerID);
        if (currentFragment instanceof FragmentSetUpStart) {
            mCustomAlertDialog.exit(this);
        } else {
            super.onBackPressed();
        }
    }

    public void onClickToSetUpQuestions (View view) {
        mCustomSoundEffects.setDefaultClick();
        loadFragmentSetUpQuestions();
    }
}
