/*
 *  UCF COP3330 Fall 2021 Exercise 20 Solution
 *  Copyright 2021 Patrick Iannini
 */
package Exercise20;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the order amount?");
        double amount = sc.nextDouble();
        sc.nextLine();

        String[] ilTax = {"IL", "ILLINOIS"};
        String[] wiTax = {"WI", "WISCONSIN"};

        System.out.println("What state do you live in?");
        String stateIn = sc.nextLine();
        double taxRate=0;


        if (Arrays.asList(wiTax).contains(stateIn.toUpperCase())) {
            taxRate = .05;
            System.out.println("What county do you live in?");
           String countyIn = sc.nextLine();
            if (countyIn.equalsIgnoreCase("EAU CLAIRE")) {
                taxRate += 0.005; //Assuming an additional .5% tax
            } else if (countyIn.equalsIgnoreCase("DUNN")) {
                taxRate += 0.004; //Assuming an additional .4% tax
            }
        } else if(Arrays.asList(ilTax).contains(stateIn.toUpperCase())) {
            taxRate = 0.08;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        double tax = amount*taxRate;
        double total = tax+amount;

        System.out.println("The tax is $"+df.format(tax)+"\nThe total is $"+df.format(total));
    }
}
