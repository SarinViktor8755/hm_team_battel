package com.mygdx.game.Lighting;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MainGaming;

import java.util.ArrayList;

import box2dLight.ConeLight;
import box2dLight.DirectionalLight;
import box2dLight.PointLight;
import box2dLight.RayHandler;

public class B2lights {
    private World world;

    private PointLight pointLightHero;
    //  private DirectionalLight pointLightHeroDirectiona;
    private ObFromLight object;
    //  private RayHandler rayHandler;
    private RayHandler rayHandlerHero;

    private ArrayList<PointLight> pointLightsList = new ArrayList<PointLight>();

    public B2lights(MainGaming mg) {
        this.world = mg.getWorld();
        pointLightsList = new ArrayList<PointLight>();
        RayHandler.useDiffuseLight(true);
        this.rayHandlerHero = new RayHandler(this.world);
        // pointLightHero = new PointLight(rayHandlerHero, 75, new Color(0.75f, 0.75f, 0.5f, 1.575f), 2000, 0, 0); /// свитильник героя

////////////
        // this.b2dr = new Box2DDebugRenderer();
        object = new ObFromLight(this.world); // припятсвия
        object.crearBodys(mg.getIndexMap().getTopQualityMap_Box());
////////////////////
        //  Color colorPoint;
        PointLight pl;





        for (int i = 0; i < 5000; i += 1000) {
            for (int j = 0; j < 5000; j += 1000) {
/////////////
                pl = new PointLight(rayHandlerHero, 4, getColorFromPoint(), 1300, j , i );
                pl.setIgnoreAttachedBody(false);
                pointLightsList.add(pl);
/////////////
            }
        }
//////////////////////////////////////////////////////////////////////////////////////////


//        for (Body obj : object.getBodyList()) {
//            pl = new PointLight(rayHandlerHero, 5, getColorFromPoint(), 500, obj.getPosition().x + 600, obj.getPosition().y + 600);
//            System.out.println(pl.toString());
//            pointLightsList.add(pl);
//        }


        pointLightHero = new PointLight(rayHandlerHero, 25, Color.WHITE, 1800, 0, 0); /// свитильник героя
        ////////////////////////
        rayHandlerHero.setAmbientLight(1);
        rayHandlerHero.setBlur(true);
      //  pointLightHero.setIgnoreAttachedBody(true);

        System.out.println("-------");
        System.out.println( object.getBodyList().size());
        for (Body cars : object.getBodyList()) {
            pl = new PointLight(rayHandlerHero, 5, getColorFromPoint(), 700, cars.getPosition().x, cars.getPosition().y);
            pointLightsList.add(pl);
            //  pl = new PointLight(rayHandlerHero, 15, getColorFromPoint(), 1600, j , i );
            //            pointLightsList.add(pl);
        }
    }


    Color getColorFromPoint() {
        Color colorPoint;
        if (MathUtils.randomBoolean(.3f)) colorPoint = Color.CHARTREUSE;
        else if ((MathUtils.randomBoolean(.3f))) colorPoint = Color.RED;
        else if ((MathUtils.randomBoolean(.3f))) colorPoint = Color.NAVY;
        else colorPoint = Color.BROWN;
        return colorPoint;
    }


    public void upDateLights(float xHero, float yHero, float align) {
        world.step(1 / 60f, 1, 1);
        pointLightHero.setPosition(xHero, yHero);

    }

    public void renderLights(Camera camera) {
        rayHandlerHero.setCombinedMatrix((OrthographicCamera) camera);
        rayHandlerHero.updateAndRender();

//
//        rayHandler.setCombinedMatrix((OrthographicCamera) camera);
//        rayHandler.updateAndRender();
////         pointLightHero.attachToBody();
//        rayHandler.setAmbientLight(.5f);
//         rayHandler.setShadows(false);
//        rayHandler.setLightMapRendering(true);
        // rayHandler.diffuseBlendFunc.apply();
//        pointLightHero.setIgnoreAttachedBody(true);
//        pointLightHero.setStaticLight(true);
//        pointLightHero.setSoftnessLength(MathUtils.random(1f));
//        pointLightHero.setDistance(MathUtils.random(1500));
//        pointLightHero.setSoftnessLength(MathUtils.random(1f));
//          cameraLl.view
//         cameraLl.transform(camera.view);
//         b2dr.render(world, camera.combined);
//        box2DDebugRenderer.render(world,camera.combined);
    }


    public boolean isAtShadow(float x, float y) {
//    System.out.println(rayHandlerHero.pointAtShadow(x, y));
        return rayHandlerHero.pointAtShadow(x, y);
    }

    public Texture getTexture() {
        return rayHandlerHero.getLightMapTexture();
    }
}
