package uk.co.scottishpower.techtest.rest.smart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MeterReadsResourceTest {
    private static final String METER_READS_PATH = "/api/smart/reads/";
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void givenAValidAccountNumber_whenRetrievingReads_thenTheCorrectReadsAreReturnedAsJson() {
        String url = getUrl(METER_READS_PATH + 39800);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void givenANonexistentAccountNumber_whenRetrievingReads_thenAnEmptyJsonResponseIsReturned() {
        String url = getUrl(METER_READS_PATH + 1234567);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void givenAnInvalidAccountNumber_whenRetrievingReads_thenABadRequestIsReturnedAlongWithAnErrorMessage() {
        String url = getUrl(METER_READS_PATH + "-1");

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    private String getUrl(String path) {
        return "http://localhost:" + port + path;
    }
}