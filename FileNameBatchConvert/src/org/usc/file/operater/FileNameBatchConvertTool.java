package org.usc.file.operater;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;

public class FileNameBatchConvertTool extends JFrame {

	private static final long serialVersionUID = -4479764848720264621L;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JRadioButton radioButton_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_7;

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
		setTitle("文件名批量转换-顺利(QQ:506817493)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FileNameBatchConvertTool.class.getResource("/org/usc/file/operater/img/Ubuntu.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("文件名批量转换");
		label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 24));

		JLabel lblv = new JLabel("顺利©V2.0");
		lblv.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));

		JPanel panel = new JPanel();

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

				JCheckBox checkBox_4 = new JCheckBox("后缀");
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

		JCheckBox checkBox_5 = new JCheckBox("原串");
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

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_7.setColumns(10);

		JButton button = new JButton("浏览");
		button.setToolTipText("打开文件夹");
		button.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));

				JLabel label_1 = new JLabel("转换结果");
				label_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));

		JButton button_1 = new JButton("转换");
		button_1.setToolTipText("按照选定的规则进行转换");
		button_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));

		JButton button_2 = new JButton("清空");
		button_2.setToolTipText("清空转换结果信息");
		button_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));

		JButton button_3 = new JButton("导出");
		button_3.setToolTipText("导出转换结果信息为文本文件");
		button_3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));

		JButton button_4 = new JButton("打开");
		button_4.setToolTipText("打开导出的文本文件");
		button_4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1)
							.addGap(9)
							.addComponent(textField_7, 762, 762, 762))
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(button_2)
						.addComponent(button_3)
						.addComponent(button_4))
					.addContainerGap(51, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(854, Short.MAX_VALUE)
					.addComponent(lblv)
					.addGap(42))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(420, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(410))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(127, Short.MAX_VALUE))
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
							.addGap(18)
							.addComponent(button_1)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_3)
							.addGap(10)
							.addComponent(button_4))
						.addComponent(label_1)
						.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
					.addContainerGap())
		);

				JCheckBox checkBox_3 = new JCheckBox("前缀");
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

				JCheckBox checkBox_2 = new JCheckBox("大小写");
				checkBox_2.setToolTipText("大小写转换规则");
				checkBox_2.setSelected(true);
				checkBox_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
				panel_2.add(checkBox_2);

		JRadioButton radioButton = new JRadioButton("大写转小写");
		radioButton.setToolTipText("例: 一.txt -> 1.txt");
		radioButton.setSelected(true);
		buttonGroup.add(radioButton);
		radioButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_2.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("小写转大写");
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

		JCheckBox checkBox = new JCheckBox("转换文件夹");
		checkBox.setToolTipText("按照规则批量转换路径下所有的文件夹(含递归)");
		checkBox.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_1.add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("显示详细的转换结果");
		checkBox_1.setToolTipText("显示转换过程中所有的信息");
		checkBox_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_1.add(checkBox_1);

		JLabel label_2 = new JLabel("转换路径");
		label_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
		panel.add(label_2);

		textField = new JTextField();
		textField.setToolTipText("输入路径或浏览文件夹");
		textField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel.add(textField);
		textField.setColumns(50);
		contentPane.setLayout(gl_contentPane);
	}
}
