package com.haitong.tools;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.haitong.utils.Code;
import com.haitong.utils.Decryption;
import com.haitong.utils.Encryption;
import java.awt.Color;

public class EncryptionAndDecryptionTool extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 13499880799943152L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Code code;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncryptionAndDecryptionTool frame = new EncryptionAndDecryptionTool();
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
	public EncryptionAndDecryptionTool() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionAndDecryptionTool.class.getResource("/com/haitong/imgs/images.jpg")));
		setResizable(false);
		setTitle("MSS-X User PWD De-Encryption Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setBounds((int) ((width - 479) / 2), (int) ((height - 216) / 4), 479, 216);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblMssxUserPwd = new JLabel("MSS-X User PWD De-Encryption Tool");
		lblMssxUserPwd.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JLabel label = new JLabel("Password");
		label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_1.add(label);

		textField_1 = new JTextField();
		textField_1.setToolTipText("加解密后的密码");
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_1.setColumns(10);
		panel_1.add(textField_1);

		JButton btnCopy = new JButton("            Copy           ");
		btnCopy.setToolTipText("复制到剪贴板");
		btnCopy.setForeground(Color.BLACK);
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copy(textField_1.getText());
			}
		});
		btnCopy.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_1.add(btnCopy);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(115, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(76, Short.MAX_VALUE)
					.addComponent(lblMssxUserPwd)
					.addGap(66))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMssxUserPwd)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(154))
		);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel.add(lblPassword);

		textField = new JTextField();
		textField.setToolTipText("原密码");
		textField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel.add(textField);
		textField.setColumns(10);

		JButton button_1 = new JButton("Encrypt");
		button_1.setToolTipText("加密");
		button_1.setForeground(Color.GREEN);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				encrypt();
			}

		});
		button_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel.add(button_1);

		JButton button = new JButton("Decrypt");
		button.setToolTipText("解密");
		button.setBackground(Color.WHITE);
		button.setForeground(Color.MAGENTA);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decrypt();
			}
		});
		button.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel.add(button);
		contentPane.setLayout(gl_contentPane);
	}

	protected void encrypt() {
		code = new Encryption();
		textField_1.setText(code.changeCode(textField.getText()));
	}

	protected void decrypt() {
		code = new Decryption();
		textField_1.setText(code.changeCode(textField.getText()));
	}

	protected  void copy(String str)
	{
		StringSelection stsel = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel, stsel);
	}
}
