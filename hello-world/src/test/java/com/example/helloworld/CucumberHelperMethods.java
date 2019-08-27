package com.example.helloworld;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Null;
import java.net.MalformedURLException;
import java.util.HashMap;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberHelperMethods {

    private final String SERVER = "http://localhost:";
    private final String MOOD_RESOURCE_NEW = "/mood/new";

    @LocalServerPort
    private String port;


    private ObjectMapper objectMapper;
    private HashMap <String, Object> map;

    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();
    private HttpEntity httpEntity;



    private String buildCallUrl (String resource){

        String url = SERVER + port;
        switch(resource){
            case "/mood/new":
                url += MOOD_RESOURCE_NEW;
                System.out.println(url);
                break;

            default:
                System.out.println("Resource to build URL not found");
                break;
        }
        return url;
    }

    private void mapResponeToHashMap(ResponseEntity responseEntity){
        map = new HashMap<String,Object>();

        map.put("header",responseEntity.getHeaders());
        map.put("status",responseEntity.getStatusCode());
        map.put("body",responseEntity.getBody());

        System.out.println(responseEntity.getHeaders());
        System.out.println(responseEntity.getBody());
        System.out.println(responseEntity.getStatusCode());
    }

    public void doRestCall(String resource) {
        headers.set("Accept", "application/json");
        httpEntity = new HttpEntity<>(headers);
        ResponseEntity response = restTemplate.exchange(buildCallUrl(resource), HttpMethod.GET, httpEntity, String.class);

        mapResponeToHashMap(response);
    }

    public void AssertHttpStatusCodeIsAsExpected(HttpStatus httpStatus){
        assertThat(map.get("status")).isEqualTo(httpStatus);
    }




}
