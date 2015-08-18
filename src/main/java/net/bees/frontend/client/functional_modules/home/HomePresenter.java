package net.bees.frontend.client.functional_modules.home;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import com.sencha.gxt.widget.core.client.ContentPanel;
import net.bees.frontend.client.BeeEventBus;
import net.bees.frontend.client.functional_modules.common.IBeeView;

@Presenter(view=HomeView.class)
public class HomePresenter extends LazyPresenter<HomePresenter.IHomeView, BeeEventBus>{
	
	public interface IHomeView extends IBeeView {

		Widget asWidget();
		void setSize();
		ContentPanel getWestPanel();
	}

	public HomePresenter() {
		Log.debug("HomePresenter");
	}

	public void bindView() {
		Log.debug("bindView");
		Log.debug("view: " + view);
	}


	//Methods called from Event Bus
	public void onStart(){
		Log.debug("onStart");
	}
		
	public void onHome(){
		Log.debug("onHome");
		eventBus.register(this);

		view.setSize();
		ContentPanel westPanel = view.getWestPanel();
		collapseWestPanel(westPanel);
		expandWestPanel(westPanel); //Fix for resizing to work. 
	}
	
	
	protected void expandWestPanel(ContentPanel westPanel) {
		try{
		westPanel.expand();
		}
		catch(Exception exception){
			Log.debug("exception: " + exception);
		}
	}

	protected void collapseWestPanel(ContentPanel westPanel) {
		try{
		westPanel.collapse();
		}
		catch(Exception exception){
			Log.debug("exception: " + exception);
		}
	}
	

	public void onDoLogout(){

	}

	/**
	 * Logout actor from marketplace.
	 */
	public void logout() {
	}


	protected int getOrderId(String orderUrl) {
		if(orderUrl == null){
			return -1;
		}
		String[] urlPaths = orderUrl.split("/");
		int id = Integer.parseInt(urlPaths[urlPaths.length-1]);
		return id;
	}

	public void westWidgetResized(int width) {

	}

	/**
	 * Lets a user view order with a non context-bound url
	 * 
	 * @param orderId
	 * @param contractId
	 */
	public void onViewOrder(long orderId, long contractId){
		Log.debug("onViewOrder");
		Log.debug("orderId: " + orderId);
		Log.debug("contractId: " + contractId);
		eventBus.register(this);
	}


	public void onLoginWithSecurityToken(String securityToken){

	}

	public void onSessionTimedOut(){
		Log.debug("onSessionTimedOut");

		//LOG OUT!!!
		Log.debug("Clearup and logout");
	}
	
}
