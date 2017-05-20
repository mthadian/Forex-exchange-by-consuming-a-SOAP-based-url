/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convcurrency;
// URL used http://www.webservicex.net/CurrencyConvertor.asmx?WSDL
import convertCurr.Currency;
import java.util.Scanner;
/**
 *
 * @author thadian
 */
public class ConvCurrency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the amount of US Dollars to convert to Kenyan Shillings: ");
        double curr;
        curr = scan.nextDouble();
            try
            {
                double rate = conversionRate( Currency.USD,Currency.KES);
                double converted=curr * rate;
                System.out.printf("$"  + curr + " is equal to Ksh" + converted + " ");
            }
            catch(Exception internet)
                    {
                       System.out.println("Check your Internet Connection!!"); 
                    }
   
    
       
    }

    private static double conversionRate(convertCurr.Currency fromCurrency, convertCurr.Currency toCurrency)
    {
        convertCurr.CurrencyConvertor service = new convertCurr.CurrencyConvertor();
        convertCurr.CurrencyConvertorSoap port = service.getCurrencyConvertorSoap12();
        return port.conversionRate(fromCurrency, toCurrency);
    }
    
}
