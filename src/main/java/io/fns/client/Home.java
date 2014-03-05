package io.fns.client;

import io.fns.client.component.TestForm;

import com.extjs.gxt.themes.client.Slate;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.util.ThemeManager;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Home implements EntryPoint{

	@Override
	public void onModuleLoad() {

		ThemeManager.register(Slate.SLATE);
		GXT.setDefaultTheme(Slate.SLATE, true);

		Viewport viewport = new Viewport();
		viewport.setLayout(new FitLayout());
		RootPanel.get().add(viewport);

		Window w = new Window();
		w.setHeadingText("TEST FORM");
		w.setLayout(new FitLayout());

		w.add(new TestForm(true,false));

		w.setWidth(500);
		w.setHeight(500);
		w.show();
	}






}
