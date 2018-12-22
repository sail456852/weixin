package yz.weixin.service;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/15/18<br/>
 * Time: 10:43 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface WxService {


    Map<String, String> parseRequest(InputStream is);

    String getResponse(Map<String, String> requestMap);
}
