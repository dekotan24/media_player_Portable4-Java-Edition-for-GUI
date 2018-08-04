/*
MIT LICENSE
Copyright 2018 Ogura Deko and other

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package mpp4;



import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;
import javax.media.bean.playerbean.MediaPlayer;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class UI extends JFrame{



	public static void main(String[] args) throws IOException, NoPlayerException, CannotRealizeException {
		new UI();
	}

	public JTextField titlebox1;
	public push_play player;



	public UI() throws NoPlayerException, CannotRealizeException, IOException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setBounds(400,150,540,120);
	    setTitle("media_player Portable4 Java Edition Ver.0.0.1");
	    setLayout(null);

		titlebox1=new JTextField();
		titlebox1.setEditable(false);
		titlebox1.setBounds(200,2,270,26);
		titlebox1.setLayout(null);
		add(titlebox1);

		JButton fcb = new JButton(new push_fc());
	    fcb.setBounds(470, 0, 50, 30);
	    fcb.setText("..");
	    add(fcb);

	    JProgressBar prg = new JProgressBar();
	    prg.setBounds();
	    prg.setValue(0);

	    JButton play=new JButton(new push_play());
	    play.setBounds(200,40,80,25);
	    play.setText("Play");
	    add(play);

	    JButton stop=new JButton(new push_stop());
	    stop.setBounds(280,40,80,25);
	    stop.setText("Stop");
	    add(stop);

	    JButton pause=new JButton(new push_pause());
	    pause.setBounds(360,40,80,25);
	    pause.setText("Pause");
	    pause.setEnabled(false);
	    add(pause);

	    JButton vol=new JButton(new push_vol());
	    vol.setBounds(440,40,80,25);
	    vol.setText("Vol");
	    add(vol);


	    prg.setVisible(true);
		titlebox1.setVisible(true);
		play.setVisible(true);
		stop.setVisible(true);
		pause.setVisible(true);
		vol.setVisible(true);
		fcb.setVisible(true);
	    setVisible(true);

	    JFrame ajframe = new JFrame("Album Jacket Work");
	    ajframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}


	 public class push_fc extends AbstractAction {

		    public push_fc() {
		      super("Select file..");
		    }
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser chooser = new JFileChooser("C:/");
		        FileFilter filter1 =
		        		new FileNameExtensionFilter("MIDI Sequence", "mid", "midi");
		        FileFilter filter2 =
		          new FileNameExtensionFilter("WAVE sound (*.wav)", "wav");
		        FileFilter filter3 =
		        		new FileNameExtensionFilter("AIF file (*.aif)", "aif");
		        FileFilter filter5 =
		        		new FileNameExtensionFilter("MP2 sound (*.mp2)", "mp2");
		        FileFilter filtern =
		        		new FileNameExtensionFilter("Supporting All Files", "mid", "midi","wav", "aif", "mp2");
		        FileFilter filteri =
		        		new FileNameExtensionFilter("JMF Supporting Files", "aiff", "avi", "gsm", "mvr", "mid", "midi", "mpg", "mpeg", "mp2", "mov", "au", "wav");
		        chooser.addChoosableFileFilter(filter1);
		        chooser.addChoosableFileFilter(filter2);
		        chooser.addChoosableFileFilter(filter3);
		        chooser.addChoosableFileFilter(filter5);
		        chooser.addChoosableFileFilter(filtern);
		        chooser.addChoosableFileFilter(filteri);
		        int answer = chooser.showDialog(null, "Select file..");
		        if (answer == JFileChooser.APPROVE_OPTION) {
		          File file = chooser.getSelectedFile();
		          titlebox1.setText(file.getPath());
		        }
		      }
	 }

	 public MediaPlayer MediaPlayer1 = new javax.media.bean.playerbean.MediaPlayer();

	 public class push_play extends AbstractAction{

		 public push_play() {
			 super("Button");
		 }
		 @Override
		 public void actionPerformed (ActionEvent e) {
			 if(titlebox1.getText()=="") {
			 }
			 else {
				 MediaPlayer1.setMediaLocation(new java.lang.String("file://"+titlebox1.getText()));
				 MediaPlayer1.start();
				    }
			 return;
		 }
	 }

	 public class push_stop extends AbstractAction{
		 public push_stop() {
			 super("Button");
		 }
		 @Override
		 public void actionPerformed(ActionEvent e) {
			 MediaPlayer1.stop();
			 }
	 }

	 public class push_pause extends AbstractAction{
		 public push_pause() {
			 super("Button");
		 }
		 @Override
		 public void actionPerformed(ActionEvent e) {
		 }
	 }

	 public class push_vol extends AbstractAction{
		 public push_vol() {
			 super("Button");
		 }
		 @Override
		 public void actionPerformed(ActionEvent e) {
			 Runtime sndvol=Runtime.getRuntime();
			 try {
				sndvol.exec("sndvol.exe");
			 } catch (IOException e1) {
				e1.printStackTrace();
			}
		 }
	 }

}
