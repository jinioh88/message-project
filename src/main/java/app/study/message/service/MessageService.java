package app.study.message.service;

import app.study.message.model.Message;
import app.study.message.security.SecurityCheck;
import app.study.message.repository.MessageRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class MessageService {
    private final static Log log = LogFactory.getLog(MessageService.class);
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

    @SecurityCheck
    @Transactional
    public Message save(String text) {
        return repository.saveMessage(new Message(text));
    }

    @Transactional(readOnly = true)
    public List<Message> getMessages() {
        return repository.getMessages();
    }

}
