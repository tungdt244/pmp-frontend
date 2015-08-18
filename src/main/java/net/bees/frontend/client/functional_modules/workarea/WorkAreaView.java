package net.bees.frontend.client.functional_modules.workarea;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mvp4g.client.view.ReverseViewInterface;
import com.sencha.gxt.widget.core.client.container.CardLayoutContainer;

import net.bees.frontend.client.functional_modules.home.blank.BlankView;
import net.bees.frontend.client.functional_modules.workarea.WorkAreaPresenter.IWorkAreaView;

/**
 * View that shows the login dialog.
 * 
 * @author Jonny Larsson.
 * 
 */
@Singleton
public class WorkAreaView extends Composite implements IWorkAreaView, ReverseViewInterface<WorkAreaPresenter> {

	private WorkAreaPresenter presenter;

	@Inject
	BlankView blankView;

	private CardLayoutContainer cardLayoutContainer;


	public void setView() {

		KeyPressHandler keyPressHandler = new KeyPressHandler() {

			public void onKeyPress(KeyPressEvent keyPressEvent) {
				Log.debug("Key Pressed:" + keyPressEvent.getCharCode());
				Log.debug("UnicodeCharcode: " +  keyPressEvent.getUnicodeCharCode());
				if(keyPressEvent.getUnicodeCharCode() == 0){

				}
			}
		};

		FocusPanel focusPanel = new FocusPanel();
		focusPanel.addKeyPressHandler(keyPressHandler);
		focusPanel.getElement().setAttribute("style", "overflow-y:auto");
		cardLayoutContainer = new CardLayoutContainer();
		focusPanel.add(cardLayoutContainer);	
		cardLayoutContainer.add(blankView);
		cardLayoutContainer.setActiveWidget(blankView);
		initWidget(focusPanel);
		this.getElement().setAttribute("style", "background-color : #dedede;");
	}




	@Override
	public void setPresenter(WorkAreaPresenter presenter) {
		this.presenter = presenter;

	}


	@Override
	public WorkAreaPresenter getPresenter() {
		return this.presenter;
	}


	@Override
	public void createView() {
		setView();		
	}

	@Override
	public void setWorkListViewActive() {

	}

	@Override
	public void setDashboardViewActive() {
		Log.debug("setDashboardViewActive");

	}


	@Override
	public void setOverallInfoViewActive() {
		Log.debug("setOverallInfoViewActive");

	}

	@Override
	public void setBlankViewActive() {
		if(blankView != null){
			cardLayoutContainer.add(blankView);
		}
		cardLayoutContainer.setActiveWidget(blankView);
	}


	@Override
	public void setSettingsViewActive() {

	}
	
	@Override
	public void setPublicInformationViewActive(){

	}

	@Override
	public Composite getMySettingsView() {
		return null;
	}

	private boolean contains(Composite view) {
		for(int i=0; i<cardLayoutContainer.getWidgetCount(); i++){
			Widget widget = cardLayoutContainer.getWidget(i);
			if(widget.equals(view)){
				return true;
			}			
		}
		return false;
	}

	@Override
	public void setIFrameViewActive() {

	}
	
	@Override
	public void setAboutRxeyeViewActive() {

	}

	@Override
	public void setMySettingsViewActive() {

	}

	@Override
	public Composite getNotificationSettingsView() {
		return null;
	}

	@Override
	public void setNotificationSettingsViewActive() {

	}

	@Override
	public Composite getUploadDICOMView() {
		return null;
	}

	@Override
	public void setUploadDICOMViewActive() {

	}

	@Override
	public Composite getAvailableStudiesView() {
		return null;
	}

	@Override
	public void setAvailableStudiesViewActive() {

	}


	@Override
	public void setReportTextTemplatesSettingsViewActive() {

	}

	@Override
	public Composite getReportTextTemplatesSettingsView() {
		return null;
	}

	@Override
	public Composite getRolesAndProtectionPointsView() {
		return null;
	}

	@Override
	public void setRolesAndProtectionPointsViewActive() {

	}

	@Override
	public Composite getOverallInfoView() {
		return null;
	}

	@Override
	public Composite getSettingsView() {
		return null;
	}

	@Override
	public Composite getWorkListView() {
		return null;
	}

	@Override
	public Composite getDashboardView() {
		return null;
	}

	@Override
	public Composite getIFrameView() {
		return null;
	}

	@Override
	public Composite getAboutRxeyeView() {
		return null;
	}

	@Override
	public void setReferralForwardingRulesViewActive() {

	}

	@Override
	public Composite getReferralForwardingRulesView() {
		return null;
	}

	@Override
	public void setNotificationViewActive() {

	}

	@Override
	public Composite getNotificationView() {
		return null;
	}

	@Override
	public void setRecipientReporViewActive() {

	}

	@Override
	public Composite getRecipientReporView() {
		return null;
	}


	@Override
	public Composite getBlankView() {
		return blankView;
	}

	@Override
	public Composite getPublicInformationView() {
		return null;
	}


	@Override
	public void resetView() {

	}
}
