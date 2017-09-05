package com.richdroid.physicsbasedanimation.ui.activity;

import android.os.Bundle;
import android.support.animation.FloatPropertyCompat;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.richdroid.physicsbasedanimation.R;

public class TranslateAndRotateSpringAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = TranslateAndRotateSpringAnimationActivity.class.getSimpleName();

    private LinearLayout mLinearLayout;
    private Button mBtnBringIt;
    private SpringAnimation mSpringRotationAnimation;
    private static final float INITIAL_ROTATION = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_and_rotate_spring_animation);

        mLinearLayout = (LinearLayout) findViewById(R.id.ll_list);
        mBtnBringIt = (Button) findViewById(R.id.button_bring);
        mBtnBringIt.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_bring) {

            SpringForce springForce = new SpringForce(INITIAL_ROTATION);
            springForce.setStiffness(SpringForce.STIFFNESS_LOW);
            springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);

            for (int i = 0; i < mLinearLayout.getChildCount(); i++) {
                View child = mLinearLayout.getChildAt(i);
                SpringAnimation rotationAnim;
                // First, let's rotate each individual head, to do that, we need to
                // go through all the items on the list, and for each item we will need
                // to create a Spring Animation on its rotation property.
                rotationAnim = new SpringAnimation(child,
                        new FloatPropertyCompat<View>("rotation") {

                            @Override
                            public float getValue(View view) {
                                return view.getRotation();
                            }

                            @Override
                            public void setValue(View view, float value) {
                                view.setRotation(value);
                            }
                        });
                // Finally, we can set the start value of the animation to -30 so that each head rotate
                // from a -30 degree angle and then oscillate around 0 degree and gradually come to a stop.
                rotationAnim.setSpring(springForce).setStartValue(-30).start();
            }

            // And finally we want the list to slide, we are going to create a Spring animation
            // on the translation property of the list.
            // We are also going to set the start value so the TRANSLATION_X will start from 400
            // and then slide back into its final position 0.

            SpringAnimation slideAnim = new SpringAnimation(mLinearLayout,
                    new FloatPropertyCompat<View>("translationX") {

                        @Override
                        public float getValue(View view) {
                            return view.getTranslationX();
                        }

                        @Override
                        public void setValue(View view, float value) {
                            view.setTranslationX(value);
                        }
                    }, 0);
            slideAnim.getSpring().setStiffness(500).setDampingRatio(0.4f);
            slideAnim.setStartValue(400).start();

        }
    }
}
