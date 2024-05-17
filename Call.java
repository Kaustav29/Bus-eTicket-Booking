import java.io.*;
public class Call
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Get_Information x = new Get_Information();
    Reservation y = new Reservation(x);
    Cancellation z = new Cancellation(x,y);
    public void menu()throws IOException
    {
        System.out.println("Enter your choice:-\n1:I want to reserve seats. \n2:I want to check my reservation status.\n3:I want to cancel seats.");
        int n = Integer.parseInt(br.readLine());
        switch(n)
        {
            case 1: x.displayInformation();
                    y.information();
                    break;
            case 2: status();
                    break;
            case 3: z.cancel();
                    break;
            default:System.out.println("SORRY WRONG INPUT");
        }
        System.out.println("DO YOU WANT TO CONTINUE? 1:YES 2:NO");
        int a = Integer.parseInt(br.readLine());
        if(a==1)
          menu();
        else{
          System.out.println("THANK YOU FOR USING MY SOFTWARE.");  
          System.exit(0);
        }  
    }//END OF MENU()
    public void status()throws IOException
    {
        System.out.println("Enter your ticket no.");
        int t=Integer.parseInt(br.readLine());
        boolean w=false;
        for(int i=0;i<y.ticket.length;i++)//SHOWING THE TICKET STATUS IF ALREADY BOOKED
        {
             if(y.ticket[i]==t)
            {
               System.out.println("NAME = "+y.reserve[i][0]+"\nAGE = "+y.reserve[i][1]+"\nAIR COMPANY =  "+y.reserve[i][2]+"\nSEAT CLASS = "+y.reserve[i][3]+"\nBOARDING = KOLKATA\nDESTINATION = "+y.reserve[i][4]+"\nFARE ="+y.reserve[i][5]);
               w=true;
            }
        }
        if(w==false)
           System.out.println("SORRY YOU DON'T HAVE A RESERVATION.");
        System.out.println("Do you want to check reservation status for other person/s? 1: yes 2: no");
        int ch = Integer.parseInt(br.readLine());
        if(ch==1)
          status();
     }//END OF STATUS()
    public static void main(String args[])throws IOException
    {
       Call b=new Call();
       System.out.println("WELCOME TO KAUSTAV'S ONLINE BUS TICKET BOOKING SYSTEM.");
       System.out.println();
       b.menu();
    }//END OF MAIN()
}//END OF CLASS CALL