package at.refugeescode.cup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/coin")
public class CupEndpoint {

    private RestTemplate restTemplate;

    @Value("${receiver.url}")
    private String receiverUrl;

    public CupEndpoint(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping
    Boolean get(){
        String url = receiverUrl + "/play";
        ResponseEntity <Boolean> forEntity = restTemplate.getForEntity(url, Boolean.TYPE);
        return forEntity.getBody();
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
