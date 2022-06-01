package app;

import java.util.Scanner;

public class ProductInfo {

    static String name ;
    static double weight;
    static int quantity;
    static Product product;
    static double totalWeight;
    static String totalWeightRounded;
    static private final String MEASURE = "kg";
    static double price;
    static double totalPrice;
    static String totalPriceRounded;

    public static void main(String[] args) {
        doInputs();
        showInfo(handleData());
    }

    static private void doInputs() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Product name:  ");
        name = scanner.nextLine();
        System.out.print("Product weight per unit" + " (" + MEASURE + "): ");
        weight = scanner.nextDouble();
        System.out.print("Product quantity (pcs.): ");
        quantity = scanner.nextInt();
        System.out.print("Price per kilogram($): ");
        price = scanner.nextDouble();
        scanner.close();
    }

    // Обработка данных
    static private String handleData() {

        product = new Product(name, weight);
        name = product.getName();

        totalWeight = getTotalWeight(product.getWeight(), quantity);
        totalWeightRounded = getTotalWeightRounded(totalWeight);
        totalPrice = getTotalPrice(price, totalWeight);
        totalPriceRounded = getTotalPriceRounded(totalPrice);

        return "------------------------\n" +
                "Product total weight " + name + " (" + MEASURE + "): "
                + totalWeightRounded + "\n------------------------\n" +
                "Price: $" + totalPriceRounded;
    }

    // Метод рассчета общего веса.
    static private double getTotalWeight(double weight, int quantity) {
        return weight * quantity;
    }

    // Метод округления общего веса.
    static private String getTotalWeightRounded(double totalWeight) {
        return Rounder.roundWeight(totalWeight);
    }

    // Метод вывода в консоль.
    static private void showInfo(String output) {
        System.out.println(output);
    }

    // Метод рассчета общей цены.
    static private double getTotalPrice(double price, double weight) {
        return price * weight;
    }

    // Метод округления общей цены.
    static private String getTotalPriceRounded(double totalPrice) {
        return Rounder.roundPrice(totalPrice);
    }
}
