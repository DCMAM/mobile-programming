package com.example.pertemuan_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView floatingMenu, actionMenu;
    ActionMode actionMode;
    Button btnPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // action menu
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // floating menu
        floatingMenu = findViewById(R.id.menu_floating);
        registerForContextMenu(floatingMenu);

        actionMenu = findViewById(R.id.menu_action);
        actionMenu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(actionMode != null) return false;
                actionMode = MainActivity.this.startActionMode(actionCallback);
                return true;
            }
        });

        btnPopUp = findViewById(R.id.btn_popup);
    }

    public ActionMode.Callback actionCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_floating, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.menu_edit:
                    Toast.makeText(MainActivity.this, "Menu Edit", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.menu_delete:
                    Toast.makeText(MainActivity.this, "Menu Delete", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.opt_profile:
                Toast.makeText(this, "Option Profile", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opt_info:
                Toast.makeText(this, "Option Info", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opt_setting:
                Toast.makeText(this, "Option Setting", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opt_logout:
                Toast.makeText(this, "Option Logout", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_floating, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_edit:
                Toast.makeText(this, "Menu Edit", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_delete:
                Toast.makeText(this, "Menu Delete", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    public void showPopUp(View view) {
        PopupMenu popupMenu = new PopupMenu(this, btnPopUp);
        popupMenu.getMenuInflater().inflate(R.menu.menu_floating, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_edit:
                        Toast.makeText(MainActivity.this, "Menu Edit", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_delete:
                        Toast.makeText(MainActivity.this, "Menu Delete", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });

        popupMenu.show();

    }
}