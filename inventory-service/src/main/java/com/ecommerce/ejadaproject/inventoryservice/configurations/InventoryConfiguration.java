package com.ecommerce.ejadaproject.inventoryservice.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

 

@Component
@ConfigurationProperties("inventory-service")

public class InventoryConfiguration {

    

     private String applicationName;

        private int serverPort;

        private String datasourceUrl;

        private String datasourceUsername;

        private String datasourcePassword;

        private String jpaDdlAuto;

        public String getApplicationName() {

            return applicationName;

        }

        public void setApplicationName(String applicationName) {

            this.applicationName = applicationName;

        }

        public int getServerPort() {

            return serverPort;

        }

        public void setServerPort(int serverPort) {

            this.serverPort = serverPort;

        }

        public String getDatasourceUrl() {

            return datasourceUrl;

        }

        public void setDatasourceUrl(String datasourceUrl) {

            this.datasourceUrl = datasourceUrl;

        }

        public String getDatasourceUsername() {

            return datasourceUsername;

        }

        public void setDatasourceUsername(String datasourceUsername) {

            this.datasourceUsername = datasourceUsername;

        }

        public String getDatasourcePassword() {

            return datasourcePassword;

        }

        public void setDatasourcePassword(String datasourcePassword) {

            this.datasourcePassword = datasourcePassword;

        }

        public String getJpaDdlAuto() {

            return jpaDdlAuto;

        }

        public void setJpaDdlAuto(String jpaDdlAuto) {

            this.jpaDdlAuto = jpaDdlAuto;

        }

        

        

    

 

}

 
/*
@Component
@ConfigurationProperties("inventory-service")
public class InventoryConfiguration  {
    private String applicationName;
    private int serverPort;
   // private String configImport;
    private String datasourceUrl;
    private String datasourceUsername;
    private String datasourcePassword;
   // private String hibernateDialect;
    private String hibernateDdlAuto;
    private boolean deferDatasourceInitialization;
    private String eurekaServiceUrl;

    // Getters and setters for the configuration properties
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getConfigImport() {
        return configImport;
    }

    public void setConfigImport(String configImport) {
        this.configImport = configImport;
    }

    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    public void setDatasourceUrl(String datasourceUrl) {
        this.datasourceUrl = datasourceUrl;
    }

    public String getDatasourceUsername() {
        return datasourceUsername;
    }

    public void setDatasourceUsername(String datasourceUsername) {
        this.datasourceUsername = datasourceUsername;
    }

    public String getDatasourcePassword() {
        return datasourcePassword;
    }

    public void setDatasourcePassword(String datasourcePassword) {
        this.datasourcePassword = datasourcePassword;
    }

    public String getHibernateDialect() {
        return hibernateDialect;
    }

    public void setHibernateDialect(String hibernateDialect) {
        this.hibernateDialect = hibernateDialect;
    }

    public String getHibernateDdlAuto() {
        return hibernateDdlAuto;
    }

    public void setHibernateDdlAuto(String hibernateDdlAuto) {
        this.hibernateDdlAuto = hibernateDdlAuto;
    }

    public boolean isDeferDatasourceInitialization() {
        return deferDatasourceInitialization;
    }

    public void setDeferDatasourceInitialization(boolean deferDatasourceInitialization) {
        this.deferDatasourceInitialization = deferDatasourceInitialization;
    }

    public String getEurekaServiceUrl() {
        return eurekaServiceUrl;
    }

    public void setEurekaServiceUrl(String eurekaServiceUrl) {
        this.eurekaServiceUrl = eurekaServiceUrl;
    }
}
*/