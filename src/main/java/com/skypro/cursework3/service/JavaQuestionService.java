package com.skypro.cursework3.service;

import com.skypro.cursework3.exception.QuestionNotFoundException;
import com.skypro.cursework3.model.Question;
import com.skypro.cursework3.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository questions;
    private final Random random = new Random();

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {

        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.getAll().contains(question)) {
            throw new QuestionNotFoundException("Этот вопрос уже есть в списке.");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.getAll().contains(question)) {
            throw new QuestionNotFoundException("Этого вопроса нет в списке.");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questions.getAll()).get(random.nextInt(questions.getAll().size()));
    }
}
