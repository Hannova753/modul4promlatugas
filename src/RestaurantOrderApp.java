import java.util.ArrayList;
import java.util.List;
//fitur anyar

class Notanota {
    private String name;
    private double price;

    public Notanota(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }
}

class OrderItem {
    private Notanota menuItem;
    private int quantity;

    public OrderItem(Notanota menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public Notanota getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateItemTotal() {
        return menuItem.getPrice() * quantity;
    }
}

class Order {
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(Notanota menuItem, int quantity) {
        items.add(new OrderItem(menuItem, quantity));
        System.out.println(quantity + " x " + menuItem.getName() + " TELAH DITAMBAHKAN KE PESANAN.");
    }

    public void removeItem(String itemName) {
        items.removeIf(orderItem -> orderItem.getMenuItem().getName().equalsIgnoreCase(itemName));
        System.out.println(itemName + " TELAH DIHAPUS DARI PESANAN.");
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.calculateItemTotal();
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("===== Nota Pemesanan =====");
        for (OrderItem item : items) {
            System.out.println(item.getQuantity() + " x " + item.getMenuItem().getName() +
                    " = Rp" + item.calculateItemTotal());
        }
        System.out.println("Total: Rp" + calculateTotal());
        System.out.println("==========================");
    }
}

class RestaurantOrderApp {
    public static void main(String[] args) {
        // Membuat item menu
        Notanota WAGYU = new Notanota("WAGYU", 20000);
        Notanota STEAK = new Notanota("STEAK", 18000);
        Notanota PASTA = new Notanota("PASTA", 25000);

        // Membuat pesanan baru
        Order order = new Order();

        // Menambahkan item ke pesanan
        order.addItem(WAGYU, 2);
        order.addItem(STEAK, 1);
        order.addItem(PASTA, 3);

        // Menghapus item dari pesanan
        order.removeItem("PASTA");

        // Mencetak nota pesanan
        order.printReceipt();
    }
}
