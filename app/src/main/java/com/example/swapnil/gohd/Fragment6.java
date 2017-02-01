package com.example.swapnil.gohd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by SWAPNIL on 28-Mar-16.
 */
public class Fragment6 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_fragment1, container, false);
        GridView gridView = (GridView) fragmentView.findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdaptor5(getActivity()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getActivity(), DetailsActivity5.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
        return fragmentView;

    }
}
