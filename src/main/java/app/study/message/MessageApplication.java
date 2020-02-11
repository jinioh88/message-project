package app.study.message;

import app.study.message.config.AppConfig;
import app.study.message.service.MessageService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MessageApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageService messageService = context.getBean(MessageService.class);
        messageService.save("안녕하세요! Test 입니다.");
    }

}
