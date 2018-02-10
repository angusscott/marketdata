package codes.angus.marketdata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:gdax.properties")
public class GDAXConnectionConfiguration {

    @Value("${gdax.url}")
    private String url;

    @Value("${gdax.subscriptionMessage}")
    private String connectionConfiguration;
    //= "{\"type\":\"subscribe\",\"product_ids\":[\"BTC-EUR\",\"ETH-EUR\"]}"

    public String getUrl() {
        return url;
    }

    public String getConnectionConfiguration() {
        return connectionConfiguration;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
