package h4g2017;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


@SuppressWarnings("serial")
public class WindowTest extends JFrame{

	private String secuencia;
	private boolean fallo1 = false;
	private JTextField textField;
	private JButton btnNewButton;
	TestWisc test;
	Media[] sonidos;


	public WindowTest() {
		test = new TestWisc();
		sonidos = new Media[14];
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		loadSonidos();

		setBounds(100, 100, 450, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);



		textField = new JTextField();
		textField.setBounds(142, 101, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);

		btnNewButton= new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				while(true){

					String bip = "";
					Media hit = new Media(new File(bip).toURI().toString());
					MediaPlayer mediaPlayer = new MediaPlayer(hit);
					mediaPlayer.play();

				}

			}
		});
		btnNewButton.setBounds(274, 100, 97, 25);
		getContentPane().add(btnNewButton);


	}

	private void loadSonidos() {
		try{
			sonidos[0] = new Media(new File("Source/sonidos/3-8-6.wav").toURI().toString());
			sonidos[1] = new Media(new File("Source/sonidos/6-1-2.wav").toURI().toString());
			sonidos[2] = new Media(new File("Source/sonidos/3-4-1-7.wav").toURI().toString());
			sonidos[3] = new Media(new File("Source/sonidos/6-1-5-8.wav").toURI().toString());
			sonidos[4] = new Media(new File("Source/sonidos/8-4-2-3-9.wav").toURI().toString());
			sonidos[5] = new Media(new File("Source/sonidos/5-2-1-8-6.wav").toURI().toString());
			sonidos[6] = new Media(new File("Source/sonidos/3-8-9-1-7-4.wav").toURI().toString());
			sonidos[7] = new Media(new File("Source/sonidos/7-9-6-4-8-3.wav").toURI().toString());
			sonidos[8] = new Media(new File("Source/sonidos/5-1-7-4-2-3-8.wav").toURI().toString());
			sonidos[9] = new Media(new File("Source/sonidos/9-8-5-2-1-6-3.wav").toURI().toString());
			sonidos[10] = new Media(new File("Source/sonidos/1-6-4-5-9-7-6-3.wav").toURI().toString());
			sonidos[11] = new Media(new File("Source/sonidos/2-9-7-6-3-1-5-4.wav").toURI().toString());
			sonidos[12] = new Media(new File("Source/sonidos/5-3-8-7-1-2-4-6-9.wav").toURI().toString());
			sonidos[13] = new Media(new File("Source/sonidos/4-2-6-9-1-7-8-3-5.wav").toURI().toString());
		}catch(Exception e ){
			System.err.println("No found audio");
			e.printStackTrace();
		}



	}

}
