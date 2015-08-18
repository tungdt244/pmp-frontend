package net.bees.frontend.client.functional_modules.home;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mvp4g.client.view.ReverseViewInterface;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.event.CollapseItemEvent;
import com.sencha.gxt.widget.core.client.event.CollapseItemEvent.CollapseItemHandler;
import com.sencha.gxt.widget.core.client.event.ExpandItemEvent;
import com.sencha.gxt.widget.core.client.event.ExpandItemEvent.ExpandItemHandler;

import net.bees.frontend.client.Customized_widget.viewport.MainMenuViewPort;
import net.bees.frontend.client.functional_modules.home.HomePresenter.IHomeView;
import net.bees.frontend.client.functional_modules.workarea.WorkAreaView;


@Singleton
public class HomeView extends Composite implements IHomeView, ReverseViewInterface<HomePresenter> {

	private HomePresenter presenter;
	
	//@Inject
	//AccordianView accordianView;
	@Inject
	WorkAreaView workAreaView;

	public static final int DEFAULT_INFO_BAR_HEIGHT=20;

	private static final int DEFAULT_MIN_NAV_WITH = 200;
	private static final int DEFAULT_MAX_NAV_WITH = 300;
	private static final double DEFAULT_PROPORTIONAL_NAV_WITH = 0.148;
	
	interface MyStyle extends CssResource {
		String accordian();
	}

	interface HomeViewUiBinder extends UiBinder<Widget, HomeView> {
	}

	private static HomeViewUiBinder uiBinder = GWT.create(HomeViewUiBinder.class);

	@UiField
	MyStyle style;
	@UiField
	MainMenuViewPort mainMenuViewPort;
	@UiField
	BorderLayoutContainer con;
	@UiField
	BorderLayoutData westData,centerData,southData;
	@UiField
	ContentPanel westPanel,centerPanel,southPanel;
	
	public void setView() {
		initWidget(uiBinder.createAndBindUi(this));
		//addHandler();
		centerPanel.add(workAreaView);
		//westPanel.add(accordianView);
		westData.setSize(getDefaultNavigationWith());
	}

	private void addHandler(){
		westPanel.addResizeHandler(new ResizeHandler() {

			@Override
			public void onResize(ResizeEvent arg0) {
				Log.debug("RESIZING. Size= " + westPanel.getOffsetWidth());
				getPresenter().westWidgetResized(westPanel.getOffsetWidth());
			}
		});
		con.addExpandHandler(new ExpandItemHandler<ContentPanel>() {

			@Override
			public void onExpand(ExpandItemEvent<ContentPanel> event) {
				Log.debug("Collapsing. Size= " + westPanel.getOffsetWidth());
				getPresenter().westWidgetResized(westPanel.getOffsetWidth());
			}
		});
		con.addCollapseHandler(new CollapseItemHandler<ContentPanel>() {

			@Override
			public void onCollapse(CollapseItemEvent<ContentPanel> event) {
				Log.debug("Collapsing. Size= " + westPanel.getOffsetWidth());
				getPresenter().westWidgetResized(westPanel.getOffsetWidth());

			}
		});
	}

	public Widget asWidget() {
		return this;
	}

	public void bindEvents() {

	}

	public int getDefaultNavigationWith() {
		int defWith = (int) (Window.getClientWidth() * DEFAULT_PROPORTIONAL_NAV_WITH);
		if(defWith < DEFAULT_MIN_NAV_WITH){
			defWith = DEFAULT_MIN_NAV_WITH;
		}
		else if(defWith > DEFAULT_MAX_NAV_WITH){
			defWith = DEFAULT_MAX_NAV_WITH;
		}
		return defWith;
	}

	@Override
	public void createView() {
		setView();		
	}

	@Override
	public void setPresenter(HomePresenter presenter) {
		Log.debug("setPresenter");
		Log.debug("presenter: " + presenter);
		this.presenter = presenter;

	}

	@Override
	public HomePresenter getPresenter() {
		Log.debug("return presenter: " + this.presenter);
		return presenter;
	}

	@Override
	public void setSize() {
		westPanel.setWidth(getDefaultNavigationWith());
		getPresenter().westWidgetResized(getDefaultNavigationWith());
	}
	
	public ContentPanel getWestPanel() {
		return westPanel;
	}


	@Override
	public void resetView() {
		setSize();
	}
	
}
