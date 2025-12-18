public class Ingredient
{
    private int number;
    private double cost;
/// ////////////////////////////////////////////////////
    public Ingredient()
    {
    }

    public Ingredient(int number, double cost)
    {
        this.number = number;
        this.cost = cost;
    }

    public Ingredient(int number)
    {
        this.number = number;
    }
/// ////////////////////////////////////////////////////
    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }



    @Override
    public String toString()
    {
        return "Ingredient{" +
                "number=" + number +
                ", cost=" + cost +
                '}';
    }
}
