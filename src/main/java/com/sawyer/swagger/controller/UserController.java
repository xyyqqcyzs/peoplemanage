package com.sawyer.swagger.controller;

import com.sawyer.entity.LoginRequest;

import com.sawyer.entity.User;
import com.sawyer.service.UserService;
import com.sawyer.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * @author sawyer
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/register")
    public ResponseEntity<String> register(User user) {
            userService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("注册成功");
    }



    @GetMapping("/code")
    public void getVerification(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //存入session中
        session.setAttribute("code", securityCode);
        //响应图片
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }


    /*@PostMapping(value = "/login")
    public String login(String account, String password) {
        User login = userService.login(account, password);
        if (login != null) {
            return "登陆成功";
        } else {
            return "登陆失败";
        }
    }*/
    @PostMapping(value = "/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String account = loginRequest.getAccount();
        String password = loginRequest.getPassword();
        User login = userService.login(account,password);
        if (login != null) {
            return "登陆成功";
        } else {
            return "登陆时报";
        }
    }

}
