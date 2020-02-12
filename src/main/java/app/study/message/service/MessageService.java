package app.study.message.service;

import app.study.message.Message;
import app.study.message.SecurityCheck;
import app.study.message.SecurityChecker;
import app.study.message.repository.MessageRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        Message message = repository.saveMessage(new Message(text));
        updateStatistics();

        return message;
    }

    // 트랜잭션 롤백용
    private void updateStatistics() {
        throw new UnsupportedOperationException("This method is not implemented yey...");
    }
}
