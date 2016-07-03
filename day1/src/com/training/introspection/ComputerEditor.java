package com.training.introspection;

import java.beans.PropertyEditorSupport;

public class ComputerEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] values = text.split(",");
		Computer com = new Computer(Integer.parseInt(values[0]),
				values[1], Double.parseDouble(values[2]));
		setValue(com);
	}

}
