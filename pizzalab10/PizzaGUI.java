import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
/*******************************************************
 * Demonstration of GUI components and Action Listeners
 * using a pizza order form
 * 
 * @author Scott Grissom
 * @version May 5, 2018
 ******************************************************/
public class PizzaGUI extends JFrame implements ActionListener {
    /** JRadioButtons for small and medium sizes */
    private JRadioButton smallRadio, mediumRadio;

    // FIX ME: declare JRadioButton for sizes large and party
        private JRadioButton largeRadio, partyRadio;
    /** JRadioButtons for thin and thick crusts */  
    private JRadioButton thinRadio, thickRadio;

    // FIX ME: declare JRadioButton for pan and stuffed crusts
        private JRadioButton panRadio, stuffedRadio;
    /** JCheckBox for two meats and two veggies */
    private JCheckBox sausageCheck, pepperoniCheck;
    private JCheckBox peppersCheck, onionsCheck;
    private JCheckBox baconCheck, hamCheck;
    private JCheckBox pineappleCheck, tomatoCheck;
    private JCheckBox oliveCheck, mushroomCheck;
    // FIX ME: declare additional check boxes for your favorite meats and veggies

    private JLabel priceLbl;
    private JButton priceBtn;
    private JButton orderBtn;
    private PizzaOrder theOrder;

    /** menu items to display about and to quit */
    JMenuItem quitItem;
    JMenuItem aboutItem;

    /*****************************************************
    This is a standard main method that creates and displays
    the GUI.
     ****************************************************/
    public static void main(String args[]){
        PizzaGUI gui = new PizzaGUI();

        // FIX ME: Change the title to include your name
        gui.setTitle("Jacob's Pizza");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
    }  

    /****************************************************
    Constructor
     ****************************************************/  
    public PizzaGUI(){

        // FIX ME: Instantiate the PizzaOrder object called theOrder
        theOrder = new PizzaOrder();
        setupMenus();
        setupGUI();
    }

    /************************************************************
     * SetupGUI - sets up the gui components
     ************************************************************/
    public void setupGUI () {
        // set layout manager and fonts
        setLayout(new GridBagLayout());
        GridBagConstraints position = new GridBagConstraints();
        Font myFont = new Font("serif", Font.BOLD, 20); 

        // make components left justified with padding on right
        position.anchor = GridBagConstraints.LINE_START;
        position.insets = new Insets(0,0,0,20);        

        // create radio buttons for size, small is the default    
        smallRadio = new JRadioButton("Small", true);
        mediumRadio = new JRadioButton("Medium");

        // FIX ME: create the 2 other JRadioButtons - large and party
            largeRadio = new JRadioButton("Small", true);
       partyRadio = new JRadioButton("Medium");
        // combine radio buttons in a group
        ButtonGroup sizesGroup = new ButtonGroup();
        sizesGroup.add(smallRadio);
        sizesGroup.add(mediumRadio);
        sizesGroup.add(largeRadio);
        sizesGroup.add(partyRadio);
        // FIX ME: add the large and party JRadioButtons to the group

        // Place radio buttons for size
        JLabel sizeLbl = new JLabel("Pick Size");
        sizeLbl.setFont(myFont);
        position.gridy = 0;
        position.gridx = 1; 
        add(sizeLbl, position);       
        position.gridy = 1; 
        add(smallRadio, position);
        position.gridy = 2; 
        add(mediumRadio, position); 
        position.gridy = 3; 
        add(largeRadio, position);
        position.gridy = 4; 
        add(partyRadio, position);

        // FIX ME: place the large and party 

        // Create radio buttons for crust
        thinRadio = new JRadioButton("Thin", true);
        thickRadio = new JRadioButton("Thick");
        panRadio = new JRadioButton("Pan");
        stuffedRadio = new JRadioButton("Stuffed");

        // FIX ME: create the two additional JRadioButtons for pan and stuffed

        // combine radio buttons in a group
        ButtonGroup crustGroup = new ButtonGroup();
        crustGroup.add(thinRadio);
        crustGroup.add(thickRadio);
        crustGroup.add(panRadio);
        crustGroup.add(stuffedRadio);

        // FIX ME: add the pan and stuffed JRadioButtons to the group 

        // Place radio buttons for crust
        JLabel crustLbl = new JLabel("Pick Crust");
        crustLbl.setFont(myFont);
        position.gridy = 0;
        position.gridx = 2; 
        add(crustLbl, position);        
        position.gridy = 1;
        add(thinRadio, position);
        position.gridy = 2;
        add(thickRadio, position);    
        position.gridy = 3;
        add(panRadio, position);
        position.gridy = 4;
        add(stuffedRadio, position);  
        // FIX ME: place the pan and stuffed JRadioButtons 

        // Create checkboxes for meat toppings
        sausageCheck = new JCheckBox("Sausage");
        pepperoniCheck = new JCheckBox("Pepperoni");  
        hamCheck = new JCheckBox("Ham"); 
        baconCheck = new JCheckBox("Bacon"); 
        // FIX ME: Create JCheckBox for additional meat toppings 

        // Place checkboxes for meat
        JLabel meatLbl = new JLabel("Pick Meat");
        meatLbl.setFont(myFont);
        position.gridy = 0;
        position.gridx = 3; 
        add(meatLbl,position);          
        position.gridy = 1;
        add(sausageCheck, position);
        position.gridy = 2;        
        add(pepperoniCheck, position);
        position.gridy = 3;
        add(hamCheck, position);
        position.gridy = 4;        
        add(baconCheck, position);

        // FIX ME: place JCheckBox for additional meat toppings 

        // create checkboxes for veggie choices
        onionsCheck = new JCheckBox("Onions");
        peppersCheck = new JCheckBox("Peppers"); 
        oliveCheck = new JCheckBox("Olive");
        mushroomCheck = new JCheckBox("Mushrooms");  
        tomatoCheck = new JCheckBox("Tomato");
        pineappleCheck = new JCheckBox("Pineapple"); 
        // FIX ME: create checkboxes for additional veggie choices

        // display checkboxes for veggies
        JLabel vegLbl = new JLabel("Pick Veggie");
        vegLbl.setFont(myFont);
        position.gridy = 0;
        position.gridx = 4;  
        add(vegLbl,position);          
        position.gridy = 1;
        add(peppersCheck, position);
        position.gridy = 2;        
        add(onionsCheck, position); 
        position.gridy = 3;
        add(oliveCheck, position);
        position.gridy = 4;        
        add(mushroomCheck, position);
        position.gridy = 5;
        add(tomatoCheck, position);
        position.gridy = 6;        
        add(pineappleCheck, position);
        // FIX ME: display checkboxes for additional veggies

        // display price
        JLabel priceTitle = new JLabel("Price");
        position.gridy = 0;
        position.gridx = 5;         
        priceTitle.setFont(myFont);
        add(priceTitle,position);
        priceLbl = new JLabel("$0.00");
        priceLbl.setFont(myFont);
        position.gridy = 1;
        add(priceLbl,position);

        // create and display the Price button
        priceBtn = new JButton("Price");
        position.gridx = 5; 
        position.gridy = 2;
        add(priceBtn,position);
        priceBtn.addActionListener(this);

        // FIX ME: create and display the Order button
            orderBtn = new JButton("Order");
            position.gridx = 5; 
        position.gridy = 3;
        add(orderBtn,position);
        orderBtn.addActionListener(this);
        // display an image of pizza
        // FIX ME: update the file name
        ImageIcon icon = new ImageIcon("pizzapic.jpg");
        JLabel imageLabel =new JLabel(icon);
        position.gridy = 0;
        position.gridx = 0; 
        position.gridheight = 10;
        add(imageLabel, position);
    }

