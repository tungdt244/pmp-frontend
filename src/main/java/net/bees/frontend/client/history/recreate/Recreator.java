package net.bees.frontend.client.history.recreate;

import java.util.ArrayList;
import java.util.Iterator;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Timer;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.BaseEventHandler;
import com.mvp4g.client.presenter.BasePresenter;
import net.bees.frontend.client.BeeEventBus;

@EventHandler
public class Recreator extends BaseEventHandler<BeeEventBus>{

	public final static String EVENT_TYPE_HOME = "home";
	public final static String EVENT_TYPE_WORKLIST = "worklist";
	public final static String EVENT_TYPE_START_READING = "startReading";
	public final static String EVENT_TYPE_MY_SETTINGS = "mySettings";
	public final static String EVENT_TYPE_MARKETPLACE = "marketPlace";
	public final static String EVENT_TYPE_MYORGANISATION = "myOrganisation";
	public final static String EVENT_TYPE_EDITDRAFT = "editDraftOrder";
	public final static String EVENT_TYPE_ROLESANDPROTECTIONPOINTS = "groupsAndReferrals";
	public static final String EVENT_TYPE_VIEWORDER = "viewOrder";
	public static final String EVENT_TYPE_UPLOADDICOM = "uploadDicom";
	public static final String EVENT_TYPE_AVAILABLESTUDIES = "availableStudies";
	public static final String EVENT_TYPE_NOTIFICATION = "notification";
	public static final String EVENT_TYPE_NOTIFICATION_SETTINGS = "notificationSettings";
	public static final String EVENT_TYPE_RECIPIENT_REPORT = "recipientReport";
	public static final String EVENT_TYPE_DASHBOARD = "dashboard";
	public static final String EVENT_TYPE_OPEN_REPORT_RECIPIENT = "openReportRecipient";
	
	private ArrayList<String> eventTypes = new ArrayList<String>();
	private RecreateItem recreateItem;

	private ArrayList<BasePresenter> executingPresenters = new ArrayList<BasePresenter>();
	private Timer timer;
	protected boolean block;
	private boolean needToRecreate;

	public void onStartRecreate(){
		Log.info("onStartRecreate");
		if(needToRecreate){
			needToRecreate = false;
			startRecreate();
		}
	}

	public void onSetRecreateData(String eventType, RecreateItem recreateItem){
		addEventType(eventType);
		setRecreateItem(recreateItem);
		needToRecreate = true;
	}
	
	public void onRemoveEventType(String eventType){
		eventTypes.remove(eventType);
	}

	public void onRegister(BasePresenter presenter){
		Log.info("***REGISTER***");
		Log.info("register: " + presenter.toString());
		block = false;
		if(!executingPresenters.contains(presenter)){
			executingPresenters.add(presenter);
		}
		Log.info("executingPresenters size: " + executingPresenters.size());
		logExecutingPresenters();
	}

	public void onUnregister(BasePresenter presenter){
		Log.info("***UNREGISTER***");
		Log.info("unregister: " + presenter.toString());
		executingPresenters.remove(presenter);
		Log.info("executingPresenters size: " + executingPresenters.size());
		logExecutingPresenters();
	}
	
	public void onReferralForwardingRules(String name, long orgId){
		stopRecreateThread();
	}

	protected void logExecutingPresenters() {
		for(Iterator<BasePresenter> iterator = executingPresenters.iterator(); iterator.hasNext();){
			Log.info(iterator.next().toString());
		}
	}

	public void onLogout(){
		stopRecreateThread();
	}

	private void addEventType(String eventType){
		Log.info("addEventType: " + eventType);
		if(eventType.equals(EVENT_TYPE_START_READING) || eventType.equals(EVENT_TYPE_EDITDRAFT)){
			addEventType(EVENT_TYPE_WORKLIST);
		}
		else if(eventType.equals(EVENT_TYPE_WORKLIST)){
			addEventType(EVENT_TYPE_HOME);
		} else if (eventType.equals(EVENT_TYPE_MY_SETTINGS) 
				|| eventType.equals(EVENT_TYPE_MARKETPLACE)
				|| eventType.equals(EVENT_TYPE_UPLOADDICOM)
				|| eventType.equals(EVENT_TYPE_AVAILABLESTUDIES)
				|| eventType.equals(EVENT_TYPE_MYORGANISATION)
				|| eventType.equals(EVENT_TYPE_NOTIFICATION)
				|| eventType.equals(EVENT_TYPE_NOTIFICATION_SETTINGS)
				|| eventType.equals(EVENT_TYPE_RECIPIENT_REPORT)
				|| eventType.equals(EVENT_TYPE_DASHBOARD)
				|| eventType.equals(EVENT_TYPE_OPEN_REPORT_RECIPIENT))
		{
			addEventType(EVENT_TYPE_HOME);
		}else if(eventType.equals(EVENT_TYPE_VIEWORDER)){
			addEventType(EVENT_TYPE_HOME);
		}
		eventTypes.add(eventType);
		Log.info("eventTypes size: " + eventTypes.size());
	}


