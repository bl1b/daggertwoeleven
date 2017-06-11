package de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import dagger.android.support.DaggerAppCompatActivity;
import de.jangruenewald.samples.android.daggertwoeleven.R;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectfragment.ChildFragment;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectwithconstructor.StringProvider;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Class ContributedActivity.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
public class ContributedActivity extends DaggerAppCompatActivity {
    @Inject
    StringProvider stringProvider;

    @Inject
    @Named("string_from_module")
    String stringFromModule;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daggertwoeleven);

        if (stringProvider != null) {
            ((TextView) findViewById(R.id.tv_string_from_constructor_injected)).setText(stringProvider.provideString());
        } else {
            ((TextView) findViewById(R.id.tv_string_from_constructor_injected)).setText(R.string.constructor_injection_failed);
        }

        if (stringFromModule != null) {
            ((TextView) findViewById(R.id.tv_string_from_module_injected)).setText(stringFromModule);
        } else {
            ((TextView) findViewById(R.id.tv_string_from_module_injected)).setText(R.string.module_injection_failed);
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_daggertwoelevenfragment, ChildFragment.newInstance())
                .commit();
    }
}
