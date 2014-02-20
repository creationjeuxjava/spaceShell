package fr.creationjeuxjava.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

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
	private ShaderProgram mShaderProgram;
	private Mesh mMesh;

	public MenuScreen(SpaceShellGame g) {
		game = g;
	}

	@Override
	public void render(float delta) {
		// Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		f.log();
		if (Gdx.graphics.isGL20Available()) {
			this.mShaderProgram.begin();
			this.mMesh.render(this.mShaderProgram, GL10.GL_TRIANGLES);
			this.mShaderProgram.end();
		} else {
			this.mMesh.render(GL10.GL_TRIANGLES);
		}

	}

	private void createMesh() {
		this.mMesh = new Mesh(true, 4, 6, VertexAttribute.Position(), VertexAttribute.ColorUnpacked(), VertexAttribute.TexCoords(0));

		this.mMesh.setIndices(new short[] { 0, 1, 2, 2, 3, 0 });
		this.mMesh.setVertices(new float[] {
			-0.5f,-0.5f,0,		1,1,1,1,	0,1, 
			0.5f,-0.5f,0,		1,1,1,1,    1,1, 
			0.5f,0.5f,0,		1,1,1,1,	1,0,
			-0.5f,0.5f,0,		1,1,1,1,	0,0 
		});
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		Gdx.app.log("MenuScreen", "Dans le Menu");
		this.createShaderProgram();
		this.createMesh();

	}

	private void createShaderProgram() {
		final FileHandle fragmentShader = Gdx.files.internal("data/fragment.txt");
		final FileHandle vertexShader = Gdx.files.internal("data/vertex.txt");

		this.mShaderProgram = new ShaderProgram(vertexShader, fragmentShader);
		System.out.println(mShaderProgram.isCompiled());
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
