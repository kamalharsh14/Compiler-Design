package Task8.ShiftReduceParsing;

import java.io.*;

class ShiftReduceParser
{
	public static void main(String[] args) throws Exception
	{
		int n, index=0, i, j;
		String str, stack="", temp;
		String[][] cfg;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter no. of CFG's: ");
		n = Integer.parseInt(in.readLine());				//Number of CFG's
		cfg = new String[n][2];								//to store expressions
		System.out.println("Enter the CFG's:");

		//Entering CFG's
		for (i=0; i < n; i++)
		{
			System.out.print("LHS for CFG "+(i+1)+": ");
			cfg[i][0] = in.readLine();
			System.out.print("RHS for CFG "+(i+1)+": ");
			cfg[i][1] = in.readLine();
		}

		System.out.println("The CFG's are:");

		//Displaying the entered CFG
		for (i=0; i < n; i++)
		{
			System.out.println(cfg[i][0]+" -> "+cfg[i][1]);
		}

		System.out.print("Enter a string: ");
		str = in.readLine();					          //String to be parsed

		//Parsing the string
		while (index < str.length()-1)
		{
			temp = str.substring(index, str.indexOf(' ', index));   //Extracting the next word(using space in inputs)
			index = str.indexOf(' ', index)+1;
			for (i=0; i < n; i++)
			{
				if (temp.equals(cfg[i][1]))
				{
					temp = cfg[i][0];
					break;
				}
			}
			if(!stack.equals(temp)){
			stack = stack+temp;  	//storing the parsed String into the stack
			}				
			System.out.println("Stack contents: "+stack);

			//Checking for the termination condition
			for (i=0; i < n; i++)
			{
				if (stack.equals(cfg[i][1]))
				{
					stack = cfg[i][0];
					break;
				}
			}
		}
		System.out.println("Stack contents: "+stack);
		if (stack.equals(cfg[0][0]))
			System.out.println("Accepted.");
		else
			System.out.println("Rejected.");
	}
}