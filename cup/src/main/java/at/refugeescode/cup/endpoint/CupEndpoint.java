package at.refugeescode.cup.endpoint;

import at.refugeescode.cup.model.Coin;
import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/coin")
public class CupEndpoint {


    @PutMapping
    Coin appear(@RequestBody Coin coin){
       return coin;
    }

    @DeleteMapping
    Coin remove(Coin coin){
       coin.setVisibility(false);
       return coin;
    }


}
