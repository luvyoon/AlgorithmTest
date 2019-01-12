package kr.tjeit.algorithmtest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Question05Activity extends BaseActivity {

//    컴퓨터가 출제한 문제(3자리 숫자가 저장됨)
    int[] questionIntArray = new int[3];




    private android.widget.ListView chatListView;
    private android.widget.EditText numInputEdt;
    private android.widget.Button okBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question05);


        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

//        화면을 켜면 컴퓨터가 바로 문제를 출제
        makeQuestionNumbers();

    }

    void  makeQuestionNumbers (){
//        문제를 조건. 3자리 숫자를 생각.
//        매번 그때 그때 다른값 =>Math.random()
//        0은 사용 하지 않을 생각. 1-9
//        중복된 숫자가 있으면 안됨.

//        문제를 만드는 방식
//        맨 앞자리를 1-9사이로 채움.
//        이 행위를 3번 반복(앞, 가운데, 뒷자리)
//        만들어진 숫자를 봤을 때 중복된 숫자가 있는지 ?
//        중복된 숫자가 있다면 3자리 숫자를 다시 생성.


//        조건을 만족 시킬때까지 무한반복.
//        조건이 만족되면 break; while문 탈출 !
        while (true){

//            앞/ 가운데/뒷자리 순서대로 랜덤값을 채우는 반복문
             for (int i=0 ; i<3; i++){

//                  Math.random() => 0.0 <=랜덤 숫자 <1.0사이의 숫자가 랜덤으로 발생 (1-9까지의 값을 위해 +1해줌)

//                 1-9 사이의 숫제를 랜덤으로 뽑아서 대입.
                 questionIntArray[i] = (int) (Math.random() * 9 + 1);

             }

//             112 , 211, 121 이렇게 중복되면 안됨
             if ((questionIntArray[0] != questionIntArray[1])
                     && (questionIntArray[1] != questionIntArray[2])
                     && (questionIntArray[0] != questionIntArray[2])) {

                 break;


             }

        }

//        임시로 값을 확인

        String temp = String.format("%d %d %d", questionIntArray[0],questionIntArray[1],questionIntArray[2]);

        numInputEdt.setText(temp);

    }

    @Override
    public void bindViews() {

        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.numInputEdt = (EditText) findViewById(R.id.numInputEdt);
        this.chatListView = (ListView) findViewById(R.id.chatListView);

    }
}
