package org.usc.file.operater;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.usc.file.operater.rules.Rule;
import org.usc.file.operater.utils.FileOperaterTool;

public class FileNameBatchConvertTool extends JFrame {

	private static final long serialVersionUID = -4479764848720264621L;

	private static final String FILE_IS_NOT_VALID = "文件名不能包含下列任何字符";
	private static final String SPECIFIC_CHAR = "\\/:*?\"<>|";

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextArea textArea;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_4;
	private JCheckBox checkBox_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JFileChooser fileChooser;
	private Preferences pref;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileNameBatchConvertTool frame = new FileNameBatchConvertTool();
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
	public FileNameBatchConvertTool() {
		setResizable(false);
		setTitle("文件名批量转换-顺利(QQ:506817493)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FileNameBatchConvertTool.class.getResource("/org/usc/file/operater/img/Ubuntu.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setBounds((int) ((width-1024)/2), (int) ((height-648)/4), 999, 648);// 128 = (1280-1024)/2
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("文件名批量转换");
		label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 24));

		JLabel lblv = new JLabel("顺利©V2.0");
		lblv.setEnabled(false);
		lblv.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setFont(new Font("SimSun", Font.PLAIN, 12));

		JPanel panel_1 = new JPanel();

		JLabel label_3 = new JLabel("转换参数");
		label_3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
		panel_1.add(label_3);

		JPanel panel_2 = new JPanel();

		JLabel label_4 = new JLabel("转换规则");
		label_4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
		panel_2.add(label_4);

		JPanel panel_3 = new JPanel();

		JPanel panel_4 = new JPanel();

