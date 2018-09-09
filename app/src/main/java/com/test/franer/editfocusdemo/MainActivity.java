package com.test.franer.editfocusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyEditText.SelectionChangedListener {

    private TextView start;
    private TextView end;
    private TextView text;
    private MyEditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        editText = findViewById(R.id.editText);
        editText.addSelectionChangedListener(this);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        text = findViewById(R.id.text);
    }

    @Override
    public void onSelectionChanged(int selStart, int selEnd) {
        Log.i("franer", "selStart:"+selStart+" selEnd:"+selEnd);
        start.setText(String.format("光标开始位置:%d", selStart));
        end.setText(String.format("光标结束位置:%d", selEnd));
        CharSequence cs = editText.getText().subSequence(selStart,selEnd);
        text.setText(String.format("光标所选中文字:%s", TextUtils.isEmpty(cs)? "空" : cs.toString()));
    }
}
