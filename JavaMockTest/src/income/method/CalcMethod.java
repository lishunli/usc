package income.method;

import income.Position;

public class CalcMethod
{
	public double calc(Position position)
	{
		double d=0;
		switch (position)
		{
		//BOSS,PROGRAMMER,MANAGER
		case BOSS:
			d=7000.00;
			break;
			
		case MANAGER:
			d=5000.00;
			break;
			
		case PROGRAMMER:
			d=3000.00;
			break;

		default:
			break;
		
		}
		return d;
	}
}
