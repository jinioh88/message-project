package app.study.message;

import lombok.Getter;

@Getter
public class Message {
    private String text;

    private Message(String text) {
        this.text = text;
    }
}
