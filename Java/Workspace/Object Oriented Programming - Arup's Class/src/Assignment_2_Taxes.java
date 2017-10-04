/*  Name:     Kelsey Cameron
     Course:	Getting ahead for OOP 1
     TA:		N/A
     Assignment title:	Taxes
     Compiler Used:		?
     Date:	6/24/15
*/





// Reference the required Java libraries import java.applet.Applet; 
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//The applet code 

public class Assignment_2_Taxes extends Applet {
	public void paint(Graphics g) { // Draw a rectangle width=250, height=100
		g.drawRect(0, 0, 500, 500);
		// Set the color to blue
		g.setColor(Color.blue);
		// //Write the message to the web page

		g.drawString(
				"Please enter your gross income, the # of dependents, and tax withheld.",
				10, 100);

	}

	public void init() {

		addItem("initializing the apple ");

		TextField gross_inc = new TextField(10);
		TextField depends = new TextField(10);
		TextField taxwithheld = new TextField(10);
		TextField output = new TextField(10);
		output.setEditable(false);
		Button b = new Button("Get my tax values!");

		add(gross_inc);
		add(depends);
		add(taxwithheld);
		add(b);
		add(output);

		getTaxes ca = new getTaxes(gross_inc, depends, taxwithheld, output);
		b.addActionListener(ca);
		gross_inc.addActionListener(ca);
		depends.addActionListener(ca);
		taxwithheld.addActionListener(ca);
	}

	public void start() {
		addItem("starting the applet ");
	}

	public void stop() {
		addItem("stopping the applet ");
	}

	public void destroy() {
		addItem("unloading the applet");
	}

	void addItem(String word) {
		System.out.println(word);
		repaint();
	}



}

class getTaxes implements ActionListener {

	private TextField gross_inc;
	private TextField depends;
	private TextField taxwithheld;
	private TextField output;

	public getTaxes(TextField gross_inc, TextField depends,
			TextField taxwithheld, TextField output) {

		this.gross_inc = gross_inc;
		this.depends = depends;
		this.taxwithheld = taxwithheld;
		this.output = output;
	}

	public void actionPerformed(ActionEvent ae) {

		int gross = Integer.parseInt(gross_inc.getText());
		int dep = Integer.parseInt(depends.getText());
		int withheld = Integer.parseInt(taxwithheld.getText());
		
		double tax_owed = getTaxVals(gross, dep, withheld);
		
		 output.setText(Double.toString(tax_owed));

	}
	
	
	public static double getTaxVals(int gross_in, int dep, int taxwith) {

		int aTi = gross_in - 2500 * dep; // adjustedTaxableIncome
		double amount_owed = 0.0;
		

			if (aTi > 60000) {
				amount_owed += (aTi - 60000) * 0.35;
				amount_owed += (60000 - 35000) * 0.3;
				amount_owed += (35000 - 20000) * 0.25;
				amount_owed += (20000 - 5000) * 0.15;
				System.out.println("You owe " + amount_owed + "so far.");

			} else if (aTi > 35000 && aTi <= 60000) {
				amount_owed += (aTi - 35000) * 0.3;
				amount_owed += (35000 - 20000) * 0.25;
				amount_owed += (20000 - 5000) * 0.15;
				System.out.println("You owe " + amount_owed + "so far.");

			} else if (aTi > 20000 && aTi <= 35000) {
				amount_owed += (aTi - 20000) * 0.25;
				amount_owed += (20000 - 5000) * 0.15;


				System.out.println("You owe " + amount_owed + "so far.");

			} else if (aTi > 5000 && aTi <= 20000) {
				amount_owed += (aTi - 5000) * 0.15;

				System.out.println("You owe " + amount_owed + "so far.");

			}

			else if (aTi > 0 && aTi <= 5000) {
				amount_owed += (aTi - 0) * 0;

				System.out.println("You owe " + amount_owed + "so far.");
			}
		
			double t = (double)taxwith;
		return t - amount_owed;
	}
}