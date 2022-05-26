package units;

import exceptions.UnitFullCapacityException;

public class Doctor extends Unit 
{
	public Doctor(int level, int maxSoldierConunt, double idleUpkeep, double marchingUpkeep,
			double siegeUpkeep) {
		super( level,  maxSoldierConunt,  idleUpkeep,  marchingUpkeep,
			 siegeUpkeep);
	}
	
	
	public void heal(Unit healedUnit) throws UnitFullCapacityException
	{
		int h = 0;
		if(healedUnit.getCurrentSoldierCount()==healedUnit.getMaxSoldierCount())
		{
			throw new UnitFullCapacityException();
		}
		else
		{
			if(healedUnit.getCurrentSoldierCount()==0)
			{
				return;
			}
			else
			{
				
				if(this.getLevel()==1)
				{
					if((int)(healedUnit.getCurrentSoldierCount()+healedUnit.getMaxSoldierCount()*0.2)>healedUnit.getMaxSoldierCount())
					{
						healedUnit.setCurrentSoldierCount(healedUnit.getMaxSoldierCount());
						
					}
					else {
					h=(int)(healedUnit.getCurrentSoldierCount()+healedUnit.getMaxSoldierCount()*0.2);
					healedUnit.setCurrentSoldierCount(h);}
				}
				else if(this.getLevel()==2)
				{
					if((int)(healedUnit.getCurrentSoldierCount()+healedUnit.getMaxSoldierCount()*0.3)>healedUnit.getMaxSoldierCount())
					{
						healedUnit.setCurrentSoldierCount(healedUnit.getMaxSoldierCount());
					}
					else
						{h=(int)(healedUnit.getCurrentSoldierCount()+healedUnit.getMaxSoldierCount()*0.3);

					healedUnit.setCurrentSoldierCount(h);}
				}
				else if(this.getLevel()==3)
				{
					if((int)(healedUnit.getCurrentSoldierCount()+healedUnit.getMaxSoldierCount()*0.4)>healedUnit.getMaxSoldierCount())
					{
						healedUnit.setCurrentSoldierCount(healedUnit.getMaxSoldierCount());
						
					}
					else {
					h=(int)(healedUnit.getCurrentSoldierCount()+healedUnit.getMaxSoldierCount()*0.4);

					healedUnit.setCurrentSoldierCount(h);
					}
				}
			}
		}

	}
	
}
