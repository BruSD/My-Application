package test.test.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import test.test.myapplication.fragments.DeteilsFragment;
import test.test.myapplication.fragments.ListOnFragment;


public class FragmentActivityDualOrientation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_activity_dual_orientation);

        int orient = this.getResources().getConfiguration().orientation;
        if (orient == 1) {
            //Portret
            final Fragment fragment = new ListOnFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.frame_one, fragment);
            ft.commitAllowingStateLoss();
        } else {
            //LANDSCAPE;
            final Fragment fragment = new DeteilsFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.frame_one, fragment);
            ft.commitAllowingStateLoss();
        }

    }


}
