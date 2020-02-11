package app.study.message.service;

import app.study.message.Message;
import app.study.message.repository.MessageRepository;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    private MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public void save(String message) {
        repository.saveMessage(new Message(message));
    }
}
