import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Restrorent{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<Integer, String> items=new HashMap<>();
        items.put(1,"Burger");
        items.put(2,"Pizza");
        items.put(3,"Cofee");
        items.put(4,"Sandwich");
        items.put(5,"Maggie");

        Map<Integer,Integer> prices=new HashMap<>();
        prices.put(1,100);
        prices.put(2,150);
        prices.put(3,50);
        prices.put(4,80);
        prices.put(5,50);

        System.out.println("        Welcome to my Restro");
        System.out.println("-----------------------------------------");
        System.out.println("    My Menu");

        for(int i=1;i<=items.size();i++){
            System.out.println(i+". "+items.get(i)+" - "+prices.get(i));
        }
        System.out.println("-------------------------------------------");
        //ordder
        Map<Integer,Integer> order=new HashMap<>();
        char choice = 0;
        do{
            System.out.print("Enter item number for order: ");
            int itemno=sc.nextInt();
            if(!items.containsKey(itemno)){
                System.out.println("intvalid item number..");
                continue;
            }
            System.out.print("Enter quantitiy for "+items.get(itemno)+": ");
            int qty=sc.nextInt();
            order.put(itemno,order.getOrDefault(itemno, 0)+qty);
            System.out.println("Do you want to add more items? (Y/N)");
            choice=sc.next().charAt(0);
        }
        while(choice =='Y' || choice=='y');
        int total = 0;
        System.out.println("\n--------- FINAL BILL ---------");
        System.out.printf("%-15s%-10s%-10s\n", "Item", "Qty", "Amount");
        for (Map.Entry<Integer, Integer> entry : order.entrySet()) {
            int id = entry.getKey();
            int qty = entry.getValue();
            int amt = qty * prices.get(id);
            total += amt;
            System.out.printf("%-15s%-10d%-10d\n", items.get(id), qty, amt);
        }

        double gst = total * 0.05; // 5% GST
        double finalAmount = total + gst;

        System.out.println("------------------------------");
        System.out.printf("Subtotal:  %.2f\n", (double) total);
        System.out.printf("GST (5%%):  %.2f\n", gst);
        System.out.printf("Total Amount to Pay:  %.2f\n", finalAmount);
        System.out.println("------------------------------");
        System.out.println("Thank you! Visit Again!");
        sc.close(); 
    }
}