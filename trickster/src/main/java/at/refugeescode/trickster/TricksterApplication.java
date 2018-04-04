package at.refugeescode.trickster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TricksterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TricksterApplication.class, args);
	}
}

/*Mp6 - The Three Cup Shuffle
		Implement the three cup shuffle game with one Cup application replicated three times and one Trickster that hosts the game.
		A third application with a UI will be provided to connect it to the endpoints of the Trickster.
		The Trickster will have the following endpoints:
		 /play starts a new game removes the coin from the Cups and hides one in one of them at random;
		 /choose/{number} chooses one of the Cups and returns whether we guessed right.*/
