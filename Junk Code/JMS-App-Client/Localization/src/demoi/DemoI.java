
package demoi;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class DemoI {
    public static void main(String[] args) {
        
        
        Locale.setDefault( Locale.FRANCE);
        NumberFormat cf=NumberFormat.getCurrencyInstance(Locale.CANADA);
        int a=4,b=5,c=0;
         c=a+b;
         System.out.println("Currency Format-->"+cf.format(c));
         
        DateFormat df=DateFormat.getDateInstance();
        Date d=new Date();
        System.out.println(df.format(d));
        
//         NumberFormat nf=NumberFormat.getNumberInstance(localee);
//                NumberFormat cf=NumberFormat.getCurrencyInstance(localee);
//                NumberFormat pf=NumberFormat.getPercentInstance(localee);
//                NumberFormat f=NumberFormat.getInstance(localee);
//                
//                System.out.println("********************"+localee+"*******************");
//                //display the values using specific format
//                System.out.println("Number Format-->"+nf.format(24.345));
//                System.out.println("Currency Format-->"+cf.format(24.345));
//                 System.out.println("percent Format-->"+pf.format(24.345));
//                 System.out.println("Normal format -->"+f.format(24.345));
    }
}
