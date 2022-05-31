package com.thienbao.userrandom.utils.mvp;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Abstract base class to be extended by any MVP View such as {@link androidx.appcompat.app.AppCompatActivity} and
 * It contains common attributes and methods to be
 * shared across Presenters.
 */
public abstract class BaseView extends AppCompatActivity implements IBaseView {
    protected ProgressBar progressBar;

    @Override
    public void showToastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
