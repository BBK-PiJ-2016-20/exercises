class GuitarLauncher {
    public static void main(String[] args) {
        Guitar g = new Guitar();
        
        MusicalInstrument m = g;
        m.play();

        WoodenObject o = g;
        o.burn();
    }
}