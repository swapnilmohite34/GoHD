package com.example.swapnil.gohd;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.AdapterView;
import android.content.Intent;
import android.view.View;
/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment{



    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View fragmentView = inflater.inflate(R.layout.fragment_fragment1, container, false);
            GridView gridView = (GridView) fragmentView.findViewById(R.id.grid_view);
            gridView.setAdapter(new ImageAdaptor(getActivity()));
            gridView.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {

                    // Sending image id to FullScreenActivity
                    Intent i = new Intent(getActivity(), DetailsActivity.class);
                    // passing array index
                    i.putExtra("id", position);
                    startActivity(i);
                }
            });
            return fragmentView;

    }
        // Prepare some dummy data for gridview



    }






