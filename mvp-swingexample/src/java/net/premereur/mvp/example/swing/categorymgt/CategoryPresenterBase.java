package net.premereur.mvp.example.swing.categorymgt;

import net.premereur.mvp.core.BasePresenter;
import net.premereur.mvp.core.View;
import net.premereur.mvp.example.domain.repository.CategoryRepository;

public abstract class CategoryPresenterBase<V extends View> extends BasePresenter<V, CategoryMgtBus> {

	private CategoryRepository repository;

	public CategoryPresenterBase() {
		setRepository(CategoryRepository.instance());
	}

	public void setRepository(CategoryRepository repository) {
		this.repository = repository;
	}

	public CategoryRepository getRepository() {
		return repository;
	}

}