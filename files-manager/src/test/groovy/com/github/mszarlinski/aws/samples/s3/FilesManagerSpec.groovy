package com.github.mszarlinski.aws.samples.s3

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * @author mszarlinski@gmail.com on 17/04/2017.
 */
@SpringBootTest(
        classes = [FilesManagerApplication],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@ActiveProfiles(Profiles.TEST)
class FilesManagerSpec extends Specification {

    @Autowired
    TestFilesManager filesManager

    @Autowired
    TestRestTemplate restTemplate

    def "should list buckets"() {
        given:
            filesManager.buckets = ['bucket1', 'bucket2']
        when:
            def result = restTemplate.getForObject("/buckets", List)
        then:
            result == ['bucket1', 'bucket2']

    }
}
