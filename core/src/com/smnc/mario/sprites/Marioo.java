package com.smnc.mario.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.smnc.mario.Mario;
import com.smnc.mario.screens.PlayScreen;

/**
 * Created by smn on 10/12/16.
 */

public class Marioo extends Sprite {

    public World world;
    public Body b2body;
    private TextureRegion marioStand;

    public Marioo(World world, PlayScreen screen) {
        super(screen.getAtlas().findRegion("little_mario"));
        this.world = world;
        defineMario();
        // get texture with coordinates
        marioStand = new TextureRegion(getTexture(), 1, 11, 16, 16);
        // set the bounds of the screen to know how large to render our sprite on the screen
        setBounds(0, 0, 16 / Mario.PPM, 16 / Mario.PPM);
        setRegion(marioStand);
    }

    public void update(float dt){
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
    }

    public void defineMario(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 / Mario.PPM, 32 / Mario.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5 / Mario.PPM);
        fdef.shape = shape;
        b2body.createFixture(fdef);
    }
}
