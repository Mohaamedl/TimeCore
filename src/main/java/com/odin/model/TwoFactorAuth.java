package com.odin.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odin.domain.VerificationType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Embeddable
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TwoFactorAuth {
    @Enumerated(EnumType.STRING)
    @JsonProperty("send_to")
    private VerificationType send_to = VerificationType.EMAIL;

    @JsonProperty
    private boolean enabled = false;
    /**
     * TODO
     * Verify whys just default values for is_enable and send_to appear
     * in the database
     *
     */


    public void setIsEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setSendTo(VerificationType send_to) {
        this.send_to = send_to;
    }

    public VerificationType getSendTo() {
        return send_to;
    }

    public boolean IsEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
