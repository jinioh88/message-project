package app.study.message.controller;

import app.study.message.Message;
import app.study.message.dto.MessageData;
import app.study.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/hellos")
    public String hello(Model model) {
        model.addAttribute("message", "Hello world!");
        return "hello"; // HttpServletResponse에 전달
    }

    @PostMapping("/hellos")
    @ResponseBody
    public ResponseEntity<Message> saveMessage(@RequestBody MessageData data) {
        Message savedMessage = messageService.save(data.getText());
        if(savedMessage == null) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok(savedMessage);
    }
}
