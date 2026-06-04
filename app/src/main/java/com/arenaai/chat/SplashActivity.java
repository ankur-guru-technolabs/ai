package com.arenaai.chat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.view.animation.AnimationSet;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#212121"));
            getWindow().setNavigationBarColor(Color.parseColor("#212121"));
        }
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setBackgroundColor(Color.parseColor("#212121"));

        TextView logoText = new TextView(this);
        logoText.setText("Arena");
        logoText.setTextColor(Color.parseColor("#ececec"));
        logoText.setTextSize(42f);
        logoText.setTypeface(Typeface.DEFAULT_BOLD);
        logoText.setGravity(Gravity.CENTER);

        TextView aiBadge = new TextView(this);
        aiBadge.setText("AI");
        aiBadge.setTextColor(Color.parseColor("#10a37f"));
        aiBadge.setTextSize(22f);
        aiBadge.setTypeface(Typeface.DEFAULT_BOLD);
        aiBadge.setGravity(Gravity.CENTER);

        TextView tagline = new TextView(this);
        tagline.setText("Powered by AI · Built for You");
        tagline.setTextColor(Color.parseColor("#8e8ea0"));
        tagline.setTextSize(14f);
        tagline.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        lp.gravity = Gravity.CENTER;
        lp.setMargins(0, 0, 0, 8);

        root.addView(logoText, lp);
        root.addView(aiBadge, lp);
        root.addView(tagline, lp);
        setContentView(root);

        AnimationSet animSet = new AnimationSet(true);
        AlphaAnimation fadeIn = new AlphaAnimation(0f, 1f);
        fadeIn.setDuration(900);
        TranslateAnimation slideUp = new TranslateAnimation(0, 0, 40f, 0f);
        slideUp.setDuration(900);
        animSet.addAnimation(fadeIn);
        animSet.addAnimation(slideUp);
        root.startAnimation(animSet);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }, 2200);
    }
}
