package pp.facerecognizer.connection.model;

/**
 * Custom Vision create images batch model.
 */
public class ImageCreateBatch {

    private String[] tagIds;

    public ImageCreateBatch(String[] tagIds) {
        this.tagIds = tagIds;
    }
}
