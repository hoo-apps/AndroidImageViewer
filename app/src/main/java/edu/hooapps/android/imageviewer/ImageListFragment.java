package edu.hooapps.android.imageviewer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ImageListFragment extends Fragment {

    ListView listView;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        initListView(v);
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
    }

    private void initListView(View parent) {
        listView = (ListView) parent.findViewById(R.id.listview);
        listView.setAdapter(new ImageAdapter(context));

        // Set a generic OnItemClickListener to show that touch events still occur on the list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, ((ImageAdapter.ViewHolder) view.getTag()).url, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
