package com.thienbao.userrandom.utils.mvp;

import android.content.Context;

public interface IBaseView {
    void showToastMessage(Context context, String message);
    void setProgressBar(boolean show);
}
