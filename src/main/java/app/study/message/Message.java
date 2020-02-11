package app.study.message;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@Getter
@EqualsAndHashCode
public class Message {
    private Long id;
    private String text;
    private Date createdDate;

    public Message(String text)
    {
        this.text = text;
        this.createdDate = new Date();
    }

    public Message(Long id, String text, Date createdDate) {
        this.id = id;
        this.text = text;
        this.createdDate = createdDate;
    }
}
