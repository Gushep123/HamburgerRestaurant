import java.util.ArrayList;
import java.util.Scanner;
public class Dish
{
    private String name;
    private double price;
    private int number;
    private double cost;

    Scanner input = new Scanner(System.in);

    ArrayList<Ingredient> material =new ArrayList<>();

/// ////////////////////////////////////////////////////////////////////////////
    Dish()
    {

    }

    public Dish(double price, ArrayList<Ingredient> material)
    {
        this.price = price;
        this.material = material;
    }

    public Dish(int number,double price)
    {
        this.number = number;
        this.price = price;
    }

/// /////////////////////////////////////////////////////////////////////////////
    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        if(price>cost)
        {
            this.price = price;
            System.out.println("Price set: "+price);
        } else
        {
            System.out.println("Price must be greater than cost! Cost is: " + cost);
        }
    }

    public ArrayList<Ingredient> getMaterial()
    {
        return material;
    }

    public void setMaterial(ArrayList<Ingredient> material)
    {
        this.material = material;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        while (number <0)
        {
            System.out.println("You can't order less than 1 hamburger,please try again");
            number = input.nextInt();
            input.nextLine();
        }
        this.number = number;
    }

/// /////////////////////////////////////////////////////////////////////////////////////


}
