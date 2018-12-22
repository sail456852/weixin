package yz.weixin.service;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;
import yz.weixin.entity.*;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/15/18<br/>
 * Time: 10:45 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
@Service
public class WxServiceImpl implements WxService {

    @Override
    public Map<String, String> parseRequest(InputStream is) {
        SAXReader reader = new SAXReader();
        Map<String, String> map = new HashMap<>();
        try {
            Document document = reader.read(is);
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.elements();
            for (Element e : elements) {
                map.put(e.getName(), e.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public String getResponse(Map<String, String> requestMap) {
        String msgType = requestMap.get("msgType");
        BaseMessage gm = null;
        switch (msgType) {
            case "text":
                gm = dealTextMessage(requestMap);
                break;
            case "image":
                break;
            case "voice":
                break;
            case "video":
                break;
            case "shortvideo":
                break;
            case "location":
                break;
            case "link":
                break;
            default:
                break;

        }
        System.err.println("gm = " + gm);
        if(gm == null){
           return null;
        }
        return beanToXml(gm);
    }

    private String beanToXml(BaseMessage gm) {
        XStream stream = new XStream();
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(VideoMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(Music.class);
        stream.processAnnotations(NewsMessage.class);
        String xml = stream.toXML(gm);
        return xml;
    }

    private BaseMessage dealTextMessage(Map<String, String> requestMap) {
        TextMessage tm = new TextMessage(requestMap, "Process Okay");
        return tm;
    }
}
