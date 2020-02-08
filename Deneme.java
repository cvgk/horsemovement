
package calismalar;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Deneme {
   
    public static void main(String args[])  {
        /*
       String[][] array = { { "a8","b8","c8","d8","e8","f8","g8","h8" }, 
          { "a7","b7","c7","d7","e7","f7","g7","h7" },
          { "a6","b6","c6","d6","e6","f6","g6","h6" },
          { "a5","b5","c5","d5","e5","f5","g5","h5" },
          { "a4","b4","c4","d4","e4","f4","g4","h4" },
          { "a3","b3","c3","d3","e3","f3","g3","h3" },
          { "a2","b2","c2","d2","e2","f2","g2","h2" },
          { "a1","b1","c1","d1","e1","f1","g1","h1" },
       };
       for(int i=0;i<array.length;i++)
       {
           for(int j=0;j<array[i].length;j++)
           {
               Horse horse = new Horse(array[i][j]);
               System.out.println(array[i][j]+" for output:"
                       +horse.possibleMoves());
           }
       }*/
        Horse h1 = new Horse("c7");
        System.out.println(h1.possibleMoves());
        h1.move("a6");
        System.out.println(h1.getLocation());
        System.out.println(h1.possibleMoves());
    }
    
}
class Horse {
    private String location;
    
    public Horse(String location)
    {
        if(location.length()>2)
        {
            throw new IllegalArgumentException("location length must be 2");
        }else if(location.length()==0){
            throw new IllegalArgumentException("location length must be 2");
        }else{
            this.location = location;
        }
    }
    public List<String> possibleMoves()
    {
        List<String> list = new ArrayList<>();
        
        Predicate<String> pre = a->(a.length()==2)&&((a.startsWith("a")||
                a.startsWith("b")||
                a.startsWith("c")||a.startsWith("d")||a.startsWith("e")||
                a.startsWith("f")||a.startsWith("g")||a.startsWith("h"))&&
                (a.endsWith("1")||a.endsWith("2")||a.endsWith("3")||
                        a.endsWith("4")||a.endsWith("5")||a.endsWith("6")||
                        a.endsWith("7")||a.endsWith("8")));
        char ilk = location.charAt(0);
        int son = Integer.parseInt(location.substring(1));
        list.add(""+(char)((int)ilk+2)+(son+1));
        list.add(""+(char)((int)ilk+2)+(son-1));
        list.add(""+(char)((int)ilk-2)+(son+1));
        list.add(""+(char)((int)ilk-2)+(son-1));
        
        list.add(""+(char)((int)ilk+1)+(son+2));
        list.add(""+(char)((int)ilk+1)+(son-2));
        list.add(""+(char)((int)ilk-1)+(son+2));
        list.add(""+(char)((int)ilk-1)+(son-2));
        List<String> listz = list.stream().filter(pre).
                collect(Collectors.toList());
        Collections.sort(listz);
        return listz;
    }
    public void move(String allowance)
    {
        List<String> list = possibleMoves();
        Predicate<String> pre = a -> a.equalsIgnoreCase(allowance);
        if(list.stream().anyMatch(pre))
        {
            location = allowance;
        }else{
            System.out.println("can not move this location");
        }
    }
    public String getLocation() { return location;}
    public void setLocation(String lokal) { location = lokal; }
}
   
       