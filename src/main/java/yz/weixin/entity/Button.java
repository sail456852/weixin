package yz.weixin.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/22/18<br/>
 * Time: 7:22 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
@Data
public class Button {
    private List<AbstractButton> button = new ArrayList<AbstractButton>();
}
