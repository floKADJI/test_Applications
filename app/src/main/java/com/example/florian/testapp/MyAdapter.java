package com.example.florian.testapp;

import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final List<Pair<String, String>> repertoire = Arrays.asList(
            Pair.create("perso1", "tel1"),
            Pair.create("perso2", "tel2"),
            Pair.create("perso3", "tel3"),
            Pair.create("perso4", "tel4"),
            Pair.create("perso5", "tel5"),
            Pair.create("perso6", "tel6"),
            Pair.create("perso7", "tel7"),
            Pair.create("perso8", "tel8"),
            Pair.create("perso9", "tel9")
    );

    @Override
    public int getItemCount() {
        return repertoire.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Pair<String, String> pair = repertoire.get(position);
        holder.display(pair);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView tel;

        private Pair<String, String> currentPair;

        public  MyViewHolder(final View itemView){
            super(itemView);

            name = ((TextView) itemView.findViewById(R.id.name));
            tel = ((TextView) itemView.findViewById(R.id.tel));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(currentPair.first)
                            .setMessage(currentPair.second)
                            .show();
                }
            });
        }

        public void display(Pair<String, String> pair){
            currentPair = pair;
            name.setText(pair.first);
            tel.setText(pair.second);
        }

    }
}
