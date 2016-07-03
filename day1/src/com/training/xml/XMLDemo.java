package com.training.xml;

import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLDemo {
	static Map students = new HashMap();

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/training/xml/beans.xml");
		Document doc = builder.parse(in);
		in.close();
		processRoot(doc.getFirstChild());
	}
	
	public static void processRoot(Node root) throws Exception {
		NodeList list = root.getChildNodes();
		for(int i=0; i<list.getLength(); i++) {
			if("http://www.training.com/beans/".equals(list.item(i).getNamespaceURI())) {
				popBeans(list.item(i));
			} else if("http://www.training.com/action/".equals(list.item(i).getNamespaceURI())) {
				processActions(list.item(i));
			};
		}
	}
	public static void popBeans(Node bean) throws Exception {
		Element e = (Element)bean;
		String id = e.getAttribute("id");
		String clazz = e.getAttribute("class");
		Class c = Class.forName(clazz);
		Object o = c.newInstance();
		NodeList props = e.getChildNodes();
		for(int i=0; i<props.getLength(); i++) {
			if("property".equals(props.item(i).getNodeName())) {
				Element prop = (Element)props.item(i);
				String fn = prop.getAttribute("name");
				String fv = prop.getAttribute("value");
				PropertyDescriptor pd = new PropertyDescriptor(fn, c);
				PropertyEditor pe = PropertyEditorManager.findEditor(pd.getPropertyType());
				pe.setAsText(fv);
				pd.getWriteMethod().invoke(o, pe.getValue());
			}
		}
		students.put(id, o);
	}
	public static void processActions(Node action) {
		Element e = (Element)action;
		if("action:print".equals(e.getNodeName())) {
			printStudents();
		} else if("action:delete".equals(e.getNodeName())) {
			String id = e.getAttribute("id");
			students.remove(id);
			printStudents();
		}
	}

	private static void printStudents() {
		Set<Map.Entry> set = students.entrySet();
		for(Map.Entry entry:set) {
			System.out.printf("id is %s and student is %s.\n", entry.getKey(), entry.getValue());
		}
	}
}
