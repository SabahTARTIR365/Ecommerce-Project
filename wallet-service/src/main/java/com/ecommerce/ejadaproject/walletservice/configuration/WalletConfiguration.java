package com.ecommerce.ejadaproject.walletservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("wallet-service")
public class WalletConfiguration {

}
