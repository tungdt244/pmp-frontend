package net.bees.frontend.client.functional_modules.main;


import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.mvp4g.client.view.ReverseViewInterface;
import com.sencha.gxt.widget.core.client.container.CardLayoutContainer;
import net.bees.frontend.client.functional_modules.home.HomeView;


public class MainView extends Composite implements MainPresenter.IMainMenuView,ReverseViewInterface<MainPresenter> {

	private MainPresenter presenter;


	private CardLayoutContainer mainCardLayoutContainer;
	@Inject
	HomeView homeView;

	public void setView() {		
		initWidget(getBodyPanel());
	}

	private CardLayoutContainer getBodyPanel(){

		Log.debug("MAIN MENU VIEW");

		mainCardLayoutContainer = new CardLayoutContainer();
		mainCardLayoutContainer.setWidth(Window.getClientWidth());
		mainCardLayoutContainer.add(homeView);
//		mainCardLayoutContainer.add(loginActorView);
		mainCardLayoutContainer.setActiveWidget(homeView);
		return mainCardLayoutContainer;
		
	}

	@Override
	public void setPresenter(MainPresenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public MainPresenter getPresenter() {
		return presenter;
	}

	@Override
	public void resetView() {

	}


	@Override
	public void bindEvents() {

	}

	@Override
	public void home() {

	}

	@Override
	public void createView() {
		setView();
	}
}