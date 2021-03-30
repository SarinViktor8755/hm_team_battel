package com.mygdx.game.Lighting;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

/**
 * Created by 1 on 27.03.2021.
 */

public class ObFromLight {
    private World world;
    private ArrayList<Body> bodyList;

    public ObFromLight(World world) {
        this.world = world;
        this.bodyList = new ArrayList<Body>();
    }

    public void crearBody(){
        Body boxGround;
        for (int i = 0; i < 50; i++) {
            boxGround = createBox(BodyDef.BodyType.StaticBody, 0.5F, 0.5F, 2);
            boxGround.setTransform(i,0,0);
            boxGround.getFixtureList().get(0).setUserData("bd");

            bodyList.add(boxGround);


        }


    }


    /**
     * Создание блока.
     * @param type тип
     * @param width ширина
     * @param height высота
     * @param density плотность
     * @return
     */
    private Body createBox(BodyDef.BodyType type, float width, float height, float density) {
        BodyDef def = new BodyDef();
        def.type = type;
        Body box = world.createBody(def);
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(width, height);
        box.createFixture(poly, density);
        poly.dispose();

        return box;
    }
}
