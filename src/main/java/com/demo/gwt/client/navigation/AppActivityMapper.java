package com.demo.gwt.client.navigation;

import com.demo.gwt.client.page.HelloPresenter;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.demo.gwt.client.page.EmployeePresenter;
import com.demo.gwt.client.page.GoodbyePresenter;

public class AppActivityMapper implements ActivityMapper {

    @Inject
    private Provider<HelloPresenter> helloPresenterProvider;
    @Inject
    private Provider<GoodbyePresenter> goodbyePresenterProvider;
    @Inject
    private Provider<EmployeePresenter> employeePresenterProvider;

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof GreetingPlace) {
            GreetingPlace greetingPlace = (GreetingPlace) place;
            if ("hello".equals(greetingPlace.getGreeting())) {
                HelloPresenter helloPresenter = helloPresenterProvider.get();
                helloPresenter.init(greetingPlace);
                return helloPresenter;
            } else if ("goodbye".equals(greetingPlace.getGreeting())) {
                GoodbyePresenter goodbyePresenter = goodbyePresenterProvider.get();
                goodbyePresenter.init(greetingPlace);
                goodbyePresenter.init(greetingPlace);
                return goodbyePresenter;
            }
        } else if (place instanceof PagePlace) {
            PagePlace pagePlace = (PagePlace) place;
            if ("employee".equals(((PagePlace) place).getPageName())) {
                EmployeePresenter employeePresenter = employeePresenterProvider.get();
                employeePresenter.init(pagePlace);
                return employeePresenter;
            }
        }
        return null;
    }
}
