package yz.weixin.entity;


import lombok.Data;
import yz.weixin.util.TokenUtil;

import java.util.Date;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/21/18<br/>
 * Time: 10:43 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
@Data
public class AccessToken {

    private String accessToken;

    private long expireTime = 0; // initial value

    public boolean tokenExpired(){
       long nowInSeconds = System.currentTimeMillis() / 1000;
       return nowInSeconds > expireTime;
    }

}
