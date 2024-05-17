public class Get_Information
{
    public int seats[][]={{5,6,5},{6,6,4},{8,5,7}};//NUMBER OF AVAILABLE SEATS
    public int fares[][]={{350,500,800},{250,400,600},{300,550,900}};//FARES
    public String busCompany[]={"TravelBuzz","A.K.Travels","Joseph Motors"};//TRAVEL AGENT
    public String seatClass[]={"Sleeper","Semi-Sleeper","Luxury"};//SEAT CLASS
     public void displayInformation()
    {
        displaySeats();
        displayFares();
    }//END OF DISPLAYINFORMATION()
    public void displaySeats()
    {
        System.out.println("Available Seat Status : ");
        for(int i=0;i<20;i++)
          System.out.print(" ");
        for (int l=0;l<3;l++)
          System.out.print(seatClass[l]+"\t");
        for (int k=0;k<3;k++)
        {
            System.out.println();
            System.out.print(busCompany[k]);
            int s = 20-busCompany[k].length();//PROPER SPACING WHILE DISPLAYING SEATS
            for(int i=0;i<s;i++)
              System.out.print(" ");
            for (int l=0;l<3;l++)
              System.out.print( seats[k][l]+"\t\t");
        }
        System.out.println();
    }//END OF DISPLAY SEATS()
    public void displayFares()
    {
        System.out.println("Available fare Status : ");
        for(int i=0;i<20;i++)
          System.out.print(" ");
        for (int l=0;l<3;l++)
          System.out.print(seatClass[l]+"\t\t");
        for (int k=0;k<3;k++)
        {
            System.out.println();
            System.out.print(busCompany[k]);
            int s = 18-busCompany[k].length();//PROPER SPACING
            for(int i=0;i<s;i++)
              System.out.print(" ");
            for (int l=0;l<3;l++)
              System.out.print( "Rs."+fares[k][l]+"\t\t"+"  ");
            System.out.println();
        }
     }//END OF DISPLAYFARES()
 }//END OF CLASS GET_INFORMATION