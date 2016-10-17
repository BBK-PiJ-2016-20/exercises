class ArrayCopier {
    public static void copy(int[] src, int[] dst) {
        int i;
        int toCopy = Math.min(src.length, dst.length);
        
        for (i = 0; i < toCopy; i++) {
            dst[i] = src[i];
        }

        for( ; i < dst.length; i++) {
            dst[i] = 0;
        }
    }

}