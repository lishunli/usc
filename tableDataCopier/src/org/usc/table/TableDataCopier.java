package org.usc.table;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TableDataCopier  extends JFrame {
	private static final long serialVersionUID = 5840057159492381296L;

	private JPanel contentPane;
	private JButton btnCopy;

	private JTextField txtJdbcoraclethinmseub;
	private JLabel label_3;
	private final JTextArea textArea = new JTextArea();
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableDataCopier frame = new TableDataCopier();
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
	public TableDataCopier() {
		setResizable(false);
		setTitle("TableDataCopier-ShunLi(QQ:506817493)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/org/usc/table/img/dataCopier.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setBounds((int) ((width - 1024) / 2), (int) ((height - 648) / 4), 999, 609);// 128
																					// =
																					// (1280-1024)/2
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("TableDataCopier");
		label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 24));

		JLabel lblv = new JLabel("ShunLi©V0.1");
		lblv.setEnabled(false);
		lblv.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		lblv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI("http://blogjava.net/lishunli"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});

		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.setFont(new Font("SimSun", Font.PLAIN, 12));

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		JLabel lblResults = new JLabel("Results");
		lblResults.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_2.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_5.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);

				JLabel lblUsername = new JLabel("Username");
				lblUsername.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));

				JLabel lblPassword = new JLabel("Password");
				lblPassword.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));

				JLabel lblTable = new JLabel("Table");
				lblTable.setHorizontalAlignment(SwingConstants.CENTER);
				lblTable.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));

				JLabel lblUrl = new JLabel("Url");
				lblUrl.setHorizontalAlignment(SwingConstants.CENTER);
				lblUrl.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));

				JLabel lblDriver = new JLabel("Driver   ");
				lblDriver.setHorizontalAlignment(SwingConstants.CENTER);
				lblDriver.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));

				JTextArea txtrscdsS = new JTextArea();
				txtrscdsS.setEditable(false);
				txtrscdsS.setWrapStyleWord(true);
				txtrscdsS.setRows(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(240)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(743, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblv)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDriver)
								.addComponent(lblUrl)
								.addComponent(lblUsername)
								.addComponent(lblPassword)
								.addComponent(lblTable)
								.addComponent(lblResults))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtrscdsS, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
								.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
								.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
								.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE))))
					.addGap(26))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(433, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(360))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(lblv))
						.addComponent(label))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDriver, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(lblUrl, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTable, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(lblResults))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(txtrscdsS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(12, Short.MAX_VALUE))
		);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
		textField_7.setColumns(49);
		panel_5.add(textField_7);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_5.setColumns(25);
		panel_4.add(textField_5);

		JLabel label_4 = new JLabel("              ");
		label_4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_4.add(label_4);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_6.setColumns(25);
		panel_4.add(textField_6);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_3.setColumns(25);
		panel_3.add(textField_3);

		JLabel label_2 = new JLabel("              ");
		label_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_3.add(label_2);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_4.setColumns(25);
		panel_3.add(textField_4);

		textField = new JTextField();
		textField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField.setColumns(25);
		panel_2.add(textField);

		JLabel label_1 = new JLabel("              ");
		label_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_2.add(label_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_2.setColumns(25);
		panel_2.add(textField_2);

		txtJdbcoraclethinmseub = new JTextField();
		txtJdbcoraclethinmseub.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_1.add(txtJdbcoraclethinmseub);
		txtJdbcoraclethinmseub.setColumns(25);

		label_3 = new JLabel("              ");
		label_3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_1.add(label_3);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_1.setColumns(25);
		panel_1.add(textField_1);

				JLabel lblFrom = new JLabel("                                                From=======");
				lblFrom.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
				panel.add(lblFrom);

				btnCopy = new JButton("Copy");
				panel.add(btnCopy);
				btnCopy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttonActionPerformed(e);
					}
				});
				btnCopy.setToolTipText("copy table's data from one database to another database(same table schema)");
				btnCopy.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));

				JLabel lblTo = new JLabel("=======>To");
				lblTo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
				panel.add(lblTo);
		contentPane.setLayout(gl_contentPane);

	}

	// Copy
	private void buttonActionPerformed(java.awt.event.ActionEvent evt) {

	}

	/**
	 * 浏览文件夹，打开文件夹
	 * @param evt
	 *//*
	private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
		*//**
		 * choose folder
		 *//*


		 * 从注册表中读取上次打开的文件夹路径 注册表路径是
		 * HKEY_CURRENT_USER\\Software\\JavaSoft\\Prefs\\org\\usc\\lastpath

		lastPath = pref.get("lastpath", "");

		if (!"".equals(lastPath)) {
			fileChooser = new JFileChooser(lastPath);
		} else {
			fileChooser = new JFileChooser();
		}

		fileChooser.setDialogTitle("浏览");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.getSelectedFile();

		fileChooser.setVisible(true);
		int open = fileChooser.showOpenDialog(this);

		if (open == JFileChooser.APPROVE_OPTION) {
			String path = fileChooser.getSelectedFile().getAbsolutePath();
			pref.put("lastpath", path);
			textField.setText(path);
		}
	}

	*//**
	 * 转换
	 * @param evt
	 *//*
	private void button_1ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	*//**
	 * 清空结果信息
	 *//*
	private void button_2ActionPerformed(java.awt.event.ActionEvent evt) {
		textArea.setText("");
	}

	*//**
	 * 设置转换按钮是否可单击
	 *//*
	private void canConvert() {
		if (textField != null && textField.getText() != null && textField.getText().trim().length() != 0
				&& (checkBox_2.isSelected() || checkBox_3.isSelected() || checkBox_4.isSelected() || checkBox_5.isSelected())) {
			button_1.setEnabled(true);
		} else {
			button_1.setEnabled(false);
		}
	}

	*//**
	 * 设置清空按钮是否可单击
	 *//*
	private void canClear() {
		if (textArea != null && textArea.getText() != null && textArea.getText().trim().length() != 0) {
			button_2.setEnabled(true);
			button_3.setEnabled(true);
		} else {
			button_2.setEnabled(false);
			button_3.setEnabled(false);
		}
	}

	*//**
	 * 导出结果信息到文本文件中
	 *//*
	public void export() {
		lastPath = pref.get("lastpath", "");

		if (!"".equals(lastPath)) {
			fileChooser = new JFileChooser(lastPath);
		} else {
			fileChooser = new JFileChooser(new File("."));
		}

		fileChooser.setDialogTitle("导出");
		fileChooser.setSelectedFile(new File("*.txt"));

		FileNameExtensionFilter filter = new FileNameExtensionFilter("文本文档(*.txt)", "txt");
		fileChooser.setFileFilter(filter);

		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();

			if (!file.toString().toLowerCase().endsWith(".txt")) {
				file = new File(file.toString().concat(".txt"));
			}

			// Check txt file is not exists
			if (file.exists()) {
				int option = JOptionPane.showConfirmDialog(this, file.getName() + "已存在\n要替换它吗?", "确认", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.NO_OPTION) {
					return;
				}
			}

			String text = textArea.getText();
			String[] lines = text.trim().split("\n");
			try {
				PrintWriter out = new PrintWriter(new FileOutputStream(file), true);
				for (String line : lines) {
					out.println(line);
				}

				lastExportFileName = file.toString();
				out.flush();
				out.close();
				button_4.setEnabled(true);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	*//**
	 * 打开导出的文本文件
	 *//*
	private void open() {
		try {
			Runtime.getRuntime().exec("notepad.exe " + lastExportFileName);
		} catch (IOException e) {
			button_4.setEnabled(false);
		}

	}

*/
	// ///////////////////////////////////////////////////
	// **
	// Function
	// *
	// ///////////////////////////////////////// /////////
//	private String rightPad(String str, int size, String padStr) {
//		if (padStr == null || padStr.length() == 0) {
//			padStr = " ";
//		}
//
//		int padLen = padStr.length();
//		int strLen = str.length();
//		int pads = size - strLen;
//		if (pads <= 0) {
//			return str; // returns original String when possible
//		}
//
//		if (pads == padLen) {
//			return str.concat(padStr);
//		} else if (pads < padLen) {
//			return str.concat(padStr.substring(0, pads));
//		} else {
//			char[] padding = new char[pads];
//			char[] padChars = padStr.toCharArray();
//			for (int i = 0; i < pads; i++) {
//				padding[i] = padChars[i % padLen];
//			}
//			return str.concat(new String(padding));
//		}
//	}
}
