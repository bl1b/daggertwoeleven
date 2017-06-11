package de.jangruenewald.samples.android.daggertwoeleven;

import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity.ContributedActivityBindingModule;

/**
 * Class App.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
public class App extends DaggerApplication {

    @dagger.Component(
            modules = {
                    ContributedActivityBindingModule.class,
                    AndroidSupportInjectionModule.class
            }
    )
    interface Component extends AndroidInjector<App> {
        @dagger.Component.Builder
        abstract class Builder extends AndroidInjector.Builder<App> {}
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApp_Component.builder().create(this);
    }
}
