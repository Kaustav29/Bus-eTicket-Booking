import java.io.*;
public class Payment
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public String email;
    public long mobileNo;
    public String bankName[]={"HDFC Bank","ICICI Bank","State Bank of India","Axis Bank","Bank of Baroda"};
    public String cardType[]={"Credit Card","Debit Card"};
    public void inputDetails()throws IOException
    {
        System.out.println("Please enter your contact details : ");
        System.out.print("Enter your email id : ");
        email = br.readLine();
        System.out.println();
        System.out.print("Enter your mobile phone number : ");
        mobileNo=Long.parseLong(br.readLine());
    }//END OF INPUT DETAILS
    public void makePayment()throws IOException
    {
        inputDetails();
        String date;
        long cardNo,cvvNo,bank,card;
        System.out.println("Choose your ATM card type.");
        for (int i=0;i<2;i++)
         System.out.println("\n"+(i+1)+":"+cardType[i]);
        do
        {
           System.out.print("Enter your card type : "); 
           card=Long.parseLong(br.readLine());
           if (card<=0||card>2) 
            System.out.println("Sorry you have given a wrong choice.Please enter your card type again.");
        }while(card<=0||card>2);
        System.out.println("Choose your bank.");
        for (int i=0;i<5;i++)
          System.out.println("\n"+(i+1)+":"+bankName[i]);
        do
        {
           System.out.print("Enter your bank name : ");
           bank=Long.parseLong(br.readLine());
           if (bank<=0||bank>5) 
             System.out.println("Sorry you have given a wrong choice.Please enter your bank name again.");
        }while(bank<0||bank>5);
        do
        {
            System.out.print("Enter your 16-digit card number : ");
            cardNo=Long.parseLong(br.readLine());
            if (countDigit(cardNo)!=16)
              System.out.println("Sorry wrong input.Please try again.");
        }while(countDigit(cardNo)!=16);
        System.out.print("Enter the expiry date in mm//yyyy format : ");
        date=br.readLine();
        do
        {
            System.out.print("Enter the 3-digit cvv number : ");
            cvvNo=Long.parseLong(br.readLine());
            if (countDigit(cvvNo)!=3)
             System.out.println("Sorry wrong input.Please try again.");
        }while(countDigit(cvvNo)!=3);
        System.out.println("Your transaction has taken place.Thank you for choosing our site.");
        System.out.println("Your ticket details will be sent to your email id and a SMS will be sent to your mobile.");
    }//END OF MAKEPAYMENT()
    public int countDigit(long no)
    {
        long x=no;//storing a copy
        int count=0;//to store the no of digits
        while(x>0)
        {
            count++;
            x/=10;
        }//end of while loop
        return count;
    }//END OF COUNTDIGIT()
}//END OF CLASS PAYMENT