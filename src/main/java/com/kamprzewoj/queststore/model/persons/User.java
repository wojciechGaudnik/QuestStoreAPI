package com.kamprzewoj.queststore.model.persons;

import com.kamprzewoj.queststore.model.baskets.GroupItemBasket;
import com.kamprzewoj.queststore.model.baskets.GroupQuestBasket;
import com.kamprzewoj.queststore.model.cards.ItemCard;
import com.kamprzewoj.queststore.model.cards.QuestCard;
import com.kamprzewoj.queststore.model.common.UserClass;
import com.kamprzewoj.queststore.model.common.UserLevel;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder(toBuilder = true)
@Audited
@Entity(name = "users")
public class User {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotBlank(message = "firstName is mandatory")
	@Size(min = 3, max = 100, message = "length out of range ")
	private String firstName;

	@NotBlank(message = "last is mandatory")
	@Size(min = 3, max = 100, message = "length out of range ")
	private String lastName;

	@Column(unique = true)
	@NotBlank(message = "email is mandatory")
	@Size(min = 3, max = 100, message = "length out of range ")
	@Email(message="Please provide a valid email address")
	private String email;

	@Column(unique = true)
	@NotBlank(message = "nick is mandatory")
	@Size(min = 3, max = 50, message = "length out of range ")
	private String nick;

	@NotBlank(message = "password is mandatory")
	private String password;  //todo <--- how save password

	@Column(unique = true)
	@Size(min = 3, max = 100, message = "length out of range ")
	private String photoUrl;

	@Range(min = 0L, max = 10000L, message = "out of range min = 1L, max =  10000L <--- check !!!")
	private int coins;


	// todo https://thoughts-on-java.org/hibernate-tips-elementcollection/
//	private List<ItemCard> endedItems;
//
//	private List<QuestCard> endedQuests;

	@OneToMany(
			mappedBy = "owner",
			targetEntity = GroupQuestBasket.class)
	private List<GroupQuestBasket> groupQuestBasketsOwned;

	@OneToMany(
			mappedBy = "owner",
			targetEntity = GroupItemBasket.class)
	private List<GroupItemBasket> groupItemBasketsOwned;

	@NotNull(message = "userLevel is mandatory")
	@ManyToOne(
			targetEntity = UserLevel.class)
	@JoinColumn(name = "user_level_id")
	private UserLevel userLevel;

	@ManyToOne(
			targetEntity = UserClass.class)
	@JoinColumn(name = "user_class_id")
	private UserClass userClass;

	@ManyToMany(
			targetEntity = GroupItemBasket.class)
	@JoinTable(
			name = "join_user_groupitembasket",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "group_item_basket_id")})
	private List<GroupItemBasket> groupItemBaskets;

	@ManyToMany(
			targetEntity = GroupQuestBasket.class)
	@JoinTable(
			name = "join_user_groupquestbasket",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "group_quest_basket_id")})
	private List<GroupQuestBasket> groupQuestBaskets;

	@ManyToMany(
			targetEntity = ItemCard.class)
	@JoinTable(
			name = "join_user_itemcard",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "item_card_id")})
	private List<ItemCard> itemCards;

	@ManyToMany(
			targetEntity = QuestCard.class)
	@JoinTable(
			name = "join_user_questcard",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "quest_card_id")})
	private List<QuestCard> questCards;
}


