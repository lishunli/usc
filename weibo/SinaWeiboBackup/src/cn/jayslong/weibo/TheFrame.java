package cn.jayslong.weibo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo. Please
 * visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS
 * MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class TheFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	static private JPanel jPanel1;
	static private JButton jButton1;
	static private JButton jButton3;
	static private JButton jButton2;
	static private JPasswordField jPasswordField1;
	static private JCheckBox jCheckBox1;
	static private JButton downImageButton;
	static private JTextField jTextField6;
	static private JTextField jTextField5;
	static private JLabel jLabel7;
	static private JButton jButton6;
	static private JButton jButton5;
	static private JTextArea jTextArea2;
	static private JScrollPane jScrollPane2;
	static private ButtonGroup buttonGroup1;
	static private JRadioButton jRadioButton4;
	static private JRadioButton jRadioButton3;
	static private JRadioButton jRadioButton2;
	static private JLabel jLabel5;
	static private JRadioButton jRadioButton1;
	static private JComboBox jComboBox1;
	static private JTextField jTextField4;
	static private JLabel jLabel6;
	static private JTextField jTextField3;
	static private JPanel jPanel2;
	static private JLabel jLabel4;
	static private JTextArea jTextArea1;
	static private JScrollPane jScrollPane1;
	static private JLabel jLabel3;
	static private JLabel jLabel2;
	static private JTextField jTextField2;
	static private JLabel jLabel1;
	static private JTextField jTextField1;
	static private JFileChooser jFileChooser1;
	static private Controller controller = new Controller();
	{
		// Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				if (!new File("sqlite_jni.dll").exists())
				{
					CopyDll cd = new CopyDll();
					try
					{
						cd.copyDll();
					} catch (Exception e)
					{
						e.printStackTrace();
						Log.log("无法复制dll文件", e);
					}
				}
				TheFrame inst = new TheFrame();
				inst.setLocationRelativeTo(null);
				inst.setResizable(false);
				inst.setTitle("\u65b0\u6d6a\u5fae\u535a\u5907\u4efd\u5bfc\u51fa\u7a0b\u5e8fV" + Controller.version + " " + Controller.date);
				inst.getContentPane().setLayout(null);
				inst.setFocusTraversalKeysEnabled(false);
				inst.setVisible(true);
				inst.setSize(399, 299);
				{
					jPanel1 = new JPanel();
					inst.getContentPane().add(jPanel1);
					jPanel1.setLayout(null);
					jPanel1.setBounds(0, 0, 394, 272);
					{
						jButton1 = new JButton();
						jPanel1.add(jButton1);
						jButton1.setText("浏览");
						jButton1.setLayout(null);
						jButton1.setBounds(318, 28, 66, 25);
						jButton1.addMouseListener(new MouseAdapter()
						{
							public void mouseClicked(MouseEvent evt)
							{
								if (!jButton1.isEnabled())
								{
									return;
								}
								JFileChooser jfChooser = new JFileChooser(
										jTextField1.getText());
								jfChooser.setDialogTitle("选择数据库文件");
								jfChooser.setFileFilter(new FileFilter()
								{
									@Override
									public boolean accept(File f)
									{
										if (f.getName().endsWith("db")
												|| f.isDirectory())
											return true;
										return false;
									}

									@Override
									public String getDescription()
									{
										return "数据库文件(*.db)";
									}
								});
								int result = jfChooser.showOpenDialog(null);
								if (result == JFileChooser.APPROVE_OPTION)
								{
									File fileIn = jfChooser.getSelectedFile();
									String path = fileIn.getAbsolutePath().endsWith(".db") ? fileIn.getAbsolutePath() : fileIn.getAbsolutePath() + ".db";
									jTextField1.setText(path);
									jTextField1.repaint();
									Controller.dbPath = path;
								}
							}
						});
					}
					{
						jTextField1 = new JTextField();
						jPanel1.add(getJTextField1());
						File file = new File(Controller.dbPath);
						jTextField1.setText(file.getAbsolutePath());
						Controller.dbPath = jTextField1.getText();
						jTextField1.setBounds(10, 30, 302, 20);
						jTextField1.setEditable(false);
					}
					{
						jLabel1 = new JLabel();
						jPanel1.add(getJLabel1());
						jLabel1.setText("数据库位置: ");
						jLabel1.setLayout(null);
						jLabel1.setBounds(10, 10, 105, 15);
					}
					{
						jTextField2 = new JTextField();
						jPanel1.add(getJTextField2());
						jTextField2.setBounds(75, 63, 106, 21);
					}
					{
						jPasswordField1 = new JPasswordField();
						jTextField2.setNextFocusableComponent(jPasswordField1);
						jPanel1.add(jPasswordField1);
						jPasswordField1.setBounds(75, 93, 106, 21);
					}
					{
						jLabel2 = new JLabel();
						jPanel1.add(getJLabel2());
						jLabel2.setText("\u767b\u5f55\u5e10\u53f7");
						jLabel2.setLayout(null);
						jLabel2.setBounds(10, 63, 61, 21);
					}
					{
						jLabel3 = new JLabel();
						jPanel1.add(jLabel3);
						jLabel3.setText("\u767b\u5f55\u5bc6\u7801");
						jLabel3.setLayout(null);
						jLabel3.setBounds(10, 93, 59, 21);
					}
					{
						jButton2 = new JButton();
						jPasswordField1.setNextFocusableComponent(getJButton2());

						jPanel1.add(getJButton2());
						jButton2.setText("下载");
						jButton2.setBounds(191, 62, 85, 22);
						jButton2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if (!jButton2.isEnabled())
								{
									return;
								}
								System.out.println("下载按钮被点击了");
								String userId = jTextField2.getText();
								char[] passWdCh = jPasswordField1.getPassword();
								if (userId == null || userId.trim().length() == 0)
								{
									JOptionPane.showMessageDialog(jPanel1, "请输入您的新浪微博登录帐号!");
									return;
								}
								if (passWdCh == null || new String(passWdCh).trim().length() == 0)
								{
									JOptionPane.showMessageDialog(jPanel1, "请输入您的新浪微博登录密码!");
									return;
								}
								if (jCheckBox1.isSelected() && jTextField6.getText().trim().length() == 0)
								{
									JOptionPane.showMessageDialog(jPanel1, "请输入您要备份的好友名字!");
									return;
								}
								String[] info = new String[] { userId, new String(passWdCh) };
								jButton1.setEnabled(false);
								jButton2.setEnabled(false);
								jButton3.setEnabled(false);
								jTextField2.setEditable(false);
								jCheckBox1.setEnabled(false);
								jPasswordField1.setEditable(false);
								jTextField6.setEditable(false);
								Log.log("开始下载,正在连接网络请稍等...");
								controller.startDownload(info);
							}
						});
						jPasswordField1.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent evt) {
								if (evt.getKeyChar() == KeyEvent.VK_ENTER)
								{
									System.out.println("密码框被敲击了回车键");
									jButton2.doClick();
								}
							}
						});
						jButton2.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent evt) {
								if (evt.getKeyChar() == KeyEvent.VK_ENTER)
								{
									System.out.println("下载按钮被敲击了回车键");
									jButton2.doClick();
								}
							}
						});
					}
					{
						jButton3 = new JButton();
						jPanel1.add(getJButton3());
						jButton3.setText("\u5bfc\u51fa\u6570\u636e");
						jButton3.setBounds(291, 62, 93, 23);
						jButton3.setNextFocusableComponent(getJTextField2());
						jButton3.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								if (!jButton3.isEnabled())
								{
									return;
								}
								System.out.println("导出文件按钮被点击了");
								if ((!jCheckBox1.isSelected()) && (jTextField2.getText() == null || jTextField2.getText().trim().length() == 0))
								{
									JOptionPane.showMessageDialog(jPanel1, "请先在左侧帐号框输入要导出的帐号!");
									return;
								}
								String filePath = jTextField1.getText();
								File file = new File(filePath);
								if (!file.exists())
								{
									JOptionPane.showMessageDialog(jPanel1, "所选择的数据库文件不存在!");
									return;
								}
								FileOutput fo = new FileOutput();
								if (!fo.checkTable())
								{
									JOptionPane.showMessageDialog(jPanel1, "数据库中暂无备份信息,请先运行下载!");
									return;
								}
								if (jCheckBox1.isSelected() && jTextField6.getText().trim().length() == 0)
								{
									JOptionPane.showMessageDialog(jPanel1, "请输入您要备份的好友名字!");
									return;
								}
								jTextField3.setText(jTextField1.getText());
								jTextField4.setText(jTextField2.getText());
								if (jCheckBox1.isSelected())
								{
									jTextField4.setText(jTextField6.getText());
								}
								fo.showOptions();
							}
						});
					}
					{
						jScrollPane1 = new JScrollPane();
						jPanel1.add(getJScrollPane1());
						jScrollPane1.setBounds(10, 125, 374, 127);
						{
							jTextArea1 = new JTextArea();
							jScrollPane1.setViewportView(getJTextArea1());
							jTextArea1.setEditable(false);
							jTextArea1.setWrapStyleWord(true);
							jTextArea1.setColumns(50);
							jTextArea1.setLineWrap(true);
							jTextArea1.setText("\u63d0\u793a: \u9700\u8981\u4e0b\u8f7d\u5176\u4ed6\u7528\u6237\u6d88\u606f\u8bf7\u52fe\u9009\"\u597d\u53cbID\"\u6309\u94ae,\u8f93\u5165\u4efb\u610f\u7528\u6237\u7684\u540d\u5b57\u518d\u70b9\u51fb\u4e0b\u8f7d,\u5bfc\u51fa\u4e5f\u4e00\u6837..\r\n");
						}
					}
					{
						jLabel4 = new JLabel();
						jPanel1.add(getJLabel4());
						jLabel4.setText("@\u5468\u5c0f\u4f26Aloong , \u70b9\u51fb\u6211\u7684\u535a\u5ba2\u4e0b\u8f7d\u65b0\u7248: http://www.jayslong.cn");
						jLabel4.setBounds(10, 252, 364, 15);
						jLabel4.setEnabled(false);
						jLabel4.setFocusable(false);
						jLabel4.setFocusTraversalKeysEnabled(false);
						jLabel4.setRequestFocusEnabled(false);
						jLabel4.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								System.out.println("底部标签被点击了");
								try
								{
									Process process = Runtime.getRuntime().exec("cmd /c start http://www.blogjava.net/jayslong/archive/2010/11/17/sina_weibo_backup.html");
									process.waitFor();
								} catch (IOException e)
								{
									e.printStackTrace();
								} catch (InterruptedException e)
								{
									e.printStackTrace();
								}
							}
						});
					}
					{
						jCheckBox1 = new JCheckBox();
						jPanel1.add(getJCheckBox1());
						jCheckBox1.setText("\u597d\u53cbID");
						jCheckBox1.setBounds(309, 92, 75, 23);
						jCheckBox1.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								System.out.println("好友按钮被改变状态");
								if (evt.getStateChange() == ItemEvent.SELECTED)
								{
									jTextField6.setEnabled(true);
								} else
								{
									jTextField6.setEnabled(false);
								}
							}
						});
					}
					{
						jTextField6 = new JTextField();
						jPanel1.add(getJTextField6());
						jTextField6.setBounds(191, 93, 116, 21);
						jTextField6.setEnabled(false);
						jTextField6.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent evt) {
								if (evt.getKeyChar() == KeyEvent.VK_ENTER)
								{
									System.out.println("好友框被敲击了回车键");
									jButton2.doClick();
								}
							}
						});
					}
				}
				{
					jPanel2 = new JPanel();
					inst.getContentPane().add(getJPanel2());
					jPanel2.setBounds(0, 0, 394, 272);
					jPanel2.setLayout(null);
					jPanel2.setVisible(false);
					{
						jLabel5 = new JLabel();
						jPanel2.add(jLabel5);
						jLabel5.setText("\u6570\u636e\u5e93\u4f4d\u7f6e:");
						jLabel5.setLayout(null);
						jLabel5.setBounds(10, 10, 113, 15);
					}
					{
						jTextField3 = new JTextField();
						jPanel2.add(jTextField3);
						jTextField3.setText(jTextField1.getText());
						jTextField3.setBounds(10, 30, 374, 20);
						jTextField3.setEditable(false);
					}
					{
						jLabel6 = new JLabel();
						jPanel2.add(jLabel6);
						jLabel6.setText("\u5bfc\u51fa\u5e10\u53f7");
						jLabel6.setLayout(null);
						jLabel6.setBounds(10, 63, 65, 21);
					}
					{
						jTextField4 = new JTextField();
						jPanel2.add(jTextField4);
						jTextField4.setText(jTextField2.getText());
						jTextField4.setBounds(79, 63, 134, 21);
						jTextField4.setEditable(false);
					}
					{
						ComboBoxModel jComboBox1Model =
								new DefaultComboBoxModel(
										new String[] { "按时间逆序(默认)", "按时间顺序" });
						jComboBox1 = new JComboBox();
						jPanel2.add(jComboBox1);
						jComboBox1.setModel(jComboBox1Model);
						jComboBox1.setBounds(223, 63, 146, 21);
					}
					{
						jRadioButton1 = new JRadioButton();
						jPanel2.add(getJRadioButton1());
						jRadioButton1.setText("TXT");
						jRadioButton1.setBounds(10, 90, 53, 23);
						jRadioButton1.setSelected(true);
					}
					{
						jRadioButton2 = new JRadioButton();
						jPanel2.add(getJRadioButton2());
						jRadioButton2.setText("CSV");
						jRadioButton2.setBounds(62, 90, 53, 23);
					}
					{
						jRadioButton3 = new JRadioButton();
						jPanel2.add(getJRadioButton3());
						jRadioButton3.setText("XML");
						jRadioButton3.setBounds(117, 90, 53, 23);
					}
					{
						jRadioButton4 = new JRadioButton();
						jPanel2.add(getJRadioButton4());
						jRadioButton4.setText("HTML");
						jRadioButton4.setBounds(172, 90, 59, 23);
					}
					{
						buttonGroup1 = getButtonGroup1();
						buttonGroup1.add(jRadioButton1);
						buttonGroup1.add(jRadioButton2);
						buttonGroup1.add(jRadioButton3);
						buttonGroup1.add(jRadioButton4);
						jRadioButton4.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								System.out.println("HTML按钮被改变状态");
								if (evt.getStateChange() == ItemEvent.SELECTED)
								{
									jLabel7.setVisible(true);
									jTextField5.setVisible(true);
									jTextField5.setText("200");
								} else
								{
									jLabel7.setVisible(false);
									jTextField5.setVisible(false);
								}
							}
						});
					}
					{
						{
							jScrollPane2 = new JScrollPane();
							jPanel2.add(getJScrollPane2());
							jScrollPane2.setBounds(10, 115, 374, 117);
							{
								jTextArea2 = new JTextArea();
								jScrollPane2.setViewportView(getJTextArea2());
								jTextArea2.setEditable(false);
								jTextArea2.setWrapStyleWord(true);
								jTextArea2.setColumns(50);
								jTextArea2.setLineWrap(true);
								jTextArea2.setText("小提示: 点击新的\"下载图片\"按钮可以下载全部图片到本地,微博数超多的请勿轻易尝试..\n下载图片后再次导出的HTML格式文件自动使用本地图片.. \n已经下载过的图片不会重复下载..\n");
							}
						}
						{
							jButton5 = new JButton();
							jPanel2.add(getJButton5());
							jButton5.setText("\u5bfc\u51fa");
							jButton5.setBounds(223, 239, 67, 23);
							jButton5.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									if (!jButton5.isEnabled())
									{
										return;
									}
									System.out.println("导出按钮被点击了");
									jComboBox1.setEnabled(false);
									jButton5.setEnabled(false);
									jButton6.setEnabled(false);
									downImageButton.setEnabled(false);
									FileOutput.reverse = jComboBox1.getSelectedIndex() == 1 ? true : false;
									if (jRadioButton1.isSelected())
									{
										FileOutput.format = "TXT";
									} else if (jRadioButton2.isSelected())
									{
										FileOutput.format = "CSV";
									} else if (jRadioButton3.isSelected())
									{
										FileOutput.format = "XML";
									} else if (jRadioButton4.isSelected())
									{
										FileOutput.format = "HTML";
									}
									if (jRadioButton4.isSelected() && Integer.valueOf(jTextField5.getText()) < 20)
									{
										JOptionPane.showMessageDialog(null, "每个网页所包含的消息条数至少应大于20条..");
										jComboBox1.setEnabled(true);
										jButton5.setEnabled(true);
										jButton6.setEnabled(true);
										return;
									}
									FileOutput.startOutput();
								}
							});
						}
						{
							jButton6 = new JButton();
							jPanel2.add(getJButton6());
							jButton6.setText("\u8fd4\u56de");
							jButton6.setBounds(300, 239, 69, 23);
							jButton6.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									if (!jButton6.isEnabled())
									{
										return;
									}
									System.out.println("返回按钮被点击了");
									jPanel2.setVisible(false);
									jPanel1.setVisible(true);
								}
							});
						}
						{
							jLabel7 = new JLabel();
							jPanel2.add(getJLabel7());
							jLabel7.setText("\u8bf7\u8f93\u5165\u6bcf\u4e2a\u7f51\u9875\u5305\u542b\u7684\u6d88\u606f\u6761\u6570");
							jLabel7.setBounds(10, 243, 168, 15);
							jLabel7.setVisible(false);
						}
						{
							jTextField5 = new JTextField();
							jPanel2.add(getJTextField5());
							jTextField5.setText("200");
							jTextField5.setBounds(181, 240, 46, 21);
							jTextField5.setVisible(false);
							jTextField5.setDocument(new NumberLenghtLimitedDmt(5));
						}
						{
							downImageButton = new JButton();
							jPanel2.add(getDownImageButton());
							downImageButton.setText(" \u4e0b\u8f7d\u56fe\u7247");
							downImageButton.setBounds(282, 90, 87, 23);
							downImageButton.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									System.out.println("下载图片按钮被点击了!");
									if (!downImageButton.isEnabled())
									{
										return;
									}
									int opt = JOptionPane.showConfirmDialog(null, "下载全部图片可能需要较长时间", "提示:", JOptionPane.OK_CANCEL_OPTION);
									if (opt == 0)
									{
										jComboBox1.setEnabled(false);
										jButton5.setEnabled(false);
										jButton6.setEnabled(false);
										downImageButton.setEnabled(false);
										new DownloadImages().startDownload();
									}
								}
							});
						}
					}
				}
			}
		});
	}

	public TheFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setVisible(true);
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	public static JPanel getJPanel1() {
		return jPanel1;
	}

	public static JFileChooser getJFileChooser1() {
		return jFileChooser1;
	}

	public static JButton getJButton1() {
		return jButton1;
	}

	public static JTextField getJTextField1() {
		return jTextField1;
	}

	public static JLabel getJLabel1() {
		return jLabel1;
	}

	public static JTextField getJTextField2() {
		return jTextField2;
	}

	public static JLabel getJLabel2() {
		return jLabel2;
	}

	public static JPasswordField getJPasswordField1() {
		return jPasswordField1;
	}

	public static JButton getJButton2() {
		return jButton2;
	}

	public static JButton getJButton3() {
		return jButton3;
	}

	public static JScrollPane getJScrollPane1() {
		return jScrollPane1;
	}

	public static JTextArea getJTextArea1() {
		return jTextArea1;
	}

	public static JLabel getJLabel4() {
		return jLabel4;
	}

	public static JPanel getJPanel2() {
		return jPanel2;
	}

	public static JLabel getJLabel5() {
		return jLabel5;
	}

	public static JTextField getJTextField3() {
		return jTextField3;
	}

	public static JLabel getJLabel6() {
		return jLabel6;
	}

	public static JTextField getJTextField4() {
		return jTextField4;
	}

	public static JComboBox getJComboBox1() {
		return jComboBox1;
	}

	public static JRadioButton getJRadioButton1() {
		return jRadioButton1;
	}

	public static JRadioButton getJRadioButton2() {
		return jRadioButton2;
	}

	public static JRadioButton getJRadioButton3() {
		return jRadioButton3;
	}

	public static JRadioButton getJRadioButton4() {
		return jRadioButton4;
	}

	private static ButtonGroup getButtonGroup1() {
		if (buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

	public static JScrollPane getJScrollPane2() {
		return jScrollPane2;
	}

	public static JTextArea getJTextArea2() {
		return jTextArea2;
	}

	public static JButton getJButton5() {
		return jButton5;
	}

	public static JButton getJButton6() {
		return jButton6;
	}

	public static JLabel getJLabel7() {
		return jLabel7;
	}

	public static JTextField getJTextField5() {
		return jTextField5;
	}

	public static JCheckBox getJCheckBox1() {
		return jCheckBox1;
	}

	public static JTextField getJTextField6() {
		return jTextField6;
	}

	public static JButton getDownImageButton() {
		return downImageButton;
	}

}

class NumberLenghtLimitedDmt extends PlainDocument
{
	private static final long serialVersionUID = 1L;
	private int limit;

	public NumberLenghtLimitedDmt(int limit)
	{
		super();
		this.limit = limit;
	}

	public void insertString(int offset, String str, AttributeSet attr)
			throws BadLocationException
	{
		if (str == null)
		{
			return;
		}
		if ((getLength() + str.length()) <= limit)
		{

			char[] upper = str.toCharArray();
			int length = 0;
			for (int i = 0; i < upper.length; i++)
			{
				if (upper[i] >= '0' && upper[i] <= '9')
				{
					upper[length++] = upper[i];
				}
			}
			super.insertString(offset, new String(upper, 0, length), attr);
		}
	}
}
