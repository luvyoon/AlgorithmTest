package kr.tjeit.algorithmtest;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kr.tjeit.algorithmtest.adapters.ChatAdapter;
import kr.tjeit.algorithmtest.datas.Chat;

public class Question05Activity extends BaseActivity {

//    굳이<Chat> 을 명시하는이유?
//    자바 1.8로 오면서 안써도 되게 업데이트
//    올드버젼을 쓰는 경우 대비

    List<Chat> chatList = new ArrayList<Chat>();

    ChatAdapter mChatAdapter;

    //    컴퓨터가 출제한 문제(3자리 숫자가 저장됨)
    int[] questionIntArray = new int[3];

//    사용자가 몇번이나 정답을 시도했는지

    int userTryCount = 0;

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


        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkUserNumber();

            }
        });


    }

    //     정답을 체크하는 메쏘드
    void checkUserNumber() {

//        시도 횟수를 1 증가.
        userTryCount++;

//        3자리가 아닐경우 다시 입력하게  Toast

        if (numInputEdt.length() != 3) {

            Toast.makeText(mContext, "3자리 숫자를 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }

//        사용자가 입력한 숫자를 저장할 세칸짜리 배열.
//        152 => [1], [5],[2]
        int[] userInputIntArray = new int[3];

//        사용자가 입력한 값을 String으로 따내자

        String inputStr = numInputEdt.getText().toString();

//        입력한 값을 채팅처럼 메세지로 출력. =>chatlist추가

        Chat inputNumChat = new Chat("user", inputStr);
        chatList.add(inputNumChat);
        mChatAdapter.notifyDataSetChanged();
//     notifychanged 필요함



//        배열에 각 자리의 숫자를 집어넣기.

//        먼저 String을 숫자로 변경
        int inputNumber = Integer.parseInt(inputStr);

//        0번칸 : 맨 앞자리를 대입하는 방법?

        userInputIntArray[0] = inputNumber / 100;

//        1번칸 : 가운데자리 따내는 방법
        userInputIntArray[1] = inputNumber % 100 / 10;

//        2번칸: 맨 뒷자리를 따내는 방법

        userInputIntArray[2] = inputNumber % 10;


//        숫자를 다 집어 넣었으면, 실제로 정답과 비교해서 ?S ?B인지 계산.

//        ?SB 인지 저장될 변수
        int strikeCount = 0;
        int ballCount = 0;

//        사용자가 입력한 값을 담당
        for (int i = 0; i < 3; i++) {


//            i:정답지를 돌아보는  index
            for (int j = 0; j < 3; j++) {

                if (userInputIntArray[i] == questionIntArray[j]) {

                    if (i == j) {

//                        위치도 같다! Strike갯수 증가


                        strikeCount++;


                    } else {
//                         ball ->위치는 다르지만 숫자 같음

                        ballCount++;
                    }


                }


            }

        }

       final String replyMessage = String.format("%d S %d B 입니다", strikeCount, ballCount);
//        Toast.makeText(mContext, temp, Toast.LENGTH_SHORT).show();



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Chat reply = new Chat("computer", replyMessage);
                chatList.add(reply);
                mChatAdapter.notifyDataSetChanged();
                chatListView.smoothScrollToPosition(chatList.size()-1);
            }
        },500);



        if (strikeCount == 3) {

//            Toast.makeText(mContext, "정답 입니다!", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Chat correct = new Chat("computer", "정답입니다 !");
                    chatList.add(correct);
                    mChatAdapter.notifyDataSetChanged();


                }
            },700);



//            Toast.makeText(mContext, userTryCount+ "번 만에 맞췄습니다.", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Chat countMessage = new Chat("computer", userTryCount + "번 만에 맞췄습니다.");
                    chatList.add(countMessage);
                    mChatAdapter.notifyDataSetChanged();
                }
            },1000);



        }


    }

    @Override
    public void setValues() {

        mChatAdapter = new ChatAdapter(mContext,chatList);
        chatListView.setAdapter(mChatAdapter);

//        화면을 켜면 컴퓨터가 바로 문제를 출제
        makeQuestionNumbers();

    }

    void makeQuestionNumbers() {
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
        while (true) {

//            앞/ 가운데/뒷자리 순서대로 랜덤값을 채우는 반복문
            for (int i = 0; i < 3; i++) {

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

//        String temp = String.format("%d %d %d", questionIntArray[0], questionIntArray[1], questionIntArray[2]);
//
//        numInputEdt.setText(temp);

    }

    @Override
    public void bindViews() {

        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.numInputEdt = (EditText) findViewById(R.id.numInputEdt);
        this.chatListView = (ListView) findViewById(R.id.chatListView);

    }
}
