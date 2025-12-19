import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main
{
  public static void main(String[] args) throws IOException
  {
    File file = new File(input.txt);  // this is your problem input as a File object
    Scanner sc = new Scanner(file);   // the Scanner object is now reading from the file object


    int answer = 0;
    int position = 50; 

    while (sc.hasNextLine())  // as long as the Scanner has more lines to read from the file...
    {
      String line = sc.nextLine();  // gets the next line of input.  This is like "R802"
      char direction = line.charAt(0);
      String numberPart = line.substring(1);
      int amount = Integer.parseInt(numberPart);
      if (direction == "R")
      {
        position = (position + amount) % 100;
      }
      else if (direction == "L")
      {
        position = (position - amount) % 100;
        if (position < 0)
        {
          position += 100;
        }
      }

      if (position == 0)
      {
        answer++;
      }
      
    }

    System.out.println("The password is " + answer);
    sc.close();
  }
}
