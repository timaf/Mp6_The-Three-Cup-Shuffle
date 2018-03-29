package at.refugeescode.trickster.endpoint;

import at.refugeescode.trickster.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping
public class TricksterEndpoint {

    private RestTemplate restTemplate;

    @Value("#{'${cup.number}'.split(',')}")
    private List <Integer> cupNumbers;

    @Value("${cup.port}")
    private String port;

    @Value("${cup.url}")
    private String cupUrl;

    public TricksterEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/play")
    void startGame(){
        Coin coin = new Coin();
        restTemplate.put(cupUrl + port + "1/coin",coin);
        restTemplate.put(cupUrl + port + "2/coin",coin);
        Collections.shuffle(cupNumbers);

    }



    @GetMapping("/choose/{cupNumber}")
    @ResponseBody
    String ask(@PathVariable int cupNumber ) {
        return "In which cup is the coin?? " + cupNumbers;
    }

    /*@GetMapping("/choose/{chosenNumber}")
    String sayResult(){
        if (h)
    }*/
    


}