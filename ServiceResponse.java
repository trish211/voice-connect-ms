package model;

/**
 * Created by d847717 on 21/04/2017.
 */
public class ServiceResponse {
    private Long waitTimeInMills;
    private String voiceConnectId;

    public Long getWaitTimeInMills() {
        return waitTimeInMills;
    }

    public void setWaitTimeInMills(Long waitTimeInMills) {
        this.waitTimeInMills = waitTimeInMills;
    }

    public String getVoiceConnectId() {
        return voiceConnectId;
    }

    public void setVoiceConnectId(String voiceConnectId) {
        this.voiceConnectId = voiceConnectId;
    }
}
