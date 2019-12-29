package com.kamprzewoj.queststore.model.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kamprzewoj.queststore.model.baskets.GroupItemBasket;
import com.kamprzewoj.queststore.model.baskets.GroupQuestBasket;
import com.kamprzewoj.queststore.model.cards.ItemCard;
import com.kamprzewoj.queststore.model.cards.QuestCard;
import com.kamprzewoj.queststore.model.common.UserClass;
import com.kamprzewoj.queststore.model.common.UserLevel;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder(toBuilder = true)
@Audited
@Entity(name = "users")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

//	@JsonIgnore
	@NotBlank(message = "role is mandatory")
	private String role = "anonymous";

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
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

//	@Column(unique = true)
	@Size(min = 3, max = 100, message = "length out of range ")
	private String photoUrl;

//	@OneToOne
//	private Properties properties = null;

	@Range(min = 0L, max = 100_000_000, message = "coins out of range ")
	private int coins;

	private int coinsAllUserReachedHistorical;

	// todo https://thoughts-on-java.org/hibernate-tips-elementcollection/
	//todo https://www.youtube.com/watch?v=kk207HAym_I
	@NotAudited
//	@ElementCollection
//	@CollectionTable(
//			name = "endedItemstest",
//			joinColumns = @JoinColumn(name = "CARD_ID"))
//	@GenericGenerator(name="sequence-gen", strategy="sequence")
//	@CollectionId(columns = { @Column(name="users_old_item_cards") }, generator = "sequence-gen", type = @Type(type="long"))

	@ManyToMany
	private Collection<ItemCard> endedItems;

	@ManyToMany
	private Collection<QuestCard> endedQuests;

	@OneToMany(
			mappedBy = "owner",
			targetEntity = GroupQuestBasket.class)
	private List<GroupQuestBasket> groupQuestBasketsOwned;

	@OneToMany(
			mappedBy = "owner",
			targetEntity = GroupItemBasket.class)
	private List<GroupItemBasket> groupItemBasketsOwned;

//	@NotNull(message = "userLevel is mandatory")
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
	private List<UserClass> userClasses;

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


