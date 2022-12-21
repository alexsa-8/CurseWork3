package com.skypro.cursework3.controller;

import com.skypro.cursework3.model.Question;
import com.skypro.cursework3.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer){
        return service.add(question, answer);
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question, @RequestParam("answer") String answer){
        Question tmp=new Question(question, answer);
        return service.remove(tmp);
    }
    @GetMapping
    public Collection<Question> getAll(){
        return service.getAll();
    }

}
