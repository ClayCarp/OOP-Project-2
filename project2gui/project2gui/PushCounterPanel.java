//Clay Carpenter
//OOP Project 2
package project2gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTree;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Choice;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JDialog;
import java.awt.Dialog;

public class PushCounterPanel extends JPanel{
	private int height;
	private int width;

	private ImageIcon image;


	private int count;
	private JButton push;
	private JLabel label;
	private JButton reset;
	private JTextField text;
	private JLabel outlookLabel;
	private JRadioButton sunnybtn;
	private JRadioButton overcastbtn;
	private JRadioButton rainybtn;
	private JTextField txtTemp;
	private Predictor predict;
	private JSlider humidSlider;
	private JToggleButton windYes;
	private JToggleButton windNo;
	private JComboBox activityComboBox;
	private JSlider rslider;
	private JCheckBox c1;
	private JCheckBox c2;
	private JCheckBox c3;
	private JCheckBox c4;
	private JCheckBox c5;
	private JCheckBox c6;
	private JCheckBox c7;
	private JCheckBox c8;
	private JCheckBox c9;
	private JCheckBox c10;
	private JLabel predictLabel;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	private String outlook;
	private String temp;
	private int humid;
	private String wind;
	private String activity;


	public PushCounterPanel() {
		outlook = "sunny";
		temp = "40";
		humid = 50;
		wind = "FALSE";
		activity = "swimming";


		//Predict
		predict = new Predictor("./project2gui/weather.numeric.txt");

		//testing to string method for predictor
		System.out.println("Testing toString for predictor class: \n" + predict);

		//add(text);
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(800,700));

		outlookLabel = new JLabel("What is the outlook?");
		outlookLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		outlookLabel.setBounds(31, 88, 218, 14);
		add(outlookLabel);

		//if radio button = s or o or r then outlook = choice

		sunnybtn = new JRadioButton("Sunny");
		sunnybtn.addActionListener(new ButtonListener3());
		buttonGroup.add(sunnybtn);
		sunnybtn.setSelected(true);
		sunnybtn.setBackground(new Color(192, 192, 192));
		sunnybtn.setBounds(32, 120, 111, 23);
		add(sunnybtn);

		overcastbtn = new JRadioButton("Overcast");
		overcastbtn.addActionListener(new ButtonListener4());
		buttonGroup.add(overcastbtn);
		overcastbtn.setBackground(new Color(192, 192, 192));
		overcastbtn.setBounds(31, 144, 111, 23);
		add(overcastbtn);

		rainybtn = new JRadioButton("Rainy");
		rainybtn.addActionListener(new ButtonListener5());
		buttonGroup.add(rainybtn);
		rainybtn.setBackground(new Color(192, 192, 192));
		rainybtn.setBounds(31, 170, 111, 23);
		add(rainybtn);

		//set text to equal string temp.

		JLabel tempLabel = new JLabel("Temperature:");
		tempLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tempLabel.setBounds(31, 250, 131, 14);
		add(tempLabel);

		c1 = new JCheckBox("10");
		c1.setBounds(10, 270, 58, 30);
		c1.addActionListener(new CheckListener1());
		add(c1);
		c2 = new JCheckBox("20");
		c2.setBounds(70, 270, 58, 30);
		c2.addActionListener(new CheckListener2());
		add(c2);
		c3 = new JCheckBox("30");
		c3.setBounds(130, 270, 58, 30);
		c3.addActionListener(new CheckListener3());
		add(c3);
		c4 = new JCheckBox("40");
		c4.setBounds(190, 270, 58, 30);
		c4.addActionListener(new CheckListener4());
		add(c4);
		c5 = new JCheckBox("50");
		c5.setBounds(250, 270, 58, 30);
		c5.addActionListener(new CheckListener5());
		add(c5);
		c6 = new JCheckBox("60");
		c6.setBounds(10, 303, 58, 30);
		c6.addActionListener(new CheckListener6());
		add(c6);
		c7 = new JCheckBox("70");
		c7.setBounds(70, 303, 58, 30);
		c7.addActionListener(new CheckListener7());
		add(c7);
		c8 = new JCheckBox("80");
		c8.setBounds(130, 303, 58, 30);
		c8.addActionListener(new CheckListener8());
		add(c8);
		c9 = new JCheckBox("90");
		c9.setBounds(190, 303, 58, 30);
		c9.addActionListener(new CheckListener9());
		add(c9);
		c10 = new JCheckBox("100");
		c10.setBounds(250, 303, 58, 30);
		c10.addActionListener(new CheckListener10());
		add(c10);



		//set slider value to int humid;

		JLabel humidLabel = new JLabel("Humidity:");
		humidLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		humidLabel.setBounds(31, 359, 111, 23);
		add(humidLabel);

		humidSlider = new JSlider();
		humidSlider.addChangeListener(new SliderListener());
		humidSlider.setPaintTicks(true);
		humidSlider.setPaintLabels(true);
		humidSlider.setMajorTickSpacing(5);
		humidSlider.setForeground(new Color(240, 240, 240));
		humidSlider.setToolTipText("");
		humidSlider.setBackground(new Color(192, 192, 192));
		humidSlider.setBounds(10, 393, 367, 62);
		add(humidSlider);
		//check which button is selected and set it to equal boolean wind;

		JLabel windLabel = new JLabel("Is It Windy?");
		windLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		windLabel.setBounds(31, 496, 138, 23);
		add(windLabel);

