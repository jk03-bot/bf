import java.util.Scanner;


class CaesarCipher
{
    public String decrypt(String ct,int key)
    {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        ct = ct.toLowerCase();
        StringBuilder pt = new StringBuilder();
        for(int i=0;i<ct.length();i++)
        {
            char current = ct.charAt(i);
            if(Character.isLetter(current))
            {
                int pos = alpha.indexOf(current);
                int currentpt = (pos-key)%26;
                if(currentpt<0)
                {
                    currentpt=currentpt+26;
                }
                char cpt = alpha.charAt(currentpt);
                pt.append(cpt);
            }
            else
            {
                pt.append(current);
            }
        }
        return pt.toString();
    }

}


public class BruteForce {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("enter cipher text:");
        String ct=obj.nextLine();
        int key=1;
        CaesarCipher cc = new CaesarCipher();

        for(int i=key;i<26;i++)
        {
            String pt = cc.decrypt(ct, i);
            System.out.println("your plain text when key="+i+":"+pt);
            System.out.print("Do you want to continue:");
            String reply = obj.nextLine();
            if(reply.toLowerCase().equals("no"))
            {
                break;
            }
        }

    }

}
