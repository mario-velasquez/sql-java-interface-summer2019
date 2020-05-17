package guiPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.sql.*;
import javax.swing.JTextPane;

public class GuiInterface {

	private JFrame frame;
	private JTextField textFieldSQLusername;
	private JTextField textFieldSQLip;
	private JLabel lblMatrixSettings;
	private JLabel lblMatrixSizeNxn;
	private JTextField textFieldSize;
	private JLabel lblRandomRange;
	private JLabel lblLowestNumber;
	private JTextField textFieldlowest;
	private JLabel lblHighest;
	private JTextField textFieldHighest;
	private JTextField txtTrials;
	//table
	private JTable table;
	private JScrollPane scroll;private JScrollPane scroll1;
	private DefaultTableModel dm;private DefaultTableModel dm1;
	private String[] columnNames = {"Size","LowestRange","HighestRange","Determinant","isDeterminantZero?"};
	private String[] topCol1 = {"Determinent","Rate"};
	private Object[][] data={{"","","","",""}};
	private Object[][] data1={{"",""}};
	//sql
	private Connection con;
	private String ip = "35.224.155.120";
	private String pw = "sharpener";
	private String usr= "root";
	private String db = "determinants";
	//
	private JButton btnRefresh;
	private JButton btnDeleteAll;
	private JLabel sizeRefresh;
	private JLabel rangeRefresh;
	private JLabel rangeDeterminant;
	private JTextField textFieldSizeR;
	private JTextField textFieldRangeLR;
	private JTextField textFieldRangeHR;
	private JTextField textFieldDeterminantR;
	private JButton btnRefresh2;
	private JTextField textFieldCustomCommand;
	private JTextField textFieldSQLpassword;
	private JTextField textFieldSQLdatabase;
	private JTextField textFieldTDlow;
	private JTextField textFieldTDhigh;
	private JTextField textFieldTDsize;
	private JTable table_1;
	private JTextField textFieldFrequency;
	private JTextPane txtpnInfo;
	private JLabel lblFrequencyOutput;
	private JLabel lblFrequency;
	

	/**
	 * Launch the GuiInterface.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInterface window = new GuiInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the GuiInterface.
	 */
	public GuiInterface() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private void initialize() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		

		
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSqlSettings = new JLabel("SQL Settings");
		lblSqlSettings.setFont(new Font("Switzera ADF", Font.BOLD, 18));
		lblSqlSettings.setBounds(64, 0, 167, 34);
		frame.getContentPane().add(lblSqlSettings);
		
		JLabel lblUsername = new JLabel("username:");
		lblUsername.setFont(new Font("Switzera ADF", Font.PLAIN, 16));
		lblUsername.setBounds(12, 39, 91, 15);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setFont(new Font("Switzera ADF", Font.PLAIN, 16));
		lblPassword.setBounds(12, 74, 91, 15);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblIpAddress = new JLabel("ip address:");
		lblIpAddress.setToolTipText("Database's IP address");
		lblIpAddress.setFont(new Font("Switzera ADF", Font.PLAIN, 16));
		lblIpAddress.setBounds(12, 101, 91, 15);
		frame.getContentPane().add(lblIpAddress);
		
		textFieldSQLusername = new JTextField();
		textFieldSQLusername.setText("root");
		textFieldSQLusername.setBounds(121, 39, 124, 19);
		frame.getContentPane().add(textFieldSQLusername);
		textFieldSQLusername.setColumns(10);
		
		textFieldSQLip = new JTextField();
		textFieldSQLip.setText("35.224.155.120");
		textFieldSQLip.setBounds(121, 97, 124, 19);
		frame.getContentPane().add(textFieldSQLip);
		textFieldSQLip.setColumns(10);
		
		JButton btnSubmitSql = new JButton("Submit SQL ");
		btnSubmitSql.setBounds(64, 149, 139, 25);
		frame.getContentPane().add(btnSubmitSql);
		
		lblMatrixSettings = new JLabel("Matrix Settings");
		lblMatrixSettings.setFont(new Font("Switzera ADF", Font.BOLD, 18));
		lblMatrixSettings.setBounds(64, 204, 167, 34);
		frame.getContentPane().add(lblMatrixSettings);
		
