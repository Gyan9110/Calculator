package cals;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{
	
	static JFrame f; // Creating a frame
	static JTextField l; // Creating a text field
	String s0, s1 ,s2;   // for storing operands and operator
	
	Calculator(){
		s0 = s1 = s2 = "";
	}

	public static void main(String[] args) {
		f = new JFrame("Calculator");
		try {    // setting look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		Calculator c = new Calculator();  // Creating an object of the class
		l = new JTextField(16);		// Creating text field
		l.setEditable(false);		// setting the text field not editable
		
		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		beq1 = new JButton("=");
		ba = new JButton("+");
		bs = new JButton("-");
		bm = new JButton("*");
		bd = new JButton("/");
		beq = new JButton("C");
		be = new JButton(".");
		
		JPanel p = new JPanel();   // Creating a panel
		b0.addActionListener(c);
		b1.addActionListener(c);
		b2.addActionListener(c);
		b3.addActionListener(c);
		b4.addActionListener(c);
		b5.addActionListener(c);	// adding ActionListner to all
		b6.addActionListener(c);
		b7.addActionListener(c);
		b8.addActionListener(c);
		b9.addActionListener(c);
		ba.addActionListener(c);
		bs.addActionListener(c);
		bm.addActionListener(c);
		bd.addActionListener(c);
		be.addActionListener(c);
		beq.addActionListener(c);
		beq1.addActionListener(c);
		
		p.add(l);
		p.add(bm);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(ba);
		p.add(b4);   // Adding buttons to panel
		p.add(b5);
		p.add(b6);
		p.add(bs);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bd);
		p.add(be);
		p.add(b0);
		p.add(beq);
		p.add(beq1);
		
		p.setBackground(Color.black); 	// Setting background color of the panel
		
		f.add(p); 	// Adding panel to the Frame
		
		f.setSize(200, 220);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
		f.setVisible(true); // Make the frame visible

	}
	
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if ((s.charAt(0)>= '0' && s.charAt(0)<= '9' || s.charAt(0)=='.')) { // if value is a no.
			if (!s1.equals(""))  // if operand is present then add to second no.
				s2 = s2 + s;
			else
				s0 = s0 + s;
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0)=='C') {
			s0 = s1 = s2 = "";
			l.setText(s0+s1+s2);
		}
		else if (s.charAt(0)=='=') {
			double te;
			if (s1.equals("+")) 
				te = (Double.parseDouble(s0)+Double.parseDouble(s2));
			else if (s1.equals("-")) 
				te = (Double.parseDouble(s0)-Double.parseDouble(s2));
			else if (s1.equals("/")) 
				te = (Double.parseDouble(s0)/Double.parseDouble(s2));
			else 
				te = (Double.parseDouble(s0)*Double.parseDouble(s2));
			l.setText(s0+s1+s2+"="+te);
			s0 = Double.toString(te);
			s1 = s2 = "";
		}
		else {		// if there was no operator
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			else {
				double te;
				if (s1.equals("+")) 
					te = (Double.parseDouble(s0)+Double.parseDouble(s2));
				else if (s1.equals("-")) 
					te = (Double.parseDouble(s0)-Double.parseDouble(s2));
				else if (s1.equals("/")) 
					te = (Double.parseDouble(s0)/Double.parseDouble(s2));
				else 
					te = (Double.parseDouble(s0)*Double.parseDouble(s2));
				s0 = Double.toString(te);
				s1 = s;     // place the operator
				s2 = "";	// make the operand blank
			}
			l.setText(s0+ s1+ s2);
		}
	}

}


