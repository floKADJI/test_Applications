package com.example.florian.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        String [][] repertoire = new String[][] {
                {"item 1: ", "data 1"},
                {"item 2: ", "data 2"},
                {"item 3: ", "data 3"},
                {"item 4: ", "data 4"},
                {"item 5: ", "data 5"},
                {"item 6: ", "data 6"},
                {"item 7: ", "data 7"},
                {"item 8: ", "data 8"},
                {"item 9: ", "data 9"},
                {"item 10: ", "data 10"},
                {"item 11: ", "data 11"},
                {"item 12: ", "data 12"},
                {"item 13: ", "data 13"}
        };

        List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> element;
//        Pour chaque personne dans notre repertoire ...
        for (int i=0; i<repertoire.length; i++){
            // ... on crée un élément pour la liste ...
            element = new HashMap<>();
            //... On déclare que la cle est "test 1"  pourr le nom de la personne
            element.put("text 1", repertoire[i][0]);
            //... On déclare que la cle est "test 2"  pour le numero de cette personne
            element.put("text 2", repertoire[i][1]);

            liste.add(element);
        }


//        Construct the data source
        ArrayList<User> arrayOfUsers = new ArrayList<>();
//        Create the adapter to convert the array to Views
        UserAdapter adapter = new UserAdapter(this, arrayOfUsers);
//        Attach the adapter to a ListView
        listView.setAdapter(adapter);

        // Add item to adapter
        User newUser1 = new User("perso1", "tel1");
        adapter.add(newUser1);
        User newUser2 = new User("perso2", "tel2");
        adapter.add(newUser2);
        User newUser3 = new User("perso3", "tel3");
        adapter.add(newUser3);

     /*
//      Creer l'adapter pour gerer le contenu de chaque vue par item et qui recevra la liste de donnee
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
//        Fournir au gestionnaire de vue (adapterView) les elements de chaque vue contenu dans adapter
        listView.setAdapter(adapter);
     */
//        ListAdapter adapter = new SimpleAdapter(this,
//                // Valeurs à insérer
//                liste,
//
//                /*
//                Layout de chaque élément (là, il s'agit d'un layout par défaut pour avoir 2 textes l'un au-dessus de l'autre,
//                c'est pourquoi on n'affiche que le nom et le numéro d'une personne)
//                 */
//                android.R.layout.simple_list_item_2,
//
//                /*
//                Les clés des informations à afficher pour chaque élément :
//                - la valeur associée à la clé "text 1" sera la première information
//                - la valeur associée à la clé "test 2" sera la seconde information
//                 */
//                new String[] {"text 1", "text 2"},
//
//                /*
//                Enfin, les layouts à appliquer à chaque widget de notre élément (ce sont des layouts fournis par défaut) :
//                - la première information appliquera le layout 'android.R.id.text1'
//                - la seconde information appliquera le layout 'android.R.id.text2'
//                 */
//                new int[] {android.R.id.text1, android.R.id.text2} );
//
//        // Pour finir, on donne à la listView le SimpleAdapter
//        listView.setAdapter(adapter);
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
