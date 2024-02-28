package com.mygdx.game;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class controls implements InputProcessor {
    public static String key = "";
    @Override
    public boolean keyDown(int keycode) {
        // Handle key down event
        key = Keys.toString(keycode);
        System.out.println("Key down: " + Keys.toString(keycode));
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        // Handle key up event
        key = "";
//        System.out.println("Key up: " + Keys.toString(keycode));
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println(screenY+" poninter "+pointer+" BTN--> "+button);
        if (screenY>460 && screenY<475) {

            if (screenX>=25 && screenX<=30) {
                key = "A";
                System.out.println("X touched"+key);

            }
            if (screenX>=50 && screenX<=55) {
                key = "D";
            }
            if (screenX>=100 && screenX<=105) {
                key = "Space";
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}

