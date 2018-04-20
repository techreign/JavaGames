package playing;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class MainPanel extends JPanel {
	
	/**
	 *  Main panel that includes the other panels
	 */
	
	private static final long serialVersionUID = -7225362362539310492L;
	private JPanel panelTop = new JPanel();
	private JPanel panelBot = new JPanel();
	private static JTextArea info = new JTextArea();
	private static JTextField data = new JTextField();
	private JScrollPane scrollpane = new JScrollPane(info);
	private JButton button = new JButton("Enter");
	private BorderLayout layout = new BorderLayout();
	private BorderLayout layoutMain = new BorderLayout();
	private GridLayout layout2 = new GridLayout();
	private Font font = new Font("Tahoma", Font.PLAIN, 20);
	private Enter enterAction =  new Enter();
	DefaultCaret caret = (DefaultCaret)info.getCaret();

	
	public MainPanel() {
		
		scrollpane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		info.setFont(font);
		info.setForeground(Color.GRAY);
		info.setEditable(false);
		info.setBackground(Color.BLACK);
		info.setWrapStyleWord(true);
		info.setLineWrap(true);
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		setLayout(layoutMain);
		button.addActionListener(enterAction);
		panelTop.setLayout(layout);
		panelBot.setLayout(layout2);
		panelTop.add(scrollpane, BorderLayout.CENTER);
		panelBot.add(data);
		panelBot.add(button);
		add(panelTop, BorderLayout.CENTER);
		add(panelBot, BorderLayout.SOUTH);
	}

	public static JTextField getData() {
		return data;
	}

	public static void setData(JTextField data) {
		MainPanel.data = data;
	}

	public static JTextArea getInfo() {
		return info;
	}

	public static void setInfo(JTextArea info) {
		MainPanel.info = info;
	}
	
	public static void update(String str) {
		info.append(str + "\n");
	}
	
	public static void space() {
		info.append("\n");
	}

}
