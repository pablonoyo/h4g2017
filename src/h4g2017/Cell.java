package h4g2017;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Cell extends JPanel{

	int i,j;
	Tuple tuple;
	boolean choosen;
	boolean invalidate;
	boolean avaliable;

	MouseListener ms;
	public Color invalidate_color;
	public boolean debeEstarMarcado;


	public Cell(int i, int j, Tuple t){
		this.i = i; 
		this.j = j;
		tuple = t;
		choosen = false;
		avaliable = false;
		
		if(t.letra=='d' && (t.id_code==1 || t.id_code==6 || t.id_code == 8)){
			debeEstarMarcado = true;
			System.out.printf("Debe->(%d,%d)\n",i,j);
		}
		
		invalidate_color = new Color(63, 0, 191);
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(avaliable && !invalidate){
					choosen = !choosen;
					repaint();
				}
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g){

		g.drawImage(tuple.image, 0, 0,getWidth(),getHeight(),null);
		if(choosen){
			g.setColor(Color.RED);
			g.drawLine(0,getHeight(),getWidth(), 0);
		}
		if(invalidate){
			g.setColor(invalidate_color);
			g.fillRect(0, (getHeight()/2)-1, getWidth(), 2);
		}

	}
	public void makeAvaliable(){
		avaliable = true;
		repaint();
		
	}

	public void customHide() {
		invalidate = true;
		repaint();

	}
}
