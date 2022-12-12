import java.util.Scanner;

public class Decompression {
    public static  String Decompress(String Tags){
        String PositionString = "";
        int Position =0;
        int Lenght =0;
        String LenghtString = "";
        char Symbol = ' ';
        String output = "";

        int turn = 0;
        int idx =0;
        boolean flag = false;

        for(int i =0 ;i<Tags.length() ; i++)
        {
            if(Tags.charAt(i) == ' ')
                continue;

            switch (turn){
                case 0:
                    idx=i;
                    while(Tags.charAt(idx) != ' ')
                    {
                        PositionString += Tags.charAt(idx);
                        idx++;
                    }
                    Position  = Integer.parseInt(PositionString);
                    PositionString = "";
                    i = idx;
                    turn =1;
                    flag = true;
                    break;

                case 1:
                    idx=i;
                    while(Tags.charAt(idx) != ' ')
                    {
                        LenghtString += Tags.charAt(idx);
                        idx++;
                    }
                    Lenght = Integer.parseInt(LenghtString);
                    LenghtString = "";
                    i = idx;
                    turn = 2;
                    flag = true;
                    break;

                case 2:
                    Symbol = Tags.charAt(i);
                    turn = 0;
                    flag = false;
                    break;

                default:
                    break;
            }

            if(flag)
                continue;

            if(Position ==0 && Lenght == 0)
            {
                output+=Symbol;
            }
            else
            {
                int newPos = output.length() - Position;
                int count =0;
                for(int j = newPos ; count != Lenght ; j++)
                {
                    output += output.charAt(j);
                    count++;

                }
                if(Symbol != '-')
                {
                    output+=Symbol;
                }

            }


        }
        return output;

    }
    public static void main(String[] args) {
        String Tags;
        Scanner scanner = new Scanner(System.in);
        Tags = scanner.nextLine();

        String Decompressed = Decompress(Tags);

        System.out.println(Decompressed);
    }
}