    /********************************************************
     * Process each button click or menu selection
     ********************************************************/    
    public void actionPerformed(ActionEvent event){      
        // Calculate price based on selected options
        if(event.getSource() == priceBtn){

            // review order selections
            updatePizzaOrder();

            // display updated price
            NumberFormat fmt = NumberFormat.getCurrencyInstance(); 
            priceLbl.setText(fmt.format(theOrder.getPrice()));    
        }

        // process menu item for Quit
        if(event.getSource() == quitItem){
            // close application
            System.exit(1);
        }

        // FIX ME: process menu item for About
            if(event.getSource() == aboutItem){
            // display my name
            JOptionPane.showMessageDialog(this,"Jacob Neiheisel");

        }
        // FIX ME: process button for Order
         if(event.getSource() == orderBtn){
            String summary = theOrder.getOrder();
            JOptionPane.showMessageDialog(this, summary);


        }
        
    

    }

    /************************************************************
    Hide details of updating all order options
     ************************************************************/
    private void updatePizzaOrder(){

        theOrder.clearOrder();

        if (smallRadio.isSelected()){
            theOrder.setSize(PizzaOrder.SMALL);
        }
           if (mediumRadio.isSelected()){
            theOrder.setSize(PizzaOrder.MEDIUM);
        }
        if (largeRadio.isSelected()){
            theOrder.setSize(PizzaOrder.LARGE);
        }
        if (partyRadio.isSelected()){
            theOrder.setSize(PizzaOrder.PARTY);
        }
        // FIX ME: add if statements for other sizes

        if (thinRadio.isSelected()){
            theOrder.setCrust(PizzaOrder.THIN);
        } 
        
        if (thickRadio.isSelected()){
            theOrder.setCrust(PizzaOrder.THICK);
        }  
        if (panRadio.isSelected()){
            theOrder.setCrust(PizzaOrder.PAN);
        }  
        if (stuffedRadio.isSelected()){
            theOrder.setCrust(PizzaOrder.STUFFED);
        }  

        // FIX ME: add if statements for other crusts 

        // FIX ME: add if statements for each meat option
        if (pepperoniCheck.isSelected()){
            theOrder.addMeat();
        }  
        if (sausageCheck.isSelected()){
            theOrder.addMeat();
        }  
        if (baconCheck.isSelected()){
            theOrder.addMeat();
        }  
        if (hamCheck.isSelected()){
            theOrder.addMeat();
        }  

        // FIX ME: add if statements for each veggie option
        if (onionsCheck.isSelected()){
            theOrder.addVeggie();
        }
        if (peppersCheck.isSelected()){
            theOrder.addVeggie();
        }
        if (tomatoCheck.isSelected()){
            theOrder.addVeggie();
        }
        if (oliveCheck.isSelected()){
            theOrder.addVeggie();
        }
        if (mushroomCheck.isSelected()){
            theOrder.addVeggie();
        }
        if (pineappleCheck.isSelected()){
            theOrder.addVeggie();
        }
        
    }    

    /************************************************************
     * Setup the file menu with two options: about and quit
     * Menu items must register their action listeners
     ************************************************************/
    private void setupMenus (){
        // create and display the menu bar
        JMenuBar menusBar = new JMenuBar();
        setJMenuBar(menusBar);

        // create a menu and add to the menubar
        JMenu fileMenu = new JMenu("File");
        menusBar.add(fileMenu);

        // create a menu item for About
        aboutItem = new JMenuItem("About");
        fileMenu.add(aboutItem);
        aboutItem.addActionListener(this);  

        // create a menu item for Quit
        quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);
        quitItem.addActionListener(this); 
         
    }
}
