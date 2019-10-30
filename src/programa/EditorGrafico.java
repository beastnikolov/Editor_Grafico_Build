package programa;

import java.awt.*;

import javax.swing.JFrame;

public class EditorGrafico extends JFrame {
	private static final long serialVersionUID = 1L;
	private Viewer viewer = new Viewer();
	private ControlPanel controlp = new ControlPanel(viewer);
	
	
	public EditorGrafico() {
		this.pintarEditor();
	}
	
	private void pintarEditor() {
        this.getContentPane().setBackground(Color.black);
		this.setTitle("Editor Gráfico");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(1024,768));
		pintarComponentes();
		this.pack();
		this.setVisible(true);
		
	}
	
	private void pintarComponentes() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 18;
		gbc.insets = new Insets(0,10,0,10);
		this.add(controlp,gbc);
		
		/////
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 18;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(viewer,gbc);
		///////////
	}
	
	

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		EditorGrafico EditorGrafico = new EditorGrafico();

	}

}
