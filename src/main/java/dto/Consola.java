package dto;

public class Consola {
    private String name;
    private int price;

    public Consola(){}

    public Consola(String name, int price ){
        this.name = name;
        this.price = price;
    }

    public String getName(){return name;}
    public void  setName(String  name){this.name = name;}
    public int getPrice(){return price;}
    public void  setName(int  price){this.price = price;}

}
