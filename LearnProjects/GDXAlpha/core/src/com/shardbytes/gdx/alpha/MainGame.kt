package com.shardbytes.gdx.alpha

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx.*
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector3

class MainGame : Game() {
	
	lateinit var cam: OrthographicCamera
	lateinit var batch: SpriteBatch
	
	lateinit var faggot: Sprite
	
	override fun create() {
		
		batch = SpriteBatch()
		faggot = Sprite(Texture("badlogic.jpg"))
		faggot.setPosition(0f, 0f)
		
		cam = OrthographicCamera(1000f, 1000f * graphics.height / graphics.width)
		cam.position.set(200f, 0f,0f)
		cam.update()
	}
	
	override fun render() {
		val dt = graphics.deltaTime
		handleInput(dt)
		
		cam.update()
		batch.projectionMatrix = cam.combined
		
		gl.glClearColor(0f, 0f, 0f, 1f)
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
		
		batch.begin()
		faggot.draw(batch)
		batch.end()
	}
	
	private fun handleInput(dt: Float) {
		val dpos = 100f*dt
		val dzoom = dt
		
		fun handleKeyToCamPos(keyCode: Int, positionDifference: Vector3) {
			if (input.isKeyPressed(keyCode)) cam.position.add(positionDifference)
		}
		
		handleKeyToCamPos(Input.Keys.UP, Vector3(0f, dpos, 0f))
		handleKeyToCamPos(Input.Keys.DOWN, Vector3(0f, -dpos, 0f))
		handleKeyToCamPos(Input.Keys.LEFT, Vector3(-dpos, 0f, 0f))
		handleKeyToCamPos(Input.Keys.RIGHT, Vector3(dpos, 0f, 0f))
		
		if (input.isKeyPressed(Input.Keys.SPACE))
			cam.zoom += dzoom
		
		if (input.isKeyPressed(Input.Keys.SHIFT_LEFT))
			if (cam.zoom - dzoom > 0.3) cam.zoom -= dzoom else cam.zoom = 0.3f
	}
	
	override fun dispose() {
		batch.dispose()
	}
	
	override fun resize(width: Int, height: Int) {
		cam.viewportWidth = 1000f
		cam.viewportHeight = 1000f * height / width
		cam.update()
	}
}
