package bitoperator;

public class BitArray {
    private int[] bitArray;
    private int size;

    public BitArray(int n) {
        this.size = n;
        this.bitArray = new int[(n + 31) / 32]; // int(32비트) 기준으로 배열 크기 계산
    }

    public void setBit(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index out of bounds");
        int arrayIndex = index / 32;
        int bitPosition = index % 32;
        bitArray[arrayIndex] |= (1 << bitPosition);
    }

    public boolean checkBit(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index out of bounds");
        int arrayIndex = index / 32;
        int bitPosition = index % 32;
        return (bitArray[arrayIndex] & (1 << bitPosition)) != 0;
    }

    public void clearBit(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index out of bounds");
        int arrayIndex = index / 32;
        int bitPosition = index % 32;
        bitArray[arrayIndex] &= ~(1 << bitPosition);
    }
}
