package org.motechproject.mots.domain;

import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.motechproject.mots.domain.enums.Language;

@Entity
@Table(name = "ivr_config")
public class IvrConfig extends BaseEntity {

  @Column(name = "base_url", nullable = false)
  @Getter
  @Setter
  private String baseUrl;

  @Column(name = "module_assigned_message_id", nullable = false)
  @Getter
  @Setter
  private String moduleAssignedMessageId;

  @Column(name = "default_users_group_id", nullable = false)
  @Getter
  @Setter
  private String defaultUsersGroupId;

  @Column(name = "send_sms_if_voice_fails", nullable = false)
  @Getter
  @Setter
  private Boolean sendSmsIfVoiceFails;

  @Column(name = "detect_voicemail_action", nullable = false)
  @Getter
  @Setter
  private Boolean detectVoicemailAction;

  @Column(name = "retry_attempts_short", nullable = false)
  @Getter
  @Setter
  @Min(value = 0)
  private Integer retryAttemptsShort;

  @Column(name = "retry_delay_short", nullable = false)
  @Getter
  @Setter
  @Min(value = 0)
  private Integer retryDelayShort;

  @Column(name = "retry_attempts_long", nullable = false)
  @Getter
  @Setter
  @Min(value = 0)
  private Integer retryAttemptsLong;

  @Column(name = "retry_delay_long", nullable = false)
  @Getter
  @Setter
  @Min(value = 0)
  private Integer retryDelayLong;

  @ElementCollection
  @CollectionTable(name = "ivr_config_languages", joinColumns = @JoinColumn(name = "ivr_config_id"))
  @Column(name = "ivr_language_id", nullable = false)
  @MapKeyColumn(name = "language")
  @MapKeyClass(Language.class)
  @MapKeyEnumerated(EnumType.STRING)
  @Getter
  @Setter
  private Map<Language, String> ivrLanguagesIds;
}
