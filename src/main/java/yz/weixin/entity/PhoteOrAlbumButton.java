package yz.weixin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/22/18<br/>
 * Time: 7:48 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
public class PhoteOrAlbumButton extends AbstractButton {
    private String type = "pic_photo_or_album";
    private String key;
    private List<AbstractButton> sub_button = new ArrayList<AbstractButton>();

    public PhoteOrAlbumButton(String name, String key) {
        super.setName(name);
        this.key = key;
    }
}
