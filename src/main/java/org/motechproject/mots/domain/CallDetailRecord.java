package org.motechproject.mots.domain;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.motechproject.mots.domain.enums.CallStatus;

@Entity
@Table(name = "call_detail_record")
@NoArgsConstructor
public class CallDetailRecord extends BaseEntity {

  @Getter
  @Setter
  @Column(name = "call_id", nullable = false)
  private String callId;

  @Getter
  @Setter
  @Column(name = "ivr_config_name", nullable = false)
  private String ivrConfigName;

  @Getter
  @Setter
  @Column(name = "chw_ivr_id", nullable = false)
  private String chwIvrId;

  @Getter
  @Setter
  @Column(name = "call_log_id", nullable = false)
  private String callLogId;

  @Column(name = "call_status", nullable = false)
  @Enumerated(EnumType.STRING)
  @Getter
  @Setter
  private CallStatus callStatus;

  @Getter
  @Setter
  @ElementCollection(fetch = FetchType.LAZY)
  @MapKeyColumn(name = "name")
  @Column(name = "value")
  @CollectionTable(name = "call_detail_record_data", joinColumns = @JoinColumn(name = "cdr_id"))
  private Map<String, String> ivrData = new HashMap<>();
}
