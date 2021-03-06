package fr.creationjeuxjava.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;

import fr.creationjeuxjava.gui.MenuGui;
import fr.creationjeuxjava.spaceshell.SpaceShellGame;

//============================================================================
// Name        : MenuScreen.java from SpaceShell
// Author      : JohnCarmack
// Version     : 
// Copyright   : www.creationjeuxjava.fr !
// Description : 
// Date		   : 16 févr. 2014 at 13:26:06	
//============================================================================
public class MenuScreen implements Screen {

	SpaceShellGame game;
	FPSLogger f = new FPSLogger();
	
	/*** pour GUI ***/
	MenuGui gui;

	public MenuScreen(SpaceShellGame g) {
		game = g;
	}

	@Override
	public void render(float delta) {
		 Gdx.gl.glClearColor(0, 0, 0, 1);
		 Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		gui.drawGui();

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		Gdx.app.log("MenuScreen", "Dans le Menu");
		gui = new MenuGui();

	}


	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
