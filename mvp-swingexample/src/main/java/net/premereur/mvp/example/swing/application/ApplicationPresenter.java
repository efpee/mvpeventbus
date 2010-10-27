package net.premereur.mvp.example.swing.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;

import net.premereur.mvp.core.EventBus;
import net.premereur.mvp.core.guice.BasePresenter;
import net.premereur.mvp.example.support.ClickHandler;
import net.premereur.mvp.example.swing.categorymgt.CategoryMgtBus;
import net.premereur.mvp.example.swing.productmgt.ProductMgtBus;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ApplicationPresenter extends BasePresenter<ApplicationFrame, ApplicationBus> {

    @Inject
    public ApplicationPresenter(final EventBus eventBus, final ApplicationFrame view) {
        super((ApplicationBus) eventBus, view);
    }

    public final void onApplicationStarted() {
        ApplicationFrame view = getView();

        getEventBus(CategoryMgtBus.class).categoryMgtActivated();
        view.pack();
        view.setVisible(true);
        view.setExitListener(getExitClickHandler());
        view.setCategoryListener(getCategoryClickHandler());
        view.setProductListener(getProductClickHandler());
    }

    public final void onSetLeftComponent(final JComponent component) {
        getView().setLeftComponent(component);
    }

    public final void onClearScreen() {
        getView().clearLeftComponent();
        getView().clearCentralComponent();
    }

    public final void onSetCenterComponent(final JComponent component) {
        getView().setCentralComponent(component);
    }

    public final void onSetFeedback(final String text) {
        getView().setFeedback(text);
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                getView().setFeedback("");

            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public final ClickHandler getExitClickHandler() {
        return new ClickHandler() {
            @Override
            public void click() {
                System.exit(0);
            }
        };
    }

    public final ClickHandler getCategoryClickHandler() {
        return new ClickHandler() {
            @Override
            public void click() {
                getEventBus(CategoryMgtBus.class).categoryMgtActivated();
            }
        };
    }

    public final ClickHandler getProductClickHandler() {
        return new ClickHandler() {
            @Override
            public void click() {
                getEventBus(ProductMgtBus.class).productMgtActivated();
            }
        };
    }
}
