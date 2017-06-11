package de.jangruenewald.samples.android.daggertwoeleven.cases.injectwithconstructor;

import javax.inject.Inject;

/**
 * Class DaggerTwoElevenProvider.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
public class DaggerTwoElevenProvider {

    private final String sample;

    @Inject
    public DaggerTwoElevenProvider() {
        sample = "String from DaggerTwoElevenProvider";
    }

    public String provideString() {
        return sample;
    }
}
