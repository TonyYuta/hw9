/**
 *   File Name: XMLbuilder.java<br>
 *
 *   Yutaka<br>
 *   Created: Jul 24, 2016
 *   
 */

package core;


import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLbuilder {

	 public String xml_builder() throws ParserConfigurationException, TransformerException {

          DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

          // root elements
          Document doc = docBuilder.newDocument();
          Element rootElement = doc.createElement("calc");
          
          rootElement.setAttribute("conversion", XML_Respond.convetsionType);
          
          doc.appendChild(rootElement);

          // id element
          Element a = doc.createElement(XML_Respond.inputType);
          a.appendChild(doc.createTextNode("100.00"));

          // a.setAttribute("attr", "value");
          rootElement.appendChild(a);

          // name element
          Element b = doc.createElement(XML_Respond.outputType);
          b.appendChild(doc.createTextNode(XML_Respond.outputValue));

          rootElement.appendChild(b);
         
          TransformerFactory transformerFactory = TransformerFactory.newInstance();
          Transformer transformer = transformerFactory.newTransformer();
          DOMSource source = new DOMSource(doc);
          StringWriter writer = new StringWriter();
          transformer.transform(new DOMSource(doc), new StreamResult(writer));
          
          String out = null;
          StreamResult result = new StreamResult();
 
          return writer.toString();
   }
}