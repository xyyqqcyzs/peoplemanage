package com.sawyer.dao;

import com.sawyer.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    void save(User user);
    User login(@Param("account") String account, @Param("password") String password);
}
