package de.jangruenewald.samples.android.daggertwoeleven.cases.injectfragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Class ChildFragmentBindingModule.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
@Module
public abstract class ChildFragmentBindingModule {
    @ContributesAndroidInjector(modules = {ChildFragmentModule.class})
    abstract ChildFragment contributeDaggerTwoElevenFragment();
}
