package programa;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel extends JPanel{
	private Viewer viewer;
	private JLabel label;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//MyBufferedImage Buff = new MyBufferedImage();

	public ControlPanel(Viewer viewer) {
		this.setBackground(Color.black);
		this.viewer = viewer;
		pintar();
	}
	
	private void pintar() {
		JButton button;
		JToggleButton jtoggle;
		GridBagConstraints gbc = new GridBagConstraints();
		JTextField textfield1;
		JTextField textfield2;
		JTextField textfield3;
		JTextField divisor;

		this.setLayout(new GridBagLayout());
		
		button = new JButton("Next Image");
		// Estilos
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		button.setFocusPainted(false);
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10,10,0,0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		this.add(button,gbc);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewer.newImage();
			}
			
		}); 
		
		button = new JButton("Grayscale");
		// Estilos
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		button.setFocusPainted(false);
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		this.add(button,gbc);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				viewer.aGris();
			}
			
		});
		
		
		label = new JLabel("Brightness");
		label.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		label.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		this.add(label,gbc);
		
		JSlider sliderBrightness = new JSlider(JSlider.HORIZONTAL, -155, 155, 0);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		this.add(sliderBrightness,gbc);
		sliderBrightness.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				viewer.Brillo(sliderBrightness.getValue());

			}
			
		});
		
		 label = new JLabel("Red");
		 label.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		 gbc.gridx = 0;
		 gbc.gridy = 5;
		 gbc.gridwidth = 2;
		 label.setForeground(Color.red);
		 this.add(label,gbc);
		 
		 JSlider sliderRedBrightness = new JSlider(JSlider.HORIZONTAL, -155, 155, 0);
		 
		 
		 gbc.gridx = 0;
		 gbc.gridy = 6;
		 gbc.gridwidth = 2;
		 sliderRedBrightness.setBackground(Color.red);
		 this.add(sliderRedBrightness,gbc);
		 
		 sliderRedBrightness.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				viewer.brilloRojo(sliderRedBrightness.getValue());
			}
			 
		 });
		 
		 label = new JLabel("Green");
		 label.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		 gbc.gridx = 0;
		 gbc.gridy = 7;
		 gbc.gridwidth = 2;
		 label.setForeground(Color.green);
		 this.add(label,gbc);
		 
		 JSlider sliderGreenBrightness = new JSlider(JSlider.HORIZONTAL, -155, 155, 0);
		 
		 
		 gbc.gridx = 0;
		 gbc.gridy = 8;
		 gbc.gridwidth = 2;
		 sliderGreenBrightness.setBackground(Color.green);
		 this.add(sliderGreenBrightness,gbc);
		 
		 sliderGreenBrightness.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				viewer.brilloVerde(sliderGreenBrightness.getValue());
			}
			 
		 });
		 
		 label = new JLabel("Blue");
		 label.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		 gbc.gridx = 0;
		 gbc.gridy = 9;
		 gbc.gridwidth = 2;
		 label.setForeground(Color.blue);
		 this.add(label,gbc);
		 
		 JSlider sliderBlueBrightness = new JSlider(JSlider.HORIZONTAL, -155, 155, 0);
		 
		 
		 gbc.gridx = 0;
		 gbc.gridy = 10;
		 gbc.gridwidth = 2;
		 sliderBlueBrightness.setBackground(Color.blue);
		 this.add(sliderBlueBrightness,gbc);
		 
		 sliderBlueBrightness.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				viewer.brilloAzul(sliderBlueBrightness.getValue());
			}
			 
		 });
		 
		 label = new JLabel("Cuadrado");
		 label.setForeground(Color.white);
		 label.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		 gbc.gridx = 0;
		 gbc.gridy = 11;
		 gbc.gridwidth = 2;
		 this.add(label,gbc);
		 
		 JSlider sliderCuadrado = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		 
		 
		 gbc.gridx = 0;
		 gbc.gridy = 12;
		 gbc.gridwidth = 2;
		 sliderCuadrado.setBackground(Color.gray);
		 this.add(sliderCuadrado,gbc);
		 
		 sliderCuadrado.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				viewer.cuadrado(sliderCuadrado.getValue());
			}
			 
		 });

		 label = new JLabel("Matriz de convolucion (Separalo con espacios)");
		 label.setForeground(Color.white);
		 label.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		 gbc.gridx = 0;
		 gbc.gridy = 13;
		 gbc.gridwidth = 2;
		 this.add(label,gbc);


		 textfield1 = new JTextField(10);
		 textfield1.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		 textfield1.setBackground(Color.black);
		 textfield1.setForeground(Color.white);
		 textfield1.setHorizontalAlignment(JTextField.CENTER);
		 gbc.gridx = 0;
		 gbc.gridy = 14;
		 gbc.gridwidth = 2;
		 this.add(textfield1,gbc);

		textfield2 = new JTextField(10);
		textfield2.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		textfield2.setBackground(Color.black);
		textfield2.setForeground(Color.white);
		textfield2.setHorizontalAlignment(JTextField.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.gridwidth = 2;
		this.add(textfield2,gbc);

		textfield3 = new JTextField(10);
		textfield3.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		textfield3.setBackground(Color.black);
		textfield3.setForeground(Color.white);
		textfield3.setHorizontalAlignment(JTextField.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 16;
		gbc.gridwidth = 2;
		this.add(textfield3,gbc);

		label = new JLabel("Divisor de brillo:");
        label.setForeground(Color.white);
        label.setFont(new Font("MS Gothic", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 17;
        gbc.gridwidth = 1;
        this.add(label,gbc);


        divisor = new JTextField(5);
        divisor.setFont(new Font("MS Gothic", Font.PLAIN, 14));
        divisor.setBackground(Color.black);
        divisor.setForeground(Color.white);
        divisor.setHorizontalAlignment(JTextField.CENTER);
        divisor.setText("1");
        gbc.gridx = 1;
        gbc.gridy = 17;
        gbc.gridwidth = 1;
        this.add(divisor,gbc);





		 button = new JButton("Aplicar convolucion");
		// Estilos
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		button.setFocusPainted(false);
		 gbc.gridx = 0;
		 gbc.gridy = 18;
		 gbc.gridwidth = 2;
		 this.add(button,gbc);

		 button.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
			     if (!(textfield1.getText().isEmpty() || textfield2.getText().isEmpty() || textfield3.getText().isEmpty())) {
                     String stringMatriz = textfield1.getText().trim() + " " + textfield2.getText().trim() + " " +  textfield3.getText().trim();
                     String[] ArrayString = stringMatriz.split(" ");
                     if (ArrayString.length < 9) {
                         System.out.println("The information is incorrect, try again.");

                     } else {
                        int[][] matriz = transformarMatriz(ArrayString);
                         viewer.convolucion(matriz, Integer.parseInt(divisor.getText().trim()));
                     }

                 } else {
			         System.out.println("Fields are empty!");
                 }


			 }
		 });




		button = new JButton("Reset");
		// Estilos
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		button.setFocusPainted(false);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		this.add(button,gbc);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			    textfield1.setText("");
			    textfield2.setText("");
			    textfield3.setText("");
			    divisor.setText("1");
				sliderBrightness.setValue(0);
				sliderRedBrightness.setValue(0);
				sliderGreenBrightness.setValue(0);
				sliderBlueBrightness.setValue(0	);
				sliderCuadrado.setValue(0);
				viewer.reset();
			}

		});


	}


	public int[][] transformarMatriz(String[] array_string) {
	    int[][] matrizConvolucion = new int[3][3];

	    int contador = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrizConvolucion[i][j] = Integer.parseInt(array_string[contador]);
                System.out.println("Num :"  + contador + " = " +  matrizConvolucion[i][j]  );
                contador++;
            }
         }
	    return matrizConvolucion;
    }


}
