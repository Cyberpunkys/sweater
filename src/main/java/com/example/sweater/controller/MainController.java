package com.example.sweater.controller;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller //Контроллер - это модуль, который по Mapping (пути) слушает запросы от юзера и возвращает данные
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) { //model - то, куда мы складываем данные, которые мы возвращаем юзеру
        return "greeting"; //В данном случае мы просто возвращаем файл-шаблон
    }

    @GetMapping("/main") //mapping с методом GET (чаще всего URL)
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        }  else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main") //mapping с методом POST (чаще всего <form>)
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model
    ) {

        Message message = new Message(text, tag, user);
        messageRepo.save(message); //сохраняем в БД

        Iterable<Message> messages = messageRepo.findAll(); //выводим данные из БД после сохранения
        model.put("messages", messages);

        return "main";
    }
}
