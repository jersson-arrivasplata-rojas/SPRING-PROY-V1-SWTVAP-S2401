package com.jersson.arrivasplata.swtvap.api.sso.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration
@PropertySource("classpath:application.properties")
@Getter
public class SOSConfig {
    @Value("${cloud.aws.credentials.accessKey}")
    String accessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    String secretKey;

    @Value("${cloud.aws.region.static}")
    String region;

    @Value("${s3.bucket}")
    String bucketName;

    @Value("${s3.endpoint}")
    String bucketEndpoint;
}
