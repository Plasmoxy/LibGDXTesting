package com.shardbytes.gdx.alpha.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.shardbytes.gdx.alpha.MainGame

object DesktopLauncher {
	@JvmStatic
	fun main(arg: Array<String>) {
		val config = LwjglApplicationConfiguration()
		config.title = "GDXAlpha"
		config.width = 1000
		config.height = 700
		LwjglApplication(MainGame(), config)
	}
}
