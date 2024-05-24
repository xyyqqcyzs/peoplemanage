package com.sawyer.swagger.controller;

import com.sawyer.entity.LoginResponse;
import com.sawyer.entity.LoginUser;
import com.sawyer.entity.User;
import com.sawyer.service.UserService;
import com.sawyer.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * @author sawyer
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 注册方法
     *
     * @param user
     * @param code
     * @param session
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(User user) {
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("注册成功");
    }
    /*public String register(User user, String code, HttpSession session) {
        String sessionCode = (String) session.getAttribute("code");
        if (sessionCode.equalsIgnoreCase(code)) {
            userService.register(user);
            return "redirect:/index";
        } else {
            return "redirect:/toRegister";
        }
    }*/
   


    /**
     * 生成验证码
     *
     * @param session
     * @param response
     * @throws IOException
     */
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
    public User login(@RequestBody LoginUser loginuser) {
        String account=loginuser.getAccount();
        String password=loginuser.getPassword();
        System.out.println(account);
        User login = userService.login(account, password);
        System.out.println(login);
        if (login != null) {
            System.out.println("登陆成功");
            return login;
            /*LoginResponse response = new LoginResponse("登录成功", login);
            return ResponseEntity.ok(response);*/
        } else {
            System.out.println("登陆失败");
            return null;
            /*LoginResponse response = new LoginResponse("登录失败", null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);*/
        }
    }

}
