package screenRecorder;

public class Profile {

    public Profile(){}

    public Profile(Codec codec, Resolution resolution, Extension extension){

    }

    public Codec getCodec() {
        return codec;
    }

    public void setCodec(Codec codec) {
        this.codec = codec;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    private Codec codec;
    private Resolution resolution;
    private Extension extension;
}
