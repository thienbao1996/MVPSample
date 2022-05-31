package com.thienbao.userrandom.presenters;

import com.thienbao.userrandom.utils.mvp.BasePresenter;

import java.util.Random;

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {
    private final String WELCOME_IMG_URL_1 = "https://static.vecteezy.com/system/resources/thumbnails/" +
            "002/483/184/small_2x/welcome-label-lettering-with-golden-stars-free-vector.jpg";
    private final String WELCOME_IMG_URL_2 = "https://image.shutterstock.com/image-illustration/" +
            "welcome-banner-speech-bubble-poster-260nw-1488656006.jpg";

    public SplashPresenter(SplashContract.View view) {
        this.view = view;
    }

    @Override
    public String getImageUrl() {
        Random random = new Random();
        return (random.nextInt(10) % 2 == 0) ? WELCOME_IMG_URL_1 : WELCOME_IMG_URL_2;
    }
}
