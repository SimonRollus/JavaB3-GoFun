package com.spring.henallux.firstSpringProject.dataAccess.entity;


import javax.persistence.*;

@Entity
@Table(name="game")
public class GameEntity {
    @Id
    @Column(name = "game_id")
    private Integer gameID;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;


    @JoinColumn(name = "discount_fk", referencedColumnName = "discount_id")
    @ManyToOne
    private DiscountEntity discount;

    @JoinColumn(name = "category_fk", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity category;

    @Column(name = "image")
    private String image;

    @Column(name = "minimum_age")
    private Integer minimumAge;

    @Column(name="minimum_number_players")
    private Integer minimumNumberPlayers;

    @Column(name="maximum_number_players")
    private Integer maximumNumberPlayers;

    public GameEntity() {
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public DiscountEntity getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountEntity discount) {
        this.discount = discount;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }

    public Integer getMinimumNumberPlayers() {
        return minimumNumberPlayers;
    }

    public void setMinimumNumberPlayers(Integer minimumNumberPlayers) {
        this.minimumNumberPlayers = minimumNumberPlayers;
    }

    public Integer getMaximumNumberPlayers() {
        return maximumNumberPlayers;
    }

    public void setMaximumNumberPlayers(Integer maximumNumberPlayers) {
        this.maximumNumberPlayers = maximumNumberPlayers;
    }
}
