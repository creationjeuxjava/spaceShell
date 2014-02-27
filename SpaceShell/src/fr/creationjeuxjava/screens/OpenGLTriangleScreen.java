package fr.creationjeuxjava.screens;

import test.openGL.MeshHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


//============================================================================
// Name        : OpenGLTriangleScreen.java from SpaceShell
// Author      : JohnCarmack
// Version     : 
// Copyright   : www.creationjeuxjava.fr !
// Description : 
// Date		   : 27 févr. 2014 at 21:38:08	
//============================================================================
public class OpenGLTriangleScreen implements Screen {

	@Mesh myMesh;
	SpriteBatch batch;
	BitmapFont bitmapfont;
	MeshHelper meshHelper;
	FPSLogger fps;

	@Override
	public void create() {

		// out(Gdx.gl.glGetString(GL20.GL_VERSION));
		// out(Gdx.gl.glGetString(GL20.GL_RENDERER));
		batch = new SpriteBatch();
		bitmapfont = new BitmapFont();
		bitmapfont.setColor(Color.RED);
		meshHelper = new MeshHelper();
		meshHelper
				.createMesh(new float[] { -0.5f, -0.5f, 0.5f, -0.5f, 0f, 0.5f });

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_BLEND_SRC_ALPHA);

		batch.begin();

		bitmapfont.draw(batch,
				"Version OPENGL : " + Gdx.gl.glGetString(GL20.GL_VERSION), 6,
				291);
		bitmapfont.draw(batch,
				"Graphics CARD : " + Gdx.gl.glGetString(GL20.GL_RENDERER), 6,
				305);
		bitmapfont.draw(batch,
				"OpenGL 2.0 ? : " + Gdx.graphics.isGL20Available(), 6, 321);

		bitmapfont.draw(batch, "JAVA HEAP : " + Gdx.app.getJavaHeap() / 10E4,
				6, 191);
		bitmapfont.draw(batch, "FPS : " + Gdx.graphics.getFramesPerSecond(), 6,
				210);
		// meshHelper.drawMesh();
		batch.end();

	}

	public static void out(String s) {
		System.out.println(s);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
		out("Paused!");
		bitmapfont.setColor(Color.YELLOW);

	}

	@Override
	public void resume() {
		out("Resumed!");
		bitmapfont.setColor(Color.BLUE);
	}

	@Override
	public void dispose() {
		batch.dispose();
		bitmapfont.dispose();
		meshHelper.dispose();

	}
}

