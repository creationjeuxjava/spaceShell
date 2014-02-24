package fr.creationjeuxjava.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.creationjeuxjava.spaceshell.SpaceShellGame;

public class AbstractScreen implements Screen {
	
	private SpaceShellGame game;
	private SpriteBatch batch;
	
	public AbstractScreen(SpaceShellGame g){
		game = g;
		batch = new SpriteBatch();
	}
	

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
