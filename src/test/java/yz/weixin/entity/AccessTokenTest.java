package yz.weixin.entity;

import org.junit.Test;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/21/18<br/>
 * Time: 11:10 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
public class AccessTokenTest {
    
    @Test
    public void testLombokPlugin() {
        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken("testString");
    }

}