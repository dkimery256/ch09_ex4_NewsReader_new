package com.kimery.newsreader;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.net.Uri;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.content.Intent;


public class ItemFragment extends Fragment implements OnClickListener {

    FragListener activityCommander;

    public ItemFragment() {
        // Required empty public constructor
    }

    public interface  FragListener{

    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            activityCommander =(FragListener) activity;

        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item, container, false);

        // get references to widgets
        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        TextView pubDateTextView = (TextView) view.findViewById(R.id.pubDateTextView);
        TextView descriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);
        TextView linkTextView = (TextView) view.findViewById(R.id.linkTextView);

        // get the intent
        Intent intent = getActivity().getIntent();

        // get data from the intent
        String pubDate = intent.getStringExtra("pubdate");
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description").replace('\n', ' ');

        // display data on the widgets
        pubDateTextView.setText(pubDate);
        titleTextView.setText(title);
        descriptionTextView.setText(description);

        // set listener
        linkTextView.setOnClickListener(this);
    return view;
    }

    @Override
    public void onClick(View v) {
        // get the intent
        Intent intent = getActivity().getIntent();

        // get the Uri for the link
        String link = intent.getStringExtra("link");
        Uri viewUri = Uri.parse(link);

        // create the intent and start it
        Intent viewIntent = new Intent(Intent.ACTION_VIEW, viewUri);
        startActivity(viewIntent);
    }
}
