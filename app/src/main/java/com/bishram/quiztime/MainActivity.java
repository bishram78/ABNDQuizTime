package com.bishram.quiztime;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSaveNext01;
    private Button btnSaveNext02;
    private Button btnSaveNext03;
    private Button btnSaveNext04;
    private Button btnSaveNext05;
    private Button btnSaveNext06;
    private Button btnSaveNext07;
    private Button btnSaveNext08;
    private Button btnSaveNext09;
    private Button btnSaveNext10;
    private CheckBox cbOption5a;
    private CheckBox cbOption5b;
    private CheckBox cbOption5d;
    private CheckBox cbOption9c;
    private CheckBox cbOption9d;
    private EditText etName;
    private EditText etOption3bAns;
    private EditText etOption7Ans;
    private ImageButton btnStart;
    private ImageView ivQtBackground;
    private ImageView ivCrossTick;
    private RadioButton rbOption1a;
    private RadioButton rbOption2a;
    private RadioButton rbOption4d;
    private RadioButton rbOption6d;
    private RadioButton rbOption8c;
    private RadioButton rbOption10b;
    private TextView tvUserName;
    private TextView tvQuestionNo;
    private TextView tvTimeElapsed;
    private TextView tvPlayForK;
    private TextView tvAwesomeOrOps;
    private TextView tvScore;
    private LinearLayout llEntryPoint;
    private LinearLayout llQuestionOption;
    private LinearLayout llQuestionOption01;
    private LinearLayout llQuestionOption02;
    private LinearLayout llQuestionOption03;
    private LinearLayout llQuestionOption04;
    private LinearLayout llQuestionOption05;
    private LinearLayout llQuestionOption06;
    private LinearLayout llQuestionOption07;
    private LinearLayout llQuestionOption08;
    private LinearLayout llQuestionOption09;
    private LinearLayout llQuestionOption10;
    private LinearLayout llScoreEarned;
    private LinearLayout llQuestionTime;

    private int scoreEarned;

    /*
     * This method is called when activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsById();
    }

    public void findViewsById() {
        btnSaveNext01 = findViewById(R.id.id_am_btn_sv_next_01);
        btnSaveNext02 = findViewById(R.id.id_am_btn_sv_next_02);
        btnSaveNext03 = findViewById(R.id.id_am_btn_sv_next_03);
        btnSaveNext04 = findViewById(R.id.id_am_btn_sv_next_04);
        btnSaveNext05 = findViewById(R.id.id_am_btn_sv_next_05);
        btnSaveNext06 = findViewById(R.id.id_am_btn_sv_next_06);
        btnSaveNext07 = findViewById(R.id.id_am_btn_sv_next_07);
        btnSaveNext08 = findViewById(R.id.id_am_btn_sv_next_08);
        btnSaveNext09 = findViewById(R.id.id_am_btn_sv_next_09);
        btnSaveNext10 = findViewById(R.id.id_am_btn_sv_next_10);
        cbOption5a = findViewById(R.id.id_am_cb_option_5a);
        cbOption5b = findViewById(R.id.id_am_cb_option_5b);
        cbOption5d = findViewById(R.id.id_am_cb_option_5d);
        cbOption9c = findViewById(R.id.id_am_cb_option_9c);
        cbOption9d = findViewById(R.id.id_am_cb_option_9d);
        ivQtBackground = findViewById(R.id.id_am_iv_qt_bkg);
        ivCrossTick = findViewById(R.id.id_am_iv_cross_tick);
        btnStart = findViewById(R.id.id_ma_btn_start);
        etName = findViewById(R.id.id_am_et_enter_name);
        etOption3bAns = findViewById(R.id.id_am_et_third_ques_ans);
        etOption7Ans = findViewById(R.id.id_am_et_seventh_que_ans);
        rbOption1a = findViewById(R.id.id_am_rb_option_1a);
        rbOption2a = findViewById(R.id.id_am_rb_option_2a);
        rbOption4d = findViewById(R.id.id_am_rb_option_4d);
        rbOption6d = findViewById(R.id.id_am_rb_option_6d);
        rbOption8c = findViewById(R.id.id_am_rb_option_8c);
        rbOption10b = findViewById(R.id.id_am_rb_option_10b);
        tvUserName = findViewById(R.id.id_am_tv_username);
        tvQuestionNo = findViewById(R.id.id_am_tv_ques_no);
        tvTimeElapsed = findViewById(R.id.id_am_tv_time_elapsed);
        tvScore = findViewById(R.id.id_am_tv_score);
        tvPlayForK = findViewById(R.id.id_am_tv_pfk);
        tvAwesomeOrOps = findViewById(R.id.id_am_tv_awesome);
        llEntryPoint = findViewById(R.id.id_am_ll_entry_point);
        llQuestionOption = findViewById(R.id.id_am_ll_question_option);
        llQuestionOption01 = findViewById(R.id.id_am_ll_qo_01);
        llQuestionOption02 = findViewById(R.id.id_am_ll_qo_02);
        llQuestionOption03 = findViewById(R.id.id_am_ll_qo_03);
        llQuestionOption04 = findViewById(R.id.id_am_ll_qo_04);
        llQuestionOption05 = findViewById(R.id.id_am_ll_qo_05);
        llQuestionOption06 = findViewById(R.id.id_am_ll_qo_06);
        llQuestionOption07 = findViewById(R.id.id_am_ll_qo_07);
        llQuestionOption08 = findViewById(R.id.id_am_ll_qo_08);
        llQuestionOption09 = findViewById(R.id.id_am_ll_qo_09);
        llQuestionOption10 = findViewById(R.id.id_am_ll_qo_10);
        llScoreEarned = findViewById(R.id.id_am_ll_score_container);
        llQuestionTime = findViewById(R.id.id_am_ll_qn_te);
    }

    /*
     * This method is called when start button (an ImageButton arrowed right way in the start
     * screen) is clicked.
     */
    public void startQuiz(View view) {
        String userName = etName.getText().toString();

        //This will check whether EditText (name of candidate) is empty.
        if (userName.isEmpty()) {
            mToastLong(getString(R.string.txt_field_filled));
            btnStart.setEnabled(false);

            //This enables the Start Button after a time interval of 2 seconds (2000 milliseconds)
            //if button is clicked in Empty state.
            new Handler().postDelayed(new Thread(new Runnable() {
                @Override
                public void run() {
                    btnStart.setEnabled(true);
                }
            }), 2000);
        } else {
            ivQtBackground.setVisibility(View.INVISIBLE);
            llEntryPoint.setVisibility(View.GONE);
            tvPlayForK.setVisibility(View.GONE);
            tvUserName.setVisibility(View.VISIBLE);
            llQuestionOption.setVisibility(View.VISIBLE);
            llQuestionTime.setVisibility(View.VISIBLE);
            mToastShort(getString(R.string.txt_quiz_started));

            //This method calculates the time elapsed in the quiz increases by 1 second.
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() {
                int mSeconds = 0;
                int mMinutes = 0;

                @Override
                public void run() {
                    String timeFormat;
                    if (mSeconds < 60) {
                        if ((mSeconds < 10)&&(mMinutes < 10)) {
                            timeFormat = String.format(getString(R.string.txt_time_elapsed_0m_0s), mMinutes, mSeconds);
                            tvTimeElapsed.setText(timeFormat);
                        } else if ((mSeconds > 9)&&(mMinutes < 10)){
                            timeFormat = String.format(getString(R.string.txt_time_elapsed_0m), mMinutes, mSeconds);
                            tvTimeElapsed.setText(timeFormat);
                        } else {
                            timeFormat = String.format(getString(R.string.txt_time_elapsed), mMinutes, mSeconds);
                            tvTimeElapsed.setText(timeFormat);
                        }
                    } else {
                        mMinutes++;
                        mSeconds = 0;
                        if (mMinutes < 10) {
                            timeFormat = String.format(getString(R.string.txt_time_elapsed_0m_0s), mMinutes, mSeconds);
                            tvTimeElapsed.setText(timeFormat);
                        } else {
                            timeFormat = String.format(getString(R.string.txt_time_elapsed_0s), mMinutes, mSeconds);
                            tvTimeElapsed.setText(timeFormat);
                        }
                    }
                    mSeconds++;
                    handler.postDelayed(this, 1000);
                }
            };
            handler.postDelayed(runnable, 0);
            tvUserName.setText(String.format(getString(R.string.txt_hi_username), userName));
        }
    }

    @SuppressLint("DefaultLocale")

    /*
     * This method is called when Save and Next button is clicked which uses Switch() method
     * to navigate between buttons
     */
    public void saveNext(View view) {
        switch (view.getId()) {
            case R.id.id_am_btn_sv_next_01:
                if (rbOption1a.isChecked()) {
                    scoreEarned = 5;
                }
                mToastShort(String.format(getString(R.string.txt_loading_question), getString(R.string.txt_second)));
                btnSaveNext01.setVisibility(View.INVISIBLE);
                loadingPleaseWait(2000, 1);
                break;

            case R.id.id_am_btn_sv_next_02:
                if (rbOption2a.isChecked()) {
                    scoreEarned += 5;
                }
                mToastShort(String.format(getString(R.string.txt_loading_question), getString(R.string.txt_third)));
                btnSaveNext02.setVisibility(View.INVISIBLE);
                loadingPleaseWait(2000, 2);
                break;

            case R.id.id_am_btn_sv_next_03:
                if (etOption3bAns.getText().toString().equals(getString(R.string.txt_analytical_engine))) {
                    scoreEarned += 5;
                }
                mToastShort(String.format(getString(R.string.txt_loading_question), getString(R.string.txt_fourth)));
                btnSaveNext03.setVisibility(View.INVISIBLE);
                loadingPleaseWait(2000, 3);
                break;

            case R.id.id_am_btn_sv_next_04:
                if (rbOption4d.isChecked()) {
                    scoreEarned +=5;
                }
                mToastShort(String.format(getString(R.string.txt_loading_question), getString(R.string.txt_fifth)));
                btnSaveNext04.setVisibility(View.INVISIBLE);
                loadingPleaseWait(2000, 4);
                break;

            case R.id.id_am_btn_sv_next_05:
                if (cbOption5a.isChecked()&&cbOption5b.isChecked()&&cbOption5d.isChecked()) {
                    scoreEarned += 5;
                }
                mToastShort(String.format(getString(R.string.txt_loading_question), getString(R.string.txt_sixth)));
                btnSaveNext05.setVisibility(View.INVISIBLE);
                loadingPleaseWait(2000, 5);
                break;

            case R.id.id_am_btn_sv_next_06:
                if (rbOption6d.isChecked()) {
                    scoreEarned += 5;
                }
                mToastShort(String.format(getString(R.string.txt_loading_question), getString(R.string.txt_seventh)));
                btnSaveNext06.setVisibility(View.INVISIBLE);
                loadingPleaseWait(2000, 6);
                break;

            case R.id.id_am_btn_sv_next_07:
                if (etOption7Ans.getText().toString().equals(getString(R.string.txt_motherboard))) {
                    scoreEarned += 5;
                }
                mToastShort(String.format(getString(R.string.txt_loading_question), getString(R.string.txt_eighth)));
                btnSaveNext07.setVisibility(View.INVISIBLE);
                loadingPleaseWait(2000, 7);
                break;

            case R.id.id_am_btn_sv_next_08:
                if (rbOption8c.isChecked()) {
                    scoreEarned += 5;
                }
                mToastShort(String.format(getString(R.string.txt_loading_question), getString(R.string.txt_ninth)));
                btnSaveNext08.setVisibility(View.INVISIBLE);
                loadingPleaseWait(2000, 8);
                break;

            case R.id.id_am_btn_sv_next_09:
                if (cbOption9c.isChecked()&&cbOption9d.isChecked()) {
                    scoreEarned += 5;
                }
                mToastShort(String.format(getString(R.string.txt_loading_question), getString(R.string.txt_last)));
                btnSaveNext09.setVisibility(View.INVISIBLE);
                loadingPleaseWait(2000, 9);
                break;

            case R.id.id_am_btn_sv_next_10:
                if (rbOption10b.isChecked()) {
                    scoreEarned += 5;
                }
                if (scoreEarned == 0) {
                    tvAwesomeOrOps.setText(R.string.txt_ops);
                    ivCrossTick.setImageDrawable(getResources().getDrawable(R.drawable.red_cross_mark_48));
                } else if (scoreEarned > 0 && scoreEarned <= 25) {
                    tvAwesomeOrOps.setText(R.string.txt_nice);
                    ivCrossTick.setImageDrawable(getResources().getDrawable(R.drawable.check_48));
                } else if (scoreEarned > 25 && scoreEarned < 45) {
                    tvAwesomeOrOps.setText(R.string.txt_awesome);
                    ivCrossTick.setImageDrawable(getResources().getDrawable(R.drawable.check_48));
                } else if (scoreEarned == 45) {
                    tvAwesomeOrOps.setText(R.string.txt_excellent);
                    ivCrossTick.setImageDrawable(getResources().getDrawable(R.drawable.check_48));
                } else {
                    tvAwesomeOrOps.setText(R.string.txt_outstanding);
                    ivCrossTick.setImageDrawable(getResources().getDrawable(R.drawable.check_48));
                }
                tvScore.setText(String.format(getString(R.string.txt_score_earned), scoreEarned));
                mToastShort(getString(R.string.txt_computing_result));
                btnSaveNext10.setVisibility(View.INVISIBLE);
                loadingPleaseWait(2000, 10);
                break;
        }
    }

    /**
     * This method handles Toast message for SHORT_TIME
     * @param message is the text string.
     */
    public void mToastShort(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * This method handles Toast message for LONG_TIME
     * @param message is the text string.
     */
    public void mToastLong (String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * This method is responsible for holding current question for a time interval of @duration
     * and loading the second question.
     * @param duration is the time interval or delay time
     * @param pos is the position of Save & Next button.
     */
    public void loadingPleaseWait(int duration, final int pos) {
        new Handler().postDelayed(new Runnable() {
            @SuppressLint("DefaultLocale")
            @Override
            public void run() {
                switch (pos) {
                    case 1:
                        llQuestionOption01.setVisibility(View.GONE);
                        llQuestionOption02.setVisibility(View.VISIBLE);
                        tvQuestionNo.setText(String.format(getString(R.string.txt_question_number), 2));
                        break;
                    case 2:
                        llQuestionOption02.setVisibility(View.GONE);
                        llQuestionOption03.setVisibility(View.VISIBLE);
                        tvQuestionNo.setText(String.format(getString(R.string.txt_question_number), 3));
                        break;
                    case 3:
                        llQuestionOption03.setVisibility(View.GONE);
                        llQuestionOption04.setVisibility(View.VISIBLE);
                        tvQuestionNo.setText(String.format(getString(R.string.txt_question_number), 4));
                        break;
                    case 4:
                        llQuestionOption04.setVisibility(View.GONE);
                        llQuestionOption05.setVisibility(View.VISIBLE);
                        tvQuestionNo.setText(String.format(getString(R.string.txt_question_number), 5));
                        break;
                    case 5:
                        llQuestionOption05.setVisibility(View.GONE);
                        llQuestionOption06.setVisibility(View.VISIBLE);
                        tvQuestionNo.setText(String.format(getString(R.string.txt_question_number), 6));
                        break;
                    case 6:
                        llQuestionOption06.setVisibility(View.GONE);
                        llQuestionOption07.setVisibility(View.VISIBLE);
                        tvQuestionNo.setText(String.format(getString(R.string.txt_question_number), 7));
                        break;
                    case 7:
                        llQuestionOption07.setVisibility(View.GONE);
                        llQuestionOption08.setVisibility(View.VISIBLE);
                        tvQuestionNo.setText(String.format(getString(R.string.txt_question_number), 8));
                        break;
                    case 8:
                        llQuestionOption08.setVisibility(View.GONE);
                        llQuestionOption09.setVisibility(View.VISIBLE);
                        tvQuestionNo.setText(String.format(getString(R.string.txt_question_number), 9));
                        break;
                    case 9:
                        llQuestionOption09.setVisibility(View.GONE);
                        llQuestionOption10.setVisibility(View.VISIBLE);
                        tvQuestionNo.setText(String.format(getString(R.string.txt_question_number), 10));
                        break;
                    case 10:
                        llQuestionOption10.setVisibility(View.GONE);
                        llScoreEarned.setVisibility(View.VISIBLE);
                        break;
                }
            }
        }, duration);
    }
}
