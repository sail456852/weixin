package yz.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WxController {
    @RequestMapping("/wx")
    @ResponseBody
    public String wxShakeHand(){

       return "hello";
    }
}
