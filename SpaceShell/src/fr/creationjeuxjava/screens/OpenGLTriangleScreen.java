package fr.creationjeuxjava.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.creationjeuxjava.spaceshell.MeshCreator;
import fr.creationjeuxjava.spaceshell.SpaceShellGame;

//============================================================================
// Name        : OpenGLTriangleScreen.java from SpaceShell
// Author      : JohnCarmack
// Version     : 
// Copyright   : www.creationjeuxjava.fr !
// Description : 
// Date		   : 27 févr. 2014 at 21:38:08	
//============================================================================
public class OpenGLTriangleScreen implements Screen {

	Mesh myMesh;
	SpriteBatch batch;
	BitmapFont bitmapfont;
	MeshCreator meshCreator;
	FPSLogger fps;
	SpaceShellGame game;

	public OpenGLTriangleScreen(SpaceShellGame g) {
		game = g;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_BLEND_SRC_ALPHA);

		batch.begin();

		// bitmapfont.draw(batch, "Version OPENGL : " + Gdx.gl.glGetString(GL20.GL_VERSION), 6, 291);
		// bitmapfont.draw(batch, "Graphics CARD : " + Gdx.gl.glGetString(GL20.GL_RENDERER), 6, 305);
		// bitmapfont.draw(batch, "OpenGL 2.0 ? : " + Gdx.graphics.isGL20Available(), 6, 321);

		// bitmapfont.draw(batch, "JAVA HEAP : " + Gdx.app.getJavaHeap() / 10E4, 6, 191);
		// bitmapfont.draw(batch, "FPS : " + Gdx.graphics.getFramesPerSecond(), 6, 210);
		meshCreator.drawMesh(); // comment this line and uncomment bitmapfont.draw to print infos but without the triangle...
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		out("Version OpenGL ", Gdx.gl.glGetString(GL20.GL_VERSION));
		out("Graphic Card ", Gdx.gl.glGetString(GL20.GL_RENDERER));
		out("OpenGL 2.0 enable ? ", "" + Gdx.graphics.isGL20Available());
		out("FPS ", "" + Gdx.graphics.getFramesPerSecond());

		batch = new SpriteBatch();
		bitmapfont = new BitmapFont();
		bitmapfont.setColor(Color.RED);
		meshCreator = new MeshCreator();
		meshCreator.createMesh(new float[] { -0.5f, -0.5f, 0.5f, -0.5f, 0f, 0.5f });
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
		out("Paused!", "We paused the game");
		bitmapfont.setColor(Color.YELLOW);

	}

	@Override
	public void resume() {
		out("Resumed!", "We resumed the game");
		bitmapfont.setColor(Color.BLUE);
	}

	public static void out(String subject, String sentence) {
		Gdx.app.log(subject, sentence);
	}

	@Override
	public void dispose() {
		batch.dispose();
		bitmapfont.dispose();
		meshCreator.dispose();
	}
}
