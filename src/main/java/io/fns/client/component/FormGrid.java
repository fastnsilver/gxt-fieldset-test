package io.fns.client.component;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class FormGrid extends ContentPanel {

	public FormGrid() {

		this.setLayout(new FitLayout());
		this.setHeadingText("Sub");
		this.setHeight(200);

		List<ColumnConfig> cfgList = new ArrayList<ColumnConfig>();

		ColumnConfig cfg = new ColumnConfig("COL1", 50);
		cfg.setHeaderText("COL1");
		cfgList.add(cfg);

		cfg = new ColumnConfig("COL2", 50);
		cfg.setHeaderText("COL2");
		cfgList.add(cfg);

		ColumnModel cm = new ColumnModel(cfgList);

		Grid<BaseModelData> grid = new Grid<BaseModelData>(
				new ListStore<BaseModelData>(), cm);
		grid.getView().setForceFit(true);

		this.add(grid);
	}
}
