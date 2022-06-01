package com.thienbao.userrandom.presenters;

import com.thienbao.userrandom.models.User;
import com.thienbao.userrandom.utils.mvp.IBasePresenter;
import com.thienbao.userrandom.utils.mvp.IBaseView;

public interface MainContract {
    interface View extends IBaseView {
        void randomUser();
        void updateCount();
        void showUser(User user);
    }

    interface Presenter extends IBasePresenter<MainContract.View> {
        void getUsers();
    }
}
