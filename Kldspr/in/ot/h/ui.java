package Kldspr.in.ot.h;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.AWTException;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.undo.UndoManager;
import Sls.ki.out.sh.*;


import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Button;
import java.awt.CheckboxMenuItem;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.Box;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import java.awt.event.InputEvent;

public class ui {

	private JFrame frmKeldphar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ui window = new ui();
					window.frmKeldphar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmKeldphar = new JFrame();
		frmKeldphar.getContentPane().setBackground(Color.DARK_GRAY);
		frmKeldphar.setTitle("Super HTML");
		frmKeldphar.setBounds(100, 100, 1356, 857);
		frmKeldphar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		styles sa = new styles();
		
		
		
		
		final JFileChooser fc = new JFileChooser();
		final JFileChooser ft = new JFileChooser();
		
		JTextPane editorPane = new JTextPane();
		editorPane.setText("<!DOCTYPE html>\r\n<html>\r\n\t<header>\r\n\t</header>\r\n\r\n\t<!-- This Part Is The Main Body -->\r\n\t<body>\r\n       </body>\r\n</html>");
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		editorPane.setForeground(Color.BLUE);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmKeldphar.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		//TODO Save
		/* Basically, what is part does is it opens
		 * a JFileChooser and allows the user to save
		 * the file.
		 */
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Handle open button action.
			    if (e.getSource() == mntmSave) {
			        int returnVal = fc.showSaveDialog(null);

			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            Path vg = file.toPath();
			            
			            Charset charset = Charset.forName("US-ASCII");
			            String s = editorPane.getText();
						
						try (BufferedWriter writer = Files.newBufferedWriter(vg, charset)){
			            		
			                writer.write(s, 0, s.length());
			            } catch (IOException x) {
			                System.err.format("IOException: %s%n", x);
			            }
			        }
			    }
			}
		});
		
		//TODO Open
		/* This part is still buggy, it only reads the first line of the selected
		 * file. This SHOULD be fixed sometime in the future.
		 */
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == mntmOpen) {
			        int returnVal = fc.showOpenDialog(null);

			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            //This is where a real application would open the file.
			            
			            Path HI = file.toPath();
			            
			            
			            try( Stream<String> lines = Files.lines(HI)
			            		){
			            	for( String line : (Iterable<String>) lines::iterator )
			            	{
			            		editorPane.setText(line); 
			            	} 
			            }catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

			            
			            
			            
			            
			            
			            
				
				        
			        }
				}
			}
		});
		/*
		 * And yes, this just adds the menus. :P
		 */
		mnFile.add(mntmOpen);
		mnFile.add(mntmSave);
		
		
		mnFile.addSeparator();
		
		/*
		 * This menu item is very simple. When clicked, it starts
		 * exd.class which asks the user if they are sure they want
		 * to quit.
		 */
		JMenuItem mntmExitKeldphar = new JMenuItem("Exit");
		mntmExitKeldphar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exd.main(null);
			}
		});
		mnFile.add(mntmExitKeldphar);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		
		// TODO Show the toolbar
		/* DANG IT I HID THE TOOLBAR!!!! Oh wait, this undoes that. :P
		 * Very usful if you want all the features back!
		 */
		JMenuItem mntmShowToolbar = new JMenuItem("Show Toolbar");
		mntmShowToolbar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_MASK));
		mntmShowToolbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toolBar.setVisible(true);
			}
		});
		mnView.add(mntmShowToolbar);
		
		mnView.addSeparator();
		JMenuItem mntmRemoveCodeHelp = new JMenuItem("Remove Code Help");
		
		mnView.add(mntmRemoveCodeHelp);
		
		JMenuItem mntmShowCodeHelp = new JMenuItem("Show Code Help");
		
		mnView.add(mntmShowCodeHelp);
		
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
		
		/*
		 * This is just a bunch of junk that adds the components
		 * to the main group layout.
		 */
		GroupLayout groupLayout = new GroupLayout(frmKeldphar.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(editorPane, GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE))
				.addComponent(editorPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
		);
		
		
		
		
		//TODO Fonts
		// Makes it bold
		JButton button = new JButton("");
		button.setToolTipText("Bold");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
		});
		
		
		/*
		 * Nothing to see here. Just the "Tools:" string.
		 */
		JLabel lblTools = new JLabel("Tools:");
		lblTools.setFont(new Font("Tahoma", Font.BOLD, 11));
		toolBar.add(lblTools);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		button.setIcon(new ImageIcon(ui.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Bold-Black.png")));
		toolBar.add(button);
		
		
		
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
			}
		});
		button_1.setToolTipText("Plain");
		button_1.setIcon(new ImageIcon(ui.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Left-Black.png")));
		toolBar.add(button_1);
		
		
		toolBar.addSeparator();
		
		
		//TODO Clear All
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.setText(null);
			}
		});
		button_3.setToolTipText("Clear All");
		button_3.setIcon(new ImageIcon(ui.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		toolBar.add(button_3);
		
		
		toolBar.addSeparator();
		
		
		//TODO Cut, Copy, Paste
		JButton btnCut = new JButton("");
		btnCut.setToolTipText("Cut");
		btnCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.cut();
			}
		});
		btnCut.setIcon(new ImageIcon(ui.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));
		toolBar.add(btnCut);
		
		
		
		
		
		JButton button_5 = new JButton("");
		button_5.setToolTipText("Copy");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.copy();
			}
		});
		button_5.setIcon(new ImageIcon(ui.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		toolBar.add(button_5);
		
		
		
		JButton button_6 = new JButton("");
		button_6.setToolTipText("Paste");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.paste();
			}
		});
		button_6.setIcon(new ImageIcon(ui.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		toolBar.add(button_6);
		
		//TODO Hide Toolbar
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toolBar.setVisible(false);
			}
		});
		
		/*
		 * I tried this but apperently, the text field has to be a "Document".
		 * XD
		 */
		UndoManager udm = new UndoManager();
		udm.setLimit(50);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		
		button_4.setToolTipText("Hide ToolBar");
		button_4.setIcon(new ImageIcon(ui.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		toolBar.add(button_4);
		
		
		
		panel.setLayout(new BorderLayout(0, 0));
		
		/*
		 * This is the code sinppets area, we all sometimes need them, right?
		 */
		JTextPane txtpnUsefulCodeSnippets = new JTextPane();
		txtpnUsefulCodeSnippets.setEditable(false);
		txtpnUsefulCodeSnippets.setText("Useful Code Snippets:\r\n\r\nMaking a button: \r\n \r\n<form action=\"http://google.com\">\r\n\t<input type=\"submit\" value=\"Go to Google\">\r\n</form>\r\n-------------------------------------------\r\nMaking a heading:\r\n\r\n<h1>Text Here</h1>\r\n\r\nor\r\n\r\n<h2>Text Here</h2>\r\n-------------------------------------------\r\nDisplaying Text:\r\n\r\n<p>Text Here.</p>");
		panel.add(txtpnUsefulCodeSnippets, BorderLayout.CENTER);
		
		
		// GO AWAY CODE SNIPPETS!!!!
		Button button_2 = new Button("Remove");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
			}
		});
		panel.add(button_2, BorderLayout.SOUTH);
		
		mntmRemoveCodeHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
			}
		});
		
		
		//TODO Stackoverflow, my favorite coding website!
		Button button_7 = new Button("Stackoverflow Help");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final URI uri = new URI("http://stackoverflow.com/questions/tagged/html");
					open(uri);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		//Because it didn't work up there.
		mntmShowCodeHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
			}
		});
		
		panel.add(button_7, BorderLayout.NORTH);
		frmKeldphar.getContentPane().setLayout(groupLayout);
	}
	
	/*
	 * This lets me open a website. Java, you really don't already have this? :/
	 */
	private static void open(URI uri) {
	    if (Desktop.isDesktopSupported()) {
	      try {
	        Desktop.getDesktop().browse(uri);
	      } catch (IOException e) { /* TODO: error handling */ }
	    } else { /* TODO: error handling */ }
	  }
}
