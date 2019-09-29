package com.kamprzewoj.queststore.model.persons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamprzewoj.queststore.model.baskets.GroupItemBasket;
import com.kamprzewoj.queststore.model.baskets.GroupQuestBasket;
import com.kamprzewoj.queststore.model.cards.ItemCard;
import com.kamprzewoj.queststore.model.cards.QuestCard;
import com.kamprzewoj.queststore.model.common.UserClass;
import com.kamprzewoj.queststore.model.common.UserLevel;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder(toBuilder = true)
@Audited
@Entity(name = "users")
public class User implements  Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@JsonIgnore
	private final String role = "user";

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
	@JsonIgnore
	private String password;  //todo <--- how save password

	@Column(unique = true)
	@Size(min = 3, max = 100, message = "length out of range ")
	private String photoUrl;

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

	@ManyToMany(
			targetEntity = UserClass.class)
	@JoinTable(
			uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "user_class_id"})},
			name= "join_userclasses_user",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "user_class_id")})
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


