package net.bees.frontend.client.functional_modules.main;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import net.bees.frontend.client.BeeEventBus;
import net.bees.frontend.client.functional_modules.common.IBeeView;


@Presenter(view=MainView.class)
public class MainPresenter extends LazyPresenter<MainPresenter.IMainMenuView, BeeEventBus> {

	private boolean windowRezisingHandled;


	public interface IMainMenuView extends IBeeView {
		Widget asWidget();
		void bindEvents();
		void home();
	}


	private void addWindowCloseHandler(){
	}

	private void addWindowResizing() {
		if(!windowRezisingHandled){
			Window.addResizeHandler(new ResizeHandler() {

				@Override
				public void onResize(ResizeEvent event) {
					resize();				
				}
			});
			windowRezisingHandled = true;
		}

	}

	protected void resize() {
		Log.debug("resizing");
	}

	public MainPresenter(){
		Log.debug("MainMenuPresenter");
	}

	//Methods called from Event Bus
	public void onStart(){
		Log.debug("onStart");
		setLocaleData();
		addWindowResizing();
		addWindowCloseHandler();
	}

	public void onHome(){
		view.home();

	}

	public void onMarketPlace(String name){
		Log.debug("onMarketPlace: " + name);
		view.home();
	}

	public void onMyOrganisation(String type, long orgId){
		Log.debug("myOrganisation: " + type);
		view.home();
	}
	
	public void onMySettings(){
		view.home();
	}
	
	public void onNotificationSettings(){
		view.home();
	}
	
	public void onNotification(){
		view.home();
	}
	
	/**
	 * Active the home view
	 */
	public void onUploadDicom(long orgId, int boxType){
		view.home();
	}
	
	/**
	 * Active the home view
	 */
	public void onAvailableStudies(long orgId, int boxType){
		view.home();
	}

	public void onResetViews(){
		view.resetView();
	}
	
	public void onLogout(){
		Log.debug("onLogout");
		windowRezisingHandled = true;//after logout, windows still have resizing handler
		view.resetView();
	}

	public void onInit(){
		Log.debug("onInit");
	}

	public void onNotFound(){
		Log.debug("onNotFound");
	}


	private void setLocaleData(){
	}

}

