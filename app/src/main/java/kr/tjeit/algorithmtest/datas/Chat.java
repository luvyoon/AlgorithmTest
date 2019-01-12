package kr.tjeit.algorithmtest.datas;

import java.io.Serializable;

public class Chat implements Serializable {

    private String sender;
    private String message;

    public Chat(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}