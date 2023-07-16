package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/selenoid.properties"
})

public interface SelenoidConfig extends Config {
    @Config.Key("selenoidUrl")
    String selenoidUrl();

    @Config.Key("selenoidVideoUrl")
    String selenoidVideoUrl();
}
