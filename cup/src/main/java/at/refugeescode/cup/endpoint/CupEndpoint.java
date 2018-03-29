package at.refugeescode.cup.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/coin")
public class CupEndpoint {

    private RestTemplate restTemplate;

    @Value("${trickster.url}")
    private String tricksterUrl;

    @Value("${server.port}}")
    private String serverPort;

    public CupEndpoint(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping
    String get(){
        String url = tricksterUrl + "/play";
        //ResponseEntity <Boolean> forEntity = restTemplate.getForEntity(url, Boolean.TYPE);

        /*if(forEntity.hasBody())
            return "I have the coin. ";
        else*/
            return "I don't have the coin.";
    }

    @PutMapping
    Boolean put(){
        return true;
    }

    @DeleteMapping
    Boolean delete(){
        return false;
    }



}
