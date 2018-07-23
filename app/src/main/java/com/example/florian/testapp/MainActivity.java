package com.example.florian.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView  listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Recuperer la vue listView du layout xml pour l'utiliser coe notre adapterView
        listView = (ListView) findViewById(R.id.listViewID);

//        Creer la liste de donnees a transmettre a notre adapter
        String[] data = new String[] {"item 1", "item 2", "item 3", "item 4", "item 5", "item 6",
                "item 7", "item 8", "item 9", "item 10", "item 11", "item 12", "item 13"};

//        Creer l'adapter pour gerer le contenu de chaque vue par item et qui recevra la liste de donnee
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

//        Fournir au gestionnaire de vue (adapterView) les elements de chaque vue contenu dans adapter
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settingsID :
                Toast.makeText(this, "Settings", Toast.LENGTH_LONG ).show();
                return true;
            case R.id.othersID :
                Toast.makeText(this, "others ", Toast.LENGTH_LONG).show();
                return true;
            default :
                    return super.onOptionsItemSelected(item);
        }

    }
}
