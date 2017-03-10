package com.japanquiz.android.japanquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    private int quizScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void evaluateTokyoQuestionText(View v){
        EditText tokyoEditText = (EditText) findViewById(R.id.enter_city_edit_text_view);
        final String answerText = tokyoEditText.getText().toString();
        final TextView tv = (TextView) findViewById(R.id.tokyo_answer_response_text);
        Button submitAnswerButton = (Button) findViewById(R.id.enter_city_edit_text_submit_button);
        submitAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerText.equals("Tokyo") ){
                    tv.setText(R.string.great_job_text);
                    tv.setVisibility(View.VISIBLE);
                    quizScore += 1;
                } else {
                    tv.setText(R.string.not_right);
                    tv.setVisibility(View.VISIBLE);
                }
                ImageView tokyoGodzillaImage = (ImageView) findViewById(R.id.tokyo_godzilla_image);
                tokyoGodzillaImage.setVisibility(View.VISIBLE);
            }
        });

    }

    public void onKyotoRadioButtonSetClicked(View v){
        boolean checked = ((RadioButton) v).isChecked();
        TextView tv = (TextView) findViewById(R.id.kyoto_set_answer_text);

//        Check which Radio is selected
        switch (v.getId()) {

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
                    tv.setVisibility(View.VISIBLE);
                break;
        }
        ImageView kyotoImage = (ImageView) findViewById(R.id.kyoto_image);
        kyotoImage.setVisibility(View.VISIBLE);

    }
}
