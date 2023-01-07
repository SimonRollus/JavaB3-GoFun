package com.spring.henallux.firstSpringProject.model;
import javax.validation.constraints.*;
public class Game {

    @NotNull
    @Min(value = 1)
    private Integer gameID;

    @NotNull
    @Size(min = 5, max = 50)
    private String name;

    @NotNull
    @Size(min = 5, max = 300)
    private String description;

    @NotNull
    private Float price;
    private Discount discount;
    private Category category;

    private String image;

    private Integer minimumAge;

    private Integer minimumNumberPlayers;

    private Integer maximumNumberPlayers;

    private Float priceWithDiscount;


    public Game() {
    }

    // GETTERS
    public Integer getGameID() {
        return gameID;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Float getPrice() {
        return price;
    }
    public Discount getDiscount() {
        return discount;
    }
    public Category getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }

    public Integer getMinimumNumberPlayers() {
        return minimumNumberPlayers;
    }

    public Integer getMaximumNumberPlayers() {
        return maximumNumberPlayers;
    }

    public Float getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public boolean isOnDiscount(){
        return !this.price.equals(this.priceWithDiscount);
    }

    //SETTERS


    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setMinimumAge(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }

    public void setMinimumNumberPlayers(Integer minimumNumberPlayers) {
        this.minimumNumberPlayers = minimumNumberPlayers;
    }

    public void setMaximumNumberPlayers(Integer maximumNumberPlayers) {
        this.maximumNumberPlayers = maximumNumberPlayers;
    }

    public void setPriceWithDiscount(Float priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    // toString
    @Override
    public String toString() {
        return "Game{" +
                "gameID=" + gameID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", category=" + category +
                ", image='" + image + '\'' +
                ", minimumAge=" + minimumAge +
                ", minimumNumberPlayers=" + minimumNumberPlayers +
                ", maximumNumberPlayers=" + maximumNumberPlayers +
                ", priceWithDiscount=" + priceWithDiscount +
                '}';
    }
}
