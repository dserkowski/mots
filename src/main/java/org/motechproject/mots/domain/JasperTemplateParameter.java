package org.motechproject.mots.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "template_parameters")
@NoArgsConstructor
@AllArgsConstructor
public class JasperTemplateParameter extends BaseEntity {

  @ManyToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name = "template_id", nullable = false)
  @Getter
  @Setter
  @Valid
  private JasperTemplate template;

  @Column(name = "name")
  @Getter
  @Setter
  private String name;

  @Column(name = "display_name")
  @Getter
  @Setter
  private String displayName;

  @Column(name = "default_value")
  @Getter
  @Setter
  private String defaultValue;

  @Column(name = "data_type")
  @Getter
  @Setter
  private String dataType;

  @Column(name = "select_expression")
  @Getter
  @Setter
  private String selectExpression;

  @Column(name = "select_method")
  @Getter
  @Setter
  private String selectMethod;

  @Column(name = "select_body")
  @Getter
  @Setter
  private String selectBody;

  @Column(name = "select_property")
  @Getter
  @Setter
  private String selectProperty;

  @Column(name = "display_property")
  @Getter
  @Setter
  private String displayProperty;

  @Column(name = "description")
  @Getter
  @Setter
  private String description;

  @ElementCollection
  @CollectionTable(name = "jasper_template_parameter_options",
      joinColumns = @JoinColumn(name = "id"))
  @Column(name = "options")
  @Getter
  @Setter
  private List<String> options;

  @Column(nullable = false, name = "required")
  @Getter
  @Setter
  private Boolean required;
}
