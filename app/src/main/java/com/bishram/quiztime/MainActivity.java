package com.bishram.quiztime;

import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnStart;
    private EditText etName;
    private TextView tvUserName;
    private RelativeLayout rlAuthentication;
    private ConstraintLayout clQuestionOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsById();
        setDefaults();
    }

    public void findViewsById() {
        btnStart = findViewById(R.id.id_ma_btn_start);
        etName = findViewById(R.id.id_am_et_enter_name);
        tvUserName = findViewById(R.id.id_am_tv_username);
        rlAuthentication = findViewById(R.id.id_am_rl_auth_container);
        clQuestionOption = findViewById(R.id.id_am_cl_question_container);
    }

    public void setDefaults() {

    }

    public void startQuiz(View view) {
        String userName = etName.getText().toString();
        if (userName.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Name field must be filled.", Toast.LENGTH_SHORT).show();
            btnStart.setEnabled(false);
            Handler mHandler = new Handler();
            mHandler.postDelayed(new Thread(new Runnable() {
                @Override
                public void run() {
                    btnStart.setEnabled(true);
                }
            }), 2000);
        } else {
            rlAuthentication.setVisibility(View.GONE);
            clQuestionOption.setVisibility(View.VISIBLE);
            tvUserName.setText("Hi! " + userName);
        }
    }

    public void saveNext(View view) {

    }
}