				checkBox_4 = new JCheckBox("后缀");
				checkBox_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkBox_4ActionPerformed(e);
					}
				});
				checkBox_4.setToolTipText("后缀转换规则");
				checkBox_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
				panel_4.add(checkBox_4);

		textField_3 = new JTextField();
		textField_3.setToolTipText("原后缀(不输人则添加新后缀)");
		textField_3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_3.setColumns(21);
		panel_4.add(textField_3);

		JLabel label_10 = new JLabel("转换为");
		label_10.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_4.add(label_10);

		textField_4 = new JTextField();
		textField_4.setToolTipText("新后缀(不输入则删除原后缀)");
		textField_4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_4.setColumns(21);
		panel_4.add(textField_4);

		JPanel panel_5 = new JPanel();

		checkBox_5 = new JCheckBox("原串");
		checkBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBox_5ActionPerformed(e);
			}
		});
		checkBox_5.setToolTipText("字符串转换规则");
		checkBox_5.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		panel_5.add(checkBox_5);

		textField_5 = new JTextField();
		textField_5.setToolTipText("原字符串");
		textField_5.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_5.setColumns(21);
		panel_5.add(textField_5);

		JLabel label_13 = new JLabel("转换为");
		label_13.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_5.add(label_13);

		textField_6 = new JTextField();
		textField_6.setToolTipText("新字符串");
		textField_6.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_6.setColumns(21);
		panel_5.add(textField_6);

		JButton button = new JButton("浏览");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonActionPerformed(e);
			}
		});
		button.setToolTipText("打开文件夹");
		button.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));

				JLabel label_1 = new JLabel("转换结果");
				label_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));

		JButton button_1 = new JButton("转换");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_1ActionPerformed(e);
			}
		});
		button_1.setToolTipText("按照选定的规则进行转换");
		button_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));

		JButton button_2 = new JButton("清空");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_2ActionPerformed(e);
			}
		});
		button_2.setToolTipText("清空转换结果信息");
		button_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));

		JButton button_3 = new JButton("导出");
		button_3.setToolTipText("导出转换结果信息为文本文件");
		button_3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));

		JButton button_4 = new JButton("打开");
		button_4.setToolTipText("打开导出的文本文件");
		button_4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 756, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_1)
								.addComponent(button)
								.addComponent(button_2)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button_4)
								.addComponent(button_3))))
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(864, Short.MAX_VALUE)
					.addComponent(lblv)
					.addGap(42))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(430, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(410))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(137, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblv)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button)
							.addGap(24)
							.addComponent(button_1)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(38)
										.addComponent(button_3))
									.addComponent(button_2))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_4))))
					.addContainerGap(18, Short.MAX_VALUE))
		);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textArea.setRows(9);
		textArea.setColumns(16);

				checkBox_3 = new JCheckBox("前缀");
				checkBox_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkBox_3ActionPerformed(e);
					}
				});
				checkBox_3.setToolTipText("前缀转换规则");
				checkBox_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
				panel_3.add(checkBox_3);

		textField_1 = new JTextField();
		textField_1.setToolTipText("原前缀(不输人则添加新前缀)");
		textField_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_3.add(textField_1);
		textField_1.setColumns(21);

		JLabel label_7 = new JLabel("转换为");
		label_7.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_3.add(label_7);

		textField_2 = new JTextField();
		textField_2.setToolTipText("新前缀(不输入则删除原前缀)");
		textField_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_3.add(textField_2);
		textField_2.setColumns(21);

				checkBox_2 = new JCheckBox("大小写");
				checkBox_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkBox_2ActionPerformed(e);
					}
				});
				checkBox_2.setToolTipText("大小写转换规则");
				checkBox_2.setSelected(true);
				checkBox_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
				panel_2.add(checkBox_2);

		radioButton = new JRadioButton("大写转小写");
		radioButton.setToolTipText("例: 一.txt -> 1.txt");
		radioButton.setSelected(true);
		buttonGroup.add(radioButton);
		radioButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_2.add(radioButton);

		radioButton_1 = new JRadioButton("小写转大写");
		radioButton_1.setToolTipText("例: 1.txt -> 一.txt");
		buttonGroup.add(radioButton_1);
		radioButton_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_2.add(radioButton_1);

		radioButton_2 = new JRadioButton("");
		buttonGroup.add(radioButton_2);
		radioButton_2.setVisible(false);
		radioButton_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		radioButton_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_2.add(radioButton_2);

		checkBox = new JCheckBox("转换文件夹");
		checkBox.setToolTipText("按照规则批量转换路径下所有的文件夹(含递归)");
		checkBox.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_1.add(checkBox);

		checkBox_1 = new JCheckBox("显示详细的转换结果");
		checkBox_1.setToolTipText("显示转换过程中所有的信息");
		checkBox_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_1.add(checkBox_1);

		JLabel label_2 = new JLabel("转换路径");
		label_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
		panel.add(label_2);

		textField = new JTextField();
		textField.setToolTipText("输入路径或浏览文件夹");
		textField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 17));
		panel.add(textField);
		textField.setColumns(47);
		contentPane.setLayout(gl_contentPane);



	}
	/////////////////////////////////////////////////////
	/**
	 * ActionPerformed
	 */
	///////////////////////////////////////////	/////////

	/**
	 * 大小写checkBox选定的话，默认选择大写转小写规则，没有选定，则选择隐藏的第三个单选按钮(起到不选择显示的单选按钮)
	 */
	private void checkBox_2ActionPerformed(java.awt.event.ActionEvent evt) {
		if(checkBox_2.isSelected()){
			radioButton.setSelected(true);
		}else{
			radioButton_2.setSelected(true);
		}
	}

	/**
	 * 前缀转换CheckBox不选定的话，清空后面的前缀
	 */
	private void checkBox_3ActionPerformed(java.awt.event.ActionEvent evt) {
		if(!checkBox_3.isSelected()){
			textField_1.setText("");
			textField_2.setText("");
		}
	}

	/**
	 * 后缀转换CheckBox不选定的话，清空后面的后缀名
	 */
	private void checkBox_4ActionPerformed(java.awt.event.ActionEvent evt) {
		if(!checkBox_4.isSelected()){
			textField_3.setText("");
			textField_4.setText("");
		}
	}

	/**
	 * 字符串转换CheckBox不选定的话，清空后面的字符串
	 */
	private void checkBox_5ActionPerformed(java.awt.event.ActionEvent evt) {
		if(!checkBox_5.isSelected()){
			textField_5.setText("");
			textField_6.setText("");
		}
	}


	private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
		/**
		 * choose folder
		 */

		/*
		 * 从注册表中读取上次打开的文件夹路径
		 * 注册表路径是
		 * HKEY_CURRENT_USER\\Software\\JavaSoft\\Prefs\\org\\usc\\lastpath
		 */

		pref = Preferences.userRoot().node("/org/usc");
		String lastPath = pref.get("lastpath", "");

		if(!"".equals(lastPath)){
			fileChooser = new JFileChooser(lastPath);
		}else{
			fileChooser = new JFileChooser();
		}

		fileChooser.setDialogTitle("浏览");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.getSelectedFile();

		fileChooser.setVisible(true);
		int open = fileChooser.showOpenDialog(this);

		if (open == JFileChooser.APPROVE_OPTION) {
			String path = fileChooser.getSelectedFile().getAbsolutePath();

			textField.setText(path);
			pref.put("lastpath", path);
		}
	}

	private void button_1ActionPerformed(java.awt.event.ActionEvent evt) {
		Rule rule = null;
		FileOperaterTool fileNameBatchConvertTool;
		String result;

		textArea.setText("");

		String path = textField.getText().trim();

		if (path == null || path.length() == 0) {
			textArea.setText("请输入路径");
		} else if (!checkBox_2.isSelected() && !checkBox_3.isSelected() && !checkBox_4.isSelected() && !checkBox_5.isSelected()) {
			textArea.setText("请选择转换规则");
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");

			long start = System.currentTimeMillis();
			textArea.setText(textArea.getText() + "------------------------------------------------\n");
			textArea.setText(textArea.getText() + "开始时间：" + dateFormat.format(new java.util.Date()) + "\n");

			StringBuffer info = new StringBuffer();

			if (checkBox_2.isSelected()) {
				if (radioButton.isSelected()) {
					rule = Rule.BigToSmall;
				} else if (radioButton_1.isSelected()) {
					rule = Rule.SmallToBig;
				}

				info.append("------------------------------------------------\n")
					.append("大小写转换中...\n");

				fileNameBatchConvertTool = new FileOperaterTool(rule);
				result = fileNameBatchConvertTool.fileRename(path, checkBox.isSelected());

				if(checkBox_1.isSelected()){
					info.append("\n").append(result);
				}

				info.append(fileNameBatchConvertTool.getStatistics());

			}
			if (checkBox_3.isSelected()) {
				rule = Rule.Prefix;

				info.append("------------------------------------------------\n")
					.append("前缀转换中...\n");

				fileNameBatchConvertTool = new FileOperaterTool(rule);
				result = fileNameBatchConvertTool.fileRename(path, textField_1.getText(), checkFileNameIsNotValid(textField_2.getText(), info),
						checkBox.isSelected());

				if(checkBox_1.isSelected()){
					info.append("\n").append(result);
				}

				info.append(fileNameBatchConvertTool.getStatistics());

			}
			if (checkBox_4.isSelected()) {
				rule = Rule.Suffix;

				info.append("------------------------------------------------\n")
					.append("后缀转换中...\n");

				fileNameBatchConvertTool = new FileOperaterTool(rule);
				result = fileNameBatchConvertTool.fileRename(path, textField_3.getText(), checkFileNameIsNotValid(textField_4.getText(), info),
						checkBox.isSelected());

				if(checkBox_1.isSelected()){
					info.append("\n").append(result);
				}

				info.append(fileNameBatchConvertTool.getStatistics());

			}
			if (checkBox_5.isSelected()) {
				rule = Rule.Replace;

				info.append("------------------------------------------------\n")
					.append("字符串转换中...\n");

				fileNameBatchConvertTool = new FileOperaterTool(rule);
				result = fileNameBatchConvertTool.fileRename(path, textField_5.getText(), checkFileNameIsNotValid(textField_6.getText(), info),
						checkBox.isSelected());

				if(checkBox_1.isSelected()){
					info.append("\n").append(result);
				}

				info.append(fileNameBatchConvertTool.getStatistics());

			}

			long end = System.currentTimeMillis();

			textArea.setText(textArea.getText() + "结束时间：" + dateFormat.format(new java.util.Date()) + "\n");
			textArea.setText(textArea.getText() + "总用时：" + (end - start) + " ms\n");

			textArea.setText(textArea.getText() + info.toString());
		}

	}

	private void button_2ActionPerformed(java.awt.event.ActionEvent evt) {
		textArea.setText("");
	}

	/////////////////////////////////////////////////////
	/**
	 * Function
	 */
	///////////////////////////////////////////	/////////

	/*protected Boolean checkFileNameIsNotValid(String fileName) {
		String regEx = "[\\\\/:\\*\\?\\\"<>\\|]";
		Pattern p = Pattern.compile(regEx);

		return p.matcher(fileName).find();
	}*/

	protected String checkFileNameIsNotValid(String fileName,StringBuffer buffer) {
		String regEx = "[\\\\/:\\*\\?\\\"<>\\|]";

		Pattern p = Pattern.compile(regEx);
		Matcher matcher = p.matcher(fileName);

		if(matcher.find()){
			buffer.append(FILE_IS_NOT_VALID).append(",做过滤处理\n").append(SPECIFIC_CHAR).append("\n");
			return matcher.replaceAll("");
		}else{
			return fileName;
		}
	}
}
