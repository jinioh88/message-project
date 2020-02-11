package app.study.message.repository;


import app.study.message.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MessageRepository {
    private final static Log log = LogFactory.getLog(MessageRepository.class);

    public void saveMessage(Message message) {
        log.info("메세지 저장 : " + message.getText());
    }
}
