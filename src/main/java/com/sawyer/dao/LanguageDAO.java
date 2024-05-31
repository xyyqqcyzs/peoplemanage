package com.sawyer.dao;

import com.sawyer.entity.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


public interface LanguageDAO {
    List<Language> findbyemp(int emp_ID);
    void add(Language lan);
    void delete(int language_ID);
    void update(Language lan);

}
