package org.rtm.systemtest.cucumber.tankmaster.utilities;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestCaseStarted;
import io.cucumber.plugin.event.TestSourceRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class FeatureScenarioLogger implements ConcurrentEventListener {

    public static final Logger featureScenarioLogger = LoggerFactory.getLogger("feature-scenario-logger");

    public static final String FIELD_DELIMITER = ";";

    private final Map<String, String> features = new ConcurrentHashMap<>();

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {

        eventPublisher.registerHandlerFor(TestCaseStarted.class, event -> {
            String feature = features.get(event.getTestCase().getUri().toString());
            String scenario = event.getTestCase().getName();
            String tags = String.join(FIELD_DELIMITER, event.getTestCase().getTags());

            featureScenarioLogger.info(String.join(FIELD_DELIMITER, feature, scenario, tags));
        });

        eventPublisher.registerHandlerFor(TestSourceRead.class, event -> {
            String featureReadableName = Stream.of(event.getSource().split("\\n"))
                .filter(str -> str.trim().startsWith("Feature"))
                .findFirst()
                .map(str -> str.split(":"))
                .filter(array -> array.length > 1)
                .map(array -> array[1].trim())
                .orElse("ERROR, No feature found");

            String featureIdentifier = event.getUri().toString();
            features.putIfAbsent(featureIdentifier, featureReadableName);
        });

    }
}
