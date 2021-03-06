package com.thienbao.userrandom.utils.mvp;

public interface IBasePresenter<ViewT> {
    void onViewActive(ViewT view);
    void onViewInactive();
}
