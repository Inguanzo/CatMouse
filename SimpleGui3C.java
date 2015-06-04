import javax.swing.*;
import java.awt.*; import java.awt.event.*;

//SimpleGui3C class creates the gui
public class SimpleGui3C implements ActionListener { 
	public static double catRadStep = CatMouseSimulation.getCatRadius();
	public static double catAngStep = CatMouseSimulation.getCatAngle();
	public static double mouseAngStep = CatMouseSimulation.getMouseAngle();

	int stepVar = 1; //time variable
	JFrame frame;
	JPanel panel = new JPanel();
	JButton resetButton = new JButton("reset"); 
	JButton stepButton = new JButton("step"); 
	JButton runButton = new JButton("run"); 
	JButton quitButton = new JButton("quit"); 
	int newTime = stepVar - 1;
	JLabel label = new JLabel("Time: " + newTime);

	//creates frames/panels for screen
	public void go() {
		frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resetButton.addActionListener(this);
		stepButton.addActionListener(this);
		runButton.addActionListener(this);
		quitButton.addActionListener(this);
		MyDrawPanel drawPanel = new MyDrawPanel();
		panel.add(resetButton);
		panel.add(stepButton);
		panel.add(runButton);
		panel.add(quitButton);
		panel.add(label);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel); 
		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		frame.setSize(800,800);
		frame.setVisible(true);
	}
	
	//responds to buttons pressed by user
	//@event is the source for the button pressed
	public void actionPerformed(ActionEvent event) { 
		newTime = stepVar;
		label.setText("Time: " + newTime);
		
		//updates cat radius/angle and mouse angle based on the selected button
		if(event.getSource() == resetButton){
			stepVar = 0;
			catRadStep = CatMouseSimulation.qe.get(stepVar);
			mouseAngStep = CatMouseSimulation.qeMouse.get(stepVar);
			frame.repaint(); //means paintComponent called on every widget
			stepVar++;

		//utilizes the cat and mouse queues that hold all the cat/mouse positions per time
		//gets the angle/position based on the timeStep called stepVar which is the position in the queue
		} else if(event.getSource() == stepButton){
			if(stepVar < CatMouseSimulation.qe.size()){
				catRadStep = CatMouseSimulation.qe.get(stepVar);
			}
			if(stepVar < CatMouseSimulation.qeMouse.size()){
				mouseAngStep = CatMouseSimulation.qeMouse.get(stepVar);
			}
			if(stepVar < CatMouseSimulation.qeCatAng.size()){
				catAngStep = CatMouseSimulation.qeCatAng.get(stepVar);
				stepVar++;
			}
			frame.repaint();
		//gets the last item in cat/mouse angle/radius queues and places the cat/mouse at these positions
		} else if(event.getSource() == runButton){
			catRadStep = CatMouseSimulation.qe.getLast();
			mouseAngStep = CatMouseSimulation.qeMouse.getLast();
			catAngStep = CatMouseSimulation.qeCatAng.getLast();
			frame.repaint();
		} else if(event.getSource() == quitButton){
			System.exit(0);
		}

		//updates time label
		if(CatMouseSimulation.statusVar.equals("eaten  ")) {
			newTime = stepVar - 1;
			label.setText("Time: " + newTime);
			if(event.getSource() == runButton){
				label.setText("Time: " + CatMouseSimulation.time);
			}
		}
	} 
}