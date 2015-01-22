/*
Copyright© 2015 Mike Gurin.

	This file is part of freebitva.

	freebitva is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License version 3 as
	published by the Free Software Foundation.

	freebitva is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with freebitva.  If not, see <http://www.gnu.org/licenses/>.
*/

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
