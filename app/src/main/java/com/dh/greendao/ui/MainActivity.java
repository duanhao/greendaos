package com.dh.greendao.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dh.greendao.R;
import com.dh.greendao.presenter.UserTestPresenter;

public class MainActivity extends AppCompatActivity implements IUserTestView {

    private EditText mContentEditView;
    private TextView mShowTxt;
    private Button mSureButtion;
    private UserTestPresenter userTestPresenter = new UserTestPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContentEditView = findView(R.id.content_editText);
        mShowTxt = findView(R.id.show_txt);
        mSureButtion = findView(R.id.sure_button);
        mSureButtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTestPresenter.insertUser();
            }
        });
    }

    public <T extends View> T findView(int viewId) {
        return (T) findViewById(viewId);

    }

    @Override
    public String getEditTextContent() {
        return mContentEditView.getText().toString().trim();
    }

    @Override
    public void showTextContent(String edtiTextContentStr) {
        mShowTxt.setText("显示：" + edtiTextContentStr);
    }
}
