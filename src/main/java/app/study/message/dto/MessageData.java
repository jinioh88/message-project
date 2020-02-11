package app.study.message.dto;

import lombok.Data;

@Data
// 요청 본문에 대한 정의
public class MessageData {
    private String text;
}
