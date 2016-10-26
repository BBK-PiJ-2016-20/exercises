public class Guitar implements MusicalInstrument, WoodenObject {
    private MusicalInstrument instrument;
    private WoodenObject wooden;

    public Guitar() {
        instrument = new MusicalInstrumentImpl();
        wooden = new WoodenObjectImpl();
    }

    public void play() {
        instrument.play();
    }

    public void burn() {
        wooden.burn();
    }
}