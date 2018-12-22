package yz.weixin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/22/18<br/>
 * Time: 7:37 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
@Data
@NoArgsConstructor
public class ClickButton extends AbstractButton {
    private String type = "click";
    private String key;

    public ClickButton(String name, String key) {
        super.setName(name);
        this.key = key;
    }
}
