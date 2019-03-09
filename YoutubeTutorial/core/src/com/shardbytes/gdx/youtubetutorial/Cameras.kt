package com.shardbytes.gdx.youtubetutorial

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Gdx.*
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Cameras : Game() {
	
	lateinit var batch: SpriteBatch
	lateinit var world: Sprite
	lateinit var cam: OrthographicCamera
	lateinit var player: Sprite
	
	val VIEWP_WIDTH: Float = 500f
	
	override fun create() {

		batch = SpriteBatch()
		world = Sprite(Texture("world.png"))
		
		player = Sprite(Texture("badlogic.jpg"))
		player.setOriginCenter()
		player.setScale(0.2f)
		
		cam = OrthographicCamera()
		cam.position.set(world.width/2f, world.height/2f, 0f)
	}
	
	override fun render() {
		Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
		
		if (input.isKeyPressed(Input.Keys.DOWN))
			cam.translate(0f, -1f)
		if (input.isKeyPressed(Input.Keys.UP))
			cam.translate(0f, 1f)
		if (input.isKeyPressed(Input.Keys.RIGHT))
			cam.translate(1f, 0f)
		if (input.isKeyPressed(Input.Keys.LEFT))
			cam.translate(-1f, 0f)
		
		cam.update()
		player.setOriginBasedPosition(cam.position.x, cam.position.y)
		
		batch.begin()
		batch.projectionMatrix = cam.combined
		world.draw(batch)
		player.draw(batch)
		batch.end()
	}
	
	override fun dispose() {
		batch.dispose()
		world.texture.dispose()
	}
	
	override fun resize(width: Int, height: Int) {
		cam.viewportWidth = VIEWP_WIDTH
		cam.viewportHeight = VIEWP_WIDTH * height/width
	}
}
