package at.refugeescode.trickster.model;

import org.springframework.stereotype.Component;

@Component
public class Coin {
    private  Boolean visibility ;

    public Coin() {
    }

    public Coin(Boolean visibility) {
        this.visibility = visibility;
    }


    public Boolean getVisibility() {
        return visibility;
    }


    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }
}
