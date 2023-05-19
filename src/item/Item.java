package item;

public class Item{

    private String name;
    private int volume;
    private int price;

    public Item(String name, int volume, int price){
        this.name = name;
        this.volume = volume;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getVolume(){
        return volume;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return "Item{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", price=" + price +
                '}';
    }

}
