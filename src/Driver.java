import java.util.Scanner;
import java.util.ArrayList;

//IngredientList 已创建 用于存放object(ingredient)
//!添加字体颜色
public class Driver
{
    ArrayList<Ingredient> IngredientList = new ArrayList<>();//总的原料列表
    Ingredient beef = new Ingredient(10,8.0);//0
    Ingredient chicken = new Ingredient(10,6.0);//1
    Ingredient cheese = new Ingredient(10,4.0);//2
    Ingredient bread = new Ingredient(10,2.0);//3
    Ingredient lettuce = new Ingredient(10,1.0);//生菜//4

    ArrayList<Table> TableList = new ArrayList<>();
    Table table1 = new Table(0, 4);
    Table table2 = new Table(0, 4);
    Table table3 = new Table(0, 4);
    Table table4 = new Table(0, 6);
    Table table5 = new Table(0, 6);

    double profit=0;
    int index=5;

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.menu();
    }


    void menu() {
        IngredientList.add(beef);
        IngredientList.add(chicken);
        IngredientList.add(cheese);
        IngredientList.add(bread);
        IngredientList.add(lettuce);

        TableList.add(table1);
        TableList.add(table2);
        TableList.add(table3);
        TableList.add(table4);
        TableList.add(table5);

        int choice;
        // //////////////////////////////////////////以上为初始化
        printChoice();
        choice = input.nextInt();
        input.nextLine();

        while (choice != -1) {
            switch (choice) {
                case (1): {
                    takeSeat();
                    break;
                }
                case (2): {
                    checkOut();
                    break;
                }
                case (3): {
                    addDish();
                    break;
                }
                case (4): {
                    addIngredient();
                    break;
                }
                case (5): {
                    printTableAvailable();
                    break;
                }
                case (6): {
                    printBill();
                    break;
                }
                case(7):
                {
                    addTable();
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                    break;
                }
            }
            System.out.println("Press any key to continue");
            input.nextLine();
            printChoice();
            choice = input.nextInt();
            input.nextLine();
        }
    }


    void printChoice() {
        System.out.println(ColourUtil.menuTitle("Welcome to Hamburger Restaurant!"));
        System.out.println(ColourUtil.info("1. Take seats"));
        System.out.println(ColourUtil.info("2. Check out"));
        System.out.println(ColourUtil.info("3. Add Dish for any table"));
        System.out.println(ColourUtil.info("4. Add Ingredient for the restaurant"));
        System.out.println(ColourUtil.info("5. Print all the table which is available"));
        System.out.println(ColourUtil.info("6. Print bill of any table"));
        System.out.println(ColourUtil.info("7. Add table"));
        System.out.println(ColourUtil.warning("Enter -1 to quit"));
        System.out.println(ColourUtil.highlight("Please enter your choice:"));
    }

    void addTable()
    {
        System.out.println(ColourUtil.highlight("Enter max people:"));
        int maxPeople=input.nextInt();
        input.nextLine();
        while(maxPeople<1||maxPeople>10)
        {
            System.out.println(ColourUtil.error("Max people can't be less than 1 or more than 10, try again:"));
            maxPeople=input.nextInt();
            input.nextLine();
        }
        Table table=new Table(0,maxPeople);
        TableList.add(table);
        System.out.println(ColourUtil.success("Success!"));
    }

    void printTableAvailable() {
        int cnt=0;
        for (int i = 0; i < TableList.size(); i++) {
            if (TableList.get(i).getNumberOfPeople() == 0) {
                System.out.println("Table " + (i + 1));
                cnt++;
                System.out.println(ColourUtil.info("The max people volume is: ")+TableList.get(i).getMaxPeople());
            }
        }
        if(cnt!=0) {
            System.out.println(ColourUtil.highlight("These tables are available"));
        }
        else
        {
            System.out.println(ColourUtil.error("No table left."));
        }
    }


    void takeSeat() {
        printTableAvailable();

        System.out.println(ColourUtil.highlight("please choose table to seat:"));
        int tableNumber = input.nextInt();
        input.nextLine();
        boolean success = false;
        for (int i = 0; i < TableList.size(); i++) {
            if ((tableNumber == i + 1)&&TableList.get(i).getNumberOfPeople()==0) {
                System.out.println(ColourUtil.highlight("please enter the number of people:"));
                TableList.get(i).setNumberOfPeople(input.nextInt());
                input.nextLine();
                System.out.println(ColourUtil.success("Success!"));
                success = true;
                break;
            }
        }
        if (!success) {
            System.out.println(ColourUtil.error("The table is not available"));
        }

    }

    void addDish() {
        int count=0;
        for (int i = 0; i < TableList.size(); i++) {
            if (TableList.get(i).getNumberOfPeople() != 0) {
                System.out.println(ColourUtil.info("Table " + (i + 1)));
                count++;
            }
        }
        if(count!=0)
        {
            System.out.println(ColourUtil.highlight("These tables are using"));
        }
        else
        {
            System.out.println(ColourUtil.error("No tables are being used."));
            return;
        }
        System.out.println(ColourUtil.highlight("Choose table to order dish:"));
        int tableNumber = input.nextInt();
        input.nextLine();
        boolean success = false;
        for (int i = 0; i < TableList.size(); i++)
        {
            if ((tableNumber == i + 1)&&TableList.get(i).getNumberOfPeople()!=0)
            {
                System.out.println(ColourUtil.highlight("Add dish for the table:"));
                System.out.println(ColourUtil.info("1.beefCheeseHamburger"));
                System.out.println(ColourUtil.info("2.chickenCheeseHamburger"));
                System.out.println(ColourUtil.info("3.beefHamburger"));
                System.out.println(ColourUtil.info("4.chickenHamburger"));
                int choice = input.nextInt();
                input.nextLine();

                while (choice>4||choice<1)
                {

                    System.out.println(ColourUtil.error("We don't have this hamburger,try again!"));
                    System.out.println(ColourUtil.info("1.beefCheeseHamburger"));
                    System.out.println(ColourUtil.info("2.chickenCheeseHamburger"));
                    System.out.println(ColourUtil.info("3.beefHamburger"));
                    System.out.println(ColourUtil.info("4.chickenHamburger"));
                    choice = input.nextInt();
                    input.nextLine();
                }

                int number =0;
                System.out.println(ColourUtil.highlight("How many hamburgers do you want?"));
                number = input.nextInt();
                input.nextLine();
                success = true;
                switch (choice)
                {
                    case 1:
                    {
                        // ///////////////////////////////////////////////////////
                        if(IngredientList.get(0).getNumber()>=number)
                        {
                         IngredientList.get(0).setNumber(IngredientList.get(0).getNumber() - number);
                        }
                        else
                        {
                         System.out.println(ColourUtil.error("No enough beef!"));
                         return;
                        }
                        if(IngredientList.get(2).getNumber()>=number)
                        {
                            IngredientList.get(2).setNumber(IngredientList.get(2).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough cheese!"));
                            return;
                        }
                        if(IngredientList.get(3).getNumber()>=number)
                        {
                            IngredientList.get(3).setNumber(IngredientList.get(3).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough bread!"));
                            return;
                        }
                        if(IngredientList.get(4).getNumber()>=number)
                        {
                            IngredientList.get(4).setNumber(IngredientList.get(4).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough lettuce!"));
                            return;
                        }
                        // ///////////////////////////////////////////////////////
                        TableList.get(i).beefCheeseHamburger.setNumber(TableList.get(i).beefCheeseHamburger.getNumber()+number);
                        System.out.println(ColourUtil.success("Success!"));
                        break;
                    }
                    case 2:
                    {
                        if(IngredientList.get(1).getNumber()>=number)
                        {
                            IngredientList.get(1).setNumber(IngredientList.get(1).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough chicken!"));
                            return;
                        }
                        if(IngredientList.get(2).getNumber()>=number)
                        {
                            IngredientList.get(2).setNumber(IngredientList.get(2).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough cheese!"));
                            return;
                        }
                        if(IngredientList.get(3).getNumber()>=number)
                        {
                            IngredientList.get(3).setNumber(IngredientList.get(3).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough bread!"));
                            return;
                        }
                        if(IngredientList.get(4).getNumber()>=number)
                        {
                            IngredientList.get(4).setNumber(IngredientList.get(4).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough lettuce!"));
                            return;
                        }
                        TableList.get(i).chickenCheeseHamburger.setNumber(TableList.get(i).chickenCheeseHamburger.getNumber()+number);
                        System.out.println(ColourUtil.success("Success!"));
                        break;
                    }
                    case 3:
                    {
                        if(IngredientList.get(0).getNumber()>=number)
                        {
                            IngredientList.get(0).setNumber(IngredientList.get(0).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough beef!"));
                            return;
                        }
                        if(IngredientList.get(3).getNumber()>=number)
                        {
                            IngredientList.get(3).setNumber(IngredientList.get(3).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough bread!"));
                            return;
                        }
                        if(IngredientList.get(4).getNumber()>=number)
                        {
                            IngredientList.get(4).setNumber(IngredientList.get(4).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough lettuce!"));
                            return;
                        }
                        TableList.get(i).beefHamburger.setNumber(TableList.get(i).beefHamburger.getNumber()+number);
                        System.out.println(ColourUtil.success("Success!"));
                        break;
                    }
                    case 4:
                    {
                        if(IngredientList.get(1).getNumber()>=number)
                        {
                            IngredientList.get(1).setNumber(IngredientList.get(1).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough chicken!"));
                            return;
                        }
                        if(IngredientList.get(3).getNumber()>=number)
                        {
                            IngredientList.get(3).setNumber(IngredientList.get(3).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough bread!"));
                            return;
                        }
                        if(IngredientList.get(4).getNumber()>=number)
                        {
                            IngredientList.get(4).setNumber(IngredientList.get(4).getNumber() - number);
                        }
                        else
                        {
                            System.out.println(ColourUtil.error("No enough lettuce!"));
                            return;
                        }
                        TableList.get(i).chickenHamburger.setNumber(TableList.get(i).chickenHamburger.getNumber()+number);
                        System.out.println(ColourUtil.success("Success!"));
                        break;
                    }
                    default:
                    {
                        System.out.println(ColourUtil.error("Error,there isn't this choice"));
                        break;
                    }
                }

            }
        }
        if (!success)
            {
                System.out.println(ColourUtil.error("Wrong table!"));
            }
    }

    void  checkOut()
    {
        int count=0;
        for (int i = 0; i < TableList.size(); i++) {
            if (TableList.get(i).getNumberOfPeople() != 0) {
                System.out.println(ColourUtil.info("Table " + (i + 1)));
                count++;
            }
        }
        if(count!=0)
        {
            System.out.println(ColourUtil.highlight("These tables are using"));
        }
        else
        {
            System.out.println(ColourUtil.error("No tables are being used."));
            return;
        }
        System.out.println(ColourUtil.highlight("please choose table to check out:"));
        int tableNumber = input.nextInt();
        input.nextLine();

        boolean confirm=false;
        for (int i = 0; i < TableList.size(); i++)
        {
            if ((tableNumber == i + 1)&&TableList.get(i).getNumberOfPeople()!=0)
            {
                   System.out.println(ColourUtil.info("The total price is"+TableList.get(i).getBill()));
                   profit+=TableList.get(i).getBill();
                   TableList.get(i).init();
                   confirm=true;
            }
        }
        if(!confirm)
        {
            System.out.println(ColourUtil.error("Wrong table!"));
        }
    }
    void printBill()
    {
        int count=0;
        for (int i = 0; i < TableList.size(); i++) {
            if (TableList.get(i).getNumberOfPeople() != 0) {
                System.out.println(ColourUtil.info("Table " + (i + 1)));
                count++;
            }
        }
        if(count!=0)
        {
            System.out.println(ColourUtil.highlight("These tables are using"));
        }
        else
        {
            System.out.println(ColourUtil.error("No tables are being used."));
            return;
        }
        System.out.println(ColourUtil.highlight("Choose table to print bill."));
        int tableNumber = input.nextInt();
        input.nextLine();
        for (int i = 0; i < TableList.size(); i++)
        {
            if ((tableNumber == i + 1)&&TableList.get(i).getNumberOfPeople()!=0)
            {
                TableList.get(i).getBillDetails();
            }
        }
    }
    void printProfit()
    {
        System.out.println(ColourUtil.info("Profit now: ")+profit);
    }

    void addIngredient()
    {
        printProfit();
        System.out.println(ColourUtil.highlight("Please add ingredient:"));
        System.out.println(ColourUtil.info("1.you have ")+beef.getNumber()+ColourUtil.info(" beef now")+ColourUtil.info("  The cost of beef is ")+beef.getCost()+ColourUtil.info(" CNY."));
        System.out.println(ColourUtil.info("2.you have ")+chicken.getNumber()+ColourUtil.info(" chicken now")+ColourUtil.info("  The cost of chicken is ")+chicken.getCost()+ColourUtil.info(" CNY."));
        System.out.println(ColourUtil.info("3.you have ")+cheese.getNumber()+ColourUtil.info(" cheese now")+ColourUtil.info("  The cost of cheese is ")+cheese.getCost()+ColourUtil.info(" CNY."));
        System.out.println(ColourUtil.info("4.you have ")+bread.getNumber()+ColourUtil.info(" bread now")+ColourUtil.info("  The cost of bread is ")+bread.getCost()+ColourUtil.info(" CNY."));
        System.out.println(ColourUtil.info("5.you have ")+lettuce.getNumber()+ColourUtil.info(" lettuce now")+ColourUtil.info("  The cost of lettuce is ")+lettuce.getCost()+ColourUtil.info(" CNY."));
        System.out.println(ColourUtil.warning("0:Exit."));
        int choice = input.nextInt();
        input.nextLine();
        while (choice<0||choice>IngredientList.size())
        {
            System.out.println(ColourUtil.error("Wrong choice!Try again!"));
            choice = input.nextInt();
            input.nextLine();
        }
        int number=0;
        if(choice!=0)
        {
            System.out.println(ColourUtil.highlight("How many ingredients do you want?"));
            number= input.nextInt();
            input.nextLine();
        }
        switch (choice)
        {
            case (1):
            {
                while (number<0||(profit-beef.getCost()*number)<0)
                {
                    if(number<0)
                    {
                        System.out.println(ColourUtil.error("You can't add less than 0 ingredients!Try again"));
                    }
                    else
                    {
                        System.out.println(ColourUtil.error("You don't have enough money to buy,try again"));
                    }
                    System.out.println(ColourUtil.highlight("How many ingredients do you want?"));
                    number= input.nextInt();
                    input.nextLine();
                }
                profit-=number* beef.getNumber();
                beef.setNumber(beef.getNumber()+number);
                System.out.println(ColourUtil.success("Success!"));
                break;
            }
            case(2):
            {
                while (number<0||(profit-chicken.getCost()*number)<0)
                {
                    if(number<0)
                    {
                        System.out.println(ColourUtil.error("You can't add less than 0 ingredients!Try again"));
                    }
                    else
                    {
                        System.out.println(ColourUtil.error("You don't have enough money to buy,try again"));
                    }
                    System.out.println(ColourUtil.highlight("How many ingredients do you want?"));
                    number= input.nextInt();
                    input.nextLine();
                }
                profit-=number* chicken.getNumber();
                chicken.setNumber(chicken.getNumber()+number);
                System.out.println(ColourUtil.success("Success!"));
                break;
            }
            case (3):
            {
                while (number<0||(profit-cheese.getCost()*number)<0)
                {
                    if(number<0)
                    {
                        System.out.println(ColourUtil.error("You can't add less than 0 ingredients!Try again"));
                    }
                    else
                    {
                        System.out.println(ColourUtil.error("You don't have enough money to buy,try again"));
                    }
                    System.out.println(ColourUtil.highlight("How many ingredients do you want?"));
                    number= input.nextInt();
                    input.nextLine();
                }
                profit-=number* cheese.getNumber();
                cheese.setNumber(cheese.getNumber()+number);
                System.out.println(ColourUtil.success("Success!"));
                break;
            }
            case(4):
            {
                while (number<0||(profit-bread.getCost()*number)<0)
                {
                    if(number<0)
                    {
                        System.out.println(ColourUtil.error("You can't add less than 0 ingredients!Try again"));
                    }
                    else
                    {
                        System.out.println(ColourUtil.error("You don't have enough money to buy,try again"));
                    }
                    System.out.println(ColourUtil.highlight("How many ingredients do you want?"));
                    number= input.nextInt();
                    input.nextLine();
                }
                profit-=number* bread.getNumber();
                bread.setNumber(bread.getNumber()+number);
                System.out.println(ColourUtil.success("Success!"));
                break;
            }
            case(5):
            {
                while (number<0||(profit-lettuce.getCost()*number)<0)
                {
                    if(number<0)
                    {
                        System.out.println(ColourUtil.error("You can't add less than 0 ingredients!Try again"));
                    }
                    else
                    {
                        System.out.println(ColourUtil.error("You don't have enough money to buy,try again"));
                    }
                    System.out.println(ColourUtil.highlight("How many ingredients do you want?"));
                    number= input.nextInt();
                    input.nextLine();
                }
                profit-=number* lettuce.getNumber();
                lettuce.setNumber(lettuce.getNumber()+number);
                System.out.println(ColourUtil.success("Success!"));
                break;
            }
            case(0):
            {
                break;
            }
        }

    }
}