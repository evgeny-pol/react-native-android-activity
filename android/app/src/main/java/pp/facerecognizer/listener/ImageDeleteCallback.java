package pp.facerecognizer.listener;

public interface ImageDeleteCallback {
    void onImagesDeleted();
    void onDeleteFailure(int responseCode);
}
