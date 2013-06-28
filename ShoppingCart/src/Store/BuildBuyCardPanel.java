package Store;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;
//SATISFIES ASSESSMENT CRITERIA 1.1
public class BuildBuyCardPanel extends JPanel {
	// SATISFIES ASSESSMENT CRITERIA 1.2
	private static final long serialVersionUID = 1L;
	private ArrayList<Product> productOptions = new ArrayList<Product>();
	private Integer[] quantity = {1,2,3,4,5,6,7,8,9,10};
	
	private DecimalFormat myFormatter = new DecimalFormat("####.00");
	
	private JComboBox<String> optionsList;
	private JComboBox<Integer> quantityList;
	
	BuildBuyCardPanel(ArrayList<Product> a) {
		super();
		productOptions = a;
		buildNewOptions();
	}
	
	private String[] constructOptions(ArrayList<Product> products) {
		ArrayList<String> info = new ArrayList<String>();
		for (Product p : products) {
			info.add(p.getProductName() + ": £" + myFormatter.format(p.getProductPrice()));
		}
		
		String[] buyOptions = new String[info.size()];
		
		for (int i = 0; i < buyOptions.length; i++) {
			buyOptions[i] = info.get(i);
		}
		
		return buyOptions;
	}
	
	private void buildNewOptions() {
		quantityList = new JComboBox<Integer>(quantity);	
		optionsList = new JComboBox<String>(constructOptions(productOptions));
		
		super.add(optionsList);
		super.add(quantityList);
	}
	
	public Product getSelected() throws ProductDoesNotExistException {
		String s = optionsList.getSelectedItem().toString();
		String[] parts = s.split(": £");
		for (Product p : productOptions) {
			if (parts[0].equals(p.getProductName())) {
				return p;
			}
		}
		throw new ProductDoesNotExistException();
	}
	
	public int getQuantity() {
		return quantityList.getSelectedIndex() + 1;
	}
}
