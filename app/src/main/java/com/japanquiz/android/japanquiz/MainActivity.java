package com.japanquiz.android.japanquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int quizScore = 0;
    public int riceCheckBoxCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * @param view Evaluate text entered by user. If user is correct, update score and show positive text.
     *             If user is incorrect, show negative text.
     *             Then reveal artwork.
     */
    public void evaluateTokyoQuestionText(View view) {
        EditText tokyoEditText = (EditText) findViewById(R.id.enter_city_edit_text_view);
        final String answerText = tokyoEditText.getText().toString();
        final TextView tv = (TextView) findViewById(R.id.tokyo_answer_response_text);
        Button submitAnswerButton = (Button) findViewById(R.id.enter_city_edit_text_submit_button);

        submitAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerText.equals("Tokyo") || answerText.equals("tokyo")) {
                    tv.setText(R.string.great_job_text);
                    quizScore += 1;
                } else {
                    tv.setText(R.string.not_right);
                }
                ImageView tokyoGodzillaImage = (ImageView) findViewById(R.id.tokyo_godzilla_image);
                tokyoGodzillaImage.setVisibility(View.VISIBLE);
            }
        });

    }

    /**
     * @param view Evaluate which Radio button was selected. If answer is correct, update score, and show text.
     *             If incorrect show corresponding text.
     *             Then reveal artwork
     */
    public void onKyotoRadioButtonSetClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        TextView tv = (TextView) findViewById(R.id.kyoto_set_answer_text);
//        Check which Radio is selected then return correct or incorrect text depending on user answer

        switch (view.getId()) {

            case R.id.hiroshima_radio_button:
            case R.id.osaka_radio_button:
            case R.id.tokyo_radio_button:
            case R.id.sapporo_radio_button:
                if (checked)
                    tv.setText(R.string.incorrect_text);
                tv.setVisibility(View.VISIBLE);
                break;
            case R.id.kyoto_radio_button:
                if (checked)
                    tv.setText(R.string.nice_work_text);
                tv.setVisibility(View.VISIBLE);
                quizScore += 1;
                break;
        }
        ImageView kyotoImage = (ImageView) findViewById(R.id.kyoto_image);
        kyotoImage.setVisibility(View.VISIBLE);

    }

    /**
     * @param view Evaluate which Radio button was selected. If answer is correct, update score, and show text.
     *             If incorrect show corresponding text.
     *             Then reveal artwork
     */
    public void onTanukiButtonSetClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        TextView tv = (TextView) findViewById(R.id.tanuki_set_answer_text);

        //Check which RadioButton is selected then return correct or incorrect text depending on user answer

        switch (view.getId()) {
            case R.id.shimonoseki_radio_button:
                if (checked)
                    tv.setText(R.string.shimonoseki_bit);
                tv.setVisibility(View.VISIBLE);
                break;
            case R.id.wasabi_radio_button:
                if (checked)
                    tv.setText(R.string.wasabi_bit);
                tv.setVisibility(View.VISIBLE);
                break;
            case R.id.shinigami_radio_button:
                if (checked)
                    tv.setText(R.string.shinigami_bit);
                tv.setVisibility(View.VISIBLE);
                break;
            case R.id.tanuki_radio_button:
                if (checked)
                    tv.setText(R.string.tanuki_bit);
                tv.setVisibility(View.VISIBLE);
                quizScore += 1;
                break;
        }
        ImageView tanukiImage = (ImageView) findViewById(R.id.tanuki_image);
        tanukiImage.setVisibility(View.VISIBLE);
    }

    /**
     * @param view Listen for checkbox taps. If user selects all of the correct checkboxes, update score.
     *             If incorrect, display incorrect text
     */
    //TODO Write logic to determine if user as chosen a wrong answer, then prevent quizscore from being updated.
    public void onRiceFoodsCheckBoxesChecked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        TextView tv = (TextView) findViewById(R.id.rice_set_answer_text);

        switch (view.getId()) {
            case R.id.onigiri_checkbox:
                if (checked)
                    tv.setText(R.string.onigiri_bit);
                riceCheckBoxCount += 1;
                if (riceCheckBoxCount == 3) {
                    quizScore += 1;
                    tv.setText(R.string.rice_answer_set);
                }
                break;
            case R.id.mochi_checkbox:
                if (checked)
                    tv.setText(R.string.mochi_bit);
                riceCheckBoxCount += 1;
                if (riceCheckBoxCount == 3) {
                    tv.setText(R.string.rice_answer_set);
                    quizScore += 1;
                }
                break;
            case R.id.sake_checkbox:
                if (checked)
                    tv.setText(R.string.sake_bit);
                riceCheckBoxCount += 1;
                if (riceCheckBoxCount == 3) {
                    tv.setText(R.string.rice_answer_set);
                    quizScore += 1;
                }
                break;
            case R.id.tamago_checkbox:
                if (checked)
                    tv.setText(R.string.ramen_bit);
                break;
            case R.id.chashu_checkbox:
                if (checked)
                    tv.setText(R.string.chashu_bit);
                break;
            case R.id.ramen_checkbox:
                if (checked)
                    tv.setText(R.string.ramen_bit);
                break;
        }

    }

    /**
     * @param view If user chooses true, update text and score. If user chooses false, update text but not score.
     */
    public void onMisogiQuestionChosen(View view) {
        boolean chosen = ((RadioButton) view).isChecked();
        TextView tv = (TextView) findViewById(R.id.misogi_answer_set_text);

        switch (view.getId()) {
            case R.id.misogi_true:
                if (chosen) {
                    tv.setText(R.string.misogi_answer_right);
                    quizScore += 1;
                    break;
                }
            case R.id.misogi_false:
                if (chosen) {
                    tv.setText(R.string.misogi_answer_wrong);
                    break;
                }
            default:
                tv.setText(R.string.misogi_answer_set);
        }
    }

    /**
     * @param view Evaluate which Radio button was selected. If answer is correct, update score, and show text.
     *             If incorrect show corresponding text.
     *             Then reveal artwork
     */
    public void onMacaqueButtonSetClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        TextView tv = (TextView) findViewById(R.id.macaque_set_answer_text);

        //Check which RadioButton is selected then return correct or incorrect text depending on user answer
        switch (view.getId()) {
            case R.id.macaque_radio_button:
                if (checked)
                    quizScore += 1;
                tv.setText(R.string.macaque_bit);
                break;
            case R.id.tit_radio_button:
                if (checked)
                    tv.setText(R.string.tit_bit);
                break;
            case R.id.dog_radio_button:
                if (checked)
                    tv.setText(R.string.dog_bit);
                break;
            case R.id.shinkansen_radio_button:
                if (checked)
                    tv.setText(R.string.shinkansen_bit);
                break;
        }
        ImageView macaqueImage = (ImageView) findViewById(R.id.macaque_image);
        macaqueImage.setVisibility(View.VISIBLE);
    }

    /**
     * @param view Capture player's score
     */
    public void score(View view) {
        // Check that player's score does not go over the number of questions.
        if (quizScore > 6) {
            quizScore = 6;
        }
        displayPlayerScore(quizScore);
        Toast toast = Toast.makeText(this, "Your score is: " + String.valueOf(quizScore) + "/6", Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * @param score Display score in view
     */
    public void displayPlayerScore(int score) {
        TextView tv = (TextView) findViewById(R.id.player_score_display_text_view);
        tv.setText(String.valueOf(score));
    }
}
