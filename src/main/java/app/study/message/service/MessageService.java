package app.study.message.service;

import app.study.message.Message;
import app.study.message.repository.MessageRepository;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    private MessageRepository repository;

    @Autowired // 생성자 주입방식,  생략 가능
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    // 세터 메서드(일반 메서드)로 생성자 주입 방식
//    @Autowired
//    public void setRepository(MessageRepository repository) {
//        this.repository = repository;
//    }

    // 필드 메서드 주입방법
//    @Autowired
//    private MessageRepository repository;

    public void save(String message) {
        repository.saveMessage(new Message(message));
    }
}
