package bug.grid.sample;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;


@SpringUI
public class AppUI extends UI {
	private VerticalLayout rootLayout = new VerticalLayout();
	private Grid<Entity> grid = new Grid(Entity.class);
	private Button button = new Button("Set Dataprovider", e -> setDataProvider());
	private List<Entity> data = new ArrayList<>();

	private void setDataProvider() {
		grid.setDataProvider((sortOrders, offset, limit) -> data.stream().skip(offset).limit(limit),
				() -> data.size()
				);
	}

	private void fillData() {
		for (int i = 0; i < 10000; i++) {
			data.add(new Entity(Long.valueOf(i), "Name-"+String.valueOf(i)));
		}

	}


	@Override
	protected void init(VaadinRequest vaadinRequest) {

		fillData();
		grid.getColumns().forEach(c -> c.setSortable(false));
		grid.setSizeFull();
		rootLayout.setSizeFull();
		rootLayout.addComponents(button, grid);
		rootLayout.setExpandRatio(grid, 1f);
		setContent(rootLayout);
	}



}
