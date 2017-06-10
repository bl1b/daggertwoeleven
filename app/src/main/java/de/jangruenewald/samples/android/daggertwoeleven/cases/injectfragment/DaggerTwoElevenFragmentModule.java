package de.jangruenewald.samples.android.daggertwoeleven.cases.injectfragment;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

/**
 * Created by Jan-2 on 10.06.2017.
 */
@Module
public abstract class DaggerTwoElevenFragmentModule {
    @Provides
    @Named("fragment_string_from_module")
    static String provideFragmentStringFromModule() {
        return "String from DaggerTwoElevenFragmentModule";
    }
}
