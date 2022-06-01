package com.thienbao.userrandom.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.thienbao.userrandom.R;
import com.thienbao.userrandom.presenters.SplashContract;
import com.thienbao.userrandom.presenters.SplashPresenter;
import com.thienbao.userrandom.utils.mvp.BaseView;


public class SplashActivity extends BaseView implements SplashContract.View{
    private ImageView splashImg;
    private SplashContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findView();
        presenter = new SplashPresenter(this);

        showSplashScreen();
    }

    private void findView() {
        splashImg = findViewById(R.id.splashImg);
        progressBar = findViewById(R.id.progress_horizontal);
    }

    @Override
    public void showWelcomeIcon() {
        Glide.with(this).load(presenter.getImageUrl()).centerInside().into(splashImg);
    }

    @Override
    public void navigateToMainScreen() {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent navigateToMain = new Intent(this, MainActivity.class);
            startActivity(navigateToMain);
        }, 5000);
    }

    @Override
    public void showSplashScreen() {
        setProgressBar(true);
        showWelcomeIcon();
        navigateToMainScreen();
    }
}