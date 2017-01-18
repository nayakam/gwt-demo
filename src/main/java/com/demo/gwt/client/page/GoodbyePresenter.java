package com.demo.gwt.client.page;

import com.demo.gwt.client.navigation.GreetingPlace;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;

import javax.inject.Inject;

public class GoodbyePresenter extends AbstractActivity {

    @ImplementedBy(GoodbyeViewImpl.class)
    interface GoodbyeView extends IsWidget {

        void setUserName(String userName);
    }

    @Inject
    private GoodbyeView view;
    private GreetingPlace greetingPlace;

    public GoodbyePresenter() {}

    public void init(GreetingPlace greetingPlace) {
        this.greetingPlace = greetingPlace;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setUserName(greetingPlace.getUserName());
        panel.setWidget(view.asWidget());
    }

}
