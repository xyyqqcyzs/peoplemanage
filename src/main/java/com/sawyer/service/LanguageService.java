package com.sawyer.service;

import com.sawyer.entity.Language;

import java.util.List;

public interface LanguageService {
    List<Language> findbyemp(int emp_ID);
    void add(Language lan);
    void delete(int language_ID);
    void update(Language lan);
}
