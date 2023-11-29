import java.util.*;


public class Menu {


    public Menu() {
    }

    CATEGORY[] CTGS = categories();

    Scanner std = new Scanner(System.in);
    Queue<Order> orderQueue = new LinkedList<>();
    Stack<Order> completedOrderStack = new Stack<>();

    public void execute(int option) {
        switch (option) {
            case 2: {
                int ansCat;
                System.out.println("Choose Category : \n");
                for (int i = 0; i < 7; i++) {
                    System.out.println("(" + (i + 1) + ")" + CTGS[i].getDescription());
                }
                System.out.println("(8)Back to Menu");
                do {
                    ansCat = std.nextInt();
                } while (ansCat < 1 || ansCat > 8);
                if (ansCat == 8) {
                    System.out.println("--------------------------------");
                    break;
                }

                float price, minutes;
                String desc;


                System.out.print("Item Description : ");
                do {
                    desc = std.nextLine();
                } while (desc.length() == 0);
                System.out.print("Price in $ : ");
                do {
                    price = std.nextFloat();
                } while (price <= 0);
                System.out.print("Minutes to prepare : ");


                do {
                    minutes = std.nextFloat();
                } while (minutes < 0);

                Item newItem = new Item(minutes, price, desc);
                CTGS[ansCat - 1].items.add(newItem);
                System.out.println("\nItem Added ! ");
                System.out.println("--------------------------------");

                break;

            }
            case 1: {
                Stack<Item> itemStack = new Stack<>();
                Stack<Item> backupitemStack = new Stack<>();
                int ansCat, ansItem;
                do {
                    System.out.println("Choose Category : \n");

                    for (int i = 0; i < 7; i++) {
                        System.out.println("(" + (i + 1) + ")" + CTGS[i].getDescription());
                    }
                    System.out.println("(8)Back to Menu");
                    do {
                        ansCat = std.nextInt();
                    } while (ansCat < 1 || ansCat > 8);

                    if (ansCat == 8) {
                        System.out.println("--------------------------------");
                        break;
                    }

                    int itemSize = CTGS[ansCat - 1].items.size();

                    if (CTGS[ansCat - 1].items.size() != 0) {

                        do {
                            System.out.println("Choose item(s) : \n");

                            CTGS[ansCat - 1].itemList();

                            System.out.println("--------------------------------");
                            System.out.println("(" + (itemSize + 1) + ")Cancel last item");
                            System.out.println("(" + (itemSize + 2) + ")Complete Order");
                            System.out.println("(" + (itemSize + 3) + ")Back to Categories");
                            System.out.println("--------------------------------");

                            do {
                                do {
                                    ansItem = std.nextInt();
                                } while (ansItem < 1 || ansItem > (itemSize + 3));

                                if (ansItem <= itemSize) {
                                    System.out.println("item added");
                                    itemStack.push(CTGS[ansCat - 1].items.get(ansItem - 1));
                                } else if (ansItem == itemSize + 1) {
                                    if (!itemStack.empty()) {
                                        itemStack.pop();
                                        System.out.println("Item Cancelled !");
                                    } else {
                                        System.out.println("No items added");
                                    }
                                }

                            } while (ansItem <= itemSize + 1);


                            if (ansItem == (itemSize + 2)) {


                                if (!itemStack.empty()) {


                                    int priority;
                                    String specialInstructions;

                                    System.out.print("\nSpecial instructions (if none type none): ");
                                    do {
                                        specialInstructions = std.nextLine();
                                    } while (specialInstructions.length() == 0);
                                    System.out.print("Set Priority : (1) HIGH | (2) MEDIUM | (3) LOW :");
                                    do {
                                        priority = std.nextInt();
                                    } while (priority < 1 || priority > 3);

                                    Order order = new Order(specialInstructions, priority);


                                    System.out.println("--------------------------------");
                                    System.out.println("Order Confirmed ! \n");

                                    while (!itemStack.isEmpty()) {

                                        Item aux = itemStack.pop();
                                        order.Items.push(aux);


                                        System.out.println(aux);

                                    }
                                    System.out.println("\n" + order.toString());
                                    {
                                        orderQueue.add(order);
                                    }
                                    System.out.println("--------------------------------");
                                    break;
                                } else {
                                    System.out.println("Order Empty");
                                }
                                System.out.println("--------------------------------");
                            }

                        } while (ansItem != (itemSize + 3));


                    } else {
                        System.out.println("No items in Category");
                        System.out.println("--------------------------------");
                    }
                } while (ansCat != 8);
                priorityRearrange(orderQueue);
                System.out.println("--------------------------------");
                break;

            }

            case 3: {

                int ordAns, completedOrders = 0;
                Order order;
                Item item;
                Queue<Order> backupOrderQueue = new LinkedList<>();
                Stack<Item> backupItemsStack = new Stack<>();
                Stack<Order> backupOrderStack = new Stack<>();
                do {
                    System.out.println("--------------------------------");
                    System.out.println("Manage Orders : \n");

                    System.out.println("(1)View Active Orders");
                    System.out.println("(2)View Completed Orders");
                    System.out.println("(3)Set Status");
                    System.out.println("(4)Set Priority (LOW -> MEDIUM -> HIGH)");
                    System.out.println("(5)Back To menu : ");

                    do {
                        ordAns = std.nextInt();
                    } while (ordAns > 5 || ordAns < 1);


                    switch (ordAns) {
                        case 1:
                            if (orderQueue.isEmpty()) {
                                System.out.println("No Active Orders");
                            } else {
                                int activeOrders = 0;
                                while (!orderQueue.isEmpty()) {
                                    order = orderQueue.poll();
                                    System.out.println(order.toString());
                                    backupOrderQueue.add(order);

                                    activeOrders++;

                                    while (!order.Items.isEmpty()) {
                                        item = order.Items.pop();
                                        System.out.println(item.toString());
                                        backupItemsStack.push(item);
                                    }
                                    while (!backupItemsStack.isEmpty()) {
                                        item = backupItemsStack.pop();
                                        order.Items.push(item);
                                    }

                                    System.out.println("--------------------------------");
                                }


                                System.out.println("\nNumber of Active Orders : " + activeOrders);
                                System.out.println("--------------------------------");

                                while (!backupOrderQueue.isEmpty()) {
                                    order = backupOrderQueue.poll();
                                    orderQueue.add(order);

                                }


                            }
                            break;

                        case 2:
                            if (completedOrderStack.isEmpty()) {
                                System.out.println("No Completed Orders");
                            }
                            while (!completedOrderStack.isEmpty()) {
                                completedOrders++;
                                order = completedOrderStack.pop();
                                System.out.println("--------------------------------");
                                System.out.println(order.toString());
                                backupOrderStack.push(order);

                                while (!order.Items.isEmpty()) {
                                    item = order.Items.pop();
                                    System.out.println(item.toString());
                                    backupItemsStack.push(item);
                                }
                                while (!backupItemsStack.isEmpty()) {
                                    item = backupItemsStack.pop();
                                    order.Items.push(item);
                                }
                                System.out.println("--------------------------------");

                            }
                            System.out.println("\nNumber of Completed : " + completedOrders);
                            System.out.println("--------------------------------");

                            while (!backupOrderStack.isEmpty()) {

                                order = backupOrderStack.pop();
                                completedOrderStack.push(order);

                            }
                            break;

                        case 3:
                            int id;
                            int status;
                            boolean complete, found;
                            System.out.println("Id of order to modify :");
                            do {
                                id = std.nextInt();
                            } while (id <= 0);

                            if (orderQueue.isEmpty()) {
                                System.out.println("No active orders");
                            } else {
                                found = false;
                                while (!orderQueue.isEmpty()) {
                                    complete = false;

                                    order = orderQueue.poll();
                                    if (order.orderId == id) {
                                        found = true;
                                        System.out.println("Set status : (1) ONGOING | (2) COMPLETED ");
                                        do {
                                            status = std.nextInt();
                                        } while (status != 1 && status != 2);
                                        if (status == 2) {
                                            order.status = Status.COMPLETE;
                                            order.urgency = Urgency.Null;
                                            completedOrderStack.push(order);
                                            complete = true;
                                        } else {
                                            order.status = Status.ONGOING;
                                        }
                                    }

                                    if (!complete)
                                        backupOrderQueue.add(order);

                                    while (!order.Items.isEmpty()) {
                                        item = order.Items.pop();
                                        backupItemsStack.push(item);
                                    }
                                    while (!backupItemsStack.isEmpty()) {
                                        item = backupItemsStack.pop();
                                        order.Items.push(item);
                                    }

                                }
                                if (!found) {
                                    System.out.println("Order ID not found");
                                }
                                System.out.println("--------------------------------");
                                while (!backupOrderQueue.isEmpty()) {
                                    order = backupOrderQueue.poll();
                                    orderQueue.add(order);

                                }


                            }

                            break;
                        case 4:
                            int ID;
                            int urgency;
                            boolean FOUND;
                            System.out.println("Id of order to modify :");
                            do {
                                ID = std.nextInt();
                            } while (ID <= 0);

                            if (orderQueue.isEmpty()) {
                                System.out.println("No active orders");
                            } else {
                                FOUND = false;
                                while (!orderQueue.isEmpty()) {

                                    order = orderQueue.poll();
                                    if (order.orderId == ID) {
                                        FOUND = true;
                                        System.out.println("Set Priority : (1) HIGH | (2) MEDIUM | (3) LOW ");
                                        do {
                                            urgency = std.nextInt();
                                        } while (urgency < 1 || urgency > 3);
                                        switch (urgency) {
                                            case 1:
                                                order.urgency = Urgency.HIGH;
                                                break;
                                            case 2:
                                                order.urgency = Urgency.MEDIUM;
                                                break;
                                            case 3:
                                                order.urgency = Urgency.LOW;
                                                break;
                                        }
                                    }
                                        backupOrderQueue.add(order);



                                    while (!order.Items.isEmpty()) {
                                        item = order.Items.pop();
                                        backupItemsStack.push(item);
                                    }
                                    while (!backupItemsStack.isEmpty()) {
                                        item = backupItemsStack.pop();
                                        order.Items.push(item);
                                    }

                                }
                                if (!FOUND) {
                                    System.out.println("Order ID not found");
                                }
                                System.out.println("--------------------------------");
                                while (!backupOrderQueue.isEmpty()) {
                                    order = backupOrderQueue.poll();
                                    orderQueue.add(order);

                                }

                                priorityRearrange(orderQueue);
                            }

                            break;



                    }

                } while (ordAns != 5);
                System.out.println("--------------------------------");
                break;

            }
            case 4:
                int idToCancel;
                System.out.print("Id of the Order to cancel :");
                do {
                    idToCancel = std.nextInt();
                } while (idToCancel <= 0);
                cancelOrder(orderQueue, idToCancel);
                priorityRearrange(orderQueue);
                break;

            default : break;



        }


    }


