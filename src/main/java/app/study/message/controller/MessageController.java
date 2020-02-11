package app.study.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/messages")
public class MessageController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello world!");
        return "hello"; // HttpServletResponse에 전달
    }
}
