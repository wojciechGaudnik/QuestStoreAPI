//package com.kamprzewoj.queststore.repository;
//
//import com.kamprzewoj.queststore.__temporary.__model.ItemCard;
//import com.kamprzewoj.queststore.__temporary.__model.ItemCategory;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//import java.util.List;
//
//@RepositoryRestResource
//public interface ItemCartRepository extends CrudRepository<ItemCard, Long> {
//	List<ItemCard> readAllByItemCategoryIs(ItemCategory itemCategory);  //todo <--- how pass this object
//	List<ItemCard> findAllByItemCategory (ItemCategory itemCategory);
//	List<ItemCard> findAllByItemCategoryIs(ItemCategory itemCategory);
////todo	http://localhost:8080/api/rest/itemCards/search/readAllByItemCategoryIs?itemCategory={"id":1,"name": "OneItemCategory"}
//}
