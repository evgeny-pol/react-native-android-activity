package pp.facerecognizer.listener;

public interface ImageUploadCallback {
    void onUploadSuccess();
    void onUploadFailure(int responseCode, boolean duplicates);
}
