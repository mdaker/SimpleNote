package com.daqer.simplenote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NoteAdapter extends ArrayAdapter<String> {
    NoteAdapter(Context context, String[] notes) {
        super(context, R.layout.custom_row, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater noteInflater = LayoutInflater.from(getContext());
        View customView = noteInflater.inflate(R.layout.custom_row,parent,false);

        String singleNoteItem = getItem(position);
        TextView titleTxt = (TextView) customView.findViewById(R.id.titleTxt);
        ImageView titleImg = (ImageView) customView.findViewById(R.id.titleImg);

        titleTxt.setText(singleNoteItem);
        titleImg.setImageResource(R.drawable.bub);
        return customView;
    }
}
