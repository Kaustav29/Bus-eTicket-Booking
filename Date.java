public class Date
{
   public boolean isLeap(int year)
    {
        if(((year%4)==0 && (year%100)!=0)||(year%400==0))
            return true;
        return false;
    }//END OF ISLEAP()
   public boolean isValid( String date)
    {
        String dd=date.substring(0,2);//extracting the day 
        int d=Integer.parseInt(dd);
        String mm=date.substring(3,5);//extracting the month
        int m=Integer.parseInt(mm);
        String yy=date.substring(6);
        int y=Integer.parseInt(yy);
        if(d<=0||m<=0||y<=0)
            return false;
        if(m>12)
            return false;
        if((isLeap(y))&&(m==2)&&(d>29))
            return false;
        if((isLeap(y)==false)&&(m==2)&&(d>28))
            return false;
        if((m==4)||(m==6)||(m==9)||(m==11))
        {
            if(d>30)
                return false;
        }//end of if
        else
        {
            if(d>31)
                return false;
        }//end of else
        return true;
    }//END OF IS VALID()
}//END OF CLASS DATE