package com.shardbytes.gdx.youtubetutorial

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Cameras : Game() {
	
	lateinit var batch: SpriteBatch
	
	override fun create() {
		batch = SpriteBatch()
	}
	
	override fun render() {
		Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
		
		
	}
	
	override fun dispose() {
		batch.dispose()
	}
}
