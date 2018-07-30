package com.example.florian.testapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter (Context context, ArrayList<User> users){
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//         Get the object located at this position in the list
        User currentUser = getItem(position);
//        Check if an existing View is being reused, otherwise inflate the View
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }
//        Find the TextView in the item_user.xml layout with the nameID
        TextView name = (TextView) convertView.findViewById(R.id.nameID);
//        Find the TextView in the item_user.xml layout with the telID
        TextView tel = (TextView) convertView.findViewById(R.id.telID);
//        Populate the data into the template view using the data object
        name.setText(currentUser.name);
        tel.setText(currentUser.tel);
//        Return the completed view to render on screen
        return convertView;
    }
}
