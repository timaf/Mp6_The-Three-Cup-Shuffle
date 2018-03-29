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
        Coin coin = new Coin(true);
        Collections.shuffle(cupNumbers);
        int hiddenCoinCup = cupNumbers.get(0);
        restTemplate.put(cupUrl + port + hiddenCoinCup +" /coin",coin);
        return "your turn you choose...";
    }

    @GetMapping("/choose/{chosenNumber}")
    @ResponseBody
    String sayResult(@PathVariable int chosenNumber ) {
        Coin coin1 = restTemplate.getForObject(cupUrl + port + cupNumbers.get(0) + " /coin", Coin.class);
        Coin coin2 = restTemplate.getForObject(cupUrl + port + cupNumbers.get(1) + " /coin", Coin.class);
        Coin coin3 = restTemplate.getForObject(cupUrl + port + cupNumbers.get(2) + " /coin", Coin.class);
        ArrayList <Coin> coins = new ArrayList <>(Arrays.asList(coin1, coin2, coin3));
        Optional <Coin> hiddenCoin = coins.stream()
                .filter(coin -> coin.getVisibility().equals(true))
                .findFirst();
        if(hiddenCoin.isPresent())
           if(hiddenCoin.toString().contains("chosenNumber"))
               return "you win ";
            else
                return "you lose";
        else
           return "lost coin";
    }

}