package h4g2017;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class ImageManager {


	Image[] char_d;
	Image[] char_p;
	Image[] row_number;
	
	Random r;

	private static final int NUM_IMAGES = 9;

	public ImageManager(){

		r = new Random();
		
		row_number = new Image[14];
		
		char_d = new Image[NUM_IMAGES]; //almacena todas las imagenees d
		char_p = new Image[NUM_IMAGES];


		for (int i = 0; i < NUM_IMAGES; i++) {
			try{
				
				char_d[i] = ImageIO.read(new File("Source/d/d"+Integer.toString(i)+".png"));
				char_p[i] = ImageIO.read(new File("Source/p/p"+Integer.toString(i)+".png"));
				
			}catch(IOException e){
				System.err.println("file not found");
			}
		}
		
		for (int i = 0; i < row_number.length; i++) {
			try{
				row_number[i] = ImageIO.read(new File("Source/numeros/"+Integer.toString(i+1)+".png"));
			}catch(IOException e){
				System.err.println("file not found");
			}
			
		}

	}
	
	public Tuple getRandomImageAndCode(){
		
		int rand = r.nextInt(NUM_IMAGES);
		
		if(r.nextBoolean())
			return new Tuple(rand,char_d[rand],'d');
		else
			return new Tuple(rand,char_p[rand],'p');
	}

	
	public Tuple getImageWithNumber(int i) {
		return new Tuple(i, row_number[i],'n');
	}
}

class Tuple{
	
	public int id_code;
	Image image;
	public char letra;
	
	public Tuple(int id, Image img, char l){
		id_code = id;
		image = img;
		letra = l;
	}
}
