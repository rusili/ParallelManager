package nyc.c4q.rusili.parallelmanager.activityMonitor.notifications;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.rusili.parallelmanager.R;

public class FragmentMonitorNotifications extends Fragment implements FragmentMonitorNotificationsContract.View{
    private View mView;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_setup_start1, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setPresenter (FragmentMonitorNotificationsContract.Presenter presenter) {
        
    }

    @Override
    public void initialize () {

    }

    @Override
    public void setViews () {

    }
}
