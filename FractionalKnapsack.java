import java.util.*;

public class FractionalKnapsack {

static class Item {  
    int weight, value;  
    double ratio;  

    Item(int weight, int value) {  
        this.weight = weight;  
        this.value = value;  
        ratio = (double) value / weight;  
    }  
}  

public static void main(String[] args) {  

    Scanner sc = new Scanner(System.in);  

    System.out.print("Enter number of items: ");  
    int n = sc.nextInt();  

    Item[] items = new Item[n];  

    for (int i = 0; i < n; i++) {  
        System.out.print("Enter weight and value: ");  

        int weight = sc.nextInt();  
        int value = sc.nextInt();  

        items[i] = new Item(weight, value);  
    }  

    System.out.print("Enter knapsack capacity: ");  
    int capacity = sc.nextInt();  

    // Sort according to value/weight ratio  
    Arrays.sort(items, (a, b) ->  
        Double.compare(b.ratio, a.ratio));  

    double maxValue = 0;  

    // Greedy method  
    for (Item item : items) {  

        if (capacity >= item.weight) {  

            capacity -= item.weight;  
            maxValue += item.value;  

        } else {  

            maxValue += item.ratio * capacity;  
            break;  
        }  
    }  

    System.out.println(  
        "\nMaximum value we can obtain = " + maxValue);  

    sc.close();  
}

}
