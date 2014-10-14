package test.test.myapplication.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import test.test.myapplication.R;

/**
 * Created by BruSD on 10/9/2014.
 */
public class ListOnFragment extends Fragment{
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_with_list_layout, container, false);
        TextView sendBroadTextView = (TextView)rootView.findViewById(R.id.send_broad_text_view);
        sendBroadTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent("SendMess111");
                intent.putExtra("messsss", "Поле было кликнуто!");
                getActivity().sendBroadcast(intent);
            }
        });
        return rootView;
    }
}
