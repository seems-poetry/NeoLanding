package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private static final int FPS_CAP = 120;
	
	/**
	 * Open the display at the beginning when we start up the game
	 */
	public static void createDisplay(){
		// 3.2 - version of OpenGL
		ContextAttribs attribs = new ContextAttribs(3,2) 
			.withForwardCompatible(true)
			.withProfileCore(true);
				
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT)); // set the size of the display
			Display.create(new PixelFormat(), attribs); // create the display
			Display.setTitle("NeoLanding"); // set the title
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT); // tells OpenGL to use the whole display to render
		
	}
	
	/**
	 * Update the display every single frame
	 */
	public static void updateDisplay(){
		
		Display.sync(FPS_CAP);
		Display.update();
		
	}
	
	public static void closeDisplay(){
		
		Display.destroy();
		
	}

}
