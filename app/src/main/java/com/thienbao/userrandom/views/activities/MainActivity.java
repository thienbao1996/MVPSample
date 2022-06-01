package com.thienbao.userrandom.views.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thienbao.userrandom.R;
import com.thienbao.userrandom.models.User;
import com.thienbao.userrandom.presenters.MainContract;
import com.thienbao.userrandom.presenters.MainPresenter;
import com.thienbao.userrandom.utils.mvp.BaseView;

import java.util.Locale;

public class MainActivity extends BaseView implements MainContract.View {
    private TextView countTxt;
    private Button randomBtn;
    private ImageView avatarImg;
    private TextView username, email;
    private MainContract.Presenter presenter;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        presenter = new MainPresenter(this::showUser);

        presenter.getUsers();
        updateCount();

        randomBtn.setOnClickListener(view -> randomUser());
    }

    private void findView() {
        progressBar = findViewById(R.id.main_progress);
        countTxt = findViewById(R.id.count_random);
        randomBtn = findViewById(R.id.random_user);
        avatarImg = findViewById(R.id.user_avatar);
        username = findViewById(R.id.user_name);
        email = findViewById(R.id.user_email);
    }


    @Override
    public void randomUser() {
        presenter.getUsers();
        count++;
        updateCount();
    }

    @Override
    public void updateCount() {
        countTxt.setText(String.format(Locale.getDefault(),"%s%d", getString(R.string.count), count));
    }

    @Override
    public void showUser(User user) {
        username.setText(String.format("%s. %s %s", user.getName().getTitle(), user.getName().getFirst(), user.getName().getLast()));
        email.setText(user.getEmail());
        Glide.with(this).load(user.getPicture().getThumbnail()).into(avatarImg);
    }
}