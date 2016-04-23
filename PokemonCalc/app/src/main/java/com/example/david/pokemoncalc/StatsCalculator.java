package com.example.david.pokemoncalc;

public class StatsCalculator
{
	//int hp,atk,def,spAtk,spDef,speed,lvl;
   //int evHp,evAtk,evDef,evSpAtk,evSpDef,evSpeed;
   //int ivHp,ivAtk,ivDef,ivSpAtk,ivSpDef,ivSpeed;
   public int calcHp(double base,double ev,double iv, double lvl)
   {
     return (int)((((2*base+iv+ev/4)*lvl)/100)+lvl+10);
   }
   public int calcStat(double base,double ev,double iv, double lvl,double nat)
   {
      return (int)(((((2*base+iv+ev/4)*lvl)/100)+5)*nat);
   }
}