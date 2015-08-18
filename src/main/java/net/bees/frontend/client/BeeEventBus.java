package net.bees.frontend.client;


import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;
import com.mvp4g.client.presenter.BasePresenter;
import net.bees.frontend.client.functional_modules.home.HomePresenter;
import net.bees.frontend.client.functional_modules.home.blank.BlankPresenter;
import net.bees.frontend.client.functional_modules.main.MainPresenter;
import net.bees.frontend.client.functional_modules.workarea.WorkAreaPresenter;
import net.bees.frontend.client.history.recreate.Recreator;


@Events(startPresenter = MainPresenter.class)
public interface BeeEventBus extends EventBus {

	@Start
	@Event( handlers = {BlankPresenter.class, HomePresenter.class, MainPresenter.class})
	public void start();

	@Event( handlers = {WorkAreaPresenter.class, MainPresenter.class, HomePresenter.class})
	public void home();

	@Event(handlers = {Recreator.class})
	public void register(BasePresenter presenter);

	@Event(handlers = {Recreator.class})
	public void unregister(BasePresenter presenter);
}
