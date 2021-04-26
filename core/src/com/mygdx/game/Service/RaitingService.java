package com.mygdx.game.Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import static com.badlogic.gdx.math.MathUtils.random;

public class RaitingService {
    static public String generateTokken(){ // Генерация токкена
        long longToken = Math.abs( random.nextLong() );
        String token = Long.toString( longToken, 16 );

        Preferences prefs = Gdx.app.getPreferences("USSD_RAITING");
        prefs.putString("ID", token);
        prefs.flush();

        System.out.println(prefs.getString("ID"));


        return token;
    }




}
