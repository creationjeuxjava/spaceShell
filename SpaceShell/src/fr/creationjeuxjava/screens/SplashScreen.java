package fr.creationjeuxjava.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.creationjeuxjava.spaceshell.SpaceShellGame;
import fr.creationjeuxjava.tweenAccessors.SpriteTween;

//============================================================================
// Name        : SplashScreen.java from SpaceShell
// Author      : JohnCarmack
// Version     : 
// Copyright   : www.creationjeuxjava.fr !
// Description : 
// Date		   : 16 févr. 2014 at 13:25:55	
//============================================================================
public class SplashScreen implements Screen {
	Texture splashTexture;
	Sprite splashSprite;
	SpriteBatch batch;
	SpaceShellGame game;
	TweenManager manager;

	public SplashScreen(SpaceShellGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		manager.update(delta);
		batch.begin();
		splashSprite.draw(batch);
		batch.end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new OpenGLTriangleScreen(game));
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		Gdx.app.log("SplashScreen", "Lancement du SplashScreen");
		splashTexture = new Texture("data/dg.png");
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		splashSprite = new Sprite(splashTexture);
		splashSprite.setColor(1, 1, 1, 0);
		splashSprite.setOrigin(splashSprite.getWidth() / 2 + splashSprite.getWidth(), splashSprite.getHeight() / 2 + splashSprite.getHeight());
		splashSprite.setPosition(Gdx.graphics.getWidth() / 2 - 330, Gdx.graphics.getHeight() / 2 - 180);

		batch = new SpriteBatch();

		Tween.registerAccessor(Sprite.class, new SpriteTween());
		manager = new TweenManager();

		TweenCallback cb = new TweenCallback() {

			@Override
			public void onEvent(int type, BaseTween<?> source) {
				tweenCompleted();
			}

		};

		Tween.to(splashSprite, SpriteTween.ALPHA, 3f).target(1).ease(TweenEquations.easeInQuad).repeatYoyo(1, 0.5f).setCallback(cb).setCallbackTriggers(TweenCallback.COMPLETE).start(manager);
	}

	private void tweenCompleted() {
		Gdx.app.log("Tween", "Completed");
		game.setScreen(new MenuScreen(game));
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
