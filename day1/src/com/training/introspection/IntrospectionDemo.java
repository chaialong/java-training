package com.training.introspection;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;

public class IntrospectionDemo {

	public static void main(String[] args) throws Exception {
		BeanInfo info = Introspector.getBeanInfo(User.class);
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		
		/*for(PropertyDescriptor pd:pds) {
			System.out.println(pd);
		}*/
		
		String s = "com.training.introspection.User";
		String fn = "id";
		String fv = "100";
		String fn1 = "com";
		String fv1 = "1,thinkpad,2000";
		
		Class c = Class.forName(s);
		Object o = c.newInstance();
		PropertyDescriptor pd = new PropertyDescriptor(fn, c);
		PropertyEditor pe = PropertyEditorManager.findEditor(pd.getPropertyType());
		pe.setAsText(fv);
		pd.getWriteMethod().invoke(o, pe.getValue());
		
		PropertyDescriptor pd1 = new PropertyDescriptor(fn1, c);
		PropertyEditor pe1 = PropertyEditorManager.findEditor(pd1.getPropertyType());
		pe1.setAsText(fv1);
		pd1.getWriteMethod().invoke(o, pe1.getValue());
		
		System.out.println(o);
	}

}
