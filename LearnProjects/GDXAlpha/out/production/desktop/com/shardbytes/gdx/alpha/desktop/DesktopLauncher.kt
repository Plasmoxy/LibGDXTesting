package com.shardbytes.gdx.alpha.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.shardbytes.gdx.alpha.MainGame

object DesktopLauncher {
	@JvmStatic
	fun main(arg: Array<String>) {
		val config = LwjglApplicationConfiguration()
		LwjglApplication(MainGame(), config)
	}
}
