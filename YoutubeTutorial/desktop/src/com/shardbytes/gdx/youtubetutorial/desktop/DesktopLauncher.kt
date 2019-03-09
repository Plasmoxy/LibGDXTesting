package com.shardbytes.gdx.youtubetutorial.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.shardbytes.gdx.youtubetutorial.Cameras

object DesktopLauncher {
	@JvmStatic
	fun main(arg: Array<String>) {
		val config = LwjglApplicationConfiguration()
		
		
		
		LwjglApplication(Cameras(), config)
	}
}
