import java.io.*;
class Cancellation
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Get_Information ob1=new Get_Information();
    private static Reservation obj=new Reservation(ob1);
    public Cancellation(Get_Information ob ,Reservation ob5)//CONSTRUCTOR
    {
        ob1=ob;
        obj=ob5;
    }//END OF CANCELLATION
    public static void cancel()throws IOException
     {
        System.out.println("Enter the Number of Deletions to be made");
        int p = Integer.parseInt(br.readLine());
        for (int i=0;i<p;i++)
        {
            System.out.println("Enter your ticket no.");
            int t = Integer.parseInt(br.readLine());
            for (int j=0 ; j<obj.ticket.length ; j++)
            {
                if(t==obj.ticket[j])
                {
                    int m=0,n=0;
                    for(int g=0;g<3;g++)
                    {
                        if(ob1.busCompany[g].equals(obj.reserve[j][2]))//STORING OF TRAVEL AGENT
                          m = g;
                        if(ob1.seatClass[g].equals(obj.reserve[j][3]))//STORING OF SEAT CLASS
                          n = g;
                    }
                    ob1.seats[m][n]++;
                    for (int k=j ; k<(obj.per-1) ; k++)
                    {
                        obj.ticket[k]=obj.ticket[k+1];
                        for (int l=0 ; l<6 ; l++)
                           obj.reserve[k][l]=obj.reserve[k+1][l];
                    }
                    obj.ticket[obj.per-1]=0;//nullation of ticket
                    for (int l=0 ; l<6 ; l++)
                       obj.reserve[obj.per-1][l]="";
                }
                else
                  continue;
            }
        }
        obj.per=obj.per-p;
        ob1.displaySeats();//displaying the final seats after cancellation
     }//END OF CANCEL()
}//END OF CLASS CANCELLATION