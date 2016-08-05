package com.mygdx.genexotrudnypacjent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mygdx.genexotrudnypacjent.R;
import com.mygdx.genexotrudnypacjent.database.DbRepository;
import com.mygdx.genexotrudnypacjent.model.NotSendUser;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by Radek on 2016-02-27.
 */
public class ZapraszamyActivity extends AppCompatActivity {
    @OnClick(R.id.multilac)
    void dalej(View v) {
        //startActivity(new Intent(this, FormActivity.class));
        startActivity(new Intent(this, QuizEntryActivity.class));
    }
    @OnClick(R.id.regulamin)
    void regulamin(View v) {
        startActivity(new Intent(this, RegulaminActivity.class));
    }
    @OnClick(R.id.try_send)
    void trySend(View v){
        startActivity(new Intent(this, ResendActivity.class));
    }
    @Bind(R.id.try_send)
    TextView trySendText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.zapraszamy_activity);

        ButterKnife.bind(this);

        startActivity(new Intent(this, QuizEntryActivity.class));
        finish();
    }

    @Override
    protected void onResume() {
        List<NotSendUser> notSendUsers = cupboard().withDatabase(DbRepository.getDb(this)).query(NotSendUser.class).list();

        int count = notSendUsers.size();

        super.onResume();
    }
}
