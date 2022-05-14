package models;

public class InformationModel {
    String wasteName;
    int imageId;

    public InformationModel(String wasteName, int imageId) {
        this.wasteName = wasteName;
        this.imageId = imageId;
    }

    public String getWasteName() {
        return wasteName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setWasteName(String wasteName) {
        this.wasteName = wasteName;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
