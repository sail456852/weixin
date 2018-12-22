package yz.weixin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/22/18<br/>
 * Time: 7:39 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
@Data
public class ViewButton extends AbstractButton {
    private String type = "view";
    private String url;

    public ViewButton(String name, String url) {
        super.setName(name);
        this.url = url;
    }
}
