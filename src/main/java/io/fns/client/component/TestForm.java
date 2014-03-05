package io.fns.client.component;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;

public class TestForm extends FormPanel {

	public TestForm(boolean withSubForm, boolean withSubGrid) {

		FormData fd = new FormData();
		fd.setAnchorSpec("95%");

		TextField<String> tf = new TextField<String>();
		tf.setFieldLabel("Field1");
		this.add(tf, fd);

		tf = new TextField<String>();
		tf.setFieldLabel("Field2");
		this.add(tf,fd);

		if (withSubForm){

			GridField subForm = new GridField();
			subForm.setFieldLabel("SubForm");

			final FieldSet fs = new FieldSet();
			fs.setLayout(new FitLayout());
			fs.setHeadingHtml(El.toSafeHTML("FieldSet"));
			fs.setCollapsible(true);
			fs.collapse();

			this.add(fs,fd);

			fs.add(subForm);

		}

		if (withSubGrid){

			GridField subGrid = new GridField();
			subGrid.setFieldLabel("SubGrid");

			this.add(subGrid, fd);
		}

		this.setHeaderVisible(false);

	}

}