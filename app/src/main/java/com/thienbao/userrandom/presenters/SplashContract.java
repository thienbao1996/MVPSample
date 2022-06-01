package com.thienbao.userrandom.presenters;

import com.thienbao.userrandom.utils.mvp.IBasePresenter;
import com.thienbao.userrandom.utils.mvp.IBaseView;

/**
 * The interface that exposes the functionalities of a Splash View
 */
public interface SplashContract {
    interface View extends IBaseView {
        void showWelcomeIcon();
        void navigateToMainScreen();
        void showSplashScreen();
    }

    interface Presenter extends IBasePresenter<View> {
        String getImageUrl();
    }
}
