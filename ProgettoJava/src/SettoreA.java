import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class SettoreA extends JFrame implements ItemListener, ActionListener {

	private static final long serialVersionUID=1L;
	SettoreA settoreA=this;
	JButton ok;
	JButton annulla;
	JToggleButton[][] seats=new JToggleButton[10][10];
	String[] column = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
	String[] row = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
	int selectedItems=0;
	JLabel seatsLabel;
	ArrayList<String> vetpos=new ArrayList<String>(8);

	int i;
	int j;
	
	public SettoreA(){
		super("Posti");
		setLayout(new FlowLayout());
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(300,100);
		setVisible(true);
		vetpos.add("A1");
		System.out.println(vetpos.get(vetpos.size()-1));
		JPanel ptop=new JPanel(); JPanel pmid=new JPanel(); JPanel pdown=new JPanel();
		pmid.setLayout(new GridLayout(10,10));
		JLabel top=new JLabel("Scegli i posti");
		top.setFont(new Font("Helvetica", Font.BOLD,18));
		ptop.add(top);
		for (i = 0; i < column.length; i++) {
		      for (j = 0; j < row.length; j++) {
		        //CREAZIONE SEDILI
		    	  seats[i][j] = new JToggleButton (column[i] + row[j]);
		    	  pmid.add(seats[i][j]);
		    	  String app=String.valueOf(i);
		    	  app.concat(String.valueOf(j));
		    	  
		    	  if(esiste(app)) seats[i][j].setBackground(Color.MAGENTA);
		    	  else
		    	  seats[i][j].addItemListener(this);
		    	  									}
		      									}
		seatsLabel=new JLabel();
		pdown.setLayout(new FlowLayout());
		pdown.add(seatsLabel);
		ok=new JButton("OK");
		pdown.add(ok);
		ok.addActionListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent e2){
				if(e2.getSource()==ok){
					for(i=0;i<column.length;i++){
						for(j=0;j<row.length;j++){
							
						}
					}
				}
				
			}
		});
		add(ptop, BorderLayout.NORTH); add(pmid, BorderLayout.CENTER); add(pdown, BorderLayout.SOUTH);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
				int status=e.getStateChange();
				if(status==ItemEvent.SELECTED){
				((JToggleButton) e.getItem()).setForeground(Color.ORANGE);
	
				selectedItems++;
				seatsLabel.setText("Posti selezionati: "+ String.valueOf(selectedItems));
				String a=((JToggleButton) e.getItem()).getText();
				vetpos.add(a);
				System.out.println(vetpos);
											  }	
				
				else if(status==ItemEvent.DESELECTED){
				((JToggleButton) e.getItem()).setForeground(Color.BLACK);
				selectedItems--;
				seatsLabel.setText("Posti selezionati: "+ String.valueOf(selectedItems));
				String a=((JToggleButton) e.getItem()).getText();
				vetpos.remove(a);
				System.out.println(vetpos);
				}
				if(selectedItems==0){seatsLabel.setText("");}
				
				
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean esiste(String s){
		boolean b=false;
		for(int i=0;i<vetpos.size();i++){
			if (vetpos.get(i).equals(s))b=true;
		}
		return b;
	}
}