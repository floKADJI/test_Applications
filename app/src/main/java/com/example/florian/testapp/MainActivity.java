package com.example.florian.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
