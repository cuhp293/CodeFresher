package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
	
	private Media media;
	
	public MediaStore(Media media) {
		this.media = media;
//		ButtonListener btnListener = new ButtonListener();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + "$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if (media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(e -> {
				if (media instanceof DigitalVideoDisc) {
					try {
						createDialog(((DigitalVideoDisc) media).play());
					} catch (PlayerException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						createDialog(((CompactDisc) media).play());
					} catch (PlayerException e1) {
						e1.printStackTrace();
					}
				}
			});
			container.add(playButton);
//			playButton.addActionListener(btnListener);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
//	public void createDialog(String playText) {
//		JDialog dialog = new JDialog();
//		JLabel label = new JLabel(playText);
//		JTextArea textArea = new JTextArea(playText);
//		textArea.setLineWrap(true);
//		textArea.setWrapStyleWord(true);
//		JScrollPane scrollPane = new JScrollPane(textArea);
//		dialog.add(label);
//		dialog.add(scrollPane);
//		dialog.setSize(300, 200);
//		dialog.setVisible(true);
//	}
	
	public void createDialog(String dialogText) {
	    JDialog dialog = new JDialog();
	    dialog.setLayout(new BorderLayout());
	    
	    JTextArea textArea = new JTextArea(dialogText);
	    textArea.setLineWrap(true);
	    textArea.setWrapStyleWord(true);

	    JScrollPane scrollPane = new JScrollPane(textArea);
	    dialog.add(scrollPane, BorderLayout.CENTER);

	    dialog.setSize(300, 200);
	    dialog.setVisible(true);
	}

	
//	private class ButtonListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JDialog dialog = new JDialog();
//			dialog.setAlwaysOnTop(true);
//			dialog.setTitle("Playing " + media.getTitle());
//			dialog.setSize(400, 300);
//			dialog.setVisible(true);
//		}
//	}
	
}
