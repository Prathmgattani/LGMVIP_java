package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.management.MBeanAttributeInfo;
import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;

class Newconverter extends JFrame implements ActionListener{
    JComboBox fromcountry,tocountry;
    JButton convert,reset,exit;
    JLabel fromunit,tounit;
    TextField fromtext;
    TextField Answer;

    String[] currencyUnits=
            {
                    "units",
                    "Indian Rupee",
                    "US Dollar",
                    "European Union",
                    "Canadian Dollar",
                    "Japanese YEN",
                    "Chinese Yuan",
            };
    Newconverter()
    {
        setBounds(300,60,790,700);
        setEnabled(true);
        getContentPane().setBackground(Color.darkGray);

        JLabel maintitle = new JLabel("*Currency Converter*");
        maintitle.setBounds(150,30,650,60);
        maintitle.setFont(new Font("SERIF",Font.BOLD , 50));

        maintitle.setForeground(Color.white);

        add(maintitle);

        JLabel from = new JLabel("From");
        from.setBounds(50,160,50,50);
        from.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        from.setForeground(Color.white);
        add(from);

        fromcountry = new JComboBox(new String[] { "Select One..", "INR","USD","EUR","CAD","JPY","CNY" });
        fromcountry.setBounds(100,165,200,40);
        fromcountry.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        fromcountry.setForeground(Color.black);
        fromcountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                fromcountryItemStateChanged(evt);
            }
        });
        add(fromcountry);

        fromtext = new TextField();
        fromtext.setBounds(350,165,250, 40);
        fromtext.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        fromtext.setForeground(Color.BLACK);
        add(fromtext);

        fromunit = new JLabel("Unit");
        fromunit.setBounds(605,140,200,90);
        fromunit.setFont(new Font("Mongolian Baiti",Font.BOLD,15));
        fromunit.setForeground(Color.white);
        add(fromunit);

        JLabel to = new JLabel("To");
        to.setBounds(50,310,50,50);
        to.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        to.setForeground(Color.white);
        add(to);

        tocountry = new JComboBox(new String[] { "Select One..","INR","USD","EUR","CAD","JPY","CNY" });
        tocountry.setBounds(100,310,200,40);
      //  tocountry.setBackground(Color.LIGHT_GRAY);
        tocountry.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        tocountry.setForeground(Color.black);
        tocountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                tocountryItemStateChanged(evt);
            }
        });
        add(tocountry);
// OUTPUT ANSWER
        Answer = new TextField(" ");
        Answer.setBounds(350,310,250, 40);
        Answer.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        Answer.setForeground(Color.BLACK);
        add(Answer);

        tounit = new JLabel("Unit");
        tounit.setBounds(605,290,250,90);
        tounit.setFont(new Font("Mongolian Baiti",Font.BOLD,15));
        tounit.setForeground(Color.white);
        add(tounit);
//CONVERT BUTTON
        convert = new JButton("Convert ");
        convert.setBounds(100,450,200,40);
        convert.setFont(new Font("Mongolian Baiti",Font.BOLD,25));
        convert.addActionListener(this);
        add(convert);

  // RESET BUTTON
        reset = new JButton("Reset");
        reset.setBounds(450,450,200,40);
        reset.setFont(new Font("Mongolian Baiti",Font.BOLD,25));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(reset);
