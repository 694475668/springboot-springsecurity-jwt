package com.ratta.controller;

import com.ratta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ******Title:<p> 程序的奥秘 </p> ******
 * ******Description:<p> </p>******
 * ******Company: <p> 雷塔智能科技有限公司 </p> ******
 *
 * @version :
 * @author: 刘 明
 * @date:Created in 2020/6/24 12:41
 */
@Controller
@RequestMapping("/login")
public class IndexController {


    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        return "login";
    }

}
