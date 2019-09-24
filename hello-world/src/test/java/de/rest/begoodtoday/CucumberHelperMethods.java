package de.rest.begoodtoday;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;


import javax.annotation.PostConstruct;
import javax.validation.constraints.Null;
import javax.xml.ws.http.HTTPException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberHelperMethods {

    private final String SERVER = "localhost";

    @LocalServerPort
    private String port;

    private UriBuilder uriBuilder = new DefaultUriBuilderFactory().builder();

    private ObjectMapper objectMapper;
    protected HashMap <String, Object> map = new HashMap<>();;
    protected RequestEntity request;

    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders headers = new HttpHeaders();
    private HttpEntity httpEntity;


    public void buildCallUrl (String resource) throws MalformedURLException {
        uriBuilder.scheme("http").host(SERVER).port(port).path(resource);
    }

    private void mapResponeToHashMap(ResponseEntity responseEntity){
        try {
            map.put("header",responseEntity.getHeaders());
            map.put("status",responseEntity.getStatusCode());
            map.put("body",responseEntity.getBody());
        }
        catch (HTTPException e){
            map.put("status",e.getStatusCode());
        }
    }

    public void doGETRestCall() throws MalformedURLException {
        headers.set("Accept", "application/json");
        httpEntity = new HttpEntity<>(headers);
        ResponseEntity response = restTemplate.exchange(uriBuilder.build(), HttpMethod.GET, httpEntity, String.class);
        mapResponeToHashMap(response);

    }




}
