package hooooong.com.basewidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        final TextView textView = (TextView)findViewById(R.id.textView);

        // 1. Spinner 에 입력될 데이터가 정의되어야 한다.
        final String data[] ={"월","화","수","목","금","토","일"};

        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, data);

        // 2. Spinner 와 Data 를 연결하는 어뎁터
        // Resource 를 커스터마이징이 가능하지만
        // 기본적으로 Android 에서 제공해주는 Resource(android.R.layout) 가 있다.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,                                           // Context
                android.R.layout.simple_dropdown_item_1line,    // Resource
                data                                            // Data
        );

        // 3. Spinner 와 Adapter 를 연결한다.
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        // 4. Spinner 에 Listener 를 달아준다.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedValue = data[position];
                textView.setText(selectedValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
