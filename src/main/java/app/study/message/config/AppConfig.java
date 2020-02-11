package app.study.message.config;

import app.study.message.repository.MessageRepository;
import app.study.message.service.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("app.study")
public class AppConfig {
    @Bean
    public MessageRepository messageRepository() {
        return new MessageRepository();
    }

    @Bean
    public MessageService messageService() {
        return new MessageService(messageRepository());
    }
}
