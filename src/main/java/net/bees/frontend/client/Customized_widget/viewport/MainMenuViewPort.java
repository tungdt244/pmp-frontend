package net.bees.frontend.client.Customized_widget.viewport;

import com.google.gwt.user.client.Window;
import com.sencha.gxt.widget.core.client.container.Viewport;

public class MainMenuViewPort extends Viewport {
	
	private int marginHeight;
	
	public MainMenuViewPort(){
		setPixelSize(Window.getClientWidth(), Window.getClientHeight());
	}

	@Override
	  protected void onWindowResize(int width, int height) {
	    setPixelSize(width, height - marginHeight);
	  }

	public void setOriginHeight(int marginHeight) {
		System.out.println("marginHeight: " + marginHeight);
		this.marginHeight =  marginHeight + 40;
		setHeight(Window.getClientHeight() - this.marginHeight);
		System.out.println("this marginHeight: " + this.marginHeight);
	}
	

}
