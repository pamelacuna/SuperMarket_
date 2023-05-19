import cart.exceptions.CartExceededCapacityException;
import cart.exceptions.EmptyCartException;
import cart.exceptions.ExistentCartException;
import cart.exceptions.NonExistentCartException;
import cart.interfaces.ICart;
import item.exceptions.ExistentItemException;
import item.exceptions.NonExistentItemException;
import superMarket.iterface.ISuperMarket;
import superMarket.SuperMarket;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for a supermarket application
 *
 * @author Lipy Cardoso - 63542
 * @author Pâmela Cuna - 63560
 */

public class Main {


    private static final String CREATE_CART = "Carrinho criado com sucesso.";
    private static final String EXISTENT_CART = "Carrinho existente!";
    private static final String CREATE_ITEM = "Artigo criado com sucesso.";
    private static final String EXISTENT_ITEM = "Artigo existente!";
    private static final String ADD_ITEM = "Artigo adicionado com sucesso.";
    private static final String NON_EXISTENT_CART = "Carrinho inexistente!";
    private static final String CART_EXCEEDED_CAPACITY = "Capacidade excedida!";
    private static final String NON_EXISTENT_ITEM = "Artigo inexistente no carrinho!";
    private static final String REMOVE_ITEM = "Artigo removido com sucesso.";
    private static final String EMPTY_CART = "Carrinho vazio!";
    private static final String EXIT_MESSAGE = "Volte sempre.";

    public static void main(String[] args) {
        Main.execute_commands();
    }

    private static void execute_commands() {
        Scanner in = new Scanner(System.in);
        ISuperMarket sm = new SuperMarket();
        Command comm = readCommand(in);
        while (!comm.equals(Command.EXIT)) {
            switch (comm) {
                case CREATE_CART:
                    createCart(in, sm);
                    break;
                case CREATE_ITEM:
                    createItem(in, sm);
                    break;
                case DEPOSIT:
                    deposit(in, sm);
                    break;
                case REMOVE:
                    remove(in, sm);
                    break;
                case LIST:
                    list(in, sm);
                    break;
                case PAY:
                    pay(in, sm);
                    break;
                default:
            }
            System.out.println();
            comm = readCommand(in);
        }
        System.out.println(EXIT_MESSAGE);
        System.out.println();
        in.close();
    }

    private static Command readCommand(Scanner in) {
        String input;
        input = in.nextLine().toUpperCase();
        for (Command c :Command.values())
            if (c.getCommandInputName().equals(input))
                return c;
        return Command.UNKNOWN_COMMAND;
    }

    private static void pay(Scanner in, ISuperMarket sm) throws NonExistentCartException {
        String cartID;

        try {
            cartID = in.nextLine();
            sm.pay(cartID);
            sm.emptyCart(cartID);
            in.nextLine();
        } catch (EmptyCartException exception) {
            System.out.println(Main.EMPTY_CART);
        }
    }

    private static void list(Scanner in, ISuperMarket sm) {
        List<ICart> listCartItems = new LinkedList<ICart>();


    }

    private static void remove(Scanner in, ISuperMarket sm) {
        String itemID, cartID;

        try {
            itemID = in.nextLine().trim();
            cartID = in.nextLine();

            sm.remove(itemID, cartID);
            System.out.println(Main.REMOVE_ITEM);
        } catch (NonExistentCartException exception) {
            in.nextLine();
            System.out.println(Main.NON_EXISTENT_CART);
        } catch (NonExistentItemException exception) {
            System.out.println(Main.NON_EXISTENT_ITEM);
        }
    }

    private static void deposit(Scanner in, ISuperMarket sm) {
        String itemID, cartID;

        try {
            itemID = in.nextLine().trim();
            cartID = in.nextLine();
            sm.deposit(itemID, cartID);
            System.out.println(Main.ADD_ITEM);
        } catch (NonExistentCartException exception) {
            in.nextLine();
            System.out.println(Main.NON_EXISTENT_CART);
        } catch (ExistentItemException exception) {
            System.out.println(Main.EXISTENT_ITEM);
        } catch (CartExceededCapacityException exception) {
            System.out.println(Main.CART_EXCEEDED_CAPACITY);
        }

    }

    private static void createItem(Scanner in, ISuperMarket sm) {
        String itemID;
        int price, volume;

        try {
            itemID = in.nextLine().trim();
            price = in.nextInt();
            volume = in.nextInt();
            in.nextLine();

            sm.hasItem(itemID);
            sm.createItem(itemID, price, volume);
            System.out.println(Main.CREATE_ITEM);
        } catch (ExistentItemException exception) {
            System.out.println(Main.EXISTENT_ITEM);
        }
    }

    private static void createCart(Scanner in, ISuperMarket sm) {
        String cartID;
        int maxVolume;

        try {
            cartID = in.nextLine().trim();
            maxVolume = in.nextInt();
            in.nextLine();

            sm.hasCart(cartID, maxVolume);
            sm.createCart(cartID, maxVolume);
            System.out.println(Main.CREATE_CART);
        } catch (ExistentCartException exception) {
            System.out.println(Main.EXISTENT_CART);
        }
    }


    private enum Command {

        CREATE_CART("CRIA CARRINHO"), CREATE_ITEM("CRIA ARTIGO"), DEPOSIT("DEPOSITA"),
        REMOVE("REMOVE"), LIST("LISTA"), PAY("PAY"), EXIT("SAIR"), UNKNOWN_COMMAND("UNKNOWN COMMAND");

        private final String commandInputName;

        Command(String commandInputName) {
            this.commandInputName = commandInputName;
        }

        private String getCommandInputName() {
            return commandInputName;
        }
    }


}