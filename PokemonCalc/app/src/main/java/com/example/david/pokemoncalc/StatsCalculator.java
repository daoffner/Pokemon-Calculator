package com.example.david.pokemoncalc;

public class StatsCalculator
{
    /*
   *Calculates the Pokemon's Hp stat
   *
   * @return int the calculated Pokemon's Hp stat
    */
   public int calcHp(double base,double ev,double iv, double lvl)
   {
     return (int)((((2*base+iv+ev/4)*lvl)/100)+lvl+10);
   }
   /*
   *Calculates the Pokemon's stat
   *
   * @return int the calculated Pokemon's stat
    */
   public int calcStat(double base,double ev,double iv, double lvl,double nat)
   {
      return (int)(((((2*base+iv+ev/4)*lvl)/100)+5)*nat);
   }
}