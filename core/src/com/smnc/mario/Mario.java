package com.smnc.mario;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.smnc.mario.screens.PlayScreen;

public class Mario extends Game {
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));

	}

	@Override
	public void render () {
		super.render();
	}
}
