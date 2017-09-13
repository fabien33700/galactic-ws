package imie.tp.galactic.ws.resources;

import imie.tp.galactic.ws.model.enums.UnityTypeEnum;

public class UnityCreationRequest {

    protected UnityTypeEnum unityType;

    public UnityTypeEnum getUnityType() {
        return unityType;
    }

    public void setUnityType(UnityTypeEnum unityType) {
        this.unityType = unityType;
    }

    public UnityCreationRequest() {}

    public UnityCreationRequest(UnityTypeEnum unityType) {
        this.unityType = unityType;
    }
}
