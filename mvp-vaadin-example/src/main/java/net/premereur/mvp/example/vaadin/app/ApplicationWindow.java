package net.premereur.mvp.example.vaadin.app;

import net.premereur.mvp.core.EventBus;
import net.premereur.mvp.core.View;

import com.google.inject.Inject;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;

@SuppressWarnings("serial")
public class ApplicationWindow extends Window implements View {

	private final ApplicationBus bus;

	private ComponentContainer workPane;

	@Inject
	public ApplicationWindow(final EventBus bus) {
		super("Sample Vaadin MVP Application");
		this.bus = (ApplicationBus) bus;
		((VerticalLayout) getContent()).setSpacing(false);
		setSizeFull();
		addMenu();
		addWorkPane();
	}

	public ApplicationBus getEventBus() {
		return bus;
	}

	private void addMenu() {
		final HorizontalLayout menuView = new HorizontalLayout();
		final MenuBar menuBar = new MenuBar();
		menuView.setSizeUndefined();
		addComponent(menuView);
		menuView.addComponent(menuBar);
		final MenuItem appItem = menuBar.addItem("Application", null);
		appItem.addItem("Categories", new Command() {

			@Override
			public void menuSelected(MenuItem selectedItem) {
				getEventBus().selectCategoryMgt();
			}
		});
		appItem.addItem("Products", new Command() {

			@Override
			public void menuSelected(MenuItem selectedItem) {
				// TODO send to event bus
			}
		});
	}

	private void addWorkPane() {
		workPane = new VerticalLayout(); // An empty pane really
		addComponent(workPane);
	}

	public void setWorkPane(ComponentContainer container) {
		removeComponent(workPane);
		this.workPane = container;
		workPane.setSizeFull();
		addComponent(workPane);
	}

}