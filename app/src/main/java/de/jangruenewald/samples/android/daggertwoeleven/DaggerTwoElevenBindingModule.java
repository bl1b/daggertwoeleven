package de.jangruenewald.samples.android.daggertwoeleven;

import android.app.Activity;
import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectfragment.DaggerTwoElevenFragment;

/**
 * Created by Jan-2 on 10.06.2017.
 */
@Module(
        subcomponents = {
                DaggerTwoElevenActivity.Component.class,
                DaggerTwoElevenFragment.Component.class
        }
)
public abstract class DaggerTwoElevenBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(DaggerTwoElevenActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindDaggerTwoElevenActivityBuilder(DaggerTwoElevenActivity.Component.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(DaggerTwoElevenFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindDaggerTwoElevenFragmentBuilder(DaggerTwoElevenFragment.Component.Builder builder);
}
