package kr.tjeit.algorithmtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/*
2번 문제 : 4가지 형태의 별찍기

*
* *
* **




 */

public class Question02Activity extends BaseActivity {

    private android.widget.EditText lineNumEdt;
    private android.widget.Button printStar01Btn;
    private android.widget.Button printStar02Btn;
    private android.widget.Button printStar03Btn;
    private android.widget.Button printStar04Btn;
    private android.widget.TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question02);


        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        printStar02Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printStar02();

            }
        });

        printStar01Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                printStar01();

            }
        });

    }
    void  printStar02(){

//        4줄을 출력!
        int inputLineNum = Integer.parseInt(lineNumEdt.getText().toString());
        String resultString = " ";

        for (int i =0; i <inputLineNum; i++){

//            먼저 띄어쓰기


            for (int j=0 ; j <inputLineNum-1-i; j++){

                resultString += " ";

            }
//            띄어쓰기가 끝나면 *

            for (int j =0 ; j <i+1; j++){

                resultString += "*";

            }

            resultString += "\n";

        }

    }

    void printStar01() {

//        만약에 줄수가 4줄로 입력된다면?

//        *
//        **
//        ***
//        ****

        int inputLineNum = Integer.parseInt(lineNumEdt.getText().toString());
        String resultString = " ";

        for (int i =0; i< inputLineNum;i++){

            for (int j=0; j < i+1 ; j++){

                resultString += "*";
            }

            resultString += "\n";
        }

        resultTxt.setText(resultString);


    }



    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
        this.printStar04Btn = (Button) findViewById(R.id.printStar04Btn);
        this.printStar03Btn = (Button) findViewById(R.id.printStar03Btn);
        this.printStar02Btn = (Button) findViewById(R.id.printStar02Btn);
        this.printStar01Btn = (Button) findViewById(R.id.printStar01Btn);
        this.lineNumEdt = (EditText) findViewById(R.id.lineNumEdt);

    }
}
