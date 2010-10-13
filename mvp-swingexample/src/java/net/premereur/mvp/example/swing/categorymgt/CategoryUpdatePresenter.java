package net.premereur.mvp.example.swing.categorymgt;

import net.premereur.mvp.core.UsesView;
import net.premereur.mvp.example.domain.model.Category;
import net.premereur.mvp.example.swing.application.ApplicationBus;

@UsesView(CategoryUpdaterPanel.class)
public class CategoryUpdatePresenter extends SingleCategoryPresenterBase<CategoryUpdaterPanel> {		
	
	public void onCategorySelected(Category selectedCategory) {
		CategoryUpdaterPanel view = getView();
		view.bind(selectedCategory);
		getEventBus(ApplicationBus.class).setCenterComponent(view);
	}
		
	public void saveClicked(Category category) {
		getRepository().save(category);
		getEventBus().defaultCategoryPanelActivated();
		getEventBus().categoryChanged(category);
		getEventBus(ApplicationBus.class).setFeedback("Category updated");
	}

}