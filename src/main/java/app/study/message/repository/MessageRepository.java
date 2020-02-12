package app.study.message.repository;


import app.study.message.Message;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<Message> getMessages() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Message";
        Query<Message> query = session.createQuery(hql, Message.class);

        return query.list();
    }
}
