package net.premereur.mvp.example.swing.presenter;

import net.premereur.mvp.core.BasePresenter;
import net.premereur.mvp.core.UsesView;
import net.premereur.mvp.example.swing.eventbus.DemoEventBus;
import net.premereur.mvp.example.swing.view.DefaultCategoryPanel;

@UsesView(DefaultCategoryPanel.class)
public class DefaultCategoryPanelPresenter extends BasePresenter<DefaultCategoryPanel, DemoEventBus>{

	public void onDefaultCategoryPanelActivated() {
		getView().setCreateButtonListener(this);
		getEventBus().setCenterComponent(getView());
	}

	public void createNewCategory() {
		getEventBus().activateCategoryCreation();
	}
	
}
