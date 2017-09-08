package com.cbdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbox;
    private EditText et;
    private static final int STATE_1 = 1;
    private static final int STATE_2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et);
        cbox = (CheckBox) findViewById(R.id.showPwdCB);
        cbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //showOrHide(STATE_1, b);
                showOrHide(STATE_2, b);
            }
        });
    }

    private void showOrHide(int state, boolean isChecked) {
        switch (state) {
            case STATE_1: {
                int passwordLength = et.getText().length();
                cbox.setInputType(isChecked ?
                        (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) :
                        (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD));
                et.setSelection(passwordLength);
                break;
            }
            case STATE_2: {
                if (isChecked) {
                    et.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    et.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            }
        }
    }
}
