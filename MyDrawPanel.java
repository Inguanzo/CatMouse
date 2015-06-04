import java.awt.*; 
import javax.swing.*;

//called automatically by actionPerformed
//creates geometry objects
class MyDrawPanel extends JPanel {
	public void paintComponent(Graphics g) { 
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		
		//creates statue
		g.setColor(Color.blue);
		g.fillOval(300,300,200,200); 


		//updates cat object and moves toward statue
		g.setColor(Color.red);
		if(SimpleGui3C.catRadStep != 1.0) {
			double catRadDoub = 400 + SimpleGui3C.catRadStep * 100;
			int catRadint = (int)catRadDoub;
			g.fillRect(400, catRadint, 20, 20);
			g.setColor(Color.black);
			g.fillRect(400, catRadint, 20, 5);
			
		//if cat is at the statue, creates a triangle and determines direction based
		//on quadrant
		} else {
			double xc = (int) 100.0 * Math.cos(SimpleGui3C.catAngStep) + 400;
			int xxc = (int) xc;
			double yc = 100 * Math.sin(SimpleGui3C.catAngStep) + 400;
			int yyc = (int) yc;
			g.fillRect(yyc, xxc, 20, 20);

			g.setColor(Color.red);
			int pos1 = xxc-10;
			int pos2 = xxc-10;
			int pos3 = yyc-10;
			int pos4 = yyc+10;
			if(xxc < 399 && yyc < 399){
				//System.out.println("0");
				int u[] = {pos1, xxc, pos2};
				int v[] = {pos3, yyc, pos4};
				g.fillPolygon(v,u,3);
			} else if(xxc > 399 && yyc < 350) {
				//System.out.println("1");
				int u[] = {pos1, xxc, pos2};
				int v[] = {pos3, yyc, pos4};
				g.fillPolygon(v,u,3);
			} else if(xxc > 399 && yyc > 351) {
				//System.out.println("2");
				int u[] = {pos1 + 20, xxc, pos2};
				int v[] = {pos3, yyc, pos4 - 20};
				g.fillPolygon(v,u,3);
			} else {
				//System.out.println("3");
				int u[] = {pos1 + 20, xxc, pos2 + 20};
				int v[] = {pos3, yyc, pos4};
				g.fillPolygon(v,u,3);
			}


		}

		//moves mouse around the statue, creates a triangle and determines direction based
		//on quadrant
		double x = (int) 100.0 * Math.cos(SimpleGui3C.mouseAngStep) + 400;
		int xx = (int) x;
		double y = 100.0 * Math.sin(SimpleGui3C.mouseAngStep) + 400;
		int yy = (int) y;	

		g.setColor(Color.orange);
		//System.out.println(yy);			
		//System.out.println(xx + ", " + yy);
		int pos1 = xx-10;
		int pos2 = xx-10;
		int pos3 = yy-10;
		int pos4 = yy+10;
		if(xx < 399 && yy < 399){
			//System.out.println("0");
			int u[] = {pos1, xx, pos2};
			int v[] = {pos3, yy, pos4};
			g.fillPolygon(v,u,3);
		} else if(xx > 399 && yy < 350) {
			//System.out.println("1");
			int u[] = {pos1, xx, pos2};
			int v[] = {pos3, yy, pos4};
			g.fillPolygon(v,u,3);
		} else if(xx > 399 && yy > 349) {
			//System.out.println("2");
			int u[] = {pos1 + 20, xx, pos2};
			int v[] = {pos3, yy, pos4 - 20};
			g.fillPolygon(v,u,3);
		} else {
			//System.out.println("3");
			int u[] = {pos1 + 20, xx, pos2 + 20};
			int v[] = {pos3, yy, pos4};
			g.fillPolygon(v,u,3);
		}
		

	}
}