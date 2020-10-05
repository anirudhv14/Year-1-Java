package coronavirus_project;
import data_structures.LinkedLIST;
import trees.Tree_Rotation;
import java.util.*;
import java.io.*;
@SuppressWarnings("unused")

/*
 * The following project requires us to feed the CSV file containing the dataset  
 * for the confirmed, recovered and dead cases in a country on a particular date.
 */
public class COVID_DateSearch 
{
	// variables to initially store the particular column from the dataset in arrays.
	String countryNames[],dates[],confirmed[],dead[],recovered[];
	int size;

	// constructor to initialize the variables declared earlier
	public COVID_DateSearch(int s)
	{
		size = s;
		countryNames = new String[size];
		dates = new String[size];
		confirmed = new String[size];
		dead = new String[size];
		recovered = new String[size];
	}

	/*
	 * input() - function to extract the input the value from the csv file
	 * to the arrays created earlier.
	 */
	public void input(String fileName)
	{
		String delimiter = ",";
		// 'try catch' block to catch exceptions
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
				ctr++;
			}
			br.close();
		}
		catch(Exception ioe) 
		{
			ioe.printStackTrace();
		}
	}

	/*
	 * inputData() - function to input the country names along with each date
	 * and the cases into the hashlist
	 */
	public HashList inputData(int s)
	{
		HashList h = new HashList(s);
		System.out.println("All the countries that have been inputed are :");
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
	
	/*
	 * printDatewise() - function to print the the cases with the date and the 
	 * country name. It has 2 cases: one to check for country name only and print
	 * all the dates cases and the other to  check for name and date so to print 
	 * only for 1 date in the country.
	 */
	public void printDatewise(String name,String date12,int val, LinkedLIST_Spl LL)
	{
		if(val == 0)
		{
			for(LinkedLIST_Spl.Node ptr = LL.start; ptr!=null ; ptr = ptr.next)
			{
				if(ptr.name.equalsIgnoreCase(name))
				{
					System.out.println();
					System.out.println(ptr.name);
					for(int j = 0 ; j<ptr.hmap.arr.size ; j++)
					{	
						if(j == 0)
						{
							String arrAll[] = ptr.hmap.retrieveAll((ptr.hmap.arr.arr[j]));
							String arrall[] = {"Confirmed", "Recovered", "Dead"};

							System.out.println(ptr.hmap.arr.arr[j]);

							for(int i = 0; i<arrAll.length ; i++)
								System.out.println(arrall[i]+":"+arrAll[i]);
							System.out.println();
						}
						else
						{
							String arrAll1[] = ptr.hmap.retrieveAll((ptr.hmap.arr.arr[j]));
							String arrAll2[] = ptr.hmap.retrieveAll((ptr.hmap.arr.arr[j-1]));
							String arrAll[] = new String[3]; 

							for(int i = 0; i<arrAll.length ; i++)
								arrAll[i] = Integer.toString(Integer.parseInt(arrAll1[i])-Integer.parseInt(arrAll2[i]));

							String arrall[] = {"Confirmed", "Recovered", "Dead"};

							System.out.println(ptr.hmap.arr.arr[j]);

							for(int i = 0; i<arrAll.length ; i++)
								System.out.println(arrall[i]+":"+arrAll[i]);
							System.out.println();
						}
					}
				}
			}
		}
		else
		{
			for(LinkedLIST_Spl.Node ptr = LL.start; ptr!=null ; ptr = ptr.next)
			{
				if(ptr.name.equalsIgnoreCase(name))
				{
					System.out.println();
					System.out.println(ptr.name);
					for(int j = 0 ; j<ptr.hmap.arr.size ; j++)
					{	
						if(ptr.hmap.arr.arr[j].equalsIgnoreCase(date12))
						{
							if(j == 0)
							{
								String arrAll[] = ptr.hmap.retrieveAll((ptr.hmap.arr.arr[j]));
								String arrall[] = {"Confirmed", "Recovered", "Dead"};

								System.out.println(ptr.hmap.arr.arr[j]);

								for(int i = 0; i<arrAll.length ; i++)
									System.out.println(arrall[i]+":"+arrAll[i]);
								System.out.println();
							}
							else
							{
								String arrAll1[] = ptr.hmap.retrieveAll((ptr.hmap.arr.arr[j]));
								String arrAll2[] = ptr.hmap.retrieveAll((ptr.hmap.arr.arr[j-1]));
								String arrAll[] = new String[3]; 

								for(int i = 0; i<arrAll.length ; i++)
									arrAll[i] = Integer.toString(Integer.parseInt(arrAll1[i])-Integer.parseInt(arrAll2[i]));

								String arrall[] = {"Confirmed", "Recovered", "Dead"};

								System.out.println(ptr.hmap.arr.arr[j]);

								for(int i = 0; i<arrAll.length ; i++)
									System.out.println(arrall[i]+":"+arrAll[i]);
								System.out.println();
							}
						}
					}
				}
			}
		}
	}
	
	/*
	 * inputDatesData() - function to input the dates for a specific country into the
	 * special linked list.
	 */
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
	
	// getForSpecificDay() - function to calculate the cases for a specific day.
	public String[] getForSpecificDay(String d,LinkedLIST_Spl.Node LL,int j)
	{
		if(j == 0)
		{
			String arrAll[] = LL.hmap.retrieveAll((LL.hmap.arr.arr[j]));

			return arrAll;
		}
		else
		{
			String arrAll1[] = LL.hmap.retrieveAll((LL.hmap.arr.arr[j]));
			String arrAll2[] = LL.hmap.retrieveAll((LL.hmap.arr.arr[j-1]));
			String arrAll[] = new String[3]; 

			for(int i = 0; i<arrAll.length ; i++)
				arrAll[i] = Integer.toString(Integer.parseInt(arrAll1[i])-Integer.parseInt(arrAll2[i]));

			return arrAll;
		}
	}
	
	// dateFormatting() - function to format the date from "dd-mm-yy" to "mm/dd/yyyy" 
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
	
	/*
	 *  checkRecovered() - function to check whether a certain country has recovered from 
	 *  COVID19. It checks the last 14 days and if on all 14 days the confirmed cases are 0 
	 *  it returns true.
	 */
	public boolean checkRecovered(String name, LinkedLIST_Spl LL)
	{
		int ctr = 1,f=0;
		for(LinkedLIST_Spl.Node ptr = LL.start ; ptr!=null;ptr = ptr.next)
		{
			if(ptr.name.equalsIgnoreCase(name))
			{
				int cv = ptr.hmap.arr.size-1;
				while(ctr != 14)
				{
					String val[] = getForSpecificDay(ptr.hmap.arr.arr[cv],ptr,cv);
					if(!val[0].equalsIgnoreCase("0"))
					{
						f = 1;
						break;
					}
					cv--;
					ctr++;
				}
				ctr = 1;
			}
		}
		if(f == 0)
			return true;
		else
			return false;
	}
	
	// checkAllCountries() - function to check all the COVID recovered countries
	public void checkAllCountries(LinkedLIST_Spl LL)
	{
		for(LinkedLIST_Spl.Node ptr = LL.start; ptr != null; ptr = ptr.next)
		{
			if(checkRecovered(ptr.name,LL))
				System.out.println(ptr.name);
		}
	}
	
	public static void main(String args[])throws IOException,NullPointerException,NumberFormatException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			long T1 =  java.lang.System.currentTimeMillis();
			int s = 42992;
			COVID_DateSearch t1 = new COVID_DateSearch(s);
			t1.input("covid_19_data.csv");
			HashList h = t1.inputData(s);
			LinkedLIST_Spl LL = new LinkedLIST_Spl();
			t1.inputDatesData(LL,h);
			long T2 =  java.lang.System.currentTimeMillis();

			System.out.println("Would you like to check the cases for a country on a specific day?(Yes/No)");
			String yon3 = br.readLine();
			if(yon3.equalsIgnoreCase("yes"))
			{
				System.out.println("Enter the country name:");
				String cName = br.readLine();
				System.out.println("Enter the date in dd-mm-yy format:");
				String date1 = br.readLine();
				String date = t1.dateFormating(date1);
				long T3 =  java.lang.System.currentTimeMillis();
				long T31 = System.nanoTime();
				System.out.println();
				System.out.println("Required Country and Date=>");
				System.out.println("In "+cName+" on "+date1+":");
				t1.printDatewise(cName, date, 1, LL);
				long T4 =  java.lang.System.currentTimeMillis();
				long T41 = System.nanoTime();
				System.out.println();
				if(T4-T3 == 0)
					System.out.println(T41-T31+" Nanoseconds taken to search and output the required data...");
				else
					System.out.println(T4-T3+" Milliseconds taken to search and output the required data...");
			}
			System.out.println();
			
			System.out.println("Would you like to find all the COVID-19 Free countries?(Yes/No)");
			String yon2 = br.readLine();
			if(yon2.equalsIgnoreCase("yes"))
			{
				t1.checkAllCountries(LL);
			}
			System.out.println();
			
			System.out.println("Would you like to get the cases for all days present in the dataset?(Yes/No)");
			String yon = br.readLine();
			if(yon.equalsIgnoreCase("yes"))
			{
				System.out.println("Enter the country name:");
				String countryName = br.readLine();
				System.out.println();
				t1.printDatewise(countryName,null,0,LL);
			}
			System.out.println();
			
			System.out.println("Would you like to check for a COVID-19 Free country?(Yes/No)");
			String yon1 = br.readLine();
			if(yon1.equalsIgnoreCase("yes"))
			{
				System.out.println("Enter the country name:");
				String countryName = br.readLine();
				if(t1.checkRecovered(countryName,LL))
					System.out.println(countryName+" has recoverd...");
				else
					System.out.println(countryName+" has not recoverd...");
				System.out.println();
			}
			
			System.out.println();
			System.out.println(T2-T1+" Milliseconds taken to group and input readings from the CSV file to the memory...");
		}
		catch(Exception e)
		{
			System.out.println("Entered Country not available in the current dataset!!");
		}

	}
}

