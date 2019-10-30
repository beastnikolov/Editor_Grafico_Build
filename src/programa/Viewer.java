package programa;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Viewer extends Canvas {
	private static final long serialVersionUID = 1L;
	private String path = "C:\\Users\\Alumnat\\Downloads\\imagen4.jpg";
	private String[] pathlist = {"C:\\Users\\Alumnat\\Downloads\\imagen1.jpg","C:\\Users\\Alumnat\\Downloads\\imagen2.jpg","C:\\Users\\Alumnat\\Downloads\\imagen3.jpg","C:\\Users\\Alumnat\\Downloads\\imagen4.jpg"};
	private BufferedImage stock_bi;
	private BufferedImage image_bi;
	private MyBufferedImage image;
	@SuppressWarnings("unused")
	private MyBufferedImage stock;
	private int contadorArray = 0;
	
	public Viewer() {
		try {
			image_bi = ImageIO.read(new File(path));
			stock_bi = ImageIO.read(new File(path));
			image = new MyBufferedImage(stock_bi);
			stock = new MyBufferedImage(image_bi);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	public void myPaint() {
		Graphics g = this.getGraphics();
		g.drawImage(image_bi, 0, 0, this.getWidth(), this.getHeight()/2, null);
		g.drawImage(stock_bi,0, this.getHeight()/2, this.getWidth(), this.getHeight()/2, null);
	}
	
	@Override
	public void paint(Graphics g) {
		this.myPaint();
	}
	
	public void newImage() {
            String newpath = pathlist[contadorArray];
            contadorArray++;
            if (contadorArray == pathlist.length) {
                contadorArray = 0;
            }
            try {
                image_bi = ImageIO.read(new File(newpath));
                stock_bi = ImageIO.read(new File(newpath));
                image = new MyBufferedImage(stock_bi);
                stock = new MyBufferedImage(image_bi);
            } catch (IOException e) {
                e.printStackTrace();
            }
		this.myPaint();
		
	}
	
	public void aGris() {
		this.image.gris();
		this.myPaint();
	}
	
	public void reset() {
		this.image.reset();
		this.myPaint();
	}
	
	public void Brillo(int pos) {
		this.image.setBrillo(pos);
		this.myPaint();
	}
	
	public void brilloRojo(int pos) {
		this.image.brilloRojo(pos);
		this.myPaint();
	}
	
	public void brilloVerde(int pos) {
		this.image.brilloVerde(pos);
		this.myPaint();
	}
	
	public void brilloAzul(int pos) {
		this.image.brilloAzul(pos);
		this.myPaint();
	}
	
	public void cuadrado(int pos) {
		this.image.cuadrado(pos);
		this.myPaint();
	}

	public void convolucion(int[][] matriz, int divisor) {
		this.image.convolucion(matriz, divisor);
		this.myPaint();
	}

}
