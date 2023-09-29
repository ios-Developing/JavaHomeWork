import java.util.ArrayList;
import java.util.List;


public class Program {
    public static void main(String[] args) {

        Toy toy1 = new Toy(0, "Кукла", 25);
        Toy toy2 = new Toy(1, "Машинка", 40);
        Toy toy3 = new Toy(2, "Робот", 3);
        Toy toy4 = new Toy(3, "Матрёшка", 65);

        List<Toy> toys = new ArrayList<Toy>();
        toys.add(toy4);
        toys.add(toy3);
        toys.add(toy2);
        toys.add(toy1);

        ToyStore toyStore = new ToyStore(toys);
        toyStore.saveToyForLottery();
        toyStore.saveToyForLottery();
        toyStore.saveToyForLottery();
        toyStore.saveToyForLottery();


    }


}
