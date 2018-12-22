package yz.weixin.entity;

import lombok.AllArgsConstructor;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/22/18<br/>
 * Time: 7:23 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractButton {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
