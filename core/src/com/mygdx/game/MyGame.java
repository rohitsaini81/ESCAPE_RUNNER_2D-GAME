package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.Color;

public class MyGame extends ApplicationAdapter {

	SpriteBatch batch;
	Texture img;
	Texture backgroundTexture;
//	Sound jumpSound;
	controls controls;
	BitmapFont font;



	int playerX, playerY;
	float velocityY;
	boolean isJumping;
	int bg_on=586;



	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("ABCD.png");
		backgroundTexture = new Texture("transp.png");
//		jumpSound = Gdx.audio.newSound(Gdx.files.internal("videoplayback.mp3"));
		controls = new controls();
		Gdx.input.setInputProcessor(controls);
		playerX = Gdx.graphics.getWidth() / 2 - img.getWidth() / 2; // Center the player horizontally
		playerY = 0; // Start at the bottom of the screen
		velocityY = 0; // Initially, no vertical velocity
		isJumping = false; // Initially, not jumping
//		jumpSound.play();
		font =new BitmapFont();
		font.setColor(0,10,0,1);


	}

	private void jump() {
//		jumpSound.play();
		if (!isJumping) {
			velocityY = 10; // Set initial jump velocity
			isJumping = true;
		}
		System.out.println(velocityY);

	}

	@Override
	public void render() {
		if (controls.key.equals("A") && playerX>0) {
			playerX-=2;
			System.out.println(playerX);
		}
		if (controls.key.equals("D") && playerX<586) {
			playerX+=2;
			System.out.println(playerX);
			//586 display last

		}

		if (controls.key.equals("Space")) {
			jump();
		}

		// Apply gravity
		velocityY -= 0.5f; // Decrease velocity to simulate gravity
		playerY += velocityY; // Update player's vertical position

		// Check if the player has landed
		if (playerY <= 0) {
			playerY = 0;
			velocityY = 0;
			isJumping = false;
		}

		ScreenUtils.clear(0, 0, 0, 1);

		batch.begin();

		if (playerX==586 && bg_on !=0 ) {
			bg_on-=2;
		}
		if (bg_on==1){playerX=587; bg_on=3;}
//		font.setColor(0,10,0,1);
		batch.draw(backgroundTexture, bg_on, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		font.draw(batch,"A",20,25);
		font.draw(batch,"D",50,25);
		font.draw(batch,"JUMP",100,25);

		batch.draw(img, playerX, playerY, 50,50);
		batch.end();
	}

	@Override
	public void dispose() {
		font.dispose();
		batch.dispose();
		img.dispose();
//		jumpSound.dispose();
	}
}

