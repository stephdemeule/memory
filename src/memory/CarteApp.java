package memory;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Deque;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import memory.FrameForDemoMaker;
import memory.ResourceUtility;

public class CarteApp extends FrameForDemoMaker {
	EtatMemoire etatMemoire = new EtatMemoire();
	private static final int ROW_COUNT = 4;
	private static final int COLUMN_COUNT = 6;
	private ImageIcon dosCarte = ResourceUtility.loadImage("images/dos.png");

	private Jeu jeu = new Jeu();
	
	public CarteApp() throws IOException{
		super("Mémoire");
		setDefaultBounds(100,100,900,600);
	}

	@Override
	public void init(JFrame frame) {
        Container cp = frame.getContentPane();
        cp.setLayout(new GridLayout(ROW_COUNT, COLUMN_COUNT));
        
        Deque<ImageIcon> pioche = jeu.creerPioche();
        while(!pioche.isEmpty()) {
            cp.add(createButton(pioche.pop()));
        }
    }

	public JComponent createButton(ImageIcon imageIcon) {
		JToggleButton button = new JToggleButton(dosCarte);
		button.setSelectedIcon(imageIcon);
		button.setDisabledIcon(imageIcon);
		button.setDisabledSelectedIcon(imageIcon);
		button.putClientProperty("carte", imageIcon.getDescription());
        
        
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    System.out.println(button.getClientProperty("carte"));
			    
			    etatMemoire.nouveauBoutonSelectionne(button);
			  }
			});
			return button;
    }

	public static void main(String[] args) throws IOException {
		CarteApp example = new CarteApp();
		SwingUtilities.invokeLater(example);
	}
}