		lblMatrixSizeNxn = new JLabel("Size (NxN)");
		lblMatrixSizeNxn.setVerticalAlignment(SwingConstants.TOP);
		lblMatrixSizeNxn.setFont(new Font("Switzera ADF", Font.PLAIN, 16));
		lblMatrixSizeNxn.setBounds(12, 250, 91, 15);
		frame.getContentPane().add(lblMatrixSizeNxn);
		
		textFieldSize = new JTextField();
		textFieldSize.setText("2");
		textFieldSize.setColumns(10);
		textFieldSize.setBounds(102, 246, 124, 19);
		frame.getContentPane().add(textFieldSize);
		
		lblRandomRange = new JLabel("Random Range");
		lblRandomRange.setFont(new Font("Switzera ADF", Font.BOLD, 18));
		lblRandomRange.setBounds(64, 277, 167, 34);
		frame.getContentPane().add(lblRandomRange);
		
		lblLowestNumber = new JLabel("Lowest");
		lblLowestNumber.setVerticalAlignment(SwingConstants.TOP);
		lblLowestNumber.setFont(new Font("Switzera ADF", Font.PLAIN, 16));
		lblLowestNumber.setBounds(12, 303, 91, 15);
		frame.getContentPane().add(lblLowestNumber);
		
		textFieldlowest = new JTextField();
		textFieldlowest.setText("-1");
		textFieldlowest.setColumns(10);
		textFieldlowest.setBounds(102, 302, 124, 19);
		frame.getContentPane().add(textFieldlowest);
		
		lblHighest = new JLabel("Highest");
		lblHighest.setVerticalAlignment(SwingConstants.TOP);
		lblHighest.setFont(new Font("Switzera ADF", Font.PLAIN, 16));
		lblHighest.setBounds(12, 328, 91, 15);
		frame.getContentPane().add(lblHighest);
		
		textFieldHighest = new JTextField();
		textFieldHighest.setText("1");
		textFieldHighest.setToolTipText("");
		textFieldHighest.setColumns(10);
		textFieldHighest.setBounds(102, 323, 124, 19);
		frame.getContentPane().add(textFieldHighest);
		
		JButton btnGenerate = new JButton("Generate");
		
		
		btnGenerate.setBounds(74, 402, 139, 25);
		frame.getContentPane().add(btnGenerate);
		
		txtTrials = new JTextField();
		txtTrials.setText("1");
		txtTrials.setBounds(64, 371, 139, 19);
		frame.getContentPane().add(txtTrials);
		txtTrials.setColumns(10);
		
		table = new JTable();
		dm = new DefaultTableModel(data, columnNames);
		table.setModel(dm);
		table.setBounds(360, 33, 498, 422);
		frame.getContentPane().add(table);
		scroll = new JScrollPane(table);
		scroll.setBounds(257, 28, 495, 399);
		frame.getContentPane().add(scroll);
		
		btnRefresh = new JButton("Refresh All");
		btnRefresh.setBounds(647, 0, 114, 25);
		frame.getContentPane().add(btnRefresh);
		
		btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.setBounds(522, 0, 114, 25);
		frame.getContentPane().add(btnDeleteAll);
		
		JLabel lblTrials = new JLabel("Trials");
		lblTrials.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrials.setVerticalAlignment(SwingConstants.TOP);
		lblTrials.setFont(new Font("Switzera ADF", Font.BOLD, 16));
		lblTrials.setBounds(64, 352, 139, 19);
		frame.getContentPane().add(lblTrials);
		
		sizeRefresh = new JLabel("Size");
		sizeRefresh.setHorizontalAlignment(SwingConstants.RIGHT);
		sizeRefresh.setVerticalAlignment(SwingConstants.TOP);
		sizeRefresh.setFont(new Font("Switzera ADF", Font.PLAIN, 16));
		sizeRefresh.setBounds(370, 439, 91, 15);
		frame.getContentPane().add(sizeRefresh);
		
