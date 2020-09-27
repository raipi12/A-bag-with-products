import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Developer {
    public static void main(String[] args) {

       List<Products> products = new ArrayList<>();
       products.add(new Apple(36, 5));
       products.add(new Cheese(200, 4));
       products.add(new Meet(12, 4));
       System.out.println(getRicheProducts(products, 7));
    }
   public static List<Products> getRicheProducts(List<Products> allProducts, int boxCapacity){
        allProducts = allProducts.stream().sorted((o1, o2) -> {

            if (o1.difference() < o2.difference())
                return 1;
            else if (o1.difference() > o2.difference())
                return -1;
            else
                return 0;
        }).collect(Collectors.toList());

        List<Products> bag = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < allProducts.size(); i++){

            index += allProducts.get(i).getAmount();
            if ((boxCapacity - index) < 0){
                index -= allProducts.get(i).getAmount();
                allProducts.get(i).setAmount(boxCapacity - index);
                bag.add(allProducts.get(i));
                break;
            }
            bag.add(allProducts.get(i));
        }
        return bag;
   }
}
interface Products{
double difference();
int getAmount();
void setAmount( int amount);
}
class Cheese implements Products{
    private int price;
    private int amount;

    public Cheese(int price, int amount) {
        this.price = price;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Amount -> " + amount;
    }

    @Override
    public double difference() {
        return price / (double) amount;
    }
}
class Apple implements Products{
    private int price;
    private int amount;

    public Apple(int price, int amount) {
        this.price = price;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Amount -> " + amount;
    }

    @Override
    public double difference() {
        return price / (double) amount;
    }
}
class Meet implements Products{
    int price;
    int amount;

    public Meet(int price, int amount) {
        this.price = price;
        this.amount = amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Amount -> " + amount;
    }

    @Override
    public double difference() {
        return price / (double) amount;
    }
}
