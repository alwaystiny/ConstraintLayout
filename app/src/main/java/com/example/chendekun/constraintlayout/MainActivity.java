package com.example.chendekun.constraintlayout;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Placeholder mainAction;
    private ConstraintLayout constraintLayout;
    private ImageButton save;
    private ImageButton delete;
    private ImageButton cancel;
    private ImageButton edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainAction = (Placeholder) findViewById(R.id.template_action);
        constraintLayout = (ConstraintLayout) findViewById(R.id.root);

        save = (ImageButton) findViewById(R.id.save);
        delete = (ImageButton) findViewById(R.id.delete);
        cancel = (ImageButton) findViewById(R.id.cancel);
        edit = (ImageButton) findViewById(R.id.edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                mainAction.setContentId(view.getId());
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                mainAction.setContentId(view.getId());
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                mainAction.setContentId(view.getId());
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                mainAction.setContentId(view.getId());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       super.onOptionsItemSelected(item);
       switch (item.getItemId()){
           case R.id.menu_constrain:
               Intent intent = new Intent(this, ConstrainLayoutActivity.class);
               startActivity(intent);
               break;
       }
       return  true;
    }
}
