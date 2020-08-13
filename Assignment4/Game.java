import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame
{
	Model model;
	View view;
	Controller controller;
	
	public Game()
	{
		model = new Model();
		controller = new Controller(model);
		view = new View(controller, model);
		this.setTitle("Mario: Step 2");
		this.setSize(900, 738);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(controller);
	}

	public static void main(String[] args)
	{
		Game g = new Game();
		g.run();
	}
	
	public void run()
{
	while(true)
	{
		controller.update();
		model.update();
		view.repaint(); // Indirectly calls View.paintComponent
		Toolkit.getDefaultToolkit().sync(); // Updates screen

		// Go to sleep for 50 miliseconds
		try
		{
			Thread.sleep(40);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
}
