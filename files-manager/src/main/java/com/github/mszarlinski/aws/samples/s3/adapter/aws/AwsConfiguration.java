package com.github.mszarlinski.aws.samples.s3.adapter.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.github.mszarlinski.aws.samples.s3.Profiles;
import com.github.mszarlinski.aws.samples.s3.domain.FilesManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author mszarlinski@gmail.com on 17/04/2017.
 */
@Profile(Profiles.AWS)
@Configuration
@EnableConfigurationProperties(AwsConfiguration.Properties.class)
class AwsConfiguration {

    @Bean
    FilesManager filesManager(Properties properties) {
        AWSCredentials credentials = new BasicAWSCredentials(properties.getKey(), properties.getSecret());
        AmazonS3 s3 = new AmazonS3Client(credentials);
        return new AwsFilesManager(s3);
    }

    @ConfigurationProperties("aws")
    static class Properties {

        private String key;
        private String secret;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }
    }
}
