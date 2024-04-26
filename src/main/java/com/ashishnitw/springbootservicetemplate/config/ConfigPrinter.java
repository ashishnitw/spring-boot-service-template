package com.ashishnitw.springbootservicetemplate.config;

import com.ashishnitw.springbootservicetemplate.config.http.HttpClientConfigs;
import com.zaxxer.hikari.HikariConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ConfigPrinter implements CommandLineRunner {

    private final HikariConfig hikariConfig;
    private final HttpClientConfigs httpClientConfigs;

    @Override
    public void run(String... args) {
        printHttpConfigs();
        printDatasourceConfig();
    }

    private void printHttpConfigs() {
        log.info("======================================");
        log.info("Http Client Configs: ");
        log.info("\t Max Total Connections: " + httpClientConfigs.getMaxTotalConnections());
        log.info("\t Max Per Route Connections: " + httpClientConfigs.getDefaultMaxPerRouteConnections());
        log.info("\t Connection Timeout: " + httpClientConfigs.getConnectTimeout());
        log.info("\t Request Timeout: " + httpClientConfigs.getRequestTimeout());
        log.info("\t Socket Timeout: " + httpClientConfigs.getSocketTimeout());
        log.info("\t Default Keep Alive Time: " + httpClientConfigs.getDefaultKeepAliveTime());
        log.info("\t Idle Connection Wait Time: " + httpClientConfigs.getIdleConnectionWaitTime());
        log.info("======================================");
    }

    private void printDatasourceConfig() {
        log.info("======================================");
        log.info("HikariCP Connection Pool Configuration : " + hikariConfig.getPoolName());
        log.info("\t JDBC URL: " + hikariConfig.getJdbcUrl());
        log.info("\t Username: " + hikariConfig.getUsername());
        log.info("\t Password: " + hikariConfig.getPassword());
        log.info("\t Connection Timeout: " + hikariConfig.getConnectionTimeout());
        log.info("\t Idle Timeout: " + hikariConfig.getIdleTimeout());
        log.info("\t Max Lifetime: " + hikariConfig.getMaxLifetime());
        log.info("\t Maximum Pool Size: " + hikariConfig.getMaximumPoolSize());
        log.info("\t Minimum Idle: " + hikariConfig.getMinimumIdle());
        log.info("======================================");
    }
}
