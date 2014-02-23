package fr.creationjeuxjava.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

//============================================================================
//Name        : MenuGui.java from SpaceShell
//Author      : Alto971
//Version     : 
//Copyright   : www.creationjeuxjava.fr !
//Description : 
//Date		   : 23/02/2014 at 22:38
//============================================================================

public class MenuGui {
	
	// SOLO, MULTIJOUEUR, QUITTER
	TextButton solo,multijoueur,quitter;
	TextButtonStyle style;
	BitmapFont font;
	
	/**mieux avec skin de libgdx ***/
	Skin skin;
	
	Stage stage;
	
	public MenuGui(){		
//		font = new BitmapFont();//fonte par d�faut
//		style = new TextButtonStyle();
//		style.font = font;
//		style.fontColor = new Color(0.2f,0.9f,0.2f,1);
//		style.overFontColor = new Color(0.8f,0.9f,0.8f,1);
		
		skin = new Skin(Gdx.files.internal("skins/uiskin/uiskin.json"));
		
		solo = new TextButton("SOLO",skin);
		solo.setPosition(Gdx.app.getGraphics().getWidth()/2, Gdx.app.getGraphics().getHeight()/2);
		multijoueur = new TextButton("MULTIJOUEUR",skin);
		multijoueur.setPosition(Gdx.app.getGraphics().getWidth()/2, Gdx.app.getGraphics().getHeight()/2 -30);
		quitter = new TextButton("QUITTER",skin);
		quitter.setPosition(Gdx.app.getGraphics().getWidth()/2, Gdx.app.getGraphics().getHeight()/2 -60);
		
		
		/*** les listeners *****/
		solo.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.log("MenuGui", "on joue SOLO");
				//code de l'action si on clique dessus !!
			}	
		});
		multijoueur.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.log("MenuGui", "on joue en Multijoueurs");
				//code de l'action si on clique dessus !!
			}	
		});
		quitter.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.log("MenuGui", "Leaving....");
				
				Gdx.app.exit();
			}	
		});
		
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
        Gdx.input.setInputProcessor(stage);
        stage.addActor(solo);
        stage.addActor(multijoueur);
        stage.addActor(quitter);
	}
	
	
	/*** permet de dessiner � l'�cran les �l�ments GUI ****/
	public void dessineGUI(){		
		stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();
	}

}
