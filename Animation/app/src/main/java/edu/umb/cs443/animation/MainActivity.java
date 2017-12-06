package edu.umb.cs443.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void move1(View v){
    	ImageView img=(ImageView) findViewById(R.id.imageView1);
    	img.setTranslationY(0f);


    	ObjectAnimator anim = ObjectAnimator.ofFloat(img, "translationX", 0, 300);
    	anim.setDuration(1000);
    	anim.start();
    }
    
    public void move2(View v){
    	ImageView img=(ImageView) findViewById(R.id.imageView1);
    	img.setTranslationY(0f);


    	ObjectAnimator anim = ObjectAnimator.ofFloat(img, "translationX", 0, 300);
    	anim.setDuration(1000);
    	anim.setInterpolator(new AccelerateInterpolator(3f));
    	anim.start();
    }
    public void move3(View v){
    	ImageView img=(ImageView) findViewById(R.id.imageView1);
    	img.setTranslationY(0f);



    	ObjectAnimator anim1 = ObjectAnimator.ofFloat(img, "translationX", 0, 300);
    	anim1.setDuration(1000);
    	
    	ObjectAnimator anim2 = ObjectAnimator.ofFloat(img, "scaleX", 1f, 0.5f);
    	anim2.setDuration(1000);
    	
    	ObjectAnimator anim3 = ObjectAnimator.ofFloat(img, "scaleY", 1f, 0.5f);
    	anim3.setDuration(1000);
    	
    	AnimatorSet aset1 = new AnimatorSet();
    	aset1.play(anim1).with(anim2);
    	aset1.play(anim1).with(anim3);
    	
    	ObjectAnimator anim4 = ObjectAnimator.ofFloat(img, "translationY", 0, 300);
    	anim4.setDuration(500);
    	
    	ObjectAnimator anim5 = ObjectAnimator.ofFloat(img, "scaleX", 0.5f, 1f);
    	anim5.setDuration(500);
    	
    	ObjectAnimator anim6 = ObjectAnimator.ofFloat(img, "scaleY", 0.5f, 1f);
    	anim6.setDuration(500);
    	
    	AnimatorSet aset2 = new AnimatorSet();
    	aset2.play(anim4).with(anim5);
    	aset2.play(anim4).with(anim6);
    	
    	
    	AnimatorSet aset = new AnimatorSet();
    	aset.play(aset1).before(aset2);
    	aset.start();
    	
    }

	public void move4(View v) {
		ImageView img = (ImageView) findViewById(R.id.imageView1);
		img.setTranslationY(100f);
        img.setTranslationX(150f);

		AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
				R.animator.property_animator);
		set.setTarget(img);
		set.start();

		//Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);
		//img.startAnimation(hyperspaceJumpAnimation);
	}
}
