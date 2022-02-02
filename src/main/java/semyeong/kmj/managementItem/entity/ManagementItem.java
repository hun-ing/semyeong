package semyeong.kmj.managementItem.entity;


import lombok.*;
import semyeong.kmj.account.entity.Account;
import semyeong.kmj.common.common.AccountType;
import semyeong.kmj.item.entity.Item;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ManagementItem {

	@Id
	@GeneratedValue
	@Column(name = "management_item_id")
	private Long id;

	private int basicPrice;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "account_id")
	private Account account;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "item_id")
	private Item item;

	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	//==연관관계 메서드==//
	public void setAccount(Account account) {
		this.account = account;
		account.getManagementItems().add(this);
	}
}