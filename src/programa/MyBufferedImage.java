package programa;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class MyBufferedImage extends BufferedImage {
	
	private byte[] copia;
	private byte[] array_bytes;
	private int altura;
	private int ancho;
	private String focus = "Image";
	
	
	public MyBufferedImage(BufferedImage bi) {
		super(
				bi.getColorModel(), bi.getRaster(), bi.getColorModel().isAlphaPremultiplied(), null
				);
		
		ancho = bi.getWidth();
		altura = bi.getHeight();
		array_bytes = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
	    copia = new byte[array_bytes.length];
	    System.arraycopy(array_bytes, 0, copia, 0, array_bytes.length);
	}

	public void brilloAzul(int brillo) {
		if (brillo > 0) {
			for (int i = 2; i < array_bytes.length; i=i+3) {
				if (Byte.toUnsignedInt(copia[i-2]) < 255) {
					int new_brillo = brillo + Byte.toUnsignedInt(copia[i-2]);
					if (new_brillo > 255) {
						new_brillo = 255;
					}
					array_bytes[i-2] = (byte) new_brillo;
				}
			}
		} else {
			for (int i = 2; i < array_bytes.length; i=i+3) {
				if (Byte.toUnsignedInt(copia[i-2]) > 0) {
					int new_brillo = brillo + Byte.toUnsignedInt(copia[i-2]);
					if (new_brillo < 0) {
						new_brillo = 0;
					}
					array_bytes[i-2] = (byte) new_brillo;
				}
			}
		}
	}

	public void brilloRojo(int brillo) {
		if (brillo > 0) {
			for (int i = 2; i < array_bytes.length; i=i+3) {
				if (Byte.toUnsignedInt(copia[i]) < 255) {
					int new_brillo = brillo + Byte.toUnsignedInt(copia[i]);
					if (new_brillo > 255) {
						new_brillo = 255;
					}
					array_bytes[i] = (byte) new_brillo;
				}
			}
		} else {
			for (int i = 2; i < array_bytes.length; i=i+3) {
				if (Byte.toUnsignedInt(copia[i]) > 0) {
					int new_brillo = brillo + Byte.toUnsignedInt(copia[i]);
					if (new_brillo < 0) {
						new_brillo = 0;
					}
					array_bytes[i] = (byte) new_brillo;
				}
			}
		}
	}

	public void brilloVerde(int brillo) {
		if (brillo > 0) {
			for (int i = 2; i < array_bytes.length; i=i+3) {
				if (Byte.toUnsignedInt(copia[i-1]) < 255) {
					int new_brillo = brillo + Byte.toUnsignedInt(copia[i-1]);
					if (new_brillo > 255) {
						new_brillo = 255;
					}
					array_bytes[i-1] = (byte) new_brillo;
				}
			}
		} else {
			for (int i = 2; i < array_bytes.length; i=i+3) {
				if (Byte.toUnsignedInt(copia[i-1]) > 0) {
					int new_brillo = brillo + Byte.toUnsignedInt(copia[i-1]);
					if (new_brillo < 0) {
						new_brillo = 0;
					}
					array_bytes[i-1] = (byte) new_brillo;
				}
			}
		}
	}

	public void bucleConvolucion(int y, int x, int r, int g, int b, int[][] matriz, int divisor) {
		Color c;
		Color newc;

		for (int f= y-1; f <= y+1; f++) {
			for (int col= x-1; col <= x+1; col++) {
				c = conseguirRgb(f,col);
				r += c.getRed() * matriz[f-(y-1)][col-(x-1)];
				g += c.getGreen() * matriz[f-(y-1)][col-(x-1)];
				b += c.getBlue() * matriz[f-(y-1)][col-(x-1)];
			}

		}

		r = r / divisor;
		g = g / divisor;
		b = b / divisor;
		r = normalizeRGB(r);
		g = normalizeRGB(g);
		b = normalizeRGB(b);
		newc = new Color(r,g,b);
		setPixel(y,x,newc);
	}

	public Color conseguirRgb(int y, int x) {
		int i = (y*ancho*3) + (x*3);
		Color color = new Color(Byte.toUnsignedInt(copia[i+2]), Byte.toUnsignedInt(copia[i+1]), Byte.toUnsignedInt(copia[i]));
		//System.out.println("Red: " + color.getRed() + " | Green: " + color.getGreen() + " | Blue: " + color.getBlue());
		return color;
	}

	public void convolucion(int[][] matriz, int divisor) {
		int r;
		int g;
		int b;

		for (int y = 1; y < altura-1; y++ ) {
			for (int x = 1; x < ancho - 1; x++) {
				r = g = b = 0;
				bucleConvolucion(y,x,r,g,b,matriz,divisor);
			}
		}
	}

	public void cuadrado(int sliderPos) {

		// Variables recuadro
		float imagePercentage;
		int yInicialRecuadro, yFinalRecuadro;
		int xInicialRecuadro, xFinalRecuadro;
		int alturaRecuadro;
		int anchoRecuadro;

		// Calculos recuadro
		imagePercentage = (float) sliderPos /100f;
		alturaRecuadro = (int) (altura * imagePercentage);
		anchoRecuadro = (int) (ancho * imagePercentage);
		yInicialRecuadro = (altura - alturaRecuadro) / 2;
		xInicialRecuadro = (ancho - anchoRecuadro) / 2;
		yFinalRecuadro = yInicialRecuadro + alturaRecuadro;
		xFinalRecuadro = xInicialRecuadro + anchoRecuadro;

		// Control repaint
		int last_pos = 0;
		if (last_pos < sliderPos) {
			this.reset();
		}
		if (sliderPos == 0) {
			this.reset();
		}


		// Bucle recuadro
		for (int y = yInicialRecuadro; y < (yFinalRecuadro-1); y++ ) {
			for (int x = xInicialRecuadro; x < (xFinalRecuadro-1); x++) {
				int i = (((((y)*ancho*3) + (x*3))));

				int media = ((Byte.toUnsignedInt(copia[i]) + (Byte.toUnsignedInt(copia[i+1]) + (Byte.toUnsignedInt(copia[i+2]))))) / 3;

				if (media > 255) {
					media = 255;
				}

				array_bytes[i] = array_bytes[i+1] = array_bytes[i+2] = (byte) media;
			}
		}

		last_pos = sliderPos;
	}

	public void gris() {
		if (focus.equals("Image")) {
			for (int i = 2; i < array_bytes.length; i=i+3) {
				int media = ((Byte.toUnsignedInt(array_bytes[i]) + (Byte.toUnsignedInt(array_bytes[i-1]) + (Byte.toUnsignedInt(array_bytes[i-2]))))) / 3;

				if (media > 255) {
					media = 255;
				}
				array_bytes[i] = array_bytes[i-1] = array_bytes[i-2] = (byte) media;
			}
		} else {
			for (int y = altura / 4; y < (altura * 3) / 4; y++) {
				for (int x = ancho / 4; x < (ancho * 3) / 4; x++) {
					int i = ((y * ancho * 3) + (x * 3));
					int media = ((Byte.toUnsignedInt(array_bytes[i]) + (Byte.toUnsignedInt(array_bytes[i-1]) + (Byte.toUnsignedInt(array_bytes[i-2]))))) / 3;
					if (media > 255) {
						media = 255;
					}
					array_bytes[i] = array_bytes[i-1] = array_bytes[i-2] = (byte) media;
				}
			}
		}

	}

	public int normalizeRGB(int value) {
		if (value > 255) {
			value = 255;
		}
		if (value < 0) {
			value = 0;
		}
		return value;
	}

	public void reset() {
		System.arraycopy(copia, 0, array_bytes, 0, copia.length);
	}

	public void setBrillo(int brillo) {
		if (brillo > 0) {
			for (int i = 2; i < array_bytes.length; i=i+3) {
				if (Byte.toUnsignedInt(copia[i]) < 255) {
					int new_brillo = brillo + Byte.toUnsignedInt(copia[i]);
					if (new_brillo > 255) {
						new_brillo = 255;
					}
					array_bytes[i] = (byte) new_brillo;
				}
				if (Byte.toUnsignedInt(copia[i-1]) < 255) {
					int new_brillo = brillo + Byte.toUnsignedInt(copia[i-1]);
					if (new_brillo > 255) {
						new_brillo = 255;
					}
					array_bytes[i-1] = (byte) new_brillo;
				}
				if (Byte.toUnsignedInt(copia[i-2]) < 255) {
					int new_brillo = brillo + Byte.toUnsignedInt(copia[i-2]);
					if (new_brillo > 255) {
						new_brillo = 255;
					}
					array_bytes[i-2] = (byte) new_brillo;
				}
			}
		} else {
			for (int i = 2; i < array_bytes.length; i=i+3) {
				if (Byte.toUnsignedInt(copia[i]) > 0) {
					int new_brillo = brillo + Byte.toUnsignedInt(copia[i]);
					if (new_brillo < 0) {
						new_brillo = 0;
					}
					array_bytes[i] = (byte) new_brillo;
				}
				if (Byte.toUnsignedInt(copia[i-1]) > 0) {
					int new_brillo = brillo + Byte.toUnsignedInt(copia[i-1]);
					if (new_brillo < 0) {
						new_brillo = 0;
					}
					array_bytes[i-1] = (byte) new_brillo;
				}
				if (Byte.toUnsignedInt(copia[i-2]) > 0) {
					int new_brillo = brillo + Byte.toUnsignedInt(copia[i-2]);
					if (new_brillo < 0) {
						new_brillo = 0;
					}
					array_bytes[i-2] = (byte) new_brillo;
				}
			}
		}

	}

	public void  setPixel(int y, int x, Color color) {
		int i = (y*ancho*3) + (x*3);
		array_bytes[i] = (byte) color.getBlue();
		array_bytes[i+1] = (byte) color.getGreen();
		array_bytes[i+2] = (byte) color.getRed();
	}

}
