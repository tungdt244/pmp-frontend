package net.bees.frontend.client.functional_modules.workarea;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import net.bees.frontend.client.BeeEventBus;
import net.bees.frontend.client.functional_modules.common.IBeeView;


@Presenter(view=WorkAreaView.class)
public class WorkAreaPresenter extends LazyPresenter<WorkAreaPresenter.IWorkAreaView, BeeEventBus>{

//
//	/** I18N */
//	private AuthenticationConstants constants = GWT
//			.create(AuthenticationConstants.class);
//
//	private AuthenticationMessages messages = GWT
//			.create(AuthenticationMessages.class);



	public interface IWorkAreaView extends IBeeView{
		void setWorkListViewActive();
		void setDashboardViewActive();
		void setOverallInfoViewActive();
		void setBlankViewActive();
		void setSettingsViewActive();
		void setIFrameViewActive();
		void setAboutRxeyeViewActive();
		void setRolesAndProtectionPointsViewActive();
		Composite getOverallInfoView();
		Composite getSettingsView();
		Composite getWorkListView();
		Composite getDashboardView();
		Composite getIFrameView();
		Composite getAboutRxeyeView();
		Composite getBlankView();
		Composite getPublicInformationView();
		void setPublicInformationViewActive();
		Composite getMySettingsView();
		void setMySettingsViewActive();
		Composite getNotificationSettingsView();
		void setNotificationSettingsViewActive();		
		Composite getUploadDICOMView();
		void setUploadDICOMViewActive();
		Composite getAvailableStudiesView();
		void setAvailableStudiesViewActive();
		void setReportTextTemplatesSettingsViewActive();
		Composite getReportTextTemplatesSettingsView();
		Composite getRolesAndProtectionPointsView();
		void setReferralForwardingRulesViewActive();
		Composite getReferralForwardingRulesView();
		void setNotificationViewActive();
		Composite getNotificationView();
		void setRecipientReporViewActive();
		Composite getRecipientReporView();
	}

	public WorkAreaPresenter() {
		Log.debug("WorkAreaPresenter");
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
		//eventBus.initGetMePollHandler();
		eventBus.register(this);
		view.setBlankViewActive();
		eventBus.unregister(this);
	}



	public void onMarketPlace(String name){
		Log.debug("onMarketPlace: " + name);
		//Log.debug("constants: " + constants.avalableCompetencies());
	}

	public void onBulleteinBoard(){
//		Log.debug("onBulleteinBoard");
//		view.setBulleteinBoardViewActive();
	}

	public void onMyOrganisationSettings(String name, long orgId){
		Log.debug("myOrganisation: " + name);
		view.setSettingsViewActive();
		//Datastore.getInstance().setActiveView(view.getSettingsView());
	}
	
	public void onMyOrganisationOverallInfo(String name, long orgId){
		view.setOverallInfoViewActive();
		//Datastore.getInstance().setActiveView(view.getOverallInfoView());
	}
	
	public void onMySettings(){
		view.setMySettingsViewActive();
		//Log.debug("constants.overAllInfo(): " + constants.overAllInfo());
		//Datastore.getInstance().setActiveView(view.getMySettingsView());
	}
	
	public void onNotificationSettings(){
		view.setNotificationSettingsViewActive();
		//Datastore.getInstance().setActiveView(view.getNotificationSettingsView());
	}
	
	public void onNotification(){
		view.setNotificationViewActive();
		//Datastore.getInstance().setActiveView(view.getNotificationView());
	}

	/**
	 * Active the upload dicom view
	 */
	public void onUploadDicom(long orgId, int boxType){
		view.setUploadDICOMViewActive();
		//Log.debug("constants.overAllInfo(): " + constants.overAllInfo());
		//Datastore.getInstance().setActiveView(view.getUploadDICOMView());
	}
	
	public void onRecipientReport(){
		view.setRecipientReporViewActive();
		//Datastore.getInstance().setActiveView(view.getRecipientReporView());
	}
	
	/**
	 * Active the available studies view.
	 */
	public void onAvailableStudies(long orgId, int boxType){
		view.setAvailableStudiesViewActive();
		//Log.debug("constants.overAllInfo(): " + constants.overAllInfo());
		//Datastore.getInstance().setActiveView(view.getAvailableStudiesView());
	}

	/**
	 * Active the IFrameView in Working Area.
	 */
	public void onGetUiClientSetting(String keyName, String language){
		Log.debug("onIFrame");
		view.setIFrameViewActive();
		//Datastore.getInstance().setActiveView(view.getIFrameView());
	}
	
	public void onAbout(){
		Log.debug("onAbout");
		view.setAboutRxeyeViewActive();
		//Datastore.getInstance().setActiveView(view.getAboutRxeyeView());
	}
	
	public void onReportTextTemplatesSettings(String name, long orgId){
		Log.debug("onReportTextTemplateSettings");
		view.setReportTextTemplatesSettingsViewActive();
		//Datastore.getInstance().setActiveView(view.getReportTextTemplatesSettingsView());
	}
	
	public void onRolesAndProtectionPoints(String name, long orgId){
		Log.debug("onRolesAndProtectionPoints");
		view.setRolesAndProtectionPointsViewActive();
		//Datastore.getInstance().setActiveView(view.getRolesAndProtectionPointsView());
	}
	
	public void onReferralForwardingRules(String name, long orgId){
		Log.debug("onReferralForwardingRules");
		view.setReferralForwardingRulesViewActive();
		//Datastore.getInstance().setActiveView(view.getReferralForwardingRulesView());
	}
	

	public void onLogout(){
		Log.debug("onLogout");
		view.setBlankViewActive();
		//Datastore.getInstance().setActiveView(view.getBlankView());
		view.resetView();
	}

	public void onDashboard(long orgId) {
		Log.debug("onDashboard");
		view.setDashboardViewActive();
		//Datastore.getInstance().setActiveView(view.getDashboardView());
	}
	
}
