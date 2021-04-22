public interface Person {
     static String createName() {
        String example = "";
        int count = 0;
        int length_name = (int) (Math.random() * 7) + 3;

        for (int i = 0; i < length_name; i++) {
            count = (int) (Math.random() * 26) + 97;
            example += String.valueOf((char)count);
        }

        return example.substring(0, 1).toUpperCase() + example.substring(1);
    }

    default int randomNumber(int min, int max){
        return (int) (Math.random() * (max - min) + 1) + min;
    }

    void setRoom_address(int i);
}
