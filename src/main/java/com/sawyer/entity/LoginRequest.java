package com.sawyer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequest {
    private String account;
    private String password;

    public String getAccount() {
        return this.account;
    }
    public String getPassword() {
        return this.password;
    }
}
