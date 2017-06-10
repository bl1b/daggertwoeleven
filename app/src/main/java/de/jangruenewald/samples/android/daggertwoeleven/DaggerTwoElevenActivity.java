package de.jangruenewald.samples.android.daggertwoeleven;

import android.os.Bundle;
import android.support.annotation.Nullable;
import dagger.Subcomponent;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Jan-2 on 20.05.2017.
 */
public class DaggerTwoElevenActivity extends DaggerAppCompatActivity {

    @Subcomponent(modules = {DaggerTwoElevenActivityModule.class})
    public interface Component extends AndroidInjector<DaggerTwoElevenActivity> {
        @Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<DaggerTwoElevenActivity> {}
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daggertwoeleven);
    }
}
