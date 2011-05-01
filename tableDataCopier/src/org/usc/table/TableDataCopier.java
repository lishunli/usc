package org.usc.table;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TableDataCopier extends JFrame {
	private static final long serialVersionUID = 5840057159492381296L;

	private JPanel contentPane;
	private JButton btnCopy;

	private JTextField textField_0_0;
	private JLabel label_3;
	private JTextField textField_0_1;
	private JTextField textField_1_0;
	private JTextField textField_1_1;
	private JTextField textField_2_0;
	private JTextField textField_2_1;
	private JTextField textField_3_0;
	private JTextField textField_3_1;
	private JTextField textField_4_0;
	private final JScrollPane scrollPane = new JScrollPane();

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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_contentPane
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup().addComponent(label).addGap(372))
												.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblv).addGap(43))
												.addGroup(
														gl_contentPane
																.createSequentialGroup()
																.addGroup(
																		gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblDriver)
																				.addComponent(lblUrl).addComponent(lblUsername).addComponent(lblPassword)
																				.addComponent(lblTable).addComponent(lblResults))
																.addGap(10)
																.addGroup(
																		gl_contentPane
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 851,
																						Short.MAX_VALUE)
																				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
																				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
																				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
																				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
																				.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
																				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 842,
																						GroupLayout.PREFERRED_SIZE)).addGap(26)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_contentPane
								.createSequentialGroup()
								.addGroup(
										gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(label))
												.addGroup(gl_contentPane.createSequentialGroup().addGap(44).addComponent(lblv)))
								.addGap(18)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(
														gl_contentPane.createSequentialGroup()
																.addComponent(lblDriver, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE).addGap(1)
																.addComponent(lblUrl, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
																.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_contentPane
																.createSequentialGroup()
																.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE).addGap(1)
																.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addGap(1)
																.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
								.addGap(1)
								.addGroup(
										gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblPassword, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
												.addComponent(panel_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGap(10)
								.addGroup(
										gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTable, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblResults)
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(196, Short.MAX_VALUE)));

		JTextArea textArea = new JTextArea();
		textArea.setRows(2);
		scrollPane.setViewportView(textArea);

		textField_4_0 = new JTextField();
		textField_4_0.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
		textField_4_0.setColumns(49);
		panel_5.add(textField_4_0);

		textField_3_0 = new JTextField();
		textField_3_0.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_3_0.setColumns(25);
		panel_4.add(textField_3_0);

		JLabel label_4 = new JLabel("              ");
		label_4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_4.add(label_4);

		textField_3_1 = new JTextField();
		textField_3_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_3_1.setColumns(25);
		panel_4.add(textField_3_1);

		textField_2_0 = new JTextField();
		textField_2_0.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_2_0.setColumns(25);
		panel_3.add(textField_2_0);

		JLabel label_2 = new JLabel("              ");
		label_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_3.add(label_2);

		textField_2_1 = new JTextField();
		textField_2_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_2_1.setColumns(25);
		panel_3.add(textField_2_1);

		textField_1_0 = new JTextField();
		textField_1_0.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_1_0.setColumns(25);
		panel_2.add(textField_1_0);

		JLabel label_1 = new JLabel("              ");
		label_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_2.add(label_1);

		textField_1_1 = new JTextField();
		textField_1_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_1_1.setColumns(25);
		panel_2.add(textField_1_1);

		textField_0_0 = new JTextField();

		textField_0_0.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_1.add(textField_0_0);
		textField_0_0.setColumns(25);

		label_3 = new JLabel("              ");
		label_3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		panel_1.add(label_3);

		textField_0_1 = new JTextField();
		textField_0_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		textField_0_1.setColumns(25);
		panel_1.add(textField_0_1);

		JTextField[] fields = new JTextField[] { textField_0_0, textField_0_1, textField_1_0, textField_1_1, textField_2_0, textField_2_1, textField_3_0,
				textField_3_1, textField_4_0 };

		initData(fields);
		addCanCopyDataListener(fields);

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
		canCopyData(fields);

		JLabel lblTo = new JLabel("=======>To");
		lblTo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
		panel.add(lblTo);
		contentPane.setLayout(gl_contentPane);

	}

	// Copy
	private void buttonActionPerformed(java.awt.event.ActionEvent evt) {

	}

	// private void open() {
	// try {
	// Runtime.getRuntime().exec("notepad.exe " + lastExportFileName);
	// } catch (IOException e) {
	// button_4.setEnabled(false);
	// }
	//
	// }

	private void initData(JTextField[] fields) {
		int i = 0;
		for (JTextField jtextField : fields) {
			jtextField.setText("" + i++);
		}

	}

	private void addCanCopyDataListener(final JTextField[] fields) {
		for (JTextField jtextField : fields) {
			jtextField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					canCopyData(fields);
				}
			});
		}

	}

	/**
	 * can copy data?
	 */
	private void canCopyData(JTextField[] fields) {
		btnCopy.setEnabled(validateAllFiledToBeFilled(fields));
	}

	// ///////////////////////////////////////////////////
	// **
	// Function
	// *
	// ///////////////////////////////////////// /////////
	private boolean validateAllFiledToBeFilled(JTextField[] fields) {
		for (JTextField obj : fields) {
			if (isBlank(obj.getText())) {
				return false;
			}
		}
		return true;
	}

	private boolean isBlank(CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(cs.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
}
