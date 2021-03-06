package org.motechproject.mots.domain;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "district", uniqueConstraints =
    @UniqueConstraint(columnNames = {"name"}))
public class District extends  Location {

  @OneToMany(mappedBy = "district")
  @Getter
  @Setter
  @OrderBy("name ASC")
  private Set<Chiefdom> chiefdoms;

  public District(String name) {
    super(name);
  }

  @Override
  public String getParentName() {
    return null;
  }
}
