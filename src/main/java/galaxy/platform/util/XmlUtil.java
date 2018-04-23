package galaxy.platform.util;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

/**
 * @创建人 许杰 xujie
 * @创建时间 2018/4/23
 * @描述
 * @项目名称 Galaxy
 * @项目包名 galaxy.platform.util
 */
public class XmlUtil {

    private static XmlUtil instance = null;

    public static XmlUtil newInstance(){
        if (instance == null){
            Test();
            instance = new XmlUtil();
        }
        return instance;
    }

    public static void Test(){
        String s = "E:\\Java\\project\\Galaxy\\conifg\\platform\\platform-addins.xml";
        Document document = readDocument(s);
        List<Element> ll = readElements(s,"addin");
        for (Element e:ll) {
            System.out.println(e.elementText("name"));
            System.out.println(e.elementText("version"));
        }

        String ss = readXPathsValue(s,"platform-addins/addin/name",1);
        System.out.println(ss);

    }

    public static Document readDocument(String fileName){
        LoggerUtil.log.debug("xml document path:"+ fileName);
        Document document = null;
        try {
            SAXReader reader = new SAXReader();
            document = reader.read(new File(fileName));
        }
        catch (DocumentException e){
            e.printStackTrace();
        }
        finally {
            return document;
        }
    }

    public static List<Element> readElements(String xmlFileName,String nodepath){
        Document document = readDocument(xmlFileName);
        if (document.hasContent()){
            List<Element> list = document.getRootElement().elements(nodepath);
            if (list.size() > 0){
                return list;
            }
        }
        return null;
    }

    public static String readXPathsValue(String xmlFileName,String xpath,int index){
        Document document = readDocument(xmlFileName);
        if (document.hasContent()){
            List<Node> list = document.selectNodes(xpath);
            if (list.size() > index){
                return list.get(index-1).getText();
            }
        }
        return "";
    }

}
