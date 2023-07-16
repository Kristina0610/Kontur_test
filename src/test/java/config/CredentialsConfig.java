package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/credentials.properties"
})

public interface CredentialsConfig extends Config {
    @Key("mailAccount")
    String mailAccount();

    @Key("passwordAccount")
    String passwordAccount();

    @Key("name")
    String name();

    @Key("surname")
    String surname();
}