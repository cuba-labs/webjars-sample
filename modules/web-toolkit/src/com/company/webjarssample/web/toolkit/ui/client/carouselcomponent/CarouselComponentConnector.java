package com.company.webjarssample.web.toolkit.ui.client.carouselcomponent;

import com.company.webjarssample.web.toolkit.ui.CarouselComponent;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractFieldConnector;
import com.vaadin.shared.ui.Connect;

@Connect(CarouselComponent.class)
public class CarouselComponentConnector extends AbstractFieldConnector {
    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        if (stateChangeEvent.hasPropertyChanged("animation")) {
            getWidget().setAnimation(getState().animation);
        }

        if (stateChangeEvent.hasPropertyChanged("slides")) {
            getWidget().setSlides(getState().slides);
        }

        if (stateChangeEvent.hasPropertyChanged("navigation")) {
            getWidget().setNavigation(getState().navigation);
        }
    }

    @Override
    public CarouselComponentState getState() {
        return (CarouselComponentState) super.getState();
    }

    @Override
    public CarouselComponentWidget getWidget() {
        return (CarouselComponentWidget) super.getWidget();
    }
}
