package com.mygdx.game.Lighting;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MainGaming;

import java.util.ArrayList;

import box2dLight.ConeLight;
import box2dLight.DirectionalLight;
import box2dLight.PointLight;
import box2dLight.RayHandler;

public class B2lights{
    private World world;

    private PointLight pointLightHero;
    private DirectionalLight pointLightHeroDirectiona;
    private ObFromLight object;
    private RayHandler rayHandler;
    private RayHandler rayHandlerHero;

    private OrthographicCamera cameraLl;

    private Box2DDebugRenderer b2dr;

 //   private Box2DDebugRenderer box2DDebugRenderer;
    private ArrayList<PointLight> pointLightsList = new ArrayList<PointLight>();
    public B2lights(MainGaming mg) {

        cameraLl = new OrthographicCamera(100,100);
        this.world = mg.getWorld();
        pointLightsList = new ArrayList<PointLight>();
        this.rayHandler = new RayHandler(this.world);
        this.rayHandlerHero = new RayHandler(this.world);

        pointLightHero = new PointLight(rayHandler, 20, new Color(0.75f, 0.75f, 0.5f, 0.75f), 2000, 0, 0); /// свитильник героя
        pointLightHero.setSoftnessLength(.5f);
////////////

        RayHandler.useDiffuseLight(true);
        //rayHandler.setAmbientLight(.7f);
      //  rayHandler1.useDiffuseLight(true);

  //      rayHandler1.setShadows(false);
        rayHandler.setAmbientLight(.4f);
        rayHandler.setShadows(false);

        rayHandlerHero.setAmbientLight(.2f);
        rayHandlerHero.setShadows(false);




////////////
        this.b2dr = new Box2DDebugRenderer();
        object = new ObFromLight(this.world); // припятсвия
        object.crearBodys(mg.getIndexMap().getTopQualityMap_Box());
////////////////////
        Color colorPoint;
        PointLight pl;
        //pointLightHero = new PointLight(rayHandler, 10, Color.WHITE, 1800, 0, 0); /// свитильник героя

     //   pointLightHero.


        for (int i = 0; i < 5000; i += 1000) {
            for (int j = 0; j < 5000; j += 1000) {
                if (MathUtils.randomBoolean()) colorPoint = Color.CHARTREUSE;
                else if ((MathUtils.randomBoolean())) colorPoint = Color.RED;
                else if ((MathUtils.randomBoolean())) colorPoint = Color.NAVY;
                else colorPoint = Color.BROWN;
                pl = new PointLight(rayHandler, 5, colorPoint, MathUtils.random(1500, 2000), j + MathUtils.random(-200, 200), i + MathUtils.random(-200, 200));
                pl.setIgnoreAttachedBody(true);
                pl.setColor(new Color(pl.getColor().r,pl.getColor().b,pl.getColor().g,.4f));
                pointLightsList.add(pl);

            }
        }


    }
    public void upDateLights(float xHero, float yHero, float align) {
        world.step(1 , 1, 1);
        pointLightHero.setPosition(xHero, yHero);
//        pointLightHero.setXray(true);
//        pointLightHero.setSoft(true);


        for (PointLight p : pointLightsList) {

//            p.setPosition(p.getX() + MathUtils.random(-1, 1), p.getY() + MathUtils.random(-10, 10));
//            p.setPosition(MathUtils.clamp(p.getPosition().x, 0, 5000), MathUtils.clamp(p.getPosition().y, 0, 5000));
        }


    }

    public void renderLights(Camera camera) {
        rayHandlerHero.setCombinedMatrix((OrthographicCamera) camera);
        rayHandlerHero.updateAndRender();

        rayHandler.setCombinedMatrix((OrthographicCamera) camera);
        rayHandler.updateAndRender();

       // pointLightHero.attachToBody();






        //rayHandler.setAmbientLight(.5f);
       // rayHandler.setShadows(false);
//        rayHandler.setLightMapRendering(true);
//       // rayHandler.diffuseBlendFunc.apply();
//        pointLightHero.setIgnoreAttachedBody(true);
//        pointLightHero.setStaticLight(true);


//        pointLightHero.setSoftnessLength(MathUtils.random(1f));
//        pointLightHero.setDistance(MathUtils.random(1500));
//        pointLightHero.setSoftnessLength(MathUtils.random(1f));




      //  cameraLl.view
       // cameraLl.transform(camera.view);
       // b2dr.render(world, camera.combined);
        //box2DDebugRenderer.render(world,camera.combined);
    }
}
