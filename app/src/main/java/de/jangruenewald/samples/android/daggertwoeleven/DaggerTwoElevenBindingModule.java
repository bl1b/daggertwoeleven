package de.jangruenewald.samples.android.daggertwoeleven;

import android.app.Activity;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Jan-2 on 10.06.2017.
 */
@Module(
        subcomponents = {
                DaggerTwoElevenActivity.Component.class
        }
)
public abstract class DaggerTwoElevenBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(DaggerTwoElevenActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindDaggerTwoElevenActivityBuilder(DaggerTwoElevenActivity.Component.Builder builder);
}