//EXIT BUTTON
        exit = new JButton("Exit");
        exit.setBounds(300,550,100,40);
        exit.setFont(new Font("Mongolian Baiti",Font.BOLD,15));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(exit);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //reset panel
        fromcountry.setSelectedIndex(0);
        tocountry.setSelectedIndex(0);
        fromtext.setText(null);
        Answer.setText(null);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //to Exit
        System.exit(0);
    }

    public static void main(String[] args)
    {
        new Newconverter();
    }
    private void fromcountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fromcountryItemStateChanged
        //units
        int position = fromcountry.getSelectedIndex();
        fromunit.setText(currencyUnits[position]);
    }

    private void tocountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tocountryItemStateChanged
        //units
        int position = tocountry.getSelectedIndex();
        tounit.setText(currencyUnits[position]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convert) {
            if (fromcountry.getSelectedIndex() == 0 || tocountry.getSelectedIndex() == 0 || fromtext.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);

            } else {
                double amt = Double.parseDouble(fromtext.getText());
                double total;
        switch (fromcountry.getSelectedItem().toString()) {
            case "USD":
                //InR
                switch (tocountry.getSelectedItem().toString()) {
                    case "INR":
                        total = amt * 82.62;
                        Answer.setText("" + total);
                        break;
                    case "EUR":
                        total = amt * 0.94;
                        Answer.setText("" + total);
                        break;
                    case "CAD":
                        total = amt * 1.35;
                        Answer.setText("" + total);
                        break;
                    case "JPY":
                        total = amt * 132.440;
                        Answer.setText("" + total);
                        break;
                    case "CNY":
                        total = amt * 6.87;
                        Answer.setText("" + total);
                        break;
                    default:
                        total = amt * 1;
                        Answer.setText("" + total);
                        break;
                }
                break;
                case "EUR":
                        //InR
                        switch (tocountry.getSelectedItem().toString()) {
                            case "USD":
                                total = amt * 1.0605;
                                Answer.setText("" + total);
                                break;
                            case "INR":
                                total = amt * 87.747;
                                Answer.setText( "" + total);
                                break;
                            case "CAD":
                                total = amt * 1.433;
                                Answer.setText( "" + total);
                                break;
                            case "JPY":
                                total = amt * 140.50;
                                Answer.setText( "" + total);
                                break;
                            case "CNY":
                                total = amt * 7.2925;
                                Answer.setText( "" + total);
                                break;
                            default:
                                total = amt * 1;
                                Answer.setText( "" + total);
                                break;}
                    break;
            case "INR":
                //InR
                switch (tocountry.getSelectedItem().toString()) {
                    case "USD":
                        total = amt * 0.012;
                        Answer.setText("" + total);
                        break;
                    case "EUR":
                        total = amt * 0.0113;
                        Answer.setText( "" + total);
                        break;
                    case "CAD":
                        total = amt * 0.016;
                        Answer.setText( "" + total);
                        break;
                    case "JPY":
                        total = amt * 1.601;
                        Answer.setText( "" + total);
                        break;
                    case "CNY":
                        total = amt * 0.08;
                        Answer.setText( "" + total);
                        break;
                    default:
                        total = amt * 1;
                        Answer.setText( "" + total);
                        break;}
                break;
            case "CAD":
                //InR
                switch (tocountry.getSelectedItem().toString()) {
                    case "USD":
                        total = amt * 0.739;
                        Answer.setText("" + total);
                        break;
                    case "EUR":
                        total = amt * 0.697;
                        Answer.setText( "" + total);
                        break;
                    case "INR":
                        total = amt * 61.204;
                        Answer.setText( "" + total);
                        break;
                    case "JPY":
                        total = amt * 98.005;
                        Answer.setText( "" + total);
                        break;
                    case "CNY":
                        total = amt * 5.086;
                        Answer.setText( "" + total);
                        break;
                    default:
                        total = amt * 1;
                        Answer.setText( "" + total);
                        break;}
                break;
            case "JPY":
                switch (tocountry.getSelectedItem().toString()) {
                    case "USD":
                        total = amt * 0.0075;
                        Answer.setText("" + total);
                        break;
                    case "EUR":
                        total = amt * 0.0071;
                        Answer.setText( "" + total);
                        break;
                    case "CAD":
                        total = amt * 0.01020;
                        Answer.setText( "" + total);
                        break;
                    case "INR":
                        total = amt * 0.6244;
                        Answer.setText( "" + total);
                        break;
                    case "CNY":
                        total = amt * 0.0519;
                        Answer.setText( "" + total);
                        break;
                    default:
                        total = amt * 1;
                        Answer.setText( "" + total);
                        break;}
                break;
            case "CNY":
                //InR
                switch (tocountry.getSelectedItem().toString()) {
                    case "USD":
                        total = amt * 0.1454;
                        Answer.setText("" + total);
                        break;
                    case "EUR":
                        total = amt * 0.1371;
                        Answer.setText( "" + total);
                        break;
                    case "CAD":
                        total = amt * 0.1965;
                        Answer.setText( "" + total);
                        break;
                    case "JPY":
                        total = amt * 19.267;
                        Answer.setText( "" + total);
                        break;
                    case "INR":
                        total = amt * 12.032;
                        Answer.setText( "" + total);
                        break;
                    default:
                        total = amt * 1;
                        Answer.setText( "" + total);
                        break;}
                break;
               }
           }
        }
    }
}