package com.example.chendekun.constraintlayout;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

/**
 * description:
 * Created by chendekun on 2018/5/10.
 */

public class ConstrainLayoutActivity extends AppCompatActivity {

    private ImageView left;
    private ImageView middle;
    private ImageView right;
    private View selectView;
    private ConstraintLayout root;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_constrain);
        selectView = null;
        left = ((ImageView) findViewById(R.id.left));
        middle = ((ImageView) findViewById(R.id.middle));
        right = ((ImageView) findViewById(R.id.right));
        root = (ConstraintLayout)findViewById(R.id.root);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectView!=left){
                    updateConstraints(R.layout.activity_main_left);
                    selectView = left;
                } else{
                    toDefault();
                }
            }
        });

    }

    private void updateConstraints(int activity_main_left) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this,activity_main_left);
        constraintSet.applyTo(root);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setInterpolator(new DecelerateInterpolator());
        TransitionManager.beginDelayedTransition(root,changeBounds);
    }

    private void toDefault() {
        if (selectView!=null){
            updateConstraints(R.layout.activity_other_constrain);
            selectView = null;
        }
    }
}
