package demoi;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Locale.Builder;
public class LocaleList
{
    public static void main(String args[])
    {
       
            System.out.println("The default locale is "+Locale.getDefault());
            int[] a={1,2,3,4,5,5};
            for(int x:a)
            {
                System.out.println(x);
            }
//   
           System.out.println("List of all available locales");
            Locale[] locales=Locale.getAvailableLocales();
            for(Locale locale:locales)
            {
                System.out.printf("Locale %s stands for %s %n",locale,locale.getDisplayName());
            }
////            
////          
//////         
            System.out.println("*****************List of locales with english language******************");
            for(Locale locale:locales)
            {
                if(locale.getLanguage().equals("en"))
                System.out.printf("Locale %s stands for %s %n",locale,locale.getDisplayName());
            }
//////               
//////        
  //          System.out.println(Locale.getDefault());
//            System.out.println("Details of a locale");
            Locale.setDefault(Locale.CHINESE);
            Locale defaultLocale=Locale.getDefault();
            System.out.println("The crurent default locale is "+Locale.getDefault());
////           
            System.out.printf("The language code is %s and the name is %s\n",defaultLocale.getLanguage(),defaultLocale.getDisplayLanguage());
            System.out.printf("The country code is %s and the name is  %s%n", defaultLocale.getCountry(),defaultLocale.getDisplayCountry());
            System.out.printf("The  variant code is %s and the name is %s\n",defaultLocale.getVariant(),defaultLocale.getDisplayVariant());
            System.out.printf("The  script code is %s and the name is %s\n",defaultLocale.getScript(),defaultLocale.getDisplayScript());
////          
//////        
//////               
//////            Locale locale=new Locale("ne","NE");
//////            Locale.setDefault(locale);
//////            
////            //NumberFormat is a local sensitive class
            Locale[] numberLocales=NumberFormat.getAvailableLocales();
            for(Locale localeee:numberLocales)
           {
               System.out.print(localeee.toString()+"-->");
           }
//////              
////   //Getting numbers based on locales
           Locale[] thaiLocales={new Locale("th"),new Locale("th","TH"),new Locale("th","TH","TH")};
            for(Locale localee:thaiLocales)
            {
                //Get numberformat(currency,general number, percent} for a given locale
                NumberFormat nf=NumberFormat.getNumberInstance(localee);
                NumberFormat cf=NumberFormat.getCurrencyInstance(localee);
                NumberFormat pf=NumberFormat.getPercentInstance(localee);
                NumberFormat f=NumberFormat.getInstance(localee);
                
                System.out.println("********************"+localee+"*******************");
                //display the values using specific format
                System.out.println("Number Format-->"+nf.format(24.345));
                System.out.println("Currency Format-->"+cf.format(24.345));
                 System.out.println("percent Format-->"+pf.format(24.345));
                 System.out.println("Normal format -->"+f.format(24.345));          
            }
//////             
           Locale[] frenchLocales={new Locale("fr"),new Locale("fr","FR"),new Locale("fr","FR","FR")};
           for(Locale localee:frenchLocales)
            {
                //Get numberformat(currency,general number, percent} for a given locale
                NumberFormat nf=NumberFormat.getNumberInstance(localee);
                NumberFormat cf=NumberFormat.getCurrencyInstance(localee);
                NumberFormat pf=NumberFormat.getPercentInstance(localee);
                NumberFormat f=NumberFormat.getInstance(localee);
               
                
                System.out.println(localee);
                //display the values using specific format
                System.out.println("Number Format-->"+nf.format(124.345));
                System.out.println("Currency Format-->"+cf.format(124.345));
                 System.out.println("percent Format-->"+pf.format(124.345));
                 System.out.println("Normal format -->"+f.format(124.345)); 
                 
                 
                 
            }
//////              
           //DateFormat is also a local sensitive class
           Locale[] dateLocales=DateFormat.getAvailableLocales();
           for(Locale localeee:dateLocales)
           {
               System.out.print(localeee.toString()+"-->");
           }
////            //Getting dates based on locales
////                  
          java.util.Date d=new Date();
          Locale.setDefault(new Locale("fr","FR","FR"));
          DateFormat df=DateFormat.getDateInstance();
          System.out.println("\nThe date on french format is "+df.format(d));
          
          Locale.setDefault(new Locale("es","PA"));
          df=DateFormat.getDateInstance();
          System.out.println("The date format for spanish is "+df.format(d));
////             */      
    }
}
