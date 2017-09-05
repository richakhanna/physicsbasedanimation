package com.richdroid.physicsbasedanimation.ui.activity;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.richdroid.physicsbasedanimation.R;

public class ChainedSpringAnimationActivity extends AppCompatActivity {

    private ImageView mViewLead;
    private ImageView mViewFirstFollower;
    private ImageView mViewSecondFollower;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chained_spring_animation);

        mViewLead = (ImageView) findViewById(R.id.iv_lead);
        mViewFirstFollower = (ImageView) findViewById(R.id.iv_first_follower);
        mViewSecondFollower = (ImageView) findViewById(R.id.iv_second_follower);

        final SpringAnimation animFirstFollowerX = new SpringAnimation(mViewFirstFollower, DynamicAnimation.TRANSLATION_X);
        final SpringAnimation animFirstFollowerY = new SpringAnimation(mViewFirstFollower, DynamicAnimation.TRANSLATION_Y);

        final SpringAnimation animSecondFollowerX = new SpringAnimation(mViewSecondFollower, DynamicAnimation.TRANSLATION_X);
        final SpringAnimation animSecondFollowerY = new SpringAnimation(mViewSecondFollower, DynamicAnimation.TRANSLATION_Y);


        mViewLead.setOnTouchListener(new View.OnTouchListener() {
            float lastX, lastY;

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {

                if (motionEvent.getActionMasked() == MotionEvent.ACTION_MOVE) {
                    float deltaX = motionEvent.getRawX() - lastX;
                    float deltaY = motionEvent.getRawY() - lastY;

                    mViewLead.setTranslationX(deltaX + mViewLead.getTranslationX());
                    mViewLead.setTranslationY(deltaY + mViewLead.getTranslationY());

                    animFirstFollowerX.animateToFinalPosition(mViewLead.getTranslationX());
                    animFirstFollowerY.animateToFinalPosition(mViewLead.getTranslationY());
                }

                lastX = motionEvent.getRawX();
                lastY = motionEvent.getRawY();

                return true;
            }
        });

        animFirstFollowerX.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                animSecondFollowerX.animateToFinalPosition(value);
            }
        });

        animFirstFollowerY.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                animSecondFollowerY.animateToFinalPosition(value);
            }
        });
    }
}