		rangeRefresh = new JLabel("Range");
		rangeRefresh.setHorizontalAlignment(SwingConstants.RIGHT);
		rangeRefresh.setVerticalAlignment(SwingConstants.TOP);
		rangeRefresh.setFont(new Font("Switzera ADF", Font.PLAIN, 16));
		rangeRefresh.setBounds(380, 462, 91, 19);
		frame.getContentPane().add(rangeRefresh);
		
		rangeDeterminant = new JLabel("Determinant");
		rangeDeterminant.setHorizontalAlignment(SwingConstants.RIGHT);
		rangeDeterminant.setVerticalAlignment(SwingConstants.TOP);
		rangeDeterminant.setFont(new Font("Switzera ADF", Font.PLAIN, 16));
		rangeDeterminant.setBounds(360, 486, 111, 15);
		frame.getContentPane().add(rangeDeterminant);
		
		textFieldSizeR = new JTextField();
		textFieldSizeR.setBounds(479, 439, 124, 19);
		frame.getContentPane().add(textFieldSizeR);
		textFieldSizeR.setColumns(10);
		
		textFieldRangeLR = new JTextField();
		textFieldRangeLR.setBounds(479, 461, 124, 19);
		frame.getContentPane().add(textFieldRangeLR);
		textFieldRangeLR.setColumns(10);
		
		textFieldRangeHR = new JTextField();
		textFieldRangeHR.setBounds(615, 461, 124, 19);
		frame.getContentPane().add(textFieldRangeHR);
		textFieldRangeHR.setColumns(10);
		
		textFieldDeterminantR = new JTextField();
		textFieldDeterminantR.setBounds(479, 485, 124, 19);
		frame.getContentPane().add(textFieldDeterminantR);
		textFieldDeterminantR.setColumns(10);
		
		btnRefresh2 = new JButton("Refresh");
		btnRefresh2.setBounds(267, 439, 114, 25);
		frame.getContentPane().add(btnRefresh2);
		
		textFieldCustomCommand = new JTextField();
		textFieldCustomCommand.setBounds(788, 482, 249, 19);
		frame.getContentPane().add(textFieldCustomCommand);
		textFieldCustomCommand.setColumns(10);
		
		JButton btnSubmitCustomCommand = new JButton("Submit Custom Command");
		btnSubmitCustomCommand.setBounds(1049, 476, 213, 25);
		frame.getContentPane().add(btnSubmitCustomCommand);
		
		textFieldSQLpassword = new JTextField();
		textFieldSQLpassword.setText("sharpener");
		textFieldSQLpassword.setColumns(10);
		textFieldSQLpassword.setBounds(121, 70, 124, 19);
		frame.getContentPane().add(textFieldSQLpassword);
		
		JLabel lblDatabase = new JLabel("database:");
		lblDatabase.setToolTipText("Database's IP address");
		lblDatabase.setFont(new Font("Switzera ADF", Font.PLAIN, 16));
		lblDatabase.setBounds(12, 122, 91, 15);
		frame.getContentPane().add(lblDatabase);
		
		textFieldSQLdatabase = new JTextField();
		textFieldSQLdatabase.setText("determinants");
		textFieldSQLdatabase.setColumns(10);
		textFieldSQLdatabase.setBounds(121, 118, 124, 19);
		frame.getContentPane().add(textFieldSQLdatabase);
		
		textFieldTDlow = new JTextField();
		textFieldTDlow.setBounds(994, 27, 124, 19);
		frame.getContentPane().add(textFieldTDlow);
		textFieldTDlow.setColumns(10);
		
		textFieldTDhigh = new JTextField();
		textFieldTDhigh.setBounds(1121, 27, 124, 19);
		frame.getContentPane().add(textFieldTDhigh);
		textFieldTDhigh.setColumns(10);
		
		textFieldTDsize = new JTextField();
		textFieldTDsize.setBounds(994, 51, 124, 19);
		frame.getContentPane().add(textFieldTDsize);
		textFieldTDsize.setColumns(10);
		
		JLabel lblRange = new JLabel("Range");
		lblRange.setHorizontalAlignment(SwingConstants.CENTER);
		lblRange.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRange.setFont(new Font("Switzera ADF", Font.PLAIN, 18));
		lblRange.setBounds(858, 20, 167, 34);
		frame.getContentPane().add(lblRange);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setFont(new Font("Switzera ADF", Font.PLAIN, 18));
		lblSize.setBounds(858, 39, 167, 34);
		frame.getContentPane().add(lblSize);
		
