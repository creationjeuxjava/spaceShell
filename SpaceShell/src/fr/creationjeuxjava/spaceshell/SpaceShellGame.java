package fr.creationjeuxjava.spaceshell;

import com.badlogic.gdx.Game;

import fr.creationjeuxjava.screens.SplashScreen;

public class SpaceShellGame extends Game {

	@Override
	public void create() {
		setScreen(new SplashScreen(this));
		System.out.println("test");
	}

}
