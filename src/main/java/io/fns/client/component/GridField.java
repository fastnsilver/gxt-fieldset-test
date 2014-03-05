package io.fns.client.component;

import com.extjs.gxt.ui.client.widget.form.AdapterField;

public class GridField extends AdapterField {
	
	public GridField() {
		super(new FormGrid());
		setResizeWidget(true);
	}
	
}
