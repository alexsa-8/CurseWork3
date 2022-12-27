package com.skypro.cursework3.repository;

import com.skypro.cursework3.model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();
//    @Override
//    public Question add(Object question, Object answer) {
//        Question question1=new Question(question, answer);
//        questions.add(question1);
//        return (Question) question;
//    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
