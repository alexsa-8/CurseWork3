package com.skypro.cursework3;

import com.skypro.cursework3.exception.QuestionNotFoundException;
import com.skypro.cursework3.model.Question;
import com.skypro.cursework3.repository.JavaQuestionRepository;
import com.skypro.cursework3.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository repository;

    public static final String QUESTION = "question";

    public static final String ANSWER = "answer";

    public static final Question TEST = new Question("question", "answer");
    @InjectMocks
    private JavaQuestionService service;


    @Test
    public void addQuestionAnswerTest() {
        when(repository.add(TEST)).thenReturn(TEST);
        assertEquals(service.add(QUESTION, ANSWER), TEST);
    }

    @Test
    public void removeTest() {
        Question question = new Question(QUESTION, ANSWER);
        repository.add(question);
        Assertions.assertThrows(QuestionNotFoundException.class, () -> service.remove(question));
    }

    @Test
    public void getAllTest() {
        Set<Question> questions = new HashSet<>();
        when(repository.getAll()).thenReturn(questions);
        assertEquals(service.getAll(), questions);
    }

    @Test
    public void getRandomQuestionTest(){
        Set<Question> questions=Set.of(TEST);
        when(repository.getAll()).thenReturn(questions);
        Question question=service.getRandomQuestion();
        assertNotEquals(question, questions);
    }
}