		JLabel lblDeterminent = new JLabel("Determinent Frequency");
		lblDeterminent.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDeterminent.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeterminent.setFont(new Font("Switzera ADF", Font.PLAIN, 18));
		lblDeterminent.setBounds(759, 79, 222, 25);
		frame.getContentPane().add(lblDeterminent);
		
		table_1 = new JTable();
		table_1.setBounds(1121, 74, 124, 200);
		frame.getContentPane().add(table_1);
		scroll1 = new JScrollPane(table_1);
		dm1 = new DefaultTableModel(data1, topCol1);
		table_1.setModel(dm1);
		scroll1 = new JScrollPane(table_1);
		scroll1.setBounds(808, 153, 212, 190);
		frame.getContentPane().add(scroll1);
		
		JButton btnRangeGen = new JButton("Get Info");
		btnRangeGen.setBounds(1148, 70, 97, 19);
		frame.getContentPane().add(btnRangeGen);
		
		textFieldFrequency = new JTextField();
		textFieldFrequency.setText("0");
		textFieldFrequency.setColumns(10);
		textFieldFrequency.setBounds(994, 82, 124, 19);
		frame.getContentPane().add(textFieldFrequency);
		
		txtpnInfo = new JTextPane();
		txtpnInfo.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
		txtpnInfo.setBounds(1068, 149, 177, 191);
		frame.getContentPane().add(txtpnInfo);
		
		lblFrequencyOutput = new JLabel("0");
		lblFrequencyOutput.setBounds(994, 99, 66, 15);
		frame.getContentPane().add(lblFrequencyOutput);
		
		lblFrequency = new JLabel("Frequency :");
		lblFrequency.setBounds(890, 99, 91, 15);
		frame.getContentPane().add(lblFrequency);
		
		btnSubmitSql.addActionListener(new ButtonSubmitSQLClicked());
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.con = DriverManager.getConnection("jdbc:mysql://35.224.155.120:3306/determinants", "root", "sharpener");
		btnGenerate.addActionListener(new ButtonGenerateClicked());
		btnRefresh.addActionListener(new ButtonRefreshClicked());
		btnRefresh2.addActionListener(new ButtonRefresh2Clicked());
		btnSubmitCustomCommand.addActionListener(new ButtonSCCClicked());
		btnDeleteAll.addActionListener(new ButtonDeleteAllClicked());
		
