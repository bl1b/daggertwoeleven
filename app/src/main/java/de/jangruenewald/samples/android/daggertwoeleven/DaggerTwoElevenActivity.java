package de.jangruenewald.samples.android.daggertwoeleven;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerAppCompatActivity;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectwithconstructor.DaggerTwoElevenActivityProvider;

import javax.inject.Inject;

/**
 * Created by Jan-2 on 20.05.2017.
 */
public class DaggerTwoElevenActivity extends DaggerAppCompatActivity {

    @Subcomponent(modules = {DaggerTwoElevenActivityModule.class})
    public interface Component extends AndroidInjector<DaggerTwoElevenActivity> {
        @Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<DaggerTwoElevenActivity> {}
    }

    @Inject
    DaggerTwoElevenActivityProvider daggerTwoElevenActivityProvider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daggertwoeleven);

        if (daggerTwoElevenActivityProvider != null) {
            ((TextView) findViewById(R.id.tv_string_from_constructor_injected)).setText(daggerTwoElevenActivityProvider.provideString());
        } else {
            ((TextView) findViewById(R.id.tv_string_from_constructor_injected)).setText("Constructor-Injection failed.");
        }
    }
}
