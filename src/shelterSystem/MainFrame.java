package shelterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textAnimalName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTextArea textInfo = new JTextArea();
		textInfo.setBounds(27, 171, 377, 63);
		contentPane.add(textInfo);
		
		textAnimalName = new JTextField();
		textAnimalName.setBounds(237, 28, 103, 21);
		contentPane.add(textAnimalName);
		textAnimalName.setColumns(10);
		
		final AnimalQueue animalQueue = new AnimalQueue();
		
		JButton btnEnqueueCat = new JButton("Enqueue Cat");
		btnEnqueueCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cat cat = new Cat(textAnimalName.getText());
				animalQueue.enqueue(cat);
				textInfo.setText(textAnimalName.getText()+" has been put into the shelter, waiting for adopting!");
			}
		});
		btnEnqueueCat.setBounds(83, 73, 119, 31);
		contentPane.add(btnEnqueueCat);
		
		JButton btnNewButton = new JButton("EnqueueDog");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dog dog = new Dog(textAnimalName.getText());
				animalQueue.enqueue(dog);
				textInfo.setText(textAnimalName.getText()+" has been put into the shelter, waiting for adopting!");
			}
		});
		btnNewButton.setBounds(212, 73, 128, 31);
		contentPane.add(btnNewButton);
		
		JButton btnDequeueCat = new JButton("Dequeue Cat");
		btnDequeueCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cat cat = animalQueue.dequeueCats();
				textInfo.setText(cat.name+" has been adopted.");
			}
		});
		btnDequeueCat.setBounds(27, 114, 119, 31);
		contentPane.add(btnDequeueCat);
		
		JButton btnDequeueAny = new JButton("Dequeue Any");
		btnDequeueAny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Animal any = animalQueue.dequeueAny();
				textInfo.setText(any.name+" has been adopted.");
			}
		});
		btnDequeueAny.setBounds(156, 114, 119, 31);
		contentPane.add(btnDequeueAny);
		
		JButton btnDequeueDog = new JButton("Dequeue Dog");
		btnDequeueDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dog dog = animalQueue.dequeueDogs();
				textInfo.setText(dog.name+" has been adopted.");
			}
		});
		btnDequeueDog.setBounds(285, 114, 119, 31);
		contentPane.add(btnDequeueDog);
		
		JLabel lblName = new JLabel("Input Animal's Name:");
		lblName.setBounds(83, 31, 128, 15);
		contentPane.add(lblName);
		
		
	}
}
