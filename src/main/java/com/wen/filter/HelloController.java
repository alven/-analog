package com.wen.filter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author awlwen
 * @since 2017/5/18.
 */
@Controller
public class HelloController {
    @RequestMapping("/json")
    public String Json() throws MyException{
        throw new MyException("发生错误");
    }
}
