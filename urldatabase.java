import java.util.Scanner;
import java.util.ArrayList;

public class urldatabase
{
    public static void main(String arg[])
    {
        Scanner scan=new Scanner(System.in);
        int num=0,i=0;
        ArrayList<Url> obj = new ArrayList<Url>();


        do
        {
            System.out.print(">");
            String command=scan.nextLine();
            String[] cmd = command.split(" ");


            if(cmd[0].equals("storeurl") && cmd.length==2)
            {
                 for(i=0;i<num;i++)
                {
                    if((obj.get(i).geturl()).equals(cmd[1]))
                    {
                        System.out.println("already exists");
                        break;
                    }
                }
                if(i==num)
                {
                    obj.add(new Url(cmd[1],num));
                    num=num+1;
                    System.out.println("Ok");
                }
            }


            else if(cmd[0].equals("get") && cmd.length==2)
            {
                for(i=0;i<num;i++)
                {
                    if((obj.get(i).geturl()).equals(cmd[1]))
                    {
                        obj.get(i).inc_count();
                        System.out.println(obj.get(i).getkey());
                        break;
                    }
                }
                if(i==num)
                System.out.println("Not found");
            }
            else if(cmd[0].equals("count") && cmd.length == 2){
              for(i=0;i<num;i++)
              {
                  if((obj.get(i).geturl()).equals(cmd[1]))
                  {
                      System.out.println(obj.get(i).getcount());
                      break;
                  }
              }
              if(i==num)
              System.out.println("Not found");

            }


            else if(cmd[0].equals("list") && cmd.length==1)
            {
               System.out.print("{");
                for(i=0;i<num-1;i++)
                {
                       System.out.print("\""+obj.get(i).geturl()+"\":"+obj.get(i).getcount()+", ");
                }
                System.out.println("\""+obj.get(i).geturl()+"\":"+obj.get(i).getcount()+"}");
            }


            else if(cmd[0].equals("exit") && cmd.length==1)
                break;


            else
                System.out.println("Invalid command");


        }while(true);

    }
}

class Url
{
    int count;
    Short key;
    String url;
    Url(String str,int num)
    {
        count=0;
        url=str;
        key=Short.valueOf(String.valueOf(num+1);
    }
    String geturl()
    {
        return url;
    }
    Short getkey()
    {
        return key;
    }
    int getcount()
    {
        return count;
    }
    void inc_count()
    {
        count=count+1;
    }
}
