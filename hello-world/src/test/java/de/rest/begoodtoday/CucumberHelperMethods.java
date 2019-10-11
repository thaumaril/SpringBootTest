package de.rest.begoodtoday;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import java.util.HashMap;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberHelperMethods {

    private final String SERVER = "localhost";

    @LocalServerPort
    private String port;

    private UriBuilder uriBuilder = new DefaultUriBuilderFactory().builder();

    protected HashMap <String, Object> map = new HashMap<>();

    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders headers = new HttpHeaders();
    private HttpEntity httpEntity;


    public void buildCallUrl (String resource) {
        uriBuilder.scheme("http").host(SERVER).port(port).path(resource);
    }

    private void mapResponeToHashMap(ResponseEntity responseEntity){
        try {
            map.put("header",responseEntity.getHeaders());
            map.put("status",responseEntity.getStatusCode());
            map.put("body",responseEntity.getBody());
        }
        catch (HttpClientErrorException | HttpServerErrorException e){
            map.put("status",e.getStatusCode());
        }
    }

    public void doGETRestCall() {
        headers.set("Accept", "application/json");
        httpEntity = new HttpEntity<>(headers);
        ResponseEntity response = restTemplate.exchange(uriBuilder.build(), HttpMethod.GET, httpEntity, String.class);
        mapResponeToHashMap(response);

    }




}
