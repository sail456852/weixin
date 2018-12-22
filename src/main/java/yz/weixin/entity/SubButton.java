package yz.weixin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/22/18<br/>
 * Time: 7:40 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubButton extends AbstractButton {
    private List<AbstractButton> sub_button = new ArrayList<AbstractButton>();
}
