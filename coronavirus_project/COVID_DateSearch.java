package coronavirus_project;
import data_structures.LinkedLIST;
import trees.Tree_Rotation;
import java.util.*;
import java.io.*;

@SuppressWarnings("unused")
public class COVID_DateSearch 
{
	String countryNames[],dates[],confirmed[],dead[],recovered[];
	int size;

	public COVID_DateSearch(int s)
	{
		size = s;
		countryNames = new String[size];
		dates = new String[size];
		confirmed = new String[size];
		dead = new String[size];
		recovered = new String[size];
	}

	public void input(String fileName)
	{
		String delimiter = ",";
		try 
		{
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			String tempArr[];
			int ctr = 0;
			while(ctr<size)
			{
				line = br.readLine();
				tempArr = line.split(delimiter);
				if(tempArr.length == 8)
				{
					countryNames[ctr] = tempArr[3];
					dates[ctr] = tempArr[1];
					confirmed[ctr] = tempArr[5];
					dead[ctr] = tempArr[6];
					recovered[ctr] = tempArr[7];
				}
				else if(tempArr.length == 9)
				{
					countryNames[ctr] = tempArr[4];
					dates[ctr] = tempArr[1];
					confirmed[ctr] = tempArr[6];
					dead[ctr] = tempArr[7];
					recovered[ctr] = tempArr[8];
				}
				if(ctr == size-2)
					System.out.println();
				ctr++;
			}
			br.close();
		}
		catch(Exception ioe) 
		{
			ioe.printStackTrace();
		}
	}

	public HashList inputData(int s)
	{
		HashList h = new HashList(s);
		System.out.println("All the countries that have been inputed:");
		System.out.println();

		for(int i =0 ; i<countryNames.length ; i++)
		{
			h.put(countryNames[i],dates[i],confirmed[i],dead[i],recovered[i]);
		}
		System.out.println();
		h.arr.print();
		System.out.println("Total number of countries:"+h.arr.size);
		return h;
	}
	
	public void printForCountry(String name, LinkedLIST_Spl LL)
	{
		for(LinkedLIST_Spl.Node ptr = LL.start; ptr!=null ; ptr = ptr.next)
		{
			if(ptr.name.equalsIgnoreCase(name))
			{
				System.out.println(ptr.name);
				for(int j = 0 ; j<ptr.hmap.arr.size ; j++)
				{	
					String arrAll[] = ptr.hmap.retrieveAll((ptr.hmap.arr.arr[j]));
					String arrall[] = {"Confirmed", "Recovered", "Dead"};

					System.out.println(ptr.hmap.arr.arr[j]);

					for(int i = 0; i<arrAll.length ; i++)
						System.out.println(arrall[i]+":"+arrAll[i]);
					System.out.println();
				}
			}
		}
	}
	
	public void inputDatesData(LinkedLIST_Spl LL,HashList h)
	{
		for(int j = 0;j < h.arr.size; j++)
		{
			if(j == h.arr.size-2)
				System.out.println();
			String arrAll[] = h.getAll(h.arr.arr[j]);
			LL.append(h.arr.arr[j]);
			String vals[][] = h.getAllDates(h.arr.arr[j], arrAll.length);
			for(int incrementer = 0; incrementer < arrAll.length ; incrementer++)
				if(vals[0][incrementer] != null || vals[1][incrementer] != null || vals[2][incrementer] != null || vals[3][incrementer]!=null)
					LL.appendHList(vals[0][incrementer], vals[1][incrementer], vals[2][incrementer], vals[3][incrementer],LL);
		}
	}
	
	public void searchDateCases(String c, String d, String d1, LinkedLIST_Spl LL)
	{
		
		String countryName = c;
		String date = d;
		String qwe[] = LL.search(countryName,date);
		String arrall[] = {"Confirmed", "Recovered", "Dead"};
		System.out.println("In "+countryName+" on "+d1+":");
		for(int i = 0; i<qwe.length; i++)
			System.out.println(arrall[i]+":"+qwe[i]);
	}
	
	public String dateFormating(String d)
	{
		String c[] = d.split("-");
		for(int i = 0; i<3;i++)
		{
			String str = c[i];
			String strPattern = "^0+(?!$)";
			str = str.replaceAll(strPattern, "");
			c[i] = str;
		}
		String date = c[1]+"/"+c[0]+"/20"+c[2];
		return date;
	}
	
	public static void main(String args[])throws IOException,NullPointerException,NumberFormatException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			long T1 =  java.lang.System.currentTimeMillis();
			int s = 36569;//36569 or 26713 
			COVID_DateSearch t1 = new COVID_DateSearch(s);
			t1.input("covid_19_data_new.csv");
			HashList h = t1.inputData(s);
			LinkedLIST_Spl LL = new LinkedLIST_Spl();
			t1.inputDatesData(LL,h);
			long T2 =  java.lang.System.currentTimeMillis();

			System.out.println("Would you like to get the cases for all days present in the dataset?(Yes/No)");
			String yon = br.readLine();
			if(yon.equalsIgnoreCase("yes"))
			{
				System.out.println("Enter the country name:");
				String countryName = br.readLine();
				System.out.println();
				t1.printForCountry(countryName, LL);
			}

			System.out.println("Enter the country name:");
			String cName = br.readLine();
			System.out.println("Enter the date in dd-mm-yy format:");
			String date1 = br.readLine();
			String date = t1.dateFormating(date1);
			long T3 =  java.lang.System.currentTimeMillis();
			System.out.println("Required Country and Date=>");
			t1.searchDateCases(cName, date, date1, LL);
			long T4 =  java.lang.System.currentTimeMillis();
			System.out.println();
			System.out.println(T2-T1+" Milliseconds taken to group and input readings from the CSV file to the memory...");
			System.out.println(T4-T3+" Milliseconds taken to search and output the required data...");
		}
		catch(Exception e)
		{
			System.out.println("Entered Country not available in the current dataset!!");
		}

	}
}