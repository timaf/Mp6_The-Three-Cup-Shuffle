package at.refugeescode.cup.model;


public class Coin {
    private  Boolean visibility = false;

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
