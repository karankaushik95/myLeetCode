public class Fizz_Buzz {
    public List<String> fizzBuzz(int n) 
    {
        List<String> output = new ArrayList<String>(n);
        int i;
        for(i=1;i<=n;i++)
        {
            if(i%3==0)
            {
                if(i%5==0)
                    output.add("FizzBuzz");
                else
                    output.add("Fizz");
            }
            else if(i%5==0)
                output.add("Buzz");
            else
                output.add(Integer.toString(i));
        }    
        return output;
        
    }
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        Fizz_Buzz sol = new Fizz_Buzz();
        List<String> output = new ArrayList<String>(n);
        output=sol.fizzBuzz(n);
    }
}
