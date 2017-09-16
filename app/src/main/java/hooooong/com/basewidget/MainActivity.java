package hooooong.com.basewidget;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textResult;
    private ToggleButton toggleButton;
    private CheckBox chkDog;
    private CheckBox chkPig;
    private CheckBox chkCow;
    private RadioGroup radioGroup;
    private RadioButton radioSpinner;
    private RadioButton radioRed;
    private RadioButton radioGreen;
    private RadioButton radioBlue;
    private RadioButton radioButton2;
    private ProgressBar progressBar;
    private Switch mSwitch;
    private SeekBar seekBar;
    private TextView textSeekbarResult;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        toggleButton.setOnCheckedChangeListener(checkedChangeListener);
        mSwitch.setOnCheckedChangeListener(checkedChangeListener);

        chkDog.setOnCheckedChangeListener(checkboxListener);
        chkPig.setOnCheckedChangeListener(checkboxListener);
        chkCow.setOnCheckedChangeListener(checkboxListener);

        radioGroup.setOnCheckedChangeListener(radioListener);


        progressBar.setVisibility(View.INVISIBLE);  // INVISIBLE -- 화면에 안보이는데 자리는 차지하고 있다
                                                    // VISIBLE   -- 현재 화면에 보이는 상태
                                                    // GONE      -- 화면에서 사라진 상태

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // onProgressChanged() : 드래그 하는 중에 발생
                textSeekbarResult.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // onStartTrackingTouch()   :  최초에 탭하여 드래그 시작할때 발생

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //  onStopTrackingTouch() : 드래그를 멈출때 발생

            }
        });

        // rating 선택 범위 설정
        //ratingBar.setStepSize(6);
        // rating 갯수 설정
        ratingBar.setNumStars(6);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                textSeekbarResult.setText(ratingBar.getRating() + "");
            }
        });


    }

    // 라디오그룹 리스너
    RadioGroup.OnCheckedChangeListener radioListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int radio_id) {
            switch (radio_id) {
                case R.id.radioRed:
                    textResult.setText("빨간불이 켜졌습니다.");
                    break;
                case R.id.radioGreen:
                    textResult.setText("녹색불이 켜졌습니다.");
                    break;
                case R.id.radioBlue:
                    textResult.setText("파란불이 켜졌습니다.");
                    break;
                case R.id.radioActivity:
                    Intent spinnerActivity = new Intent(getBaseContext(), SpinnerActivity.class);
                    startActivity(spinnerActivity);
                    break;
            }
        }
    };

    // 체크박스 리스너
    ArrayList<String> checkedList = new ArrayList<>();
    CompoundButton.OnCheckedChangeListener checkboxListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            // 체크박스 처리
            switch (compoundButton.getId()) {
                case R.id.chkDog:
                    if (b) {
                        checkedList.add("개");
                    } else {
                        checkedList.remove("개");
                    }
                    break;
                case R.id.chkPig:
                    if (b) {
                        checkedList.add("돼지");
                    } else {
                        checkedList.remove("돼지");
                    }
                    break;
                case R.id.chkCow:
                    if (b) {
                        checkedList.add("소");
                    } else {
                        checkedList.remove("소");
                    }
                    break;
            }

            String checkedResult = "";
            for (String item : checkedList) {
                checkedResult += item + " ";
            }

            textResult.setText(checkedResult + "(이)가 체크되었습니다.");
        }
    };

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
            // 토글, 스위치 처리
            switch (compoundButton.getId()) {
                case R.id.toggleButton:
                    // Check 값으로 On, Off 를 알 수 있다.
                    if (check) {
                        textResult.setText("토글버튼이 켜졌습니다");
                    } else {
                        textResult.setText("토글버튼이 꺼졌습니다");
                    }
                    break;
                case R.id.mSwitch:
                    if (check) {
                        progressBar.setVisibility(View.VISIBLE);
                    } else {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                    break;
            }
        }
    };


    private void initView() {
        textResult = (TextView) findViewById(R.id.textView);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        chkDog = (CheckBox) findViewById(R.id.chkDog);
        chkPig = (CheckBox) findViewById(R.id.chkPig);
        chkCow = (CheckBox) findViewById(R.id.chkCow);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioRed = (RadioButton) findViewById(R.id.radioRed);
        radioGreen = (RadioButton) findViewById(R.id.radioGreen);
        radioBlue = (RadioButton) findViewById(R.id.radioBlue);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mSwitch = (Switch) findViewById(R.id.mSwitch);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textSeekbarResult = (TextView) findViewById(R.id.seekbarResultTxt);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
    }
}