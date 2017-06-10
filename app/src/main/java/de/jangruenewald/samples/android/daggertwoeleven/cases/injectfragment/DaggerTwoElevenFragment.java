package de.jangruenewald.samples.android.daggertwoeleven.cases.injectfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerFragment;
import de.jangruenewald.samples.android.daggertwoeleven.R;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectwithconstructor.DaggerTwoElevenProvider;

import javax.inject.Inject;
import javax.inject.Named;

public class DaggerTwoElevenFragment extends DaggerFragment {

    @dagger.Subcomponent(
            modules = {
                    DaggerTwoElevenFragmentModule.class
            }
    )
    public interface Component extends AndroidInjector<DaggerTwoElevenFragment> {
        @dagger.Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<DaggerTwoElevenFragment> {}
    }

    @Inject
    DaggerTwoElevenProvider provider;

    @Inject
    @Named("fragment_string_from_module")
    String stringFromFragmentModule;

    /**
     * This works because of the `includes`-relationship in `DaggerTwoElevenFragmentModule`.
     */
    @Inject
    @Named("string_from_module")
    String stringFromActivityModule;

    public DaggerTwoElevenFragment() {
        // Required empty public constructor
    }

    public static DaggerTwoElevenFragment newInstance() {
        DaggerTwoElevenFragment fragment = new DaggerTwoElevenFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dagger_two_eleven, container, false);

        if (provider != null) {
            ((TextView) root.findViewById(R.id.tv_fragment_constructor_injected)).setText(provider.provideString());
        } else {
            ((TextView) root.findViewById(R.id.tv_fragment_constructor_injected)).setText(R.string.fragment_constructor_injection_failed);
        }

        if (stringFromFragmentModule != null) {
            ((TextView) root.findViewById(R.id.tv_fragment_module_injected)).setText(stringFromFragmentModule);
        } else {
            ((TextView) root.findViewById(R.id.tv_fragment_module_injected)).setText(R.string.fragment_module_injection_failed);
        }
        if (stringFromFragmentModule != null) {
            ((TextView) root.findViewById(R.id.tv_fragment_activitymodule_injected)).setText(stringFromActivityModule);
        } else {
            ((TextView) root.findViewById(R.id.tv_fragment_activitymodule_injected)).setText(R.string.fragment_module_injection_failed);
        }
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
