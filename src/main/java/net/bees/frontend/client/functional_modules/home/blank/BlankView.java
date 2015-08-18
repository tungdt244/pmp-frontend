package net.bees.frontend.client.functional_modules.home.blank;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.inject.Singleton;
import com.mvp4g.client.view.ReverseViewInterface;


@Singleton
public class BlankView extends Composite implements BlankPresenter.IBlankView, ReverseViewInterface<BlankPresenter> {

	private BlankPresenter presenter;
	
	public void setView() {

		FocusPanel focusPanel = new FocusPanel();
		initWidget(focusPanel);
	}



	@Override
	public void createView() {
		setView();		
	}

	@Override
	public BlankPresenter getPresenter() {
		return presenter;
	}




	@Override
	public void setPresenter(BlankPresenter presenter) {
		this.presenter = presenter;
		
	}

}
