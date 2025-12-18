import java.util.ArrayList;
import java.util.Scanner;
/// /////////////！加菜功能
public class Table
{
    private int NumberOfPeople;
    private int MaxPeople;
    private ArrayList<Dish>OrderedDish = new ArrayList<>();//用于存放object(dish)
    private double bill;
    Dish beefCheeseHamburger=new Dish(0,30.0);
    Dish chickenCheeseHamburger=new Dish(0,28.0);
    Dish beefHamburger=new Dish(0,22.0);
    Dish chickenHamburger=new Dish(0,18.0);
    Scanner input=new Scanner(System.in);

    /// ////////////////////////////////////
    Table(int numberOfPeople, int MaxPeople)
    {
        this.NumberOfPeople=numberOfPeople;
        this.MaxPeople=MaxPeople;

    }
    Table()
    {

    }
    // ////////////////////////////////////


    /// ////////////////////////////////////////////////////

    public void init()
    {
        this.NumberOfPeople =0;
        beefCheeseHamburger.setNumber(0);
        chickenCheeseHamburger.setNumber(0);
        beefHamburger.setNumber(0);
        chickenHamburger.setNumber(0);

    }


    public int getNumberOfPeople()
    {
        return NumberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople)
    {
        while (numberOfPeople > MaxPeople||numberOfPeople < 1)
        {
            System.out.println("People can't be more than MaxPeople or less than 1,please try again");
            numberOfPeople=input.nextInt();
            input.nextLine();
        }
            this.NumberOfPeople = numberOfPeople;
    }


    public int getMaxPeople()
    {
        return MaxPeople;
    }

    public void setMaxPeople(int maxPeople)
    {
        MaxPeople = maxPeople;
    }

    public ArrayList<Dish> getOrderedDish()
    {
        return OrderedDish;
    }

    public void setOrderedDish(ArrayList<Dish> orderedDish)
    {
        OrderedDish = orderedDish;
    }
    // //////////////////////////////////////////////////////

    /// //////////////////////////////////////////////////////



    public double getBill()
    {
        double sum = 0;
        sum += beefCheeseHamburger.getNumber() * beefCheeseHamburger.getPrice();
        sum += chickenCheeseHamburger.getNumber() * chickenCheeseHamburger.getPrice();
        sum += beefHamburger.getNumber() * beefHamburger.getPrice();
        sum += chickenHamburger.getNumber() * chickenHamburger.getPrice();
        this.bill = sum;
        return sum;
    }
    public void getBillDetails()
    {
        System.out.println("Beef cheese hamburger number:"+beefCheeseHamburger.getNumber()+" * price:"+ beefCheeseHamburger.getPrice());
        System.out.println("Chicken cheese hamburger:"+chickenCheeseHamburger.getNumber()+" * price:"+ chickenCheeseHamburger.getPrice());
        System.out.println("Beef hamburger number:"+beefHamburger.getNumber() +" * price:"+ beefHamburger.getPrice());
        System.out.println("Chicken hamburger:"+chickenHamburger.getNumber() +" * price:"+ chickenHamburger.getPrice());
        System.out.println("total:"+getBill());
    }

    @Override
    public String toString() {
        return "table{" +
                "NumberOfPeople=" + NumberOfPeople +
                ", MaxPeople=" + MaxPeople +
                ", OrderedDish=" + OrderedDish +
                ", bill=" + bill +
                '}';
    }
    // /////////////////////////////////////////////////////////////

}
