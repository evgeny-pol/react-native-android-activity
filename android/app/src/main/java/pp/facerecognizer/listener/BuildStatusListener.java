package pp.facerecognizer.listener;

import pp.facerecognizer.connection.model.VstsBuild;

public interface BuildStatusListener {
    void onBuildStatusChanged(VstsBuild build);
}
