/*
 *  Copyright (C) 2017 Jan Grünewald
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package de.jangruenewald.samples.android.daggertwoeleven.cases.injectfragment.aschild;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import dagger.android.support.DaggerFragment;
import de.jangruenewald.samples.android.daggertwoeleven.R;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity.contributed.Contributed;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity.contributed.ContributedBindingModule;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectwithconstructor.StringProvider;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Class ChildFragment.
 * This is an example of a fragment that is injected using the
 * `@ContributesAndroidInjector`-method in {@link ChildFragmentBindingModule}.
 * It's linked as a child-element to {@link Contributed}
 * see: {@link ContributedBindingModule}.
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
public class ChildFragment extends DaggerFragment {
    @Inject
    StringProvider provider;

    @Inject
    @Named("fragment_string_from_module")
    String stringFromFragmentModule;

    // Works because fragment is bound as a "child" to `Contributed` in
    // the Dagger-Dependency-Graph.
    @Inject
    @Named("string_from_module")
    String stringFromActivityModule;

    public static ChildFragment newInstance() {
        ChildFragment fragment = new ChildFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // NOTE:
        // Since this fragment derives from DaggerFragment the call to `AndroidInjection.inject(this)` is obsolete.
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
            ((TextView) root.findViewById(R.id.tv_fragment_activitymodule_injected)).setText(R.string.activity_module_injection_failed);
        }
        return root;
    }
}
