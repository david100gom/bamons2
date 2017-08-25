package com.bamons2.monitoring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by david100gom on 2017. 8. 24.
 *
 * Github : https://github.com/david100gom
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MonitoringApplication.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OauthIntegrationTest {

    private static final String LOCAL_HOST = "http://localhost:";

    @LocalServerPort
    private int port;

    @Test
    public void retrieveTodos() throws Exception {

        String expected = "{index:index}";
        String uri = "/";

        ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
        resource.setUsername("admin");
        resource.setPassword("1234");
        resource.setAccessTokenUri(createURL("/oauth/token"));
        resource.setClientId("test");
        resource.setClientSecret("abc");
        resource.setGrantType("password");
        OAuth2RestTemplate oauthTemplate = new OAuth2RestTemplate(resource,new DefaultOAuth2ClientContext());
        ResponseEntity<String> response = oauthTemplate.getForEntity(createURL(uri), String.class);
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    private String createURL(String uri) {

        System.out.print("port : "+port);

        return LOCAL_HOST + port + uri;
    }
}
