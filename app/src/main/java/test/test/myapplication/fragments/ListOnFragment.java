package test.test.myapplication.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.test.myapplication.R;

/**
 * Created by BruSD on 10/9/2014.
 */
public class ListOnFragment extends Fragment{
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_with_list_layout, container, false);
        return rootView;
    }
}
