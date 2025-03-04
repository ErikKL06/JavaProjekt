import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Motorn i spelet
 * Betrakta detta som en svart låda.
 * 
 * @author Henrik Bygren
 * @since 2016-05-10
 * @see GameUpdate
 */
public class GameCanvas extends Canvas implements KeyListener{
	static final long serialVersionUID = 1L;

	private BufferStrategy backBuffer; 	

	private Image shipGreen;
	private Image shipGrey;
	private Image bg;

	private Dimension dimension = new Dimension(1024, 720);
	private GameUpdate gm;

	private boolean gameLoop = true;
	
	private HashMap<Integer,Boolean> keyDownMap = new HashMap<Integer, Boolean>();

	public  GameCanvas(){
		this.gm = new GameUpdate();
		createWindow();
		addKeyListener(this);
		this.createBufferStrategy(2);				
		backBuffer = this.getBufferStrategy();	

		shipGreen = new ImageIcon(getClass().getResource("/shipGreen.png")).getImage();
		shipGrey = new ImageIcon(getClass().getResource("/shipGrey.png")).getImage();
		bg = new ImageIcon(getClass().getResource("/bg.png")).getImage();

		gameLoop();
	}

	public void createWindow(){
		JFrame window = new JFrame("Air Strike"); 

		setPreferredSize(dimension); 

		window.add(this);			
		window.pack();	
		window.setResizable(false);
		window.setVisible(true); 
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.requestFocus();
	}

	public void gameLoop(){
		while(gameLoop){
			update();
			render();
			try{ Thread.sleep(20);}catch(Exception e){};
		}

	}
	
	public void update(){
		if(keyDownMap.containsKey(KeyEvent.VK_LEFT))
			gm.leftKey();
		GameUpdate.game();
		if(keyDownMap.containsKey(KeyEvent.VK_RIGHT))
			gm.rightKey();
		GameUpdate.game();
		if(keyDownMap.containsKey(KeyEvent.VK_UP))
			gm.upKey();
		GameUpdate.game();
		if(keyDownMap.containsKey(KeyEvent.VK_DOWN))
			gm.downKey();
		GameUpdate.game();
		if(keyDownMap.containsKey(KeyEvent.VK_S))
			gm.sKey();
		GameUpdate.game();
		if(keyDownMap.containsKey(KeyEvent.VK_W))
			gm.wKey();
		GameUpdate.game();
		if(keyDownMap.containsKey(KeyEvent.VK_A))
			gm.aKey();
		GameUpdate.game();
		if(keyDownMap.containsKey(KeyEvent.VK_D))
			gm.dKey();
		GameUpdate.game();
		if(keyDownMap.containsKey(KeyEvent.VK_SPACE)){

		}
		
		if(keyDownMap.containsKey(KeyEvent.VK_SPACE)){

		}
		if(keyDownMap.containsKey(KeyEvent.VK_Q)){

		}
		
		if(keyDownMap.containsKey(KeyEvent.VK_ESCAPE)){
			gameLoop = false;
			System.exit(0);
		}
	}
	
	public void render(){
		Graphics2D g = (Graphics2D) backBuffer.getDrawGraphics();		
		
		g.drawImage(bg, 0, 0,dimension.width,dimension.height, null);
		
		g.drawImage(shipGrey, gm.greyX, gm.greyY, null);
		g.drawImage(shipGreen, gm.greenX, gm.greenY, null);				

		g.dispose();
		backBuffer.show();
	}

	public void keyPressed(KeyEvent e) {
		keyDownMap.put(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		keyDownMap.remove(e.getKeyCode());
	}

	public void keyTyped(KeyEvent e) {}
	
	public static void main(String[] args){
		new GameCanvas();
	}
}
