package kr.tjeit.algorithmtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private android.widget.Button questionBtn;
    private Button question2Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        question2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(mContext,Question02Activity.class);
                startActivity(intent);
            }
        });

        questionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Question01Activity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.question2Btn = (Button) findViewById(R.id.question2Btn);
        this.questionBtn = (Button) findViewById(R.id.questionBtn);

    }
}
