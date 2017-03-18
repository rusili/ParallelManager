package nyc.c4q.rusili.parallelmanager.activitySetUp.questions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import nyc.c4q.rusili.parallelmanager.R;

public class FragmentSetUpQuestions extends Fragment implements View.OnClickListener, FragmentSetUpQuestionsContract.View{
    private View mView;
    private Button buttonNext;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_setup_questions, container, false);
        return mView;
    }

    @Override
    public void setPresenter (FragmentSetUpQuestionsContract.Presenter presenter) {

    }

    @Override
    public void initialize () {
        setViews();
        setOnClickListeners();
    }

    @Override
    public void setViews () {
        buttonNext = (Button) mView.findViewById(R.id.fragment_setup_questions_button_next);
    }

    private void setOnClickListeners(){
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        switch (v.getId()){
            case (R.id.fragment_setup_questions_button_next): {
                break;
            }
        }
    }
}
