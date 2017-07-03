package com.wen;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author awlwen
 * @since 2017/6/6.
 */
@RestController
public class WriteController {

    @RequestMapping(value = "test.do")
    public String printRequest(HttpServletRequest request, HttpServletResponse response){

        return "{\"DeptId\":\"06221}";
    }
}
