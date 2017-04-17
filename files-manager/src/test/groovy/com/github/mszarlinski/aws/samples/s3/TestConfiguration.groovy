package com.github.mszarlinski.aws.samples.s3

import com.github.mszarlinski.aws.samples.s3.domain.FilesManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 * @author mszarlinski@gmail.com on 17/04/2017.
 */
@Configuration
@Profile(Profiles.TEST)
class TestConfiguration {

    @Bean
    FilesManager filesManager() {
        return new TestFilesManager()
    }
}
