
package utils;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
/**
 * Created by liurl3 on 2015/12/9.
 */
public class BundleCut {
    static {
       try{
           File f=new File("src/main/resources/META-INF/maven/archetype-metadata.xml");
           DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
           DocumentBuilder builder=factory.newDocumentBuilder();
           Document doc = builder.parse(f);
           NodeList nl = doc.getElementsByTagName("requiredProperty");
           for (int i=0;i<nl.getLength();i++){
               Element element = (Element)nl.item(i);
               if("bundleArtifactId".equals(element.getAttribute("key"))){
               //    System.out.println("==========element.getFirstChild(): " + element.getFirstChild().getNextSibling().getFirstChild().getTextContent());
                   String featureArtifactId = element.getFirstChild().getNextSibling().getFirstChild().getNodeValue();
                   System.out.println("==========featureArtifactId: "+featureArtifactId);
                   String bundleArtifactId = featureArtifactId.substring(0,featureArtifactId.lastIndexOf("."));
                   System.out.println("==========bundleArtifactId:"+bundleArtifactId);
                   element.setNodeValue(bundleArtifactId);
               }
           }
       }catch(Exception e){
           e.printStackTrace();
       }
   }
}
