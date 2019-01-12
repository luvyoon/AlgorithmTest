package kr.tjeit.algorithmtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Question03Activity extends BaseActivity {

    private android.widget.Button twoBtn;
    private android.widget.Button threeBtn;
    private android.widget.Button fourBtn;
    private android.widget.Button fiveBtn;
    private android.widget.Button sixBtn;
    private android.widget.Button sevenBtn;
    private android.widget.Button eightBtn;
    private android.widget.Button nineBtn;
    private android.widget.Button totalBtn;
    private android.widget.TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question03);

        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {

//        2~9단 까지는 똑같은 행위를 하는데 숫자만 다른 상황.
//        그 달라지는 숫자를 태그에 메모해두고, 찾아서 활용 이벤트

        View.OnClickListener guguListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //                2*1 ~2*9 까지 갑을 resultTxt 값에 출력

//                String 변수를 가공해서 최종 결과를 resultTxt의 text로 지정

//                xml에 적은 태그는 기본적으로 String형태로 뽑힘.


                String danStr = v.getTag().toString();
//                Toast.makeText(mContext, danStr, Toast.LENGTH_SHORT).show();

//                tag 는 str 이므로 -> for :int로 변환
//                integer클래스 활용해서 변환하기

                int dan = Integer.parseInt(danStr);


                String gugudanStr = " ";

                for (int i = 1 ; i < 10 ; i ++){

                    gugudanStr += String.format( "%d * %d = %d\n" , dan ,i, dan*i);

                }

                resultTxt.setText(gugudanStr);


            }
        };

        twoBtn.setOnClickListener(guguListener);
        threeBtn.setOnClickListener(guguListener);
        fourBtn.setOnClickListener(guguListener);
        fiveBtn.setOnClickListener(guguListener);
        sixBtn.setOnClickListener(guguListener);
        sevenBtn.setOnClickListener(guguListener);
        eightBtn.setOnClickListener(guguListener);
        nineBtn.setOnClickListener(guguListener);



    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
        this.totalBtn = (Button) findViewById(R.id.totalBtn);
        this.nineBtn = (Button) findViewById(R.id.nineBtn);
        this.eightBtn = (Button) findViewById(R.id.eightBtn);
        this.sevenBtn = (Button) findViewById(R.id.sevenBtn);
        this.sixBtn = (Button) findViewById(R.id.sixBtn);
        this.fiveBtn = (Button) findViewById(R.id.fiveBtn);
        this.fourBtn = (Button) findViewById(R.id.fourBtn);
        this.threeBtn = (Button) findViewById(R.id.threeBtn);
        this.twoBtn = (Button) findViewById(R.id.twoBtn);

    }
}
