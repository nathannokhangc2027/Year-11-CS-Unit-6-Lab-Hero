public class Hero {
    private int hitPoints;
    private String name;

    public Hero(String name){
        this.name = name;
        hitPoints = 100;
    }

    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public String toString()
    {
        return "Hero{name=\'" + name + "\', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent)
    {
        double num = Math.random();
        if (num < 0.5)
        {
            opponent.hitPoints -=10;
        }
        else
        {
            hitPoints -= 10;
        }
    }

    public void senzuBean()
    {
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper (Hero opponent)
    {
        while (hitPoints > 0 && opponent.hitPoints > 0)
        {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath (Hero opponent)
    {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "\t" + opponent.getName() + ": " + opponent.getHitPoints();
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n)
    {
        int hero = 0;
        int opp = 0;

        for (int i = 1; i <= n; i++)
        {
            fightUntilTheDeath(opponent);
            if (hitPoints > 0)
            {
                hero++;
            }
            else
            {
                opp++;
            }
        }
        return new int[]{hero, opp};
    }

    public String nFightsToTheDeath(Hero opponent, int n)
    {
        String winner = "";
        int result[] = nFightsToTheDeathHelper(opponent, n);
        if (result[0] > result[1])
        {
            winner = name + " wins!";
        }
        else if (result[1] > result[0])
        {
            winner = opponent.getName() + " wins!";
        }
        else
        {
            winner = "OMG! It was actually a draw!";
        }

        return name + ": " + result[0] + " wins" + "\n" + opponent.getName() + ": " + result[1] + " wins" + "\n" + winner;
    }

    public void dramaticFightToTheDeath(Hero opponent)
    {
        String winner = "";
        senzuBean();
        opponent.senzuBean();
        while (hitPoints > 0 && opponent.hitPoints > 0)
        {
            attack(opponent);
            System.out.println(name + ": " + hitPoints + "\t" + opponent.getName() + ": " + opponent.getHitPoints());
            if (hitPoints == 0)
            {
                winner = opponent.getName();
            }
            else if (opponent.getHitPoints() == 0)
            {
                winner = name;
            }
        }
        System.out.println(winner + " wins!");
    }

}
