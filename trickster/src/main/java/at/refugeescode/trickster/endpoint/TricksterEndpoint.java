package at.refugeescode.trickster.endpoint;

import at.refugeescode.trickster.model.Coin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;


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
    String startGame(){
         restTemplate.delete(cupUrl + port + cupNumbers.get(0) + "/coin", Coin.class);
         restTemplate.delete(cupUrl + port + cupNumbers.get(1) + "/coin", Coin.class);
         restTemplate.delete(cupUrl + port + cupNumbers.get(2) + "/coin", Coin.class);
         return " I hided the coin ,your turn you choose...";
    }

    @GetMapping("/choose/{chosenNumber}")
    String sayResult(@PathVariable int chosenNumber ) {
        Coin coin = new Coin(true);
        Collections.shuffle(cupNumbers);
        int hiddenCoinCup = cupNumbers.get(0);//cupUrl + port + hiddenCoinCup + "/coin"
        restTemplate.put("http://localhost:9001/coin",coin);
        if(hiddenCoinCup == chosenNumber)
            return "you win ";
        else
            return "you lose";

    }

}