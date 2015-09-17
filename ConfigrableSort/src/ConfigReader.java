
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ConfigReader {
	
	static ArrayList<Integer> myArrayList =new ArrayList<>();

	
	public static ArrayList<Integer> parseConfigFile()
	{
		File fXmlFile = new File("myconfig.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

			try {
				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
			NodeList algsElement=parseAlgorithmsElement(doc);
			NodeList algElement=parseAlgorithmElement(algsElement);
			NodeList inputElements=parseInputElement(algElement);
			return parseEachDataItem(inputElements); 
			} 
			catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			return null;
		
	}
	
	public static NodeList parseAlgorithmsElement(Document doc) 
	{
		doc.getDocumentElement().normalize();

		System.out.println("Root element :"
				+ doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("algorithms");
		System.out.println("----------------------------");
		return nList;
	}
	
	public static NodeList parseAlgorithmElement(NodeList nList)
	{
		NodeList inputList=null;
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				 inputList = nNode.getChildNodes();
				
	}}
		return inputList;
		}
			
	public static NodeList 	parseInputElement (NodeList inputList)
	{
		NodeList elementList=null;
		if (inputList != null) {
			for (int j = 0; j < inputList.getLength(); j++) {
				Node eachNode = inputList.item(j);
				if (eachNode.getNodeType() == Node.ELEMENT_NODE) {
					Element algorithmElement = (Element) eachNode;
					System.out
							.println("Name : "
									+ algorithmElement
											.getAttribute("name"));
					elementList = eachNode.getChildNodes();
				}
	}
			}
		
		return elementList;
	}
				
	public static ArrayList<Integer> parseEachDataItem(NodeList elementList)
	{
		if (elementList != null) {
			for (int k = 0; k < elementList.getLength(); k++) {
				Node elementNode = elementList.item(k);
				 
				if (elementNode.getNodeType() == Node.ELEMENT_NODE) {
					NodeList list = elementNode.getChildNodes();
					
					if (list != null) {
						for (int m = 0; m < list.getLength(); m++) {
							
							Node inputNode =list.item(m);
							
							System.out
							.println(inputNode.getNodeName());
							
							NodeList valueList = inputNode.getChildNodes();
							
							if (valueList != null) {
								for (int n = 0; n < valueList.getLength(); n++) {
									Node valNode = valueList.item(n);	
									
									System.out
									.println(valNode.getNodeValue());		//this line has the array values
										
									myArrayList.add(new Integer(valNode.getNodeValue()));
									
											
									
								}
							}
							
						}
					}
				}
			}
			}
		return myArrayList;
	}
	

	public static void main(String argv[]) {
	
		myArrayList=QuickSort.quickSort(parseConfigFile());
		System.out.println(myArrayList);

			
						}
					

					
		
	
		
	}

