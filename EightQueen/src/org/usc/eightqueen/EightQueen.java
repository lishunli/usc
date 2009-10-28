package org.usc.eightqueen;
/**
 * 
 * 
 * @author MZ
 *
 * @Time 2009-10-26下午03:18:07
 * @Time 2009-10-26下午03:19:56
 * @Time 2009-10-26下午03:20:00
 * @Time 2009-10-26下午03:20:23
 */
public class EightQueen
{
	private static char map[][] = new char[8][8];
	private static int count = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		init();
		Track(0);

	}
	/**
	 * 初始化map数组
	 */
	protected static void init()
	{
		int i;
		int j;
		for (i=0; i<8; i++)
		{
			for (j=0; j<8; j++)
			{
				map[i][j] = '0';
			}
		}
	}
	protected static void print()
	{
		int i;
		int j;
		System.out.println("第"+(++count)+"种八皇后棋谱:");
		for (i=0; i<8; i++)
		{
			for (j=0; j<8; j++)
			{
				if (map[i][j] == '0')
				{
					System.out.print(" □ ");
				}
				else
				{
					System.out.print(" O ");
				}
			}
			System.out.println();
		}
		System.out.println("");
	}
	
	/**
	 * 
	 * @param n
	 */
	protected static void Track(int n)
	{
		int i;
		if (n>=8)
		{
			print();
			return ;
		}
		for (i=0; i<8; i++)
		{
			if (Set(n,i)==1)
			{
				map[n][i] = '1';
				Track(n+1);
				map[n][i] = '0';
			}
		}
	}
	

	protected static int Set(int i, int j)
	{
		int r;
		int c;
		for (r=0; r<8; r++)
		{
			if (map[r][j] == '1')
			{
				return 0;
			}
		}
		for (c=0; c<8; c++)
		{
			if (map[i][c] == '1')
			{
				return 0;
			}
		}

		for (r=i-1,c=j-1; r>=0&&c>=0; r--,c--)
		{
			if (map[r][c] == '1')
			{
				return 0;
			}
		}
		for (r=i-1,c=j+1; r>=0&&c<8; r--,c++)
		{
			if (map[r][c] == '1')
			{
				return 0;
			}
		}
		for (r=i+1,c=j-1; r<8&&c>=0; r++,c--)
		{
			if (map[r][c] == '1')
			{
				return 0;
			}
		}
		for (r=i+1,c=j+1; r<8&&c<8; r++,c++)
		{
			if (map[r][c] == '1')
			{
				return 0;
			}
		}

		return 1;
	}

}
