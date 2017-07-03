package com.wen;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author awlwen
 * @since 2017/5/13.
 */
@RestController
@ResponseBody
public class HiController {
    private static Random random = new Random();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @RequestMapping(value = "queryActBalInfo.do")
    public String printRequest(HttpServletRequest request, HttpServletResponse response){
        String appid = request.getHeader("appid");
        String version = request.getHeader("version");
        String charset = request.getHeader("charset");
        String timestamp = request.getHeader("timestamp");
        String sequenceid = request.getHeader("sequenceid");
        String algorithm = request.getHeader("algorithm");
        String payload = request.getParameter("payload");
        String signature = request.getParameter("signature");
        Map map = new HashMap();
        map.put("appid", appid);
        map.put("version", version);
        map.put("charset", charset);
        map.put("sequenceid", sequenceid);
        map.put("algorithm", algorithm);
        map.put("payload", payload);
        map.put("timestamp", timestamp);

        try {
            int time = (random.nextInt(8)) * 1000;
            Thread.sleep(time);
            objectMapper.writeValueAsString(map);
            /*try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            return "{\"DeptId\":\"06221\",\"accntNumber1\":\"80020000005040416\"}";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