		windYes = new JToggleButton("Yes");
		windYes.addActionListener(new ButtonListener7());
		windYes.setBounds(20, 524, 60, 23);
		add(windYes);

		windNo = new JToggleButton("No");
		windNo.addActionListener(new ButtonListener8());
		windNo.setBounds(90, 524, 60, 23);
		add(windNo);

		//get text from combo box and set it to string activity

		activityComboBox = new JComboBox();
		String[] myActivities = predict.getActivities();
		activityComboBox.setModel(new DefaultComboBoxModel(myActivities));
		activityComboBox.setBounds(31, 624, 218, 37);
		activityComboBox.addActionListener(new ComboListener());
		add(activityComboBox);

		JLabel activityLabel = new JLabel("Activity");
		activityLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		activityLabel.setBounds(31, 600, 101, 23);
		add(activityLabel);


		//all the instances

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(403, 142, 322, 405);
		add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setText(predict.toString());
		scrollPane.setViewportView(textArea);

		//Remove element
		rslider = new JSlider();
		rslider.addChangeListener(new SliderListener2());
		rslider.setMinorTickSpacing(1);
		rslider.setMajorTickSpacing(1);
		rslider.setPaintLabels(true);
		rslider.setSnapToTicks(true);
		rslider.setPaintTrack(false);
		rslider.setMaximum(predict.getSize()-1);
		rslider.setOrientation(SwingConstants.VERTICAL);
		rslider.setBounds(827, 152, 32, 395);
		add(rslider);

		JLabel RemoveLabel = new JLabel("Select an \r\nelement to\r\n remove.");
		RemoveLabel.setBounds(735, 53, 180, 140);
		add(RemoveLabel);

		//Add weather
		JButton addButton = new JButton("Add Weather");
		addButton.setBounds(420, 603, 124, 58);
		add(addButton);
		addButton.addActionListener(new ButtonListener2());

		//Add activity
		JButton predictButton = new JButton("Predict Activity");
		predictButton.setBounds(540, 603, 124, 58);
		predictButton.addActionListener(new ButtonListener10());
		add(predictButton);

		predictLabel = new JLabel("Prediction");
		predictLabel.setBounds(565,420,500,500);
		add(predictLabel);	
		
		
		JLabel imageLabel = new JLabel();
		image = new ImageIcon (this.getClass().getResource("/project2gui/weather.png"));
		imageLabel.setBounds(670,400,550,550);
		imageLabel.setIcon(image);
		add(imageLabel);
		
		width = 50;
		height = 50;
	}

	private class ButtonListener3 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (sunnybtn.isEnabled()) {
				outlook = "sunny";
			}
		}
	}

	private class ButtonListener4 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (overcastbtn.isEnabled()) {
				outlook = "overcast";
			}
		}
	}

	private class ButtonListener5 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (rainybtn.isEnabled()){
				outlook = "rainy";
			}
		}
	}

	private class ButtonListener2 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			Instance testGUI = new Instance(outlook, Integer.parseInt(temp), humid, (wind), activity); // **WILL NEED TO EDIT THIS TO CHECK IF UPDATING IS WORKING**
			predict.add(testGUI);
		}
	}

	private class SliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			humid = humidSlider.getValue();
		}
	}

	private class ButtonListener7 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (windYes.isEnabled()){
				wind = "TRUE";
			}
		}
	}

	private class ButtonListener8 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (windNo.isEnabled()){
				wind = "FALSE";
			}
		}
	}

	private class TextListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			temp = txtTemp.getText();
		}
	}

	public class ComboListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			activity = (String) activityComboBox.getSelectedItem();
		}
	}

	private class SliderListener2 implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			if (!rslider.getValueIsAdjusting()) {
				int temp = rslider.getValue();
				predict.removeWeather(temp);
			}
		}
	}

	private class ButtonListener10 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			System.out.println(predict.getpredictionInstance(new Instance(outlook, Integer.parseInt(temp), humid, wind, activity)));

			Instance tempor = predict.getpredictionInstance(new Instance(outlook, Integer.parseInt(temp), humid, wind, activity));
			predictLabel.setText("" + tempor);

		}
	}

	private class CheckListener1 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (c1.isEnabled() == true) {
				temp = "10";
			}
		}
	}

	private class CheckListener2 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (c2.isEnabled() == true) {
				temp = "20";
			}
		}
	}

	private class CheckListener3 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (c3.isEnabled() == true) {
				temp = "30";
			}
		}
	}

	private class CheckListener4 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (c4.isEnabled() == true) {
				temp = "40";
			}
		}
	}

	private class CheckListener5 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (c5.isEnabled() == true) {
				temp = "50";
			}
		}
	}

	private class CheckListener6 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (c6.isEnabled() == true) {
				temp = "60";
			}
		}
	}

	private class CheckListener7 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (c7.isEnabled() == true) {
				temp = "70";
			}
		}
	}

	private class CheckListener8 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (c8.isEnabled() == true) {
				temp = "80";
			}
		}
	}

	private class CheckListener9 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (c9.isEnabled() == true) {
				temp = "90";
			}
		}
	}

	private class CheckListener10 implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (c10.isEnabled() == true) {
				temp = "100";
			}
		}
	}

	public void doClose() {
		predict.writeFile("./project2gui/weather.numeric.txt");
	}
}



