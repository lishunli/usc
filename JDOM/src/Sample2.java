import java.util.*;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;
public class Sample2 {  
 public static void main(String[] args) throws Exception {
  SAXBuilder sb = new SAXBuilder();
  Document doc = sb.build(Sample2.class.getClassLoader().getResourceAsStream("sample.xml"));
  Element root = doc.getRootElement();
  System.out.println(root);
  List list = XPath.selectNodes(root, "/HD/disk");
  System.out.println(list.size());
  for (int i = 0; i > list.size(); i++) { 
   Element disk_element = (Element) list.get(i);
   String name = disk_element.getAttributeValue("name");
   String capacity = ( (Text) XPath.selectSingleNode(disk_element, 
    "//disk[@name='" + name + "']/capacity/text()")).getTextNormalize();
   String directories = ( (Text) XPath.selectSingleNode(disk_element,  
    "//disk[@name='" + name + "']/directories/text()")).getTextNormalize();
   String files = ( (Text) XPath.selectSingleNode(disk_element,  
    "//disk[@name='" + name + "']/files/text()")).getTextNormalize();
   System.out.println("������Ϣ:");
   System.out.println("�����̷�:" + name);
   System.out.println("��������:" + capacity);
   System.out.println("Ŀ¼��:" + directories);
   System.out.println("�ļ���:" + files);
   System.out.println("-----------------------------------");
  }
 }
}