    public static CATEGORY[] categories() {
        CATEGORY[] CATEGORIES = new CATEGORY[7];

        CATEGORIES[0] = new CATEGORY("Sandwich");
        CATEGORIES[1] = new CATEGORY("Burger");
        CATEGORIES[2] = new CATEGORY("Pizza");
        CATEGORIES[3] = new CATEGORY("Steak");
        CATEGORIES[4] = new CATEGORY("Sides");
        CATEGORIES[5] = new CATEGORY("Drinks");
        CATEGORIES[6] = new CATEGORY("Desert");

        return CATEGORIES;

    }

    public void priorityRearrange(Queue<Order> orderQueue) {
        Queue<Order> HIGHQueue = new LinkedList<>();
        Queue<Order> MEDIUMQueue = new LinkedList<>();
        Queue<Order> LOWQueue = new LinkedList<>();

        Order order;
        while (!orderQueue.isEmpty()) {
            order = orderQueue.poll();
            if (order.urgency.equals(Urgency.HIGH))
                HIGHQueue.add(order);
            else if (order.urgency.equals(Urgency.MEDIUM))
                MEDIUMQueue.add(order);
            else if (order.urgency.equals(Urgency.LOW))
                LOWQueue.add(order);
        }

        unstackQ(HIGHQueue,orderQueue);
        unstackQ(MEDIUMQueue,orderQueue);
        unstackQ(LOWQueue,orderQueue);



    }
    public void unstackQ (Queue<Order> Q,Queue<Order> orderQueue)
    {
        Order order;
        while (!Q.isEmpty()) {
            order = Q.poll();
            orderQueue.add(order);

        }
    }

    public void cancelOrder(Queue<Order> orderQueue, int idToCancel) {
        if (orderQueue.isEmpty()) {
            System.out.println("\nNo order found with ID " + idToCancel);
            return;
        }

        Order order = orderQueue.poll();

        if (order.orderId == idToCancel) {
            System.out.println("\nOrder with ID " + idToCancel + " has been canceled.");

        }
        else
        {

            cancelOrder(orderQueue, idToCancel);

            orderQueue.add(order);
        }
        System.out.println("--------------------------------");
    }


}