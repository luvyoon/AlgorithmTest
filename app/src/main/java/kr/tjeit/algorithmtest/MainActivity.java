package kr.tjeit.algorithmtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private android.widget.Button questionBtn;
    private Button question2Btn;
    private Button question3Btn;
    private Button question4Btn;

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

        question4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Question04Activity.class);
                startActivity(intent);
            }
        });


        question3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Question03Activity.class);
                startActivity(intent);
            }
        });


        question2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Question02Activity.class);
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
        this.question4Btn = (Button) findViewById(R.id.question4Btn);
        this.question3Btn = (Button) findViewById(R.id.question3Btn);
        this.question2Btn = (Button) findViewById(R.id.question2Btn);
        this.questionBtn = (Button) findViewById(R.id.questionBtn);

    }
}
