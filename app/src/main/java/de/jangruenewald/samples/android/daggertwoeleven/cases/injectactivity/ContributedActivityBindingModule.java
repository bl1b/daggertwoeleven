package de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectfragment.ChildFragmentBindingModule;

/**
 * Class ContributedActivityBindingModule.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
@Module
public abstract class ContributedActivityBindingModule {
    @ContributesAndroidInjector(modules = {ContributedActivityModule.class, ChildFragmentBindingModule.class})
    abstract ContributedActivity contributeDaggerTwoElevenActivity();
}
