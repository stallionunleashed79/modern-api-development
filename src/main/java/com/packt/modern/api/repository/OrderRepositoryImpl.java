package com.packt.modern.api.repository;

import com.packt.modern.api.entity.ItemEntity;
import com.packt.modern.api.entity.OrderEntity;
import com.packt.modern.api.exceptions.ResourceNotFoundException;
import com.packt.modern.api.model.NewOrder;
import com.packt.modern.api.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepositoryExt{

    @PersistenceContext private final EntityManager em;

    private final ItemRepository itemRepo;
    private final CartRepository cRepo;
    private final OrderItemRepository oiRepo;

    @Autowired
    public OrderRepositoryImpl(EntityManager em, ItemRepository itemRepo, CartRepository cRepo, OrderItemRepository oiRepo) {
        this.itemRepo = itemRepo;
        this.em = em;
        this.oiRepo = oiRepo;
        this.cRepo = cRepo;
    }

    //TODO: NEED TO IMPLEMENT THIS METHOD
    @Override
    public Optional<OrderEntity> insert(NewOrder m) {

        return Optional.empty();
    }
}
