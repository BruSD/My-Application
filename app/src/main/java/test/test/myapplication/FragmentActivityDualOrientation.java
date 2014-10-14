package test.test.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

import test.test.myapplication.fragments.DeteilsFragment;
import test.test.myapplication.fragments.ListOnFragment;


public class FragmentActivityDualOrientation extends Activity {
    private FragmentMessBroadcastReceiver fragmentMessBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_activity_dual_orientation);

        fragmentMessBroadcastReceiver =  new FragmentMessBroadcastReceiver();

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

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction("SendMess111");
        registerReceiver(fragmentMessBroadcastReceiver, filter);
    }

    class FragmentMessBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("SendMess111")) {
                String mess = intent.getStringExtra("messsss");

                Toast.makeText(context, "" + mess, Toast.LENGTH_LONG).show();



            }
        }
    }
}