		btnRangeGen.addActionListener(new ButtonTopDetClicked());
		
	}
		public class ButtonTopDetClicked implements ActionListener{
			public void actionPerformed(ActionEvent Arg0) {
				try {
					TopDet();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public void TopDet() throws SQLException {
			
			int Array[][] = rsToArray();
			//display(Array);
			
			String low = textFieldTDlow.getText();
			String high = textFieldTDhigh.getText();
			String size = textFieldTDsize.getText();;
			String Freq = textFieldFrequency.getText();
			int max,min,avgDet,hiDet,loDet,cmnDet,total,count,freqCount;
			max = min = avgDet = hiDet = loDet = cmnDet = total = count=freqCount =0;
			
			ArrayList<Integer> al = new ArrayList<Integer>();
			
			if(!low.isBlank() && !high.isBlank() && !size.isBlank()) {// Everything is filled in
				for(int i = 0; i < rowChecker(); i++) { //Finds the first elemens with the same range
					if(Integer.parseInt(low) == Array[i][1] && Integer.parseInt(high) == Array[i][2] && Integer.parseInt(size) == Array[i][0]) {
						max = Array[i][3];
						min = Array[i][3];
						break;
					}
				}
				
				for(int i = 0; i < rowChecker(); i++) {
					if(Integer.parseInt(low) == Array[i][1] && Integer.parseInt(high) == Array[i][2] && Integer.parseInt(size) == Array[i][0]) {
						if(Array[i][3] > max ) {
							max = Array[i][3];
						}
						if(Array[i][3] < min ) {
							min = Array[i][3];
						}
						if(Integer.parseInt(Freq) == Array[i][3]) {
							freqCount++;
						}
						
						total += Array[i][3];
						al.add(Array[i][3]);
						count++;
					}
				}
			}
			
			else if(low.isBlank() && high.isBlank() && !size.isBlank()) { //if size is filled in
				
					for(int i = 0; i < rowChecker(); i++) { //Finds the first element with the same size
						if(Integer.parseInt(size) == Array[i][0]) {
							max = Array[i][3];
							min = Array[i][3];
							break;
						}
					}
					
					for(int i = 0; i < rowChecker(); i++) {
						if(Integer.parseInt(size) == Array[i][0]) {
							if(Array[i][3] > max ) {
								max = Array[i][3];
							}
							if(Array[i][3] < min ) {
								min = Array[i][3];
							}
							if(Integer.parseInt(Freq) == Array[i][3]) {
								freqCount++;
							}
							
							total += Array[i][3];
							count++;
							al.add(Array[i][3]);
						}
					}
			}
			
			else if(!low.isBlank() && !high.isBlank() && size.isBlank()) {//if range is filled up
				
				for(int i = 0; i < rowChecker(); i++) { //Finds the first elemens with the same range
					if(Integer.parseInt(low) == Array[i][1] && Integer.parseInt(high) == Array[i][2]) {
						max = Array[i][3];
						min = Array[i][3];
						break;
					}
				}
				
				for(int i = 0; i < rowChecker(); i++) {
					if(Integer.parseInt(low) == Array[i][1] && Integer.parseInt(high) == Array[i][2]) {
						if(Array[i][3] > max ) {
							max = Array[i][3];
						}
						if(Array[i][3] < min ) {
							min = Array[i][3];
						}
						if(Integer.parseInt(Freq) == Array[i][3]) {
							freqCount++;
						}
						
						total += Array[i][3];
						count++;
						al.add(Array[i][3]);
					}
				}
			}
			
			
			
			double frequency = 0;
			double avg = 0;
			if(count != 0 || total !=0) {
			avg = ((double)total/(double)count);
			frequency = ((double)freqCount/(double)count)*100;
			}
		    DecimalFormat df = new DecimalFormat("0.00");
		    
			
			///// Find the most common values
			int determinants[] = new int[count];
			for(int i = 0; i < count;i++) {
				determinants[i] = al.get(i);
			}
			
			Arrays.sort(determinants);
			
			HashMap<Integer, Integer> map = new HashMap<>();
			
			int first,second,third;
			first = second = third = 0;
			int firstCount,secondCount,thirdCount;
			firstCount=secondCount=thirdCount = 0;
			
			first = determinants[0];
			second = first = third;
			for(int i =0 ; i  < count; i++) {				
				
				Integer j = map.get(determinants[i]);
				if(map.get(determinants[i]) == null) {
					map.put(determinants[i], 1);
				}
				else {
					map.put(determinants[i], ++j);
				}
				
			}
	        
	        Map<Integer, Integer> sortedMap = sortByValue(map);
			map = (HashMap<Integer, Integer>) sortedMap;
			int[][] frequencies = new int[map.size()][2];
			Set entries = map.entrySet();
			Iterator entriesIterator = entries.iterator();
			int a = 0;
			while(entriesIterator.hasNext()){

			    Map.Entry mapping = (Map.Entry) entriesIterator.next();

			    frequencies[a][0] = (int) mapping.getKey();
			    frequencies[a][1] = (int) mapping.getValue();

			    a++;
			}
			System.out.println("For Loop...");
			int len = frequencies.length;
			if(len > 100) len = 100;
			Object[][] data1 = new Object[len][2];
			int e = 0;
			for(int i = frequencies.length-1; i > -1; i--) {
				data1[i][0] = frequencies[e][0];
				data1[i][1] = df.format(((double)frequencies[e][1])/(double)count*100)  + "%";
				e++;
			}
			cmnDet = (int) data1[0][0];
			txtpnInfo.setText("\nMode:   " + cmnDet
							+ "\n\nAverage:" + df.format(avg)
							+ "\n\nHighest:" + max
							+ "\n\nLowest  " + min
							+ "\n\nRange:  " + (max-min));
			System.out.println("Hi/Lo-Gen Has Been Pressed");
			
			lblFrequencyOutput.setText(df.format(frequency)+"%");
			
			dm1.setDataVector(data1, topCol1);
			dm1.fireTableDataChanged();
		}
		
	    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) { 
	        List<Map.Entry<Integer, Integer> > list =  new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet()); 
	        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
	            public int compare(Map.Entry<Integer, Integer> o1,Map.Entry<Integer, Integer> o2){ 
	                return (o1.getValue()).compareTo(o2.getValue()); 
	            } 
	        }); 
	        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
	        for (Map.Entry<Integer, Integer> aa : list) { 
	            temp.put(aa.getKey(), aa.getValue()); 
	        } 
	        return temp;
	    }
	  
		
		public class ButtonGenerateClicked implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Insert();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				System.out.println("Generate has been pressed");}}
		
		public class ButtonSCCClicked implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Custom();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();}}}
		public void Custom() throws SQLException {
			Statement st = con.createStatement();
			st.executeUpdate(textFieldCustomCommand.getText());
			Refresh();
		}
		
		public class ButtonSubmitSQLClicked implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					SubmitSQL();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				System.out.println("SubmitSQL has been pressed");}}
		public void SubmitSQL() throws SQLException{
			String ip = "35.224.155.120";
			String pw = "sharpener";
			String usr= "root";
			String db = "determinants";
			if(!textFieldSQLpassword.getText().isBlank()&&!textFieldSQLusername.getText().isBlank()&&!textFieldSQLip.getText().isBlank()&&!textFieldSQLdatabase.getText().isBlank()) {
				ip =textFieldSQLip.getText();
				pw =textFieldSQLpassword.getText();
				usr=textFieldSQLusername.getText();
				db =textFieldSQLdatabase.getText();
			}
			this.con = DriverManager.getConnection("jdbc:mysql://"+ip+":3306/"+db+"", ""+usr+"", ""+pw+"");
		}
		
		public class ButtonRefreshClicked implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Refresh();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		public class ButtonRefresh2Clicked implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Refresh2();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}		
		
		public class ButtonDeleteAllClicked implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					DeleteAll();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("DeleteAll has been pressed");}}
		
		public void DeleteAll() throws SQLException{
			Statement st = con.createStatement();
			st.executeUpdate("TRUNCATE TABLE results");
			Refresh();
		}
		public int rowChecker() throws SQLException{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from results"); //* means every column
			int r = 0;
			while(rs.next()) r++;
			return r;
		}
		public void Refresh() throws SQLException{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from results"); //* means every column
			
			int rows = rowChecker();
			int limit = 100000;
			if (rows > limit) rows = limit;
			Object[][] data = new Object[rows][5];
			int count = 0;
			while(rs.next()){
				
				for(int x = 0; x <= 4; x++)
					data[count][x] = rs.getObject(x+1);
				count++;
				if(count == rows) break;
			}
			dm.setDataVector(data, columnNames);
			dm.fireTableDataChanged();
		}
		public int rowChecker2() throws SQLException{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from results"); //* means every column
			int r = 0;
			while(rs.next()) r++;
			return r;
		}
		
		public void Refresh2() throws SQLException{
			Statement st = con.createStatement();
			
			String size = textFieldSizeR.getText();
			String lowR = textFieldRangeLR.getText();
			String highR= textFieldRangeHR.getText();
			String det	= textFieldDeterminantR.getText();
			String Query = "SELECT * FROM results ";
			
			if(!size.isEmpty() && lowR.isEmpty() && highR.isEmpty() && det.isEmpty()) // Size Only
				Query = ("SELECT * FROM results WHERE size = " + "'"+size+"';");
			
			else if(size.isEmpty() && lowR.isEmpty() && highR.isEmpty() && !det.isEmpty()) // Determinant Only
				Query = "SELECT * FROM results WHERE determinant = " + "'"+det+"';";
			
			else if(size.isEmpty() && !lowR.isEmpty() && !highR.isEmpty() && det.isEmpty()) // Range Only
				Query = "SELECT * FROM results WHERE lowestRange = " + "'"+lowR+"' AND highestRange = " + "'"+highR +"';";
			
			else if(!size.isEmpty() && lowR.isEmpty() && highR.isEmpty() && !det.isEmpty()) { // Size && Determinant
				Query = ("SELECT * FROM results WHERE size = " + "'"+size+"'");Query += " AND determinant = " + "'"+det+"';";}
			
			else if(!size.isEmpty() && !lowR.isEmpty() && !highR.isEmpty() && det.isEmpty()) { // Size && Range
				Query = ("SELECT * FROM results WHERE size = " + "'"+size+"'"); Query += " AND lowestRange = " + "'"+lowR+"' AND highestRange = " + "'"+highR +"';";}
				
			else if(size.isEmpty() && !lowR.isEmpty() && !highR.isEmpty() && !det.isEmpty()) { // Determinant && Range
				Query = ("SELECT * FROM results WHERE determinant = " + "'"+det+"'"); Query += " AND lowestRange = " + "'"+lowR+"' AND highestRange = " + "'"+highR +"';";}
			
			
			ResultSet rs = st.executeQuery(Query);
			
			int rows = rowChecker();
			int limit = 100000;
			if (rows > limit) rows = limit;
			Object[][] data = new Object[rows][5];
			int count = 0;
			while(rs.next()){
				
				for(int x = 0; x <= 4; x++)
					data[count][x] = rs.getObject(x+1);
				count++;
				if(count == rows) break;
			}
			dm.setDataVector(data, columnNames);
			dm.fireTableDataChanged();
		}
		
		
		public void Insert() throws SQLException{
			long start =System.currentTimeMillis();
			Statement st = con.createStatement();
			//Retrieving the Size
			int n = Integer.parseInt(textFieldSize.getText());
			
			int[][] matrix = new int[n][n];//line 792
			//Filling in the Matrix
			for(int i = 0; i < Integer.parseInt(txtTrials.getText()); i++) {
				func.fillWithRandom(matrix, n, textFieldlowest.getText(), textFieldHighest.getText());
				int determinant = func.determinantOfMatrix(matrix, n);
				
				String command;
				if (determinant != 0) command = "INSERT INTO results VALUES ('"+ n +"','"+ textFieldlowest.getText() +"','"+textFieldHighest.getText()+"','"+determinant+"','');";
				else command = "INSERT INTO results VALUES ('"+ n +"','"+ textFieldlowest.getText() +"','"+textFieldHighest.getText()+"','"+determinant+"', b'1');";
				
				
				st.executeUpdate(command);
				
				Refresh();
			}
			long finish =System.currentTimeMillis();
			long timeElapsed = finish - start;
			System.out.println("Elapsed time: " + (timeElapsed/1000)/60 + " min(s) " + timeElapsed/1000 + " seconds " + timeElapsed + " milesconds");
		}
		
		public int[] giveDeterminantInArray () throws SQLException {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from results"); //* means every column
			ArrayList<Integer> al = new ArrayList<Integer>();
			int i = 0;
			while(rs.next()) {
				al.add(rs.getInt(4));
				i++;
			}
			int[] returned = new int[i];
			for(int j = 0; j < al.size();j++)
				returned[j] = al.get(j);
			System.out.println("ArraySize = " + returned.length + "\n ArrayList Size = " + al.size());
			return returned;
		}
		
		public int[][] rsToArray() throws SQLException{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from results"); //* means every column
			int AmountOfRows = rowChecker();
			int[][] array = new int[AmountOfRows][5];
			int r = 0;
			while(rs.next()) {
				array[r][0]= rs.getInt(1); //Size
				array[r][1]= rs.getInt(2); //L
				array[r][2]= rs.getInt(3); //H
				array[r][3]= rs.getInt(4); //D
				array[r][4]= rs.getInt(5); //B
				r++;
			}
			System.out.println("Size of Data to Multi-Dimensional Array: "+array.length);
			return array;
		}
		
		public void display(int[][] arr) throws SQLException {
			for(int i = 0; i < rowChecker();i++) {
				for(int j = 0; j < 5; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
}
