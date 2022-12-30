package com.skypro.cursework3.service;

import com.skypro.cursework3.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
