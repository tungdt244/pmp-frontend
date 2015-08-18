package net.bees.frontend.client.functional_modules.home.blank;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import com.mvp4g.client.view.LazyView;
import net.bees.frontend.client.BeeEventBus;

@Presenter(view=BlankView.class)
public class BlankPresenter extends LazyPresenter<BlankPresenter.IBlankView, BeeEventBus>{


	
	public interface IBlankView extends LazyView{

	}

	public BlankPresenter() {
		
	}

	public void bindView() {
		
	}


	//Methods called from Event Bus
	public void onStart(){

	}
}
