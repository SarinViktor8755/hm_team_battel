package com.mygdx.game.Lighting;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Lighting.utils.b2d.BodyBuilder;
import com.mygdx.game.SpaceMap.Obstacles.BoxObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 27.03.2021.
 */

public class ObFromLight {
    private World world;
    private ArrayList<Body> bodyList;

    public ObFromLight(World world) {
        this.world = world;
        this.bodyList = new ArrayList<Body>();


        // BodyBuilder.createBox(world,2500,4000,200,450,true,true);


//        for (int i = 0; i < 10; i++) {
//            BodyBuilder.createBox(world,i * 5000,i *5000,200,450,true,true);
//        }


    }

    public void crearBodys(HashMap<Integer, BoxObject> badis) {

        BoxObject obj;
        for (Map.Entry<Integer, BoxObject> entry : badis.entrySet()) {
            obj = entry.getValue();
            //System.out.println(obj);

            if(obj.getPointLeftBottom().y == 4800) continue;
            if(obj.getPointLeftBottom().x == 0) continue;
            if(obj.getPointLeftBottom().y == 0) continue;
            if(obj.getPointLeftBottom().x == 4790.0) continue;


            if (obj.isGorisont())
                BodyBuilder.createBox(world, obj.getPointLeftBottom().x + 100 + 20, obj.getPointLeftBottom().y + 450 / 2, (200 / 2) - 20, 450 / 2, true, true); else
                BodyBuilder.createBox(world, obj.getPointLeftBottom().x + 450 / 2 , obj.getPointLeftBottom().y + 100 + 20, 450 / 2, (200 / 2) - 20, true, true);


        }


    }


}
