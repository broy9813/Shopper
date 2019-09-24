package com.example.shopper;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ViewLiswt extends AppCompatActivity {

    Intent intent;

    //fields used to get shopping list id passed from Main Activity
    long id;
    Bundle bundle;

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_liswt);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //get the id
        bundle = this.getIntent().getExtras();
        id = bundle.getLong("_id");

        dbHandler = new DBHandler(this, null);

        //call database method that returns shopping list name
        String shoppingListName = dbHandler.getShoppingListName((int)id);

        //set tittle of this activity to shopping list name
        this.setTitle(shoppingListName);

    }
    /**
     * This method further initializes the Action Bar of
     * the Main Activity. It gets the code we wrote in the
     * menu main and incorporates it into the Action Bar
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_list, menu);
        return true;
    }

    /**
     * This method gets called when an item in the overflow menu is selected and
     * it controls what happens when the item is selected
     * @param item item selected in the overflow menu. It contains information
     *             about the item; for example, its id.
     * @return true if an item is selected; else returns false
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // get the id of the item that was selected
        switch (item.getItemId()) {
            case R.id.action_home :
                // initializing an Intent for the Main Activity, starting it
                // and returning true
                intent = new Intent(this,MainActivity.class );
                startActivity(intent);
                return true;
            case R.id.action_create_list :
                // initializing an Intent for the Create List Activity, starting it
                // and returning true
                intent = new Intent(this, CreateList.class );
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
    public void openAddItem(View view) {
    }
}
