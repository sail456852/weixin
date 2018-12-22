package yz.weixin.util;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;
import yz.weixin.entity.AccessToken;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/21/18<br/>
 * Time: 10:39 PM<br/>
 * To change this template use File | Settings | File Templates.
 * return token available
 */
public class TokenUtil {

    private TokenUtil() {

    }

    private static AccessToken accessToken = new AccessToken();
    private static String appId = "wxdc4c05ea98fa23f4";
    private static String secret = "f5e01197f0f06e7e74ce8e429a12312f";
    private static String sampleTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static AccessToken getAccessToken() {
        if (accessToken == null) {
            accessToken = new AccessToken();
        }
        if (accessToken.tokenExpired()) accessToken = getNewAccessToken();
        return accessToken;
    }

    private static AccessToken getNewAccessToken() {
        try {
            Properties pp = new Properties();
            FileInputStream fi = new FileInputStream("token.properties");
            pp.load(fi);
            Set<String> pns = pp.stringPropertyNames();
            for (String pn : pns) {
                System.err.println("pn = " + pn);
                System.err.println("pp.getProperty(pn) = " + pp.getProperty(pn));
            }
            fi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String realTokenUrl = sampleTokenUrl.replace("APPID", appId).replace("APPSECRET", secret);
        System.err.println("realTokenUrl = " + realTokenUrl);
        String tokenRespUrl = requestUrlGet(realTokenUrl);
        if ("fail".equals(tokenRespUrl)) {
            return accessToken; // empty object
        }
        Map<String, Object> tokenMap = (Map<String, Object>) JSON.parse(tokenRespUrl);
        System.err.println("tokenMap = " + tokenMap);
        long expiresInL = (Integer)tokenMap.get("expires_in");
        String token = (String)tokenMap.get("access_token");
        if (expiresInL <= 0 ) return accessToken;
        if (StringUtils.isEmpty(token)) return accessToken;
        long nowInSeconds = System.currentTimeMillis() / 1000;
        long expireTime = nowInSeconds + expiresInL;
        try {
            PrintWriter pw = new PrintWriter("token.properties");
            pw.write("token=" + token + "\n");
            pw.write("expireTime=" +  expireTime + "\n");
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        accessToken.setAccessToken(token);
        accessToken.setExpireTime(expireTime);
        return accessToken;
    }

    public static void main(String[] args) {
        //{"access_token":"ACCESS_TOKEN","expires_in":7200}
//        Map<String, String> tokenMap = (Map<String, String>) JSON.parse("{\"access_token\":\"ACCESS_TOKEN\",\"expires_in\":7200}");
//        System.err.println("tokenMap = " + tokenMap);
        AccessToken accessToken = getAccessToken();
        System.err.println("accessToken = " + accessToken);
    }

    public static String requestUrlGet(String url) {
        try {
            URL urlOBJ = new URL(url);
            URLConnection connection = urlOBJ.openConnection();
            return urlInputStream(connection);
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }

    private static String urlInputStream(URLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        byte[] oneKB = new byte[1024];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(oneKB)) != -1) {
            sb.append(new String(oneKB, 0, len));
        }
        return sb.toString();
    }

    public static String requestUrlPost(String url, String data){

        try {
            URL urlOBJ = new URL(url);
            URLConnection connection = urlOBJ.openConnection();
            connection.setDoOutput(true);
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(data.getBytes());
            outputStream.close();

            return urlInputStream(connection);


        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }


}
