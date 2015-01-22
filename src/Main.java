import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.IOException;

public class Main extends MIDlet {	
	Display display;
	
	public class StartCanvas extends Canvas {
		public void paint(Graphics g) {
			g.setColor(0xC8AC70);
			g.fillRect(0, 0, getWidth(), getHeight());
			try {
				g.drawImage(Image.createImage("/logo.png"), getWidth() / 2, getHeight() / 2, Graphics.VCENTER | Graphics.HCENTER);
			} catch (IOException e) {
				Alert alert = new Alert("Failure", "Can’t open image file.", null, null);
				alert.setTimeout(Alert.FOREVER);
				display.setCurrent(alert);
			}
		}
	};
	
	StartCanvas canvas;

	public Main() {
		display = Display.getDisplay(this);
		canvas = new StartCanvas();
	}

	public void startApp() {
		display.setCurrent(canvas);
		canvas.repaint();
	}

	public void pauseApp() {}

	public void destroyApp(boolean unconditional) {}
}
