package de.jangruenewald.samples.android.daggertwoeleven.cases.injectwithconstructor;

import javax.inject.Inject;

/**
 * Class StringProvider.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
public class StringProvider {

    private final String sample;

    @Inject
    public StringProvider() {
        sample = "String from StringProvider";
    }

    public String provideString() {
        return sample;
    }
}
