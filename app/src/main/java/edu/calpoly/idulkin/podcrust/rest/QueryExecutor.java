package edu.calpoly.idulkin.podcrust.rest;

import android.util.Log;

//import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter ;
//import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.web.client.RestTemplate;

/*import java.util.ArrayList;
import java.util.List;

import static android.R.attr.port;
import static java.lang.String.format;
import static java.util.Arrays.asList;*/

/**
 * Created by Max on 11/29/2016.
 */

public class QueryExecutor {
    public static Trending getTrending() {

        /*ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setUsername("roy");
        resourceDetails.setPassword("spring");
        resourceDetails.setAccessTokenUri(format("http://localhost:%d/oauth/token", port));
        resourceDetails.setClientId("clientapp");
        resourceDetails.setClientSecret("123456");
        resourceDetails.setGrantType("password");
        resourceDetails.setScope(asList("read", "write"));

        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();

        OAuth2RestTemplate restTemplate2 = new OAuth2RestTemplate(resourceDetails, clientContext);
        //restTemplate2.setMessageConverters(asList(new MappingJackson2HttpMessageConverter()));

        final List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());
        restTemplate2.setMessageConverters(converters);
        return restTemplate2.getForObject("https://www.audiosear.ch/api/trending", Trending.class);*/


        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());;
        Trending t = restTemplate.getForObject("https://www.audiosear.ch/api/trending", Trending.class);
        Log.d("QueryExecutor", t.toString());
        return t;
    }
}