	public void startRecreate(){		
		block = false;
		startRecreateThread();
	}

	private void startRecreateThread() {
		if(timer == null ){
			timer = new Timer() {

				@Override
				public void run() {
					Log.info("********Recreating********");
					Log.info("eventTypes size: " + eventTypes.size());
					Log.info("executingPresenters size: " + executingPresenters.size());
					logExecutingPresenters();
					if(eventTypes == null || eventTypes.size()<1){					
						stopRecreateThread();
					}
					if((eventTypes != null && eventTypes.size() > 0) && !block && executingPresenters.size()==0){
						Log.info("Checking eventTypes");
						block = true;
						Log.info("block = true");
						String eventType = eventTypes.get(0);
						eventTypes.remove(0);
						Log.info("eventTypes size: " + eventTypes.size());
//						if(eventType.equals(EVENT_TYPE_HOME)){
//							eventBus.setStartPage(false);
//							Log.info("*home");
//							eventBus.home();
//						}
//						else if(eventType.equals(EVENT_TYPE_WORKLIST)){
//							Log.info("*worklist");
//							Datastore.getInstance().unfreezeState();
//							Log.info("recreateItem organizationBox: " + recreateItem.getOrganisationBox());
//							Log.info("recreateItem.isResetOrderPanel(): " + recreateItem.isResetOrderPanel());
//							eventBus.worklist(recreateItem.getOrganisationBox(), recreateItem.isResetOrderPanel(), false);
//							eventBus.expandWorklistNavPanel(recreateItem.getOrganisationBox());
//						} else if(eventType.equals(EVENT_TYPE_START_READING)){
//							Log.info("*startReading with orderId: " + recreateItem.getOrderId());
//							eventBus.setCurrentOrder(recreateItem.getOrderId());
//							eventBus.startReading(recreateItem.getOrderId(), recreateItem.getOrganisationBox());
//							eventBus.selectOrder(recreateItem.getOrderId());
//						} else if(eventType.equals(EVENT_TYPE_MY_SETTINGS)){
//							eventBus.mySettings();
//						} else if(eventType.equals(EVENT_TYPE_MARKETPLACE)){
//							eventBus.marketPlace(recreateItem.getViewType());
//						} else if(eventType.equals(EVENT_TYPE_MYORGANISATION)){
//							eventBus.myOrganisation(recreateItem.getViewType(), (int)recreateItem.getOrgId());
//						} else if(eventType.equals(EVENT_TYPE_EDITDRAFT)){
//							eventBus.editDraftOrder(recreateItem.getOrderId(), (int)recreateItem.getOrgId());
//						} else if(eventType.equals(EVENT_TYPE_VIEWORDER)){
//							Log.info("shooting: viewOrder");
//							eventBus.viewOrder(recreateItem.getOrderId(), recreateItem.getContractId());
//						} else if(eventType.equals(EVENT_TYPE_UPLOADDICOM)){
//							eventBus.expandImageRepository(recreateItem.getOrgId(), Integer.valueOf(recreateItem.getBoxType()));
//						} else if(eventType.equals(EVENT_TYPE_AVAILABLESTUDIES)){
//							eventBus.availableStudies(recreateItem.getOrgId(), Integer.valueOf(recreateItem.getBoxType()));
//						} else if(eventType.equals(EVENT_TYPE_NOTIFICATION)){
//							eventBus.notification();
//						} else if(eventType.equals(EVENT_TYPE_NOTIFICATION_SETTINGS)){
//							eventBus.notificationSettings();
//						} else if(eventType.equals(EVENT_TYPE_RECIPIENT_REPORT)){
//							eventBus.recipientReport();
//						} else if (eventType.equals(EVENT_TYPE_OPEN_REPORT_RECIPIENT)) {
//							eventBus.recipientReport();
//							if (recreateItem != null) {
//								eventBus.openReportRecipient(recreateItem.getReportRecipientRecord());
//							}
//						} else if(eventType.equals(EVENT_TYPE_DASHBOARD)){
//							if (recreateItem.getOrganisationBox() != null) {
//								eventBus.expandWorklistNavPanel(recreateItem.getOrganisationBox());
//								eventBus.dashboard(recreateItem.getOrganisationBox().getOrgId());
//							}
//						}
					}
				}
			};
			if (timer!=null) timer.scheduleRepeating(100);
		}
		
	}

	private void stopRecreateThread(){
		if(timer != null){
			timer.cancel();
			timer = null;
		}
	}

	private void setRecreateItem(RecreateItem recreateItem) {
		this.recreateItem = recreateItem;		
	}

}
