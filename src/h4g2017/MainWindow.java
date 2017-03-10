package h4g2017;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame
{
	Cell[][] matrix; 
	int rows,cols;
	ImageManager manager;
	private static int DELAY = 5*1000;
	int edad;

	public MainWindow()
	{

		rows = 14;
		cols = 47;

		matrix = new Cell[rows][cols];
		manager = new ImageManager();

		boolean correcta = false;
		do{
			String s = JOptionPane.showInputDialog("Inserta edad (de 6 a 11 años):");
			try{
				edad = Integer.parseInt(s);
				if(edad>=6 || edad<=11){
					correcta = true;
				}
			}catch (Exception e) {}
			
		}while(!correcta);
		
		setWindowDetails();

		GridLayout g = new GridLayout(rows, cols);
		g.setVgap(3);
		JPanel p = new JPanel(g);




		Cell c;
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){

				c = new Cell(i,j, manager.getRandomImageAndCode());
				matrix[i][j] = c;
				if(j!=0){
					p.add(c);
				}else{
					p.add(new Cell(i,j,manager.getImageWithNumber(i)));
				}
			}
		}

		this.add(p);
		//System.out.println("Width-"+getWidth()+"Height"+getHeight());
		avaliableRow(0);
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int j = 0; j < matrix.length; j++) {
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						System.err.println("Hilo interrumplido");
					}
					invalidateRow(j);
				}
				//Insertar final test
				calcularResultado();

			}

		});

		t.start();

	}

	private void calcularResultado() {
		int omisiones=0;
		int comisiones=0;
		int total_respuestas=0;
		int total_aciertos=0;
		int total_preguntas=0;
		int total_fallos = 0;
		int efectividad = 0;
		int tasa_concentracion = 0;
		


		Cell c;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				total_preguntas++;
				c = matrix[i][j];
				if(c.choosen){
					total_respuestas++;
					if(!c.debeEstarMarcado)
						comisiones++;;

				}else{
					if(c.debeEstarMarcado)
						omisiones++;
				}
			}
		}
		total_fallos = comisiones + omisiones;
		total_aciertos = total_preguntas - total_fallos;
		
		



	}

	private void invalidateRow(int i) {

		for (int j = 0; j < cols; j++) {
			matrix[i][j].customHide();
			try{ 
				avaliableRow(i+1);
			}catch(Exception e){

			}
		}
	}

	private void avaliableRow(int i){

		for (int j = 0; j < cols; j++) {
			matrix[i][j].makeAvaliable();;
		}
	}


	private void setWindowDetails() {

		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

	}
}