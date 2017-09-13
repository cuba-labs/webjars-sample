package com.company.webjarssample.gui.xml.layout.loaders;

import com.company.webjarssample.gui.components.Carousel;
import com.haulmont.cuba.gui.xml.layout.loaders.AbstractComponentLoader;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

public class CarouselLoader extends AbstractComponentLoader<Carousel> {
    @Override
    public void createComponent() {
        resultComponent = factory.createComponent(Carousel.class);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {
        assignXmlDescriptor(resultComponent, element);

        loadStyleName(resultComponent, element);

        loadWidth(resultComponent, element);
        loadHeight(resultComponent, element);
        loadAlign(resultComponent, element);

        loadAnimation(resultComponent, element);
        loadNavigation(resultComponent, element);
        loadSlides(resultComponent, element);
    }

    private void loadSlides(Carousel resultComponent, Element element) {
        Element itemsElement = element.element("items");

        List itemsList = itemsElement.elements("item");
        List<String> slides = new ArrayList<>(itemsList.size());
        for (Object o : itemsList) {
            Element item = (Element) o;
            slides.add(item.attributeValue("url"));
        }

        resultComponent.setSlides(slides);
    }

    private void loadNavigation(Carousel resultComponent, Element element) {
        String navigation = element.attributeValue("navigation");
        if (StringUtils.isNotEmpty(navigation)) {
            resultComponent.setNavigation(Carousel.Navigation.valueOf(navigation));
        }
    }

    private void loadAnimation(Carousel resultComponent, Element element) {
        String animation = element.attributeValue("animation");
        if (StringUtils.isNotEmpty(animation)) {
            resultComponent.setAnimation(Carousel.Animation.valueOf(animation));
        }
    }
}
