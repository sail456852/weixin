package yz.weixin.controller;

import org.apache.catalina.util.ToStringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.style.ToStringCreator;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yeahka.commons.utils.GsonUtils;
import yz.weixin.service.WxService;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;

/**
 * weixin testing
 */
@Controller
public class WxController {
    Logger logger = LoggerFactory.getLogger(WxController.class);


    @Autowired
    private WxService wxService;

    @RequestMapping(value = "/wx", method = RequestMethod.GET)
    @ResponseBody
    public String wxShakeHand(HttpServletRequest request) {
        return validateAccess(request);
    }

    @RequestMapping(value = "/wx", method = RequestMethod.POST)
    @ResponseBody
    public String wxProcessing(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return processMsg(request, response);
    }

    private String processMsg(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        Map<String, String> requestMap = null;
        try {
            ServletInputStream inputStream = request.getInputStream();
            requestMap = wxService.parseRequest(inputStream);
            System.err.println("requestMap = " + requestMap);
        } catch (IOException e) {
            e.printStackTrace();
            return "success";
        }
        String resXml = "<xml><ToUserName>< ![CDATA[" + requestMap.get("FromUserName") + "] ]></ToUserName> <FromUserName>< ![CDATA[" +
                requestMap.get("ToUserName") + "] ]></FromUserName><CreateTime>1348831860</CreateTime><MsgType>< ![CDATA[text] ]></MsgType><Content>< ![CDATA[this is a test] ]></Content><MsgId>1234567890123456</MsgId></xml>";
        resXml=resXml.replaceAll(" ", "");
        System.err.println("resXml = " + resXml);
        return resXml;
    }

    /**
     * used when shaking hands with the wechat server
     *
     * @param request
     * @return
     */
    private String validateAccess(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String echoStr = request.getParameter("echostr");
        String token = "hello123";
        String nonce = request.getParameter("nonce");
        System.err.println("token = " + token + "  timestamp= " + timestamp + "  nonce= " + nonce);
        logger.info("wxShakeHand()- ", token);
        System.err.println("signature = " + signature);
        logger.debug("validateAccess()- ", signature);

        String[] sortStrArr = new String[]{token, timestamp, nonce};
        Arrays.sort(sortStrArr);

        String sha1Hex = DigestUtils.sha1Hex(sortStrArr[0] + sortStrArr[1] + sortStrArr[2]);
        System.err.println("sha1Hex = " + sha1Hex);

        if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(sha1Hex))
            return "wrong step 1";

        if (signature.equals(sha1Hex)) {
            System.err.println("WxController.wxShakeHand shake okay");
            logger.debug("validateAccess()- ", sha1Hex);
            return echoStr;
        }
        return echoStr;
    }

    @RequestMapping("/new")
    @ResponseBody
    public String newTest() {
        return "new";
    }
}
