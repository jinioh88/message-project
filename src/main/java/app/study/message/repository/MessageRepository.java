package app.study.message.repository;


import app.study.message.Message;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageRepository {

    private final static Log log = LogFactory.getLog(MessageRepository.class);
    private final SessionFactory sessionFactory;

    public Message saveMessage(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.save(message);

        return message;
    }
}
