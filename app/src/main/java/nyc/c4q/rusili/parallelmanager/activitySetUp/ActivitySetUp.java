package nyc.c4q.rusili.parallelmanager.activitySetUp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eftimoff.viewpagertransformers.DepthPageTransformer;

import github.chenupt.springindicator.SpringIndicator;
import nyc.c4q.rusili.parallelmanager.R;
import nyc.c4q.rusili.parallelmanager.activitySetUp.questions.FragmentSetUpQuestions;
import nyc.c4q.rusili.parallelmanager.utility.CustomAlertDialog;
import nyc.c4q.rusili.parallelmanager.utility.viewpager.ViewPagerAdapter;

public class ActivitySetUp extends AppCompatActivity implements View.OnClickListener {
    private CustomAlertDialog mCustomAlertDialog = new CustomAlertDialog();
    private ViewPager viewPager;
    private SpringIndicator springIndicator;
    private ViewPagerAdapter viewPagerAdapter;
    private TextView textViewStep;
    private TextView textViewOverview;
    private Button buttonNext;
    private Button buttonPrevious;
    private Button buttonContinue;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        initialize();
    }

    private void initialize () {
        setViews();
        setOnClickListeners();
        setupViewpager();
    }

    private void setOnClickListeners () {
        buttonNext.setOnClickListener(this);
        buttonPrevious.setOnClickListener(this);
        buttonContinue.setOnClickListener(this);
    }

    private void setViews () {
        buttonNext = (Button) findViewById(R.id.activity_setup_button_next);
        buttonPrevious = (Button) findViewById(R.id.activity_setup_button_previous);
        buttonContinue = (Button) findViewById(R.id.activity_setup_button_continue);
        textViewStep = (TextView) findViewById(R.id.activity_setup_textview_step);
        textViewOverview = (TextView) findViewById(R.id.activity_setup_textview_overview);
    }

    public void setupViewpager() {
        viewPager = (ViewPager) findViewById(R.id.activity_setup_viewpager);
        springIndicator = (SpringIndicator) findViewById(R.id.activity_setup_springindicator);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled (int positionP, float positionOffset, int positionOffsetPixels) {
                int position = positionP + 1;
                String stepName = null;
                if (position == 1){
                    stepName = "Event Basics";
                    buttonPrevious.setVisibility(View.INVISIBLE);
                    buttonNext.setVisibility(View.VISIBLE);
                    buttonContinue.setVisibility(View.INVISIBLE);
                } else if (position == 2){
                    stepName = "Date and Time";
                    buttonPrevious.setVisibility(View.VISIBLE);
                    buttonNext.setVisibility(View.VISIBLE);
                    buttonContinue.setVisibility(View.INVISIBLE);
                } else if (position == 3){
                    stepName = "Miscellaneous";
                    buttonPrevious.setVisibility(View.VISIBLE);
                    buttonNext.setVisibility(View.INVISIBLE);
                    buttonContinue.setVisibility(View.VISIBLE);
                }
                textViewStep.setText("Step " + position + " of 4 - " + stepName);
            }

            @Override
            public void onPageSelected (int position) {}
            @Override
            public void onPageScrollStateChanged (int state) {}
        });
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        springIndicator.setViewPager(viewPager);
    }


    @Override
    public void onBackPressed () {
        super.onBackPressed();
    }

    @Override
    public void onClick (View v) {
        switch (v.getId()){
            case R.id.activity_setup_button_previous:
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1, true);
                break;
            case R.id.activity_setup_button_next:
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1, true);
                break;
            case R.id.activity_setup_button_continue:
                toFragmentQuestions();
                break;
        }
    }

    private void toFragmentQuestions () {
        CustomAlertDialog customAlertDialog = new CustomAlertDialog();
        customAlertDialog.confirmReplaceFragment(this, new FragmentSetUpQuestions(), R.id.activity_setup_fragment_container, textViewStep, textViewOverview);
    }
}
