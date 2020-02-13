package app.study.message.controller;

import app.study.message.model.Message;
import app.study.message.dto.MessageData;
import app.study.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/messages")
    public String index() {
        return "index";
    }

    @GetMapping("/api/messages")
    @ResponseBody
    public ResponseEntity<List<Message>> getMessages() {
        List<Message> messages = messageService.getMessages();
        return ResponseEntity.ok(messages);
    }

    @PostMapping("/api/messages")
    @ResponseBody
    public ResponseEntity<Message> saveMessage(@RequestBody MessageData data) {
        Message savedMessage = messageService.save(data.getText());
        if(savedMessage == null) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok(savedMessage);
    }
}
