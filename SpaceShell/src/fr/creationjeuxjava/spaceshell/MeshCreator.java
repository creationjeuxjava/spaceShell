package fr.creationjeuxjava.spaceshell;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

//============================================================================
// Name        : MeshCreator.java from SpaceShell
// Author      : JohnCarmack
// Version     : 
// Copyright   : www.creationjeuxjava.fr !
// Description : 
// Date		   : 27 févr. 2014 at 21:40:33	
//============================================================================
public class MeshCreator {

	private Mesh mesh;
	private ShaderProgram meshShader;

	public MeshCreator() {
		createShader();
	}

	public void createMesh(float[] vertices) {
		mesh = new Mesh(true, vertices.length, 0, new VertexAttribute(
				Usage.Position, 2, "a_position"));
		mesh.setVertices(vertices);
	}

	public void drawMesh() {
		if (mesh == null)
			throw new IllegalStateException(
					"drawMesh called before a mesh has been created.");

		meshShader.begin();
		mesh.render(meshShader, GL20.GL_TRIANGLES);
		meshShader.end();
	}

	private void createShader() {
		// Vertex shader
		String vertexShader = "attribute vec4 a_position;    \n"
				+ "void main()                   \n"
				+ "{                             \n"
				+ "   gl_Position = a_position;  \n"
				+ "}                             \n";

		// this one tells it what goes in between the points (i.e
		// colour/texture)
		String fragmentShader = "#ifdef GL_ES                \n"
				+ "precision mediump float;    \n"
				+ "#endif                      \n"
				+ "void main()                 \n"
				+ "{                           \n"
				+ "  gl_FragColor = vec4(1.0,0.2,0.0,1.0);    \n" + "}";

		// make an actual shader from our strings
		meshShader = new ShaderProgram(vertexShader, fragmentShader);

		// check there's no shader compile errors
		if (meshShader.isCompiled() == false)
			throw new IllegalStateException(meshShader.getLog());
	}

	public void dispose() {
		mesh.dispose();
		meshShader.dispose();
	}

}
