package com.spring.henallux.firstSpringProject.dataAccess.util;

import com.spring.henallux.firstSpringProject.dataAccess.entity.*;
import com.spring.henallux.firstSpringProject.model.*;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {


    //CATEGORY
    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        Category category = new Category();
        category.setCategoryID(categoryEntity.getCategoryID());
        return category;
    }

    public CategoryEntity categoryModelToCategoryEntity(Category category){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryID(category.getCategoryID());
        return categoryEntity;
    }

    //DISCOUNT
    public Discount discountEntityToDiscountModel(DiscountEntity discountEntity){
        Discount discount = new Discount();

        if(discountEntity != null){
            discount.setDiscountID(discountEntity.getDiscountID());
            discount.setPercentageDiscount(discountEntity.getPercentageDiscount());
            discount.setStartDate(discountEntity.getStartDate());
            discount.setEndDate(discountEntity.getEndDate());
        }

        return discount;
    }

    public DiscountEntity discountModelToDiscountEntity(Discount discount){
        DiscountEntity discountEntity = new DiscountEntity();
        discountEntity.setDiscountID(discount.getDiscountID());
        discountEntity.setPercentageDiscount(discount.getPercentageDiscount());
        discountEntity.setStartDate(discount.getStartDate());
        discountEntity.setEndDate(discount.getEndDate());
        return discountEntity;
    }

    //GAME
    public GameEntity gameModelToGameEntity(Game game){
        GameEntity gameEntity = new GameEntity();
        gameEntity.setGameID(game.getGameID());
        gameEntity.setName(game.getName());
        gameEntity.setDescription(game.getDescription());
        gameEntity.setPrice(game.getPrice());
        gameEntity.setCategory(categoryModelToCategoryEntity(game.getCategory()));
        gameEntity.setDiscount(discountModelToDiscountEntity(game.getDiscount()));
        gameEntity.setImage(game.getImage());
        gameEntity.setMinimumAge(game.getMinimumAge());
        gameEntity.setMinimumNumberPlayers(game.getMinimumNumberPlayers());
        gameEntity.setMaximumNumberPlayers(game.getMaximumNumberPlayers());

        return gameEntity;
    }

    public Game gameEntityToGameModel(GameEntity gameEntity){
        Game game = new Game();
        game.setGameID(gameEntity.getGameID());
        game.setName(gameEntity.getName());
        game.setDescription(gameEntity.getDescription());
        game.setPrice(gameEntity.getPrice());
        game.setCategory(categoryEntityToCategoryModel(gameEntity.getCategory()));
        game.setDiscount(discountEntityToDiscountModel(gameEntity.getDiscount()));
        game.setImage(gameEntity.getImage());
        game.setMinimumAge(gameEntity.getMinimumAge());
        game.setMinimumNumberPlayers(gameEntity.getMinimumNumberPlayers());
        game.setMaximumNumberPlayers(gameEntity.getMaximumNumberPlayers());
        return game;
    }

    // CUSTOMER
    public CustomerEntity customerModelToCustomerEntity(Customer customer){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerID(customer.getCustomerID());
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setUsername(customer.getUsername());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPassword(customer.getPassword());
        customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setStatut(customer.getStatut());
        customerEntity.setAuthorities(customer.getAuthorities().toString());
        customerEntity.setCredentialsNonExpired(customer.isCredentialsNonExpired());
        customerEntity.setEnabled(customer.isEnabled());
        customerEntity.setNonLocked(customer.isAccountNonLocked());
        customerEntity.setAccountNonExpired(customer.isAccountNonExpired());
        return customerEntity;
    }

    public Customer customerEntityToCustomerModel(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setCustomerID(customerEntity.getCustomerID());
        customer.setFirstName(customerEntity.getFirstName());
        customer.setLastName(customerEntity.getLastName());
        customer.setUsername(customerEntity.getUsername());
        customer.setEmail(customerEntity.getEmail());
        customer.setPassword(customerEntity.getPassword());
        customer.setPhoneNumber(customerEntity.getPhoneNumber());
        customer.setAddress(customerEntity.getAddress());
        customer.setStatut(customerEntity.getStatut());
        customer.setAuthorities(customerEntity.getAuthorities());
        customer.setCredentialsNonExpired(customerEntity.getCredentialsNonExpired());
        customer.setEnabled(customerEntity.getEnabled());
        customer.setAccountNonLocked(customerEntity.getNonLocked());
        customer.setAccountNonExpired(customerEntity.getAccountNonExpired());
        return customer;
    }


    //ORDER
        public OrderEntity orderModelToOrderEntity(Order order){
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setOrderID(order.getOrderID());
            orderEntity.setOrderDate(order.getOrderDate());
            orderEntity.setOrderPaid(order.isOrderPaid());
            orderEntity.setCustomer(customerModelToCustomerEntity(order.getCustomer()));
            return orderEntity;
        }

        public Order orderEntityToOrderModel(OrderEntity orderEntity){
            Order order = new Order();
            order.setOrderID(orderEntity.getOrderID());
            order.setOrderDate(orderEntity.getOrderDate());
            order.setOrderPaid(order.isOrderPaid());
            order.setCustomer(customerEntityToCustomerModel(orderEntity.getCustomer()));
            return order;

        }

        //ORDER_LINE

        public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine){
            OrderLineEntity orderLineEntity = new OrderLineEntity();
            orderLineEntity.setOrderLineID(orderLine.getOrderLineID());
            orderLineEntity.setRealPrice(orderLine.getRealPrice());
            orderLineEntity.setQuantity(orderLine.getQuantity());
            orderLineEntity.setOrder(orderModelToOrderEntity(orderLine.getOrder()));
            orderLineEntity.setGame(gameModelToGameEntity(orderLine.getGame()));
            return orderLineEntity;
        }

        public OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity){
            OrderLine orderLine = new OrderLine();
            orderLine.setOrderLineID(orderLineEntity.getOrderLineID());
            orderLine.setRealPrice(orderLineEntity.getRealPrice());
            orderLine.setQuantity(orderLineEntity.getQuantity());
            orderLine.setOrder(orderEntityToOrderModel(orderLineEntity.getOrder()));
            orderLine.setGame(gameEntityToGameModel(orderLineEntity.getGame()));
            return orderLine;

        }

        // LANGUAGE

        public Language languageEntityToLanguageModel(LanguageEntity languageEntity){
            Language language = new Language();
            language.setLanguageID(languageEntity.getLanguageID());
            return language;
        }

        public LanguageEntity languageModelToLanguageEntity(Language language){
            LanguageEntity languageEntity = new LanguageEntity();
            languageEntity.setLanguageID(language.getLanguageID());
            return languageEntity;
        }

        // TRANSLATION

        public Translation translationEntityToTranslationModel(TranslationEntity translationEntity){
            Translation translation = new Translation();
            translation.setTranslationID(translationEntity.getTranslationID());
            translation.setLabel(translationEntity.getLabel());
            translation.setLanguage(languageEntityToLanguageModel(translationEntity.getLanguage()));
            translation.setCategory(categoryEntityToCategoryModel(translationEntity.getCategory()));
            return translation;
        }

        public TranslationEntity translationModelToTranslationEntity(Translation translation){
            TranslationEntity translationEntity = new TranslationEntity();
            translationEntity.setTranslationID(translation.getTranslationID());
            translationEntity.setLabel(translation.getLabel());
            translationEntity.setCategory(categoryModelToCategoryEntity(translation.getCategory()));
            translationEntity.setLanguage(languageModelToLanguageEntity(translation.getLanguage()));
            return translationEntity;

        }
















}
