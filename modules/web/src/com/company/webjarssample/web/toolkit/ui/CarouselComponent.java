package com.company.webjarssample.web.toolkit.ui;

import com.company.webjarssample.gui.components.Carousel;
import com.company.webjarssample.web.toolkit.ui.client.carouselcomponent.CarouselComponentState;
import com.haulmont.bali.util.Preconditions;
import com.haulmont.cuba.web.sys.WebJarResource;
import com.vaadin.ui.AbstractComponent;
import org.springframework.util.CollectionUtils;

import java.util.List;

@WebJarResource("jrcarousel/1.0.0/dist/jRCarousel.min.js")
public class CarouselComponent extends AbstractComponent {
    public CarouselComponent() {
    }

    public void setAnimation(Carousel.Animation animation) {
        if (!getState(false).animation.equals(animation.name())) {
            getState().animation = animation.name();
        }
    }

    public Carousel.Animation getAnimation() {
        return Carousel.Animation.valueOf(getState(false).animation);
    }

    public void setSlides(List<String> slides) {
        Preconditions.checkNotNullArgument(slides);

        if (CollectionUtils.isEmpty(slides)) {
            throw new IllegalArgumentException("You should set at least one slide");
        }

        if (!getState(false).slides.equals(slides)) {
            getState().slides = slides;
        }
    }

    public List<String> getSlides() {
        return getState(false).slides;
    }

    public void setNavigation(Carousel.Navigation navigation) {
        if (!getState(false).navigation.equals(navigation.name())) {
            getState().navigation = navigation.name();
        }
    }

    public Carousel.Navigation getNavigation() {
        return Carousel.Navigation.valueOf(getState(false).navigation);
    }

    @Override
    protected CarouselComponentState getState() {
        return (CarouselComponentState) super.getState();
    }

    @Override
    protected CarouselComponentState getState(boolean markAsDirty) {
        return (CarouselComponentState) super.getState(markAsDirty);
    }
}