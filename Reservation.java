import java.io.*;
class Reservation
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public int agenOpt,seatOpt,m,n,w,fare,age,tick=0;
    public int per;
    public String name,busAgen,busSeat,fares ,ageS,dest,date,dur,t;
    public String reserve[][],busStation[];
    public int ticket[],duration[];
    public double time[];
    Get_Information ob=new Get_Information();
    Payment p = new Payment();
    Date dc=new Date();
    public Reservation(Get_Information obj)//CONSTRUCTOR
    {
        ob=obj;
        busStation=new String[]{"PATNA","RANCHI","BHUBANESHWAR","DIGHA","DURGAPUR","SILIGURI","PURI"};
        duration=new int[]{12,10,9,7,5,12,10};
        time=new double[]{8.20,6.50,18.30,1.20,10.40,15.00,23.10};
    }//END OF RESERVATION()
    public  void reservation_get()throws IOException
    {
        boolean valid;
        do
        {   
            System.out.print("Enter the name : ");
            name= br.readLine();
            System.out.println();
            System.out.print("Enter the age : ");
            age=Integer.parseInt(br.readLine());
            System.out.println();
            System.out.println("Enter the journey date in dd/mm/yyyy format : ");
            do//ENTERING OF DATE
            {
               date=br.readLine();
               valid=dc.isValid(date);
               if (valid==false)
                 System.out.println("Sorry your date is not valid.Please enter again.");
            }while(valid==false);
            destination();//calling destination method
            System.out.println("Available names of  Bus Agenies are :");
            for (int l=0;l<3;l++)
              System.out.println("\n"+(l+1)+":"+ ob.busCompany[l]);
            do
            {
                System.out.println("Enter your option");
                agenOpt = -1;
                while (agenOpt < 1 ||agenOpt > 3)        
                {
                    agenOpt = Integer.parseInt(br.readLine());   
                    if (agenOpt < 1 || agenOpt > 3) 
                      System.out.println("Invalid input, try again");
                } 
            }while (agenOpt < 1 || agenOpt > 3);
            System.out.println("Available classes of  Seats are : ");
            for (int l=0;l<3;l++)
               System.out.println("\n"+(l+1)+":"+ ob.seatClass[l]);
            do
            {
                System.out.println("Enter your option");
                seatOpt = -1;
                while (seatOpt < 1 || seatOpt > 3)        
                 {
                    seatOpt = Integer.parseInt(br.readLine());
                    if (seatOpt < 1 || seatOpt > 3) 
                      System.out.println("Invalid input, try again");
                 }
            }while (seatOpt < 1 || seatOpt > 3) ;
            m=agenOpt-1;
            n=seatOpt-1;
            int x=0;
             for (int i=0 ; i<8 ; i++)
             {
                 if (agenOpt == i+1)
                 {
                  t=Double.toString(time[i]);
                  dur=Integer.toString(duration[i]);
                  x=i;
                  break;
                }//end of if
            }//end of loop
            if (time[x]<=12.00)
              t+="A.M.";
            else
              t+="hours";
            if(age<=12)
                fare=ob.fares[m][n]/2;//half charges for children less than equal to 12 years 
            else
                fare=ob.fares[m][n];//normal charges for adults
            ob.seats[m][n] = ob.seats[m][n] - 1;
            if(ob.seats[m][n]>=0)
            {
                System.out.println("Base Fare : Rs "+fare);
                System.out.println("Service Tax : Rs 80");
                System.out.println("Amount payable : Rs "+(fare+80));
                System.out.println("We are proceeding for the payment.");
                p.makePayment();
            }
            else
            {
                System.out.println("SORRY NO SEATS ARE AVAILABLE.PLEASE ENTER A NEW CHOICE");
                ob.seats[m][n]=0;
            }
        }while(ob.seats[m][n]<0);
        fare+=80;
        busAgen=ob.busCompany[m];
        busSeat=ob.seatClass[n];
        fares="Rs."+Integer.toString(fare);
        ageS=Integer.toString(age);
    }//END OF RESERVATIONGET()
    public void information()throws IOException
     {
         System.out.println("Enter the number of tickets to be booked : ");
         do
         {
            per=Integer.parseInt(br.readLine());
            if (per<=0)
             System.out.println("Sorry invalid input,please try again.");
         }while(per<=0);
         reserve=new String[per][9];
         ticket=new int[per];
         for (int i=0;i<per;i++)
         {
             reservation_get();
             reserve[i][0]=name;
             reserve[i][1]=ageS;
             reserve[i][2]=dest;
             reserve[i][3]=date;
             reserve[i][4]=t;
             reserve[i][5]=dur;
             reserve[i][6]=busAgen;
             reserve[i][7]=busSeat;
             reserve[i][8]=fares;
             ticket[i]=i+2000;
             System.out.println("Your ticket no. is = "+ticket[i]);
             System.out.println("THANK YOU FOR BOOKING YOUR TICKET.PLEASE VISIT AGAIN");
         }
         reservationDetails();
         ob.displaySeats();
    }//END OF INFORMATION()
    public void reservationDetails()throws IOException
    {
         System.out.println("For checking your ticket details enter your ticket number.");
         tick=Integer.parseInt(br.readLine());
         for (int i=0;i<ticket.length;i++)
          {
             if (tick==ticket[i])
              {
                 System.out.println("TICKET NO.  NAME\tAGE\tBOARDING POINT\t\tDESTINATION\tDATE\tBOARDING TIME\t DURATION\tBUS AGENCY\tSEAT CLASS\tFARE");
                 System.out.println( ticket[i]+"\t"+"   "+reserve[i][0]+ "\t"+reserve[i][1]+ "\t"+"SealDah Bus Station"+"\t"+reserve[i][2]+ "\t"+reserve[i][3]+ "\t"+reserve[i][4]+ "\t"+reserve[i][5]+"Hours"+"\t"+reserve[i][6]+"\t"+reserve[i][7]+"\t"+reserve[i][8]);      
              }
      }
    }//END OF RESERVATIONDETAILS()
    public void destination()throws IOException
    {
        System.out.println("All BOARDINGS ARE FROM KOLKATA(SEALDAH BUS STATION)"); 
        System.out.println("AVAILABLE DESTINATIONS:");
        for (int i=0;i<busStation.length;i++)
            System.out.println((i+1)+":"+busStation[i]);
        System.out.println("Enter your option");
         w = -1;
        while (w < 1 || w>7)        
        {
            w = Integer.parseInt(br.readLine());
            if (w < 1 || w > 7) 
               System.out.println("Invalid input, try again");
        } 
        dest = busStation[w-1];
    }//END OF DESTINATION()
  }//END OF CLASS RESERVATION