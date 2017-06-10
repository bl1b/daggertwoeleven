package de.jangruenewald.samples.android.daggertwoeleven.cases.injectfragment;

import dagger.Module;
import dagger.Provides;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity.DaggerTwoElevenActivityModule;

import javax.inject.Named;

/**
 * Created by Jan-2 on 10.06.2017.
 */
@Module(
        includes = {
                DaggerTwoElevenActivityModule.class
        }
)
public abstract class DaggerTwoElevenFragmentModule {
    @Provides
    @Named("fragment_string_from_module")
    static String provideFragmentStringFromModule() {
        return "String from DaggerTwoElevenFragmentModule";
    }
}
