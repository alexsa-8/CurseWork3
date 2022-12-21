package com.skypro.cursework3;

import com.skypro.cursework3.model.Question;
import com.skypro.cursework3.service.ExaminerServiceImpl;
import com.skypro.cursework3.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    private Collection<Question> questions;

    @BeforeEach
    public void setUp(){
        questions= Set.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3"),
                new Question("question4", "answer4")
        );
        when(javaQuestionService.getAll()).thenReturn(questions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3"),
                new Question("question4", "answer4")
        );
    }
    @Test
    public void weGetQuestions(){

        Assertions.assertEquals(examinerService.getQuestions(4), questions);
    }
